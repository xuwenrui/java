package com.xuwenrui.shiro.entity;

import java.io.Serializable;
import com.xuwenrui.shiro.entity.Organization;

/**
 * @author 作者:ManrayHsu
 * @Email 386277405@qq.com
 * @date 创建时间: 2016年3月17日
 * @version 1.0
 * @since
 */
public class Organization implements Serializable {
	/**
	 * The serializable class XXX does not declare a static final
	 * serialVersionUID field of type long serialVersionUID作用：
	 * 序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。
	 */
	private static final long serialVersionUID = 1L;
	private Long id; // 编号
	private String name; // 组织机构名称
	private Long parentId; // 父编号
	private String parentIds; // 父编号列表，如1/2/
	private Boolean available = Boolean.FALSE;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public boolean isRootNode() {
		return parentId == 0;
	}

	public String makeSelfAsParentIds() {
		return getParentIds() + getId() + "/";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Organization that = (Organization) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Organization{" + "id=" + id + ", name='" + name + '\'' + ", parentId=" + parentId + ", parentIds='"
				+ parentIds + '\'' + ", available=" + available + '}';
	}
}
