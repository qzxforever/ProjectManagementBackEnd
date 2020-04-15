package org.bestsoft.jpa.entity;

import lombok.Data;
import org.bestsoft.jpa.base.BaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "permission")
@SQLDelete(sql = "update permission set deleted = 1 where id = ?")
@Where(clause = "deleted = 0")
public class Permission extends BaseEntity implements Serializable {
    private String name;
}
