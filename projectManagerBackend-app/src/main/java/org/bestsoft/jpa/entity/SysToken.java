package org.bestsoft.jpa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author CrazyJay
 * @Date 2019/3/31 10:56
 * @Version 1.0
 */

@Data
@Entity
@Table(name = "sys_token")
public class SysToken implements Serializable {
    /**
     * 用户ID
     */
    @Id
    private Long userId;

    /**
     * token
     */
    private String token;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
