package part03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//   http://localhost:8090/myapp/helloModelAndView.htm

@Controller
public class HelloModelAndViewController {

	@RequestMapping("/helloModelAndView.htm")
	public ModelAndView search(ModelAndView mav) {
		// ModelAndView mav =new ModelAndView(); 위에 10행이랑 같은 의미
		mav.addObject("name","kim");
		mav.addObject("age",30);
		mav.setViewName("part03/helloModelView");
		
	
		return mav;
	}
}
