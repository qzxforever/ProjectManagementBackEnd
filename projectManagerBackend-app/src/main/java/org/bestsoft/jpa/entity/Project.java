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
@Table(name = "project")
@SQLDelete(sql = "update project set deleted = 1 where id = ?")
@Where(clause = "deleted = 0")
public class Project extends BaseEntity implements Serializable {
    private String name;
    private String status;
    private String series;
    private Integer importance;
    private String zone;
    private Double contractamount;
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "project_customer",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "customer_id")})
    private List<Customer> customerList;
}
