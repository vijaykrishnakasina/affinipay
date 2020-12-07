package com.affinipay.util;

import java.util.Calendar;

import org.springframework.util.StringUtils;

import com.affinipay.dto.UserDate;

public class CalendarUtil {

	public static UserDate convertDateStringToDate(String dateString) {
		
		if (!StringUtils.hasText(dateString)) {
			throw new IllegalArgumentException("Date String should not be empty");
		}
		
		String meridies = dateString.split(" ")[1];
		String timeString = dateString.split(" ")[0];
		
		String hours = timeString.split(":")[0];
		String minutes = timeString.split(":")[1];
		
		hours = meridies.equals("AM") && hours.equals("12")? "0" : hours;
		
		Long totalMinutes = Integer.valueOf(hours) * Constants.MIN_IN_HOUR + Integer.valueOf(minutes) + (!hours.equals("12") && meridies.equals("PM") ? Constants.MIN_IN_HALF_DAY : 0L);
		
		return new UserDate(totalMinutes);
	}

}
