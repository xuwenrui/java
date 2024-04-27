package com.frank.auth.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.frank.base.BaseEntity;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author system
 * @since 2024-04-27
 */
@Getter
@Setter
@TableName("sys_user")
public class SysUserEntity extends BaseEntity {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    private LocalDateTime createTime;

    private String createUser;

    private LocalDateTime updateTime;

    private String updateUser;
}
