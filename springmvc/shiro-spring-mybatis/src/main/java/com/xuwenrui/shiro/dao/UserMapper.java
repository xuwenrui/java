package com.xuwenrui.shiro.dao;

import java.util.List;
import com.xuwenrui.shiro.entity.User;

/**
 * @author 作者:ManrayHsu
 * @Email 386277405@qq.com
 * @date 创建时间: 2016年3月17日
 * @version 1.0
 * @since
 */
public interface UserMapper {
	public int createUser(User user);

	public int updateUser(User user);

	public void deleteUser(Long userId);

	User findOne(Long userId);

	List<User> findAll();

	User findByUsername(String username);
}