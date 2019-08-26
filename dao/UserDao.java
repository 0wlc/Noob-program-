package com.ozc.dao;

import org.springframework.stereotype.Repository;

import com.ozc.entity.User;
import com.ozc.implem.IUserDao;

/**
 * 用户操作Dao
 * @author Administrator
 *
 */
@Repository
public class UserDao extends BaseDao<User> implements IUserDao{

}
