package com.v_academy.zoomin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.v_academy.zoomin.model.User_details;
import com.v_academy.zoomin.service.User_details_service;


@Controller
public class login_controller {
	
		@Autowired
		private User_details_service user_details_service;

		@GetMapping("/")
		public String test(Model model) throws IOException
		{
			User_details user = new User_details();
			model.addAttribute("user", user);
			return "login_page"; //login page is "index"
		}
	
		@GetMapping("/sign_up") //register is sign_up 
	    public ModelAndView register(Model model)
		{
			User_details user = new User_details();
			model.addAttribute("user", user);
			return new ModelAndView("/sign_up");
	    }
		
		@PostMapping("/login_validation")              //validate is ;login_valiadation
	    public ModelAndView check(@ModelAttribute("user") User_details user) {
	    
		     ArrayList <User_details> list=(ArrayList<User_details>) user_details_service.service_get_user_logging(user.getUser_name(),user.getPassword());
		  /*   Iterator<User_details> iterator=list.iterator();
		     while(iterator.hasNext())
		     {
		    	 User_details ref=(User_details) iterator.next();
		    	 System.out.println(ref.getUser_name());
		    	 System.out.println(ref.getPassword());
		     }
		   */
		    if( list.isEmpty())
		    	  return new ModelAndView("invalid_user");
		    else
		    	return new ModelAndView("learner_profile");
			
		}
		@PostMapping("/become_user")  // check is become_user
		public ModelAndView become_user(@ModelAttribute("user") User_details user) throws IOException
		{
			 ArrayList <User_details> list=(ArrayList<User_details>) user_details_service.service_does_user_exist(user.getUser_name());
			 if( list.isEmpty())
			 {
				  user_details_service.save_row(user);
			 	  return new ModelAndView("redirect:/");
			 }
		    else
		    	return new ModelAndView("user_exists");
			
		}
	
}
