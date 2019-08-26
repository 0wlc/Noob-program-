package com.ozc.implem;

import com.ozc.entity.Role;

public interface IRoleDao extends IBaseDao<Role>{

	// 增加角色和菜单关系
	public abstract int addRole2Menu(long roleId, long menuId);

	// 删除角色和菜单关系
	public abstract int deleteRole2Menu(long roleId, long menuId);

}