package com.affinipay.service;

import org.springframework.stereotype.Service;

import com.affinipay.dto.UserDate;
import com.affinipay.util.CalendarUtil;

@Service
public class CalendarService {

	public UserDate addMinutes(String dateString, Integer minutes) {
		
		UserDate date = CalendarUtil.convertDateStringToDate(dateString);
		date = date.addMinutes(minutes);
		return date;
	}
}
