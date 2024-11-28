package kr.ohora.www.domain;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.ohora.www.persistence.TimeMapper;

@Controller
public class TimeMybatisController {
	
	//Dependency Injection
	@Autowired
	private TimeMapper timeMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(TimeMybatisController.class);

	//@RequestMapping(value = "/time", method = RequestMethod.GET)
	@GetMapping(value = "/time")//control method? controller method?
	public String time(Locale locale, Model model, HttpServletRequest request) {
		logger.info("TimeMybatisController.time()호출했당~~", locale);
		
		//지금까지는 DAO에서 선언, DAO implements class에서 구현해서 했어
		//그런데 Mybatis 쓰면 DAO implements 안써도 돼
		String currentTime = this.timeMapper.getTime();
		model.addAttribute("currentTime", currentTime);
		
		String currentNextTime = this.timeMapper.getNextTime();
		request.setAttribute("currentNextTime", currentNextTime);
		
		return "time";//ViewResolver에 의해 경로가 만들어져.
	}
	
}
