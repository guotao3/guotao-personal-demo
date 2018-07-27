package cc.dao.impl;

import cc.dao.IBaseDao;
import cc.utils.Page;
import cc.utils.PageList;
import cc.utils.ReflectionUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public abstract class BaseDao<T> extends SqlSessionDaoSupport implements
		IBaseDao<T> {
	private Logger LOGGER = LoggerFactory.getLogger(getClass());

	private Class<T> entityClass;
	private String className;
	private String insert;
	private String update;
	private String delete;
	private String queryList;
	private String count;
	private String queryPage;

	public BaseDao() {
		LOGGER.info("BaseDao() " + className);
		this.entityClass = ReflectionUtils.getSuperClassGenericType(getClass());
		this.className = this.entityClass.getSimpleName();
		this.insert = MessageFormat.format("{0}.insert",
				new Object[] { this.className });
		this.update = MessageFormat.format("{0}.update",
				new Object[] { this.className });
		this.delete = MessageFormat.format("{0}.delete",
				new Object[] { this.className });
		this.queryList = MessageFormat.format("{0}.queryList",
				new Object[] { this.className });
		this.count = MessageFormat.format("{0}.count",
				new Object[] { this.className });
		this.queryPage = MessageFormat.format("{0}.queryPage",
				new Object[] { this.className });
	}

	@Override
	public int insert(T entity) {
		LOGGER.info("Entering {0} insert dao...",
				new Object[] { this.className });
		int result = this.getSqlSession().insert(this.insert, entity);
		LOGGER.info("Exiting {0} insert dao...",
				new Object[] { this.className });
		return result;
	}

	@Override
	public int update(T entity) {
		LOGGER.info("Entering {0} update dao...", new Object[] { this.className });
		int result = this.getSqlSession().update(this.update, entity);
		LOGGER.info("Exiting {0} update dao...", new Object[] { this.className });
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int delete(T entity) {
		LOGGER.info("Entering {0} delete dao...", new Object[] { this.className });
		int result = this.getSqlSession().delete(this.delete, entity);
		LOGGER.info("Exiting {0} delete dao...", new Object[] { this.className });
		return result;
	}

	@Override
	public List<T> queryList(Map<String, Object> map) {
		LOGGER.info("Entering {0} queryList dao...", new Object[] { this.className });
		List<T> list = this.getSqlSession().selectList(this.queryList, map);
		LOGGER.info("Exiting {0} queryList dao...", new Object[] { this.className });
		return list;
	}

	@Override
	public PageList<T> queryPage(Page page, Map<String, Object> map) {
		LOGGER.info("Entering {0} queryPage dao...", new Object[] { this.className });

		List<T> list = this.getSqlSession().selectList(this.queryPage, map);
		map.put("startIndex", Integer.valueOf(page.getStartIndex()));
		map.put("pageSize", Integer.valueOf(page.getPageSize()));

		PageList<T> pagingList = new PageList<T>(list, page);
		LOGGER.info("Exiting {0} queryPage dao...", new Object[] { this.className });

		return pagingList;
	}

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

}
