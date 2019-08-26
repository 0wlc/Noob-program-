package com.ozc.dao;
/**
 * 课程操作Dao
 */
import org.springframework.stereotype.Repository;
import com.ozc.entity.Course;
import com.ozc.implem.ICourseDao;

@Repository
public class CourseDao extends BaseDao<Course> implements ICourseDao{
	
}
