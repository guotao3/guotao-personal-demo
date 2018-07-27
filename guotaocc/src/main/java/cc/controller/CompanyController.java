package cc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {

	/**
	 * @param request
	 * @return
	 * @throws ServletRequestBindingException
	 */
	@RequestMapping(value = "/company", method = RequestMethod.GET)
	public ModelAndView forwardUserInfo(HttpServletRequest request, @RequestParam(required = true, defaultValue = "0") String num) throws ServletRequestBindingException {
		if(num.equals("1")){
			ModelAndView mav = new ModelAndView("company/company_1");
			return mav;
		}else if(num.equals("2")){
			ModelAndView mav = new ModelAndView("company/company_2");
			return mav;
		}else if(num.equals("3")){
			ModelAndView mav = new ModelAndView("company/company_3");
			return mav;
		}else if(num.equals("4")){
			ModelAndView mav = new ModelAndView("company/company_4");
			return mav;
		}else if(num.equals("5")){
			ModelAndView mav = new ModelAndView("company/company_5");
			return mav;
		}else if(num.equals("6")){
			ModelAndView mav = new ModelAndView("company/company_6");
			return mav;
		}else if(num.equals("7")){
			ModelAndView mav = new ModelAndView("company/company_7");
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("index/index");
		return mav;
	}
	
	/**
	 * @param request
	 * @return
	 * @throws ServletRequestBindingException
	 */
	@RequestMapping(value = "/newsIndex", method = RequestMethod.GET)
	public ModelAndView newsIndex(HttpServletRequest request)
			throws ServletRequestBindingException {
		ModelAndView mav = new ModelAndView("news/news_index");
		return mav;
	}
	

}
