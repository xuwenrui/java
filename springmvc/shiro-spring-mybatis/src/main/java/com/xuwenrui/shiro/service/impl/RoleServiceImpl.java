package com.xuwenrui.shiro.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuwenrui.shiro.dao.RoleMapper;
import com.xuwenrui.shiro.entity.Role;
import com.xuwenrui.shiro.service.ResourceService;
import com.xuwenrui.shiro.service.RoleService;


/**
 * @author 作者:ManrayHsu
 * @Email 386277405@qq.com
 * @date 创建时间: 2016年3月17日
 * @version 1.0 
 * @since
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ResourceService resourceService;

    public int createRole(Role role) {
        return roleMapper.createRole(role);
    }

    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    public void deleteRole(Long roleId) {
        roleMapper.deleteRole(roleId);
    }

    @Override
    public Role findOne(Long roleId) {
        return roleMapper.findOne(roleId);
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public Set<String> findRoles(Long... roleIds) {
        Set<String> roles = new HashSet<String>();
        for(Long roleId : roleIds) {
            Role role = findOne(roleId);
            if(role != null) {
                roles.add(role.getRole());
            }
        }
        return roles;
    }

    @Override
    public Set<String> findPermissions(Long[] roleIds) {
        Set<Long> resourceIds = new HashSet<Long>();
        for(Long roleId : roleIds) {
            Role role = findOne(roleId);
            if(role != null) {
                resourceIds.addAll(role.getResourceIds());
            }
        }
        return resourceService.findPermissions(resourceIds);
    }
}
