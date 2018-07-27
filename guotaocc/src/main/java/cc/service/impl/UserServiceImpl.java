package cc.service.impl;

import cc.common.CommonConst;
import cc.dao.IUserDao;
import cc.entity.UserEntity;
import cc.service.IUserService;
import cc.utils.Page;
import cc.utils.PageList;
import cc.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("userService")
public class UserServiceImpl implements IUserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private IUserDao userDao;
	
	
	@Override
	public int insert(UserEntity entity) {
		if(null == entity) {
			LOGGER.info("UserServiceImpl insert entity is null.");
			return CommonConst.DIGIT_ZERO;
		}
		
		LOGGER.info("Entering UserServiceImpl insert...");
		int result = userDao.insert(entity);
		LOGGER.info("Exiting UserServiceImpl insert...");
		return result;
		
	}
	
	@Override
	public int update(UserEntity entity) {
		if(null == entity) {
			LOGGER.info("UserServiceImpl update entity is null.");
			return CommonConst.DIGIT_ZERO;
		}
		
		if(StringUtils.isBlank(entity.getUserMobile())) {
			LOGGER.info("UserServiceImpl update userName is null.");
			return CommonConst.DIGIT_ZERO;
		}
		
		LOGGER.info("Entering UserServiceImpl update...");
		int result = userDao.update(entity);
		LOGGER.info("Exiting UserServiceImpl update...");
		return result;
	}
	
	
	@Override
	public int delete(UserEntity entity) {
		if(null == entity) {
			LOGGER.info("UserServiceImpl delete entity is null.");
			return CommonConst.DIGIT_ZERO;
		}
		
		if(StringUtils.isBlank(entity.getUserMobile())) {
			LOGGER.info("UserServiceImpl delete userName is null.");
			return CommonConst.DIGIT_ZERO;
		}
		
		LOGGER.info("Entering UserServiceImpl delete...");
		int result = userDao.delete(entity);
		LOGGER.info("Exiting UserServiceImpl delete...");
		return result;
	}
	

	@Override
	public List<UserEntity> queryList(Map<String, Object> map) {
		if(null == map || map.isEmpty()) {
			LOGGER.info("UserServiceImpl queryList Service Map is null.");
			return null;
		}
		LOGGER.info("Entering UserServiceImpl queryList service...");
		List<UserEntity> list = userDao.queryList(map);
		LOGGER.info("Exiting UserServiceImpl queryList service...");
		return list;
	}

	@Override
	public PageList<UserEntity> queryPage(Page page, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}

