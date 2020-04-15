package org.bestsoft.easyExcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.bestsoft.DTO.Constants;
import org.bestsoft.jpa.entity.Inoutcome;
import org.bestsoft.jpa.entity.excel.PublicTransaction;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PublicTransactionDataListener extends AnalysisEventListener<PublicTransaction> {
    private static final int BATCH_COUNT = 3000;
    List<PublicTransaction> list = new ArrayList<>();
    List<Inoutcome> inoutcomeList = new ArrayList<>();

    @Override
    public void invoke(PublicTransaction data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
        log.info("所有数据解析完成！");
    }

    private void saveData() {
        log.info("{}条数据！", list.size());
        for (PublicTransaction publicTransaction : list) {
            try {
                Inoutcome inoutcome = new Inoutcome();
                inoutcome.setOtherName(publicTransaction.getOtherName());
                inoutcome.setOtherAccount(publicTransaction.getOtherAccount());
                inoutcome.setAmount(BigDecimal.ZERO.equals(publicTransaction.getIncomeAmount()) ? publicTransaction.getOutAmount().negate() : publicTransaction.getIncomeAmount());
                inoutcome.setBalance(publicTransaction.getBalance());
                inoutcome.setCardType(Constants.PUBLIC_CARD_TYPE);
                inoutcome.setTransactionDate(new Timestamp(publicTransaction.getTransactionDate().getTime()));
                inoutcome.setRemark(publicTransaction.getRemark());
                inoutcomeList.add(inoutcome);
            } catch (Exception e) {
                log.error("对公账户明细解析异常，问题数据:{}", publicTransaction.toString());
                log.error("对公账户明细解析异常详情，e:{}", ExceptionUtils.getStackTrace(e));
            }
        }
    }

    public List<Inoutcome> getInoutcomeList() {
        return inoutcomeList;
    }
}
