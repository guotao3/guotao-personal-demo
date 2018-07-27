package cc.service;

import cc.utils.Page;
import cc.utils.PageList;

import java.util.List;
import java.util.Map;


public interface IBaseService<T> {
	
	int insert(T entity);
	int update(T entity);
	int delete(T entity);
	List<T> queryList(Map<String, Object> map);
	PageList<T> queryPage(Page page, Map<String, Object> map);
}
