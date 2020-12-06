package com.affinipay.dto;

import com.affinipay.util.Constants;

public class UserDate {

	Long totalMinutes;
	
	int days;
	int hours;
	int minutes;

	public int getDays() {
		return days;
	}

	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}


	

	
	
	
	public UserDate(Long totalMinutes){
		
		if(totalMinutes < 0) {
			long daysOffSet = -1 - totalMinutes/Constants.MIN_IN_DAY;
			long minutesOffset = -1 * daysOffSet * Constants.MIN_IN_DAY + totalMinutes;
			
			days += daysOffSet;
			this.totalMinutes = minutesOffset;
		}
		
		if (totalMinutes >=0) {
			long daysOffSet = totalMinutes / Constants.MIN_IN_DAY;
			long minutesOffset = totalMinutes - daysOffSet * Constants.MIN_IN_DAY;
			
			days += daysOffSet;
			this.totalMinutes = minutesOffset;
		}
		
		this.hours = (int) (this.totalMinutes / 60);
		this.minutes = (int) (this.totalMinutes - this.hours * 60) ;
	}

	@Override
	public String toString() {
		return "UserDate [totalMinutes=" + totalMinutes + ", days=" + days + ", hours=" + hours + ", minutes=" + minutes
				+ "]";
	}

	public UserDate addMinutes(Integer minutes) {
		return new UserDate(this.totalMinutes + minutes);
		
	}

	public String to12HrsTimeString() {
		StringBuilder sb = new StringBuilder();
		if (Constants.ADD_DAYS_OFFSET && this.days != 0) {
			sb.append(this.days).append(" D ");
		}
		
		sb.append(String.format("%02d", hours % 12)).append(":").append(String.format("%02d", minutes)).append(" ").append(hours >=12 ? "PM": "AM");
		return sb.toString();
	}
	
	
	
}
