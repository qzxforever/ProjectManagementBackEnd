package org.bestsoft.jpa.repository;

import org.bestsoft.jpa.entity.SysToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author CrazyJay
 * @Date 2019/3/30 22:05
 * @Version 1.0
 */

public interface SysTokenRepository extends JpaRepository<SysToken, Integer> {
    SysToken findByToken(String accessToken);

    SysToken findByUserId(Long userId);
}
