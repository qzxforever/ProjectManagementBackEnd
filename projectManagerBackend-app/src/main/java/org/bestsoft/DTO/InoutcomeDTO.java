package org.bestsoft.DTO;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class InoutcomeDTO {
    private String transactionDate;
    private String otherName;
    private String otherAccount;
    private String ownAccount;
    private BigDecimal amount;
    private String unit;
    private Integer type;
    private BigDecimal balance;
    private Integer cardType;
}
