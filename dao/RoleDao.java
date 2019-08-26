package com.ozc.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.ozc.entity.Role;
import com.ozc.implem.IRoleDao;

/**
 * 角色操作Dao
 * @author Administrator
 *
 */
@Repository
public class RoleDao extends BaseDao<Role> implements IRoleDao{
	
	// 增加角色和菜单关系
	/* (non-Javadoc)
	 * @see com.zc.dao.IRoleDao#addRole2Menu(long, long)
	 */
	public int addRole2Menu(long roleId, long menuId) {
		int i = 0;
		Map<String,Object> param = new HashMap<>();
		param.put("roleId", roleId);
		param.put("menuId", menuId);
		i = this.getSqlSession().insert(getNs("addR2M"),param);
		return i;
	}

	// 删除角色和菜单关系
	/* (non-Javadoc)
	 * @see com.zc.dao.IRoleDao#deleteRole2Menu(long, long)
	 */
	public int deleteRole2Menu(long roleId, long menuId) {
		int i = 0;
		Map<String,Object> param = new HashMap<>();
		param.put("roleId", roleId);
		param.put("menuId", menuId);
		i = this.getSqlSession().insert(getNs("deleteR2M"),param);
		return i;
	}
}
