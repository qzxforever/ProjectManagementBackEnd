package org.bestsoft.jpa.entity;

import lombok.Data;
import org.bestsoft.jpa.base.BaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "inoutcome")
@SQLDelete(sql = "update inoutcome set deleted = 1 where id = ?")
@Where(clause = "deleted = 0")
public class Inoutcome extends BaseEntity implements Serializable {
	@Column(name = "project_id")
	private Long projectId;
	@Column(name = "other_name")
	private String otherName;
	@Column(name = "other_account")
	private String otherAccount;
	@Column(name = "own_account")
	private String ownAccount;
	private BigDecimal amount;
	private String unit;
	private Integer type;
	private BigDecimal balance;
	@Column(name = "card_type")
	private Integer cardType;
	@Column(name = "transaction_date")
	private Timestamp transactionDate;

}
