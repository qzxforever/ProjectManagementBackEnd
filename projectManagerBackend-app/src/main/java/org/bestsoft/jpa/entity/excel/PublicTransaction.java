package org.bestsoft.jpa.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PublicTransaction {
	@ExcelProperty("日期")
	@DateTimeFormat("yyyy/MM/dd")
	private Date transactionDate;

	@ExcelProperty("对方户名")
	private String otherName;

	@ExcelProperty("对方账号")
	private String otherAccount;

	@ExcelProperty("摘要")
	protected String remark;

	@ExcelProperty("借方发生额")
	private BigDecimal incomeAmount;

	@ExcelProperty("贷方发生额")
	private BigDecimal outAmount;

	@ExcelProperty("余额")
	private BigDecimal balance;





}
