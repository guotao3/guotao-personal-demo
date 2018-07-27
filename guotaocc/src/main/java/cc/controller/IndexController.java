package cc.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/index")
public class IndexController {
	/**
	 * @param request
	 * @return
	 * @throws ServletRequestBindingException
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView forwardUserInfo(HttpServletRequest request)
			throws ServletRequestBindingException {
			ModelAndView mav = new ModelAndView("index/index");
			return mav;
		}

	/**
	 * @param request
	 * @return
	 * @throws ServletRequestBindingException
	 */
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about(HttpServletRequest request)
			throws ServletRequestBindingException {
		ModelAndView mav = new ModelAndView("index/about");
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
	@RequestMapping(value = "/pricing", method = RequestMethod.GET)
	public ModelAndView pricing(HttpServletRequest request)
			throws ServletRequestBindingException {
		ModelAndView mav = new ModelAndView("index/pricing");
		return mav;
	}

}
