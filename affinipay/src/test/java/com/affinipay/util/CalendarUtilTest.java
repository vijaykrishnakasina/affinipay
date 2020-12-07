package com.affinipay.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.affinipay.dto.UserDate;

public class CalendarUtilTest {

	/// 11:59 AM -> 12:00 PM 
	// 11:59 PM -> 12:00 AM
	
	
	
	@Test
	public void UserDateTest() {
		UserDate date = new UserDate(120L);
		assertEquals(2, date.getHours());
		assertEquals(0, date.getMinutes());
		
		UserDate date2 = new UserDate(-120L);
		assertEquals(22, date2.getHours());
		assertEquals(0, date2.getMinutes());
		
		
	}
	
	
	@Test
	public  void convertDateStringToDateTest() {
		UserDate date = CalendarUtil.convertDateStringToDate("9:45 AM");
		date = date.addMinutes(5);
		assertEquals("09:50 AM", date.to12HrsTimeString());
	}
	
	@Test
	public  void convertDateStringToDateTest12AM() {
		UserDate date = CalendarUtil.convertDateStringToDate("12:45 AM");
		assertEquals(0, date.getHours());
		assertEquals(45, date.getMinutes());
		
	}
	
	@Test
	public  void convertDateStringToDateTest12PM() {
	
		
		UserDate date = CalendarUtil.convertDateStringToDate("12:45 PM");
		assertEquals(12, date.getHours());
		assertEquals(45, date.getMinutes());
		
	}
	
	@Test
	public  void convertDateStringToDateTest_At12AM() {
		UserDate date = CalendarUtil.convertDateStringToDate("12:00 AM");
		
		UserDate futureDate = date.addMinutes(5);
		assertEquals("00:05 AM", futureDate.to12HrsTimeString());
		
		UserDate pastDate = date.addMinutes(-5);
		assertEquals("11:55 PM", pastDate.to12HrsTimeString());
		
	}
	
	@Test
	public  void convertDateStringToDateTest_At12PM() {
		UserDate date = CalendarUtil.convertDateStringToDate("12:00 PM");
		
		UserDate futureDate = date.addMinutes(5);
		assertEquals("12:05 PM", futureDate.to12HrsTimeString());
		
		UserDate pastDate = date.addMinutes(-5);
		assertEquals("11:55 AM", pastDate.to12HrsTimeString());
		
	}
	
	@Test
	public  void convertDateStringToDateTest_MoreThanADay() {
		UserDate date = CalendarUtil.convertDateStringToDate("12:00 PM");
		
		UserDate futureDate = date.addMinutes((int) (Constants.MIN_IN_DAY + 5));
		assertEquals("12:05 PM", futureDate.to12HrsTimeString());
		
		UserDate pastDate = date.addMinutes((int) (-1 * Constants.MIN_IN_DAY -5));
		assertEquals("11:55 AM", pastDate.to12HrsTimeString());
		
	}
	
	
}
