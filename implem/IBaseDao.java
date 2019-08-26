package com.ozc.implem;

import java.util.List;
import java.util.Map;


public interface IBaseDao<E> {
	
		public List<E> list(Map<String, Object> param);
		public E getObjById(Long id);
		public int add(E obj);
		public int update(E obj);
		public int delete(Long id);
}
