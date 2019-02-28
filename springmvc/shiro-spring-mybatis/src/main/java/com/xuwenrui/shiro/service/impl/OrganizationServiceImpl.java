package com.xuwenrui.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuwenrui.shiro.entity.Organization;
import com.xuwenrui.shiro.service.OrganizationService;
import com.xuwenrui.shiro.dao.OrganizationMapper;


/**
 * @author 作者:ManrayHsu
 * @Email 386277405@qq.com
 * @date 创建时间: 2016年3月17日
 * @version 1.0 
 * @since
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public int createOrganization(Organization organization) {
        return organizationMapper.createOrganization(organization);
    }

    @Override
    public int updateOrganization(Organization organization) {
        return organizationMapper.updateOrganization(organization);
    }

    @Override
    public void deleteOrganization(Long organizationId) {
        organizationMapper.deleteOrganization(organizationId);
    }

    @Override
    public Organization findOne(Long organizationId) {
        return organizationMapper.findOne(organizationId);
    }

    @Override
    public List<Organization> findAll() {
        return organizationMapper.findAll();
    }

    @Override
    public List<Organization> findAllWithExclude(Organization excludeOraganization) {
        return organizationMapper.findAllWithExclude(excludeOraganization);
    }

    @Override
    public void move(Organization source, Organization target) {
    	target.setId(source.getId());
    	organizationMapper.updateOrganization(target);
    	organizationMapper.updateOrganizationByparentIds(source);
    }
}

