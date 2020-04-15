package org.bestsoft.jpa.entity;

import lombok.Data;
import org.bestsoft.jpa.base.BaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "project_customer")
@SQLDelete(sql = "update project_customer set deleted = 1 where id = ?")
@Where(clause = "deleted = 0")
public class ProjectCustomer extends BaseEntity implements Serializable {
	@Column(name = "customer_id")
	private Long customerId;
	@Column(name = "project_id")
	private Long projectId;

}
