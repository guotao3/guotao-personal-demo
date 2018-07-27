package cc.controller;

import cc.common.CommonConst;
import cc.entity.NewsEntity;
import cc.entity.UserEntity;
import cc.service.INewsService;
import cc.utils.AliyunOSSUtil;
import cc.utils.StringUtils;
import cc.utils.YouDaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/new")
public class NewsController {

	@Autowired
	private INewsService newsService;

	/**
	 * @param request
	 * @return
	 * @throws ServletRequestBindingException
	 */
	@ResponseBody
	@RequestMapping(value = "/newsIndex", method = RequestMethod.POST)
	public Map<String,Object> newsIndex(HttpServletRequest request,@RequestParam(value = "id", required = true, defaultValue = "")String id)throws ServletRequestBindingException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		if(StringUtils.isBlank(id)){
			resultMap.put(CommonConst.RESPONSE_STATUS, CommonConst.RESPONSE_STATUS_FAIL);
			return resultMap;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		List<NewsEntity> list = newsService.queryList(map);

		if (list == null || list.size() <= 0) {
			resultMap.put(CommonConst.RESPONSE_STATUS, CommonConst.RESPONSE_STATUS_FAIL);
			return resultMap;
		}
		
		NewsEntity news = list.get(0);
		news.setUrl(AliyunOSSUtil.getDownLoadUrl(news.getUrl()));
		news.setTitle(YouDaoUtil.getYouDaoValue(news.getTitle()));
		
		resultMap.put(CommonConst.RESPONSE_STATUS, CommonConst.RESPONSE_STATUS_SUCCESS);
		resultMap.put("news", news);
		return resultMap;

	}

	/**
	 * 新闻列表
	 * 
	 * @param request
	 * @return
	 * @throws ServletRequestBindingException
	 */
	@RequestMapping(value = "/newsList", method = RequestMethod.GET)
	public ModelAndView about(HttpServletRequest request) throws ServletRequestBindingException {
		UserEntity user = (UserEntity) request.getSession().getAttribute(CommonConst.SESSION_USER);
		if(user == null){
			return new ModelAndView("user/login");
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<NewsEntity> newslist = newsService.queryList(map);

		ModelAndView mav = new ModelAndView("news/news_list");
		mav.addObject("newslist", newslist);

		return mav;
	}

	/**
	 * @param request
	 * @return
	 * @throws ServletRequestBindingException
	 */
	@RequestMapping(value = "/subcompanys", method = RequestMethod.GET)
	public ModelAndView subcompanys(HttpServletRequest request)
			throws ServletRequestBindingException {
		ModelAndView mav = new ModelAndView("index/subcompanys");
		return mav;
	}

	/**
	 * @param request
	 * @return
	 * @throws ServletRequestBindingException
	 */
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact(HttpServletRequest request)
			throws ServletRequestBindingException {
		ModelAndView mav = new ModelAndView("index/contact");
		return mav;
	}

	/**
	 * @param request
	 * @return
	 * @throws ServletRequestBindingException
	 */
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public ModelAndView news(HttpServletRequest request)
			throws ServletRequestBindingException {
		UserEntity user = (UserEntity) request.getSession().getAttribute(CommonConst.SESSION_USER);
		if(user == null){
			return new ModelAndView("user/login");
		}
		return new ModelAndView("news/news_write");
	}

	/**
	 * 添加新闻
	 * 
	 * @author yzp
	 * @since 2016-10-11
	 * @param request
	 * @return
	 * @throws ServletRequestBindingException
	 */
	@RequestMapping(value = "/addNews", method = RequestMethod.POST)
	public ModelAndView addNews(@RequestParam(value = "picture", required = false) MultipartFile picture, HttpServletRequest request) throws ServletRequestBindingException {
		
		UserEntity user = (UserEntity) request.getSession().getAttribute(CommonConst.SESSION_USER);
		if(user == null){
			return new ModelAndView("user/login");
		}
		
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String enContent = request.getParameter("enContent");

		if (StringUtils.isBlank(content) || StringUtils.isBlank(title)) {
			return new ModelAndView("news/news_write");
		}

		try {
			if (picture.getSize() <= 0) {
				return new ModelAndView("news/news_write");
			}

			String newFileName = upload(picture, request);
			if (StringUtils.isBlank(newFileName)) {
				return new ModelAndView("news/news_write");
			}

			NewsEntity news = new NewsEntity();
			news.setId(StringUtils.produceUUID());
			news.setWriter(author);
			news.setContent(content);
			news.setEnContent(enContent);
			news.setTitle(title);
			news.setUrl(newFileName);
			news.setActive(true);
			news.setCreateTime(new Date());

			int result = newsService.insert(news);

			if (result <= 0) {
				ModelAndView mav = new ModelAndView("news/news_write");
				return mav;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView("redirect:newsList.html");
		return mav;
	}

	/**
	 * 上传图片
	 * 
	 * @author yzp
	 * @since 2016-10-11
	 * @param picture
	 * @return
	 */
	public String upload(MultipartFile picture, HttpServletRequest request) {
		try {
			String fileName = picture.getOriginalFilename();
			// 获取图片的扩展名
			String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
			// 新的图片文件名 = 获取时间戳+"."图片扩展名
			String newFileName = String.valueOf(System.currentTimeMillis()) + "." + extensionName;
			// TODO Auto-generated method stub
			// 根据配置文件获取服务器图片存放路径
            AliyunOSSUtil.uploadMultipartFile(newFileName, picture);
            // 上传后删除
			return newFileName;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 显示一条新闻
	 * 
	 * @author yzp
	 * @since 2016-10-11
	 * @param picture
	 * @return
	 */
	@RequestMapping(value = "/showNews", method = RequestMethod.GET)
	public ModelAndView showNews(@RequestParam(value = "id", required = true, defaultValue = "") String id, HttpServletRequest request) {
		UserEntity user = (UserEntity) request.getSession().getAttribute(CommonConst.SESSION_USER);
		if(user == null){
			return new ModelAndView("user/login");
		}
		
		if (StringUtils.isBlank(id)) {
			return new ModelAndView("redirect:newsList.html");
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		List<NewsEntity> list = newsService.queryList(map);

		if (list == null || list.size() <= 0) {
			return new ModelAndView("redirect:newsList.html");
		}

		ModelAndView mv = new ModelAndView("news/news_update");
		NewsEntity news = list.get(0);

		String path = request.getScheme() + "://" + request.getServerName() + CommonConst.PICTURE_VIS_URL + news.getUrl();// +request.getRequestURI()+"?"+request.getQueryString();
		news.setUrl(path);

		mv.addObject("news", news);

		return mv;
	}

	/**
	 * 显示一条新闻
	 * 
	 * @author yzp
	 * @since 2016-10-11
	 * @param picture
	 * @return
	 */
	@RequestMapping(value = "/deleteNews", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteNews(@RequestParam(value = "id", required = true, defaultValue = "") String id, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		UserEntity user = (UserEntity) request.getSession().getAttribute(CommonConst.SESSION_USER);
		if(user == null){
			resultMap.put(CommonConst.RESPONSE_STATUS, CommonConst.RESPONSE_STATUS_FAIL);
		}
		
		if (StringUtils.isBlank(id)) {
			resultMap.put(CommonConst.RESPONSE_STATUS, CommonConst.RESPONSE_STATUS_FAIL);
			return resultMap;
		}

		NewsEntity entity = new NewsEntity();
		entity.setId(id);
		int result = newsService.delete(entity);

		if (result <= 0) {
			resultMap.put(CommonConst.RESPONSE_STATUS, CommonConst.RESPONSE_STATUS_FAIL);
			return resultMap;
		}

		resultMap.put(CommonConst.RESPONSE_STATUS, CommonConst.RESPONSE_STATUS_SUCCESS);
		return resultMap;

	}

	/**
	 * 添加新闻
	 * 
	 * @author yzp
	 * @since 2016-10-11
	 * @param request
	 * @return
	 * @throws ServletRequestBindingException
	 */
	@RequestMapping(value = "/updateNews", method = RequestMethod.POST)
	public ModelAndView updateNews(@RequestParam(value = "picture", required = false) MultipartFile picture, HttpServletRequest request) throws ServletRequestBindingException {
		UserEntity user = (UserEntity) request.getSession().getAttribute(CommonConst.SESSION_USER);
		if(user == null){
			return new ModelAndView("user/login");
		}
		
		String anthor = request.getParameter("anthor");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String enContent = request.getParameter("enContent");
		String id = request.getParameter("id");
		
		if ( StringUtils.isBlank(title) || StringUtils.isBlank(id)) {
			return  new ModelAndView("redirect:showNews.html?id="+id);
		}

		try {
			NewsEntity news = new NewsEntity();
			if (picture.getSize() > 0) {
				String newFileName = upload(picture, request);

				if (StringUtils.isBlank(newFileName)) {
					return  new ModelAndView("redirect:showNews.html?id="+id);
				}
				news.setUrl(newFileName);
			}
			
			if(!StringUtils.isBlank(content)){
				news.setContent(content);
			}
			if(!StringUtils.isBlank(enContent)){
				news.setEnContent(enContent);
			}
			
			news.setId(id);
			news.setWriter(anthor);
			news.setTitle(title);
			news.setCreateTime(new Date());

			int result = newsService.update(news);

			if (result <= 0) {
				return  new ModelAndView("redirect:showNews.html?id="+id);
			}
			
			return new ModelAndView("redirect:newsList.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return  new ModelAndView("redirect:showNews.html?id="+id);
	}

}
