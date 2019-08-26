package com.ozc.dao;

import org.springframework.stereotype.Repository;
import com.ozc.entity.Dict;
import com.ozc.implem.IDictDao;

/**
 * 字典操作Dao
 * @author Administrator
 *
 */
@Repository
public class DictDao extends BaseDao<Dict> implements IDictDao{
	
}
