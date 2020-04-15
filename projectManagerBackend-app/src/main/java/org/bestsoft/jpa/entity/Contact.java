package org.bestsoft.jpa.entity;

import lombok.Data;
import org.bestsoft.jpa.base.BaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "contact")
@SQLDelete(sql = "update contact set deleted = 1 where id = ?")
@Where(clause = "deleted = 0")
public class Contact extends BaseEntity implements Serializable {
	private String name;
	private String phone;
	@Column(name = "customer_id")
	private Long customerId;

}
