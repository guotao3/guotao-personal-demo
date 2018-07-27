package cc.controller;

import cc.common.CommonConst;
import cc.entity.VisitorEntity;
import cc.service.IVisitorService;
import cc.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/visitor")
public class VisitorController {

	@Autowired
	private IVisitorService visitorService;

	/**
	 * 添加联系人
	 * 
	 * @author yzp
	 * @since 2016-10-11
	 * @param request
	 * @return
	 * @throws ServletRequestBindingException
	 */
	@RequestMapping(value = "/addVisitor", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateNews(HttpServletRequest request) throws ServletRequestBindingException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("message");

		VisitorEntity visitor = new VisitorEntity();

		visitor.setActive(true);
		visitor.setContent(content);
		visitor.setCreateTime(new Date());
		visitor.setEmail(email);
		visitor.setSubject(subject);
		visitor.setId(StringUtils.produceUUID());
		visitor.setVisitorName(name);

		visitorService.insert(visitor);
		Map<String,Object> resultMap = new HashMap<String,Object>(); 
		resultMap.put(CommonConst.RESPONSE_STATUS, CommonConst.RESPONSE_STATUS_SUCCESS);
		return resultMap;
	}

}
