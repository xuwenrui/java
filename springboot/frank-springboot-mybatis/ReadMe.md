### mysql脚本
```mysql
CREATE TABLE `t_u ser` (
  `id` INT(8) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(50) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户表';
```

### mybatis注解
@Select("sql") 使用注解可以不配置mapper.xml

### mybatis基于properties配置方式
```
mybatis.mapper-locations=classpath:mapper/*.xml
mybatis.type-aliases-package=com.frank.entity
```

### mybatis基于xml配置方式
```code
mybatis.config-location=classpath:mybatis-config.xml
```
内容见mybatis-config.xml，mapper映射需要注意配置
