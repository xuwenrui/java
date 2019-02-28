package com.xuwenrui.shiro.dao;

import java.util.List;
import com.xuwenrui.shiro.entity.Role;

/**
 * @author 作者:ManrayHsu
 * @Email 386277405@qq.com
 * @date 创建时间: 2016年3月17日
 * @version 1.0
 * @since
 */
public interface RoleMapper {
	public int createRole(Role role);

	public int updateRole(Role role);

	public void deleteRole(Long roleId);

	public Role findOne(Long roleId);

	public List<Role> findAll();
}