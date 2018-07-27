package cc.service.impl;

import cc.common.CommonConst;
import cc.dao.INewsDao;
import cc.entity.NewsEntity;
import cc.service.INewsService;
import cc.utils.Page;
import cc.utils.PageList;
import cc.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("newsService")
public class NewsServiceImpl implements INewsService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(NewsServiceImpl.class);

	@Autowired
	private INewsDao newsDao;

	@Override
	public int insert(NewsEntity entity) {
		if (null == entity) {
			LOGGER.info("UserServiceImpl insert entity is null.");
			return CommonConst.DIGIT_ZERO;
		}

		LOGGER.info("Entering UserServiceImpl insert...");
		int result = newsDao.insert(entity);
		LOGGER.info("Exiting UserServiceImpl insert...");
		return result;

	}

	@Override
	public int update(NewsEntity entity) {
		if (null == entity) {
			LOGGER.info("UserServiceImpl update entity is null.");
			return CommonConst.DIGIT_ZERO;
		}

		if (StringUtils.isBlank(entity.getTitle())) {
			LOGGER.info("UserServiceImpl update userName is null.");
			return CommonConst.DIGIT_ZERO;
		}

		LOGGER.info("Entering UserServiceImpl update...");
		int result = newsDao.update(entity);
		LOGGER.info("Exiting UserServiceImpl update...");
		return result;
	}

	@Override
	public int delete(NewsEntity entity) {
		if (null == entity) {
			LOGGER.info("UserServiceImpl delete entity is null.");
			return CommonConst.DIGIT_ZERO;
		}

		if (StringUtils.isBlank(entity.getId())) {
			LOGGER.info("UserServiceImpl delete userName is null.");
			return CommonConst.DIGIT_ZERO;
		}

		LOGGER.info("Entering UserServiceImpl delete...");
		int result = newsDao.delete(entity);
		LOGGER.info("Exiting UserServiceImpl delete...");
		return result;
	}

	@Override
	public List<NewsEntity> queryList(Map<String, Object> map) {
		LOGGER.info("Entering UserServiceImpl queryList service...");
		List<NewsEntity> list = newsDao.queryList(map);
		LOGGER.info("Exiting UserServiceImpl queryList service...");
		return list;
	}

	@Override
	public PageList<NewsEntity> queryPage(Page page, Map<String, Object> map) {
		if(null == page || null == map) {
			LOGGER.info("UserPicServiceImpl queryList page or map is null.");
			return null;
		}
		
		LOGGER.info("Entering UserPicServiceImpl queryPage...");
		PageList<NewsEntity> list = newsDao.queryPage(page, map);
		LOGGER.info("Exiting UserPicServiceImpl queryPage...");
		return list;
	}

}
