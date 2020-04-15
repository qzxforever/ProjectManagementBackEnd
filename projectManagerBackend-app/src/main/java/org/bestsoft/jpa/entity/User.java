package org.bestsoft.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
@SQLDelete(sql = "update user set deleted = 1 where id = ?")
@Where(clause = "deleted = 0")
public class User implements Serializable {
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
	private String username;

	private String password;

	private String salt;

	private String name;

	private Integer sex;

	private String email;

	private String phone;

	private Integer status;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role",
			joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
	private Set<Role> roleSet;
}
