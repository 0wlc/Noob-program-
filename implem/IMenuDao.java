package com.ozc.implem;

import java.util.List;

import com.ozc.entity.Menu;

public interface IMenuDao extends IBaseDao<Menu>{

	public abstract List<Menu> getMenusByRoleId(Long roleId);

}