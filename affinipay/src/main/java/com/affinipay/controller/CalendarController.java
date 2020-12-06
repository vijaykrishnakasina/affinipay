package com.affinipay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.affinipay.dto.UserDate;
import com.affinipay.service.CalendarService;

@RestController
public class CalendarController {
	
	@Autowired
	CalendarService calendarService;

	@RequestMapping(method = RequestMethod.GET)
	public String addMinutes(@RequestParam String dateString, @RequestParam Integer minutes) {
		
		UserDate date = calendarService.addMinutes(dateString, minutes);
		return date.to12HrsTimeString();
	}
}
