package com.xuwenrui.shiro.dao;

import java.util.List;
import com.xuwenrui.shiro.entity.Organization;

/**
 * @author 作者:ManrayHsu
 * @Email 386277405@qq.com
 * @date 创建时间: 2016年3月17日
 * @version 1.0
 * @since
 */
public interface OrganizationMapper {
	public int createOrganization(Organization organization);

	public int updateOrganization(Organization organization);

	public void deleteOrganization(Long organizationId);

	Organization findOne(Long organizationId);

	List<Organization> findAll();

	List<Organization> findAllWithExclude(Organization excludeOraganization);

	void updateOrganizationByparentIds(Organization source);
}