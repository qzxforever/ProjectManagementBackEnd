package org.bestsoft.jpa.base;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 20, unique = true)
    protected Long id;

    @Column(name = "cdate", nullable = false)
    protected Timestamp cdate;

    @Column(name = "edate", nullable = false)
    protected Timestamp edate;

    @Column(name = "creator", nullable = false)
    protected String creator;

    @Column(name = "editor", nullable = false)
    protected String editor;

    @Column(name = "remark")
    protected String remark;

    @Column(name="deleted")
    private Boolean deleted = false;
}
