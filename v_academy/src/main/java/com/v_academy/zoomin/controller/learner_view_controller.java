package com.v_academy.zoomin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.v_academy.zoomin.service.User_details_service;
@RestController
public class learner_view_controller {
	
	@Autowired
	private User_details_service user_details_service;
	
	@GetMapping("/all_courses")
	public ModelAndView show_courses() {
		return new ModelAndView("all_courses");
	}
	
	@GetMapping("/course_disc/{course_id}")
    public ModelAndView course1_disc(@PathVariable("course_id") String course_id)
	{
		return new ModelAndView("course"+course_id+"_disc");
    }
	
	
	@GetMapping("/activate_course/{course_id}")   //plus_one to activate course_!
    public ModelAndView activate_course_1(@PathVariable("course_id") String course_id)
	{
		return new ModelAndView("welcome_course"+course_id);
	}
	
}
