package com.ozc.dao;

import org.springframework.stereotype.Repository;

import com.ozc.entity.SCourse;
import com.ozc.implem.ISCourseDao;

/**
 * 学生选课操作Dao
 * @author Administrator
 *
 */
@Repository
public class SCourseDao extends BaseDao<SCourse> implements ISCourseDao{

}
