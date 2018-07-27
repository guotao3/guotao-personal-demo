package cc.service.impl;

import cc.common.CommonConst;
import cc.dao.IVisitorDao;
import cc.entity.VisitorEntity;
import cc.service.IVisitorService;
import cc.utils.Page;
import cc.utils.PageList;
import cc.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("visitorService")
public class VisitorServiceImpl implements IVisitorService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(VisitorServiceImpl.class);

	@Autowired
	private IVisitorDao visitorDao;

	@Override
	public int insert(VisitorEntity entity) {
		if (null == entity) {
			LOGGER.info("UserServiceImpl insert entity is null.");
			return CommonConst.DIGIT_ZERO;
		}

		LOGGER.info("Entering UserServiceImpl insert...");
		int result = visitorDao.insert(entity);
		LOGGER.info("Exiting UserServiceImpl insert...");
		return result;

	}

	@Override
	public int update(VisitorEntity entity) {
		if (null == entity) {
			LOGGER.info("UserServiceImpl update entity is null.");
			return CommonConst.DIGIT_ZERO;
		}

		LOGGER.info("Entering UserServiceImpl update...");
		int result = visitorDao.update(entity);
		LOGGER.info("Exiting UserServiceImpl update...");
		return result;
	}

	@Override
	public int delete(VisitorEntity entity) {
		if (null == entity) {
			LOGGER.info("UserServiceImpl delete entity is null.");
			return CommonConst.DIGIT_ZERO;
		}

		if (StringUtils.isBlank(entity.getId())) {
			LOGGER.info("UserServiceImpl delete userName is null.");
			return CommonConst.DIGIT_ZERO;
		}

		LOGGER.info("Entering UserServiceImpl delete...");
		int result = visitorDao.delete(entity);
		LOGGER.info("Exiting UserServiceImpl delete...");
		return result;
	}

	@Override
	public List<VisitorEntity> queryList(Map<String, Object> map) {
		LOGGER.info("Entering UserServiceImpl queryList service...");
		List<VisitorEntity> list = visitorDao.queryList(map);
		LOGGER.info("Exiting UserServiceImpl queryList service...");
		return list;
	}

	@Override
	public PageList<VisitorEntity> queryPage(Page page, Map<String, Object> map) {
		if(null == page || null == map) {
			LOGGER.info("UserPicServiceImpl queryList page or map is null.");
			return null;
		}
		
		map.put("startIndex", Integer.valueOf(page.getStartIndex()));
		map.put("pageSize", Integer.valueOf(page.getPageSize()));
		
		LOGGER.info("Entering UserPicServiceImpl queryPage...");
		PageList<VisitorEntity> list = visitorDao.queryPage(page, map);
		LOGGER.info("Exiting UserPicServiceImpl queryPage...");
		return list;
	}

}
