package com.xuwenrui.shiro.dao;

import java.util.List;
import com.xuwenrui.shiro.entity.Resource;

/**
 * @author 作者:ManrayHsu
 * @Email 386277405@qq.com
 * @date 创建时间: 2016年3月17日
 * @version 1.0
 * @since
 */
public interface ResourceMapper {
	public int createResource(Resource resource);

	public int updateResource(Resource resource);

	public void deleteResource(Long resourceId);

	Resource findOne(Long resourceId);

	List<Resource> findAll();
}