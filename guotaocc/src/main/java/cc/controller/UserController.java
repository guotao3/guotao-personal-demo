package cc.controller;

import cc.common.CommonConst;
import cc.entity.UserEntity;
import cc.service.IUserService;
import cc.utils.SHA;
import cc.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;
	
	/**
	 * 显示登录
	 * 
	 * @author yzp
	 * @since 2016 10 10
	 * @param request
	 * @return
	 * @throws ServletRequestBindingException
	 */
	@RequestMapping(value = "/showLogin", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request) throws ServletRequestBindingException {
		return new ModelAndView("user/login");
	}
	
	/**
	 * 登录
	 * 
	 * @author yzp
	 * @since 2016-09-23
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request) {
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		
		Map<String,Object> map = new HashMap<String, Object>();
		if(StringUtils.isBlank(mobile) || StringUtils.isBlank(password)) {
			LOGGER.info("user Login login mobile password is null.");
			map.put(CommonConst.RESPONSE_STATUS, CommonConst.RESPONSE_STATUS_FAIL);
			map.put(CommonConst.RESPONSE_ERROR_MESSAGE, "参数不能为空");
		    return map;
		}
		
		map.put("userMobile", mobile);
//		map.put("userPassword", SHA.getResult(password));
		List<UserEntity> entityList = userService.queryList(map);
		if(null == entityList || entityList.size() <= 0){
			map.clear();
			map.put(CommonConst.RESPONSE_STATUS, CommonConst.RESPONSE_STATUS_FAIL);
			map.put(CommonConst.RESPONSE_ERROR_MESSAGE, "用户不存在");
			return map;
		}
		
		if (!SHA.getResult(password).equals(entityList.get(CommonConst.DIGIT_ZERO).getUserPassword())) {
			map.clear();
			map.put(CommonConst.RESPONSE_STATUS, CommonConst.RESPONSE_STATUS_FAIL);
			map.put(CommonConst.RESPONSE_ERROR_MESSAGE, "密码不正确");
			return map;
		}
		
		map.put(CommonConst.RESPONSE_STATUS, CommonConst.RESPONSE_STATUS_SUCCESS);
		LOGGER.info("validateUser success.");
		request.getSession().setAttribute(CommonConst.SESSION_USER, entityList.get(0));
		
		return map;
	}
	
}
