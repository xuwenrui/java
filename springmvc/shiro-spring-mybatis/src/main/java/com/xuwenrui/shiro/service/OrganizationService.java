package com.xuwenrui.shiro.service;

import java.util.List;

import com.xuwenrui.shiro.entity.Organization;

/**
 * @author 作者:ManrayHsu
 * @Email 386277405@qq.com
 * @date 创建时间: 2016年3月17日
 * @version 1.0
 * @since
 */
public interface OrganizationService {
	public int createOrganization(Organization organization);

	public int updateOrganization(Organization organization);

	public void deleteOrganization(Long organizationId);

	Organization findOne(Long organizationId);

	List<Organization> findAll();

	Object findAllWithExclude(Organization excludeOraganization);

	void move(Organization source, Organization target);
}
