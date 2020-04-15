package org.bestsoft.jpa.entity;

import lombok.Data;
import org.bestsoft.jpa.base.BaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "project_job")
@SQLDelete(sql = "update project_job set deleted = 1 where id = ?")
@Where(clause = "deleted = 0")
public class ProjectJob extends BaseEntity implements Serializable {
	@OneToOne
	@JoinColumn(name = "confirmer_id")
	private User confirmerUser;
	@OneToOne
	@JoinColumn(name = "executor_id")
	private User executorUser;
	@Column(name = "project_id")
	private Long projectId;

}
