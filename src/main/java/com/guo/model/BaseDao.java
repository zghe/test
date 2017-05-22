package com.guo.model;

import java.util.List;

/**
 * 
 * @author hzg
 * @date 2012-9-12
 */
public interface BaseDao {

	public List<?> queryAll();
	public Object queryById(String id);
	public String insert(Object parameterObject);
	public String update(String id);
	public String delete(String id);
	
}
