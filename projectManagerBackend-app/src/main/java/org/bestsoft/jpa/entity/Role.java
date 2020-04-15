package org.bestsoft.jpa.entity;

import lombok.Data;
import org.bestsoft.jpa.base.BaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "role")
@SQLDelete(sql = "update role set deleted = 1 where id = ?")
@Where(clause = "deleted = 0")
public class Role extends BaseEntity implements Serializable {
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_permission",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")})
    private Set<Permission> permissions;
}