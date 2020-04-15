package org.bestsoft.jpa.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PersonalTransaction {
	@ExcelProperty("交易日期")
	@DateTimeFormat("yyyyMMdd")
	private Date transactionDate;

	@ExcelProperty("收入")
	private BigDecimal incomeAmount;

	@ExcelProperty("支出")
	private BigDecimal outAmount;

	@ExcelProperty("余额")
	private BigDecimal balance;

	@ExcelProperty("对方姓名")
	private String otherName;

	@ExcelProperty("对方账号")
	private String otherAccount;

	@ExcelProperty("摘要")
	protected String remark;

	@Override
	public String toString() {
		return "PersonalTransaction{" +
				"transactionDate=" + transactionDate +
				", incomeAmount=" + incomeAmount +
				", outAmount=" + outAmount +
				", balance=" + balance +
				", otherName='" + otherName + '\'' +
				", otherAccount='" + otherAccount + '\'' +
				", remark='" + remark + '\'' +
				'}';
	}
}
