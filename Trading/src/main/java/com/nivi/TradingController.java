package com.nivi;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TradingController {
	protected Logger logger = Logger
			.getLogger(TradingController.class.getName());
	
	@Autowired
	TradingRepository tradingRepository;
	@Autowired
	UserRepository userRepository;
	
	
	@RequestMapping("/")
	public ModelAndView getHomePage() {
		ModelAndView mv=new ModelAndView();
		//List<Stock> stock=(List<Stock>) tradingService.findAll();
		mv.setViewName("Home");
		return mv;
	}
		
	@RequestMapping("/ViewAllStocks")	
	public ModelAndView getStock() {
		ModelAndView mv=new ModelAndView();
		List<Stock> stock=(List<Stock>)tradingRepository.findAll();
		mv.addObject("stockList",stock);
		mv.setViewName("ViewStocks");
		return mv;
		
	}
	@RequestMapping("/BuyStocks")	
	public ModelAndView buyStock()  {
			ModelAndView mv=new ModelAndView();
			mv.setViewName("User");
			return mv;
	}
	@RequestMapping("/PlaceOrder")	
	public ModelAndView order(@ModelAttribute User user)  {
			ModelAndView mv=new ModelAndView();
			User user1=new User();
			mv.setViewName("User");
			return mv;
	}
}