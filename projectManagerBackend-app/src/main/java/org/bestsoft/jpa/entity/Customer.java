package org.bestsoft.jpa.entity;

import lombok.Data;
import org.bestsoft.jpa.base.BaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
@SQLDelete(sql = "update customer set deleted = 1 where id = ?")
@Where(clause = "deleted = 0")
public class Customer extends BaseEntity implements Serializable {
	private String name;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="customer_id")
	private List<Contact> contactList;
}
