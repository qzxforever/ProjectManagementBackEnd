package org.bestsoft.easyExcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.bestsoft.DTO.Constants;
import org.bestsoft.jpa.entity.Inoutcome;
import org.bestsoft.jpa.entity.excel.PersonalTransaction;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class PersonalTransactionDataListener extends AnalysisEventListener<PersonalTransaction> {
    private static final int BATCH_COUNT = 3000;
    List<PersonalTransaction> list = new ArrayList<>();
    List<Inoutcome> inoutcomeList = new ArrayList<>();
    @Override
    public void invoke(PersonalTransaction data, AnalysisContext context) {
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
        for (PersonalTransaction personalTransaction : list) {
            try {
                Inoutcome inoutcome = new Inoutcome();
                inoutcome.setOtherName(personalTransaction.getOtherName());
                inoutcome.setOtherAccount(personalTransaction.getOtherAccount());
                inoutcome.setAmount(Optional.ofNullable(personalTransaction.getIncomeAmount()).orElseGet(()->personalTransaction.getOutAmount().negate()));
                inoutcome.setBalance(personalTransaction.getBalance());
                inoutcome.setCardType(Constants.PERSONAL_CARD_TYPE);
                inoutcome.setTransactionDate(new Timestamp(personalTransaction.getTransactionDate().getTime()));
                inoutcome.setRemark(personalTransaction.getRemark());
                inoutcomeList.add(inoutcome);
            } catch (Exception e) {
                log.error("个人银行明细解析异常，问题数据:{}", personalTransaction.toString());
                log.error("个人银行明细解析异常详情，e:{}", ExceptionUtils.getStackTrace(e));
            }
        }
    }

    public List<Inoutcome> getInoutcomeList() {
        return inoutcomeList;
    }
}
