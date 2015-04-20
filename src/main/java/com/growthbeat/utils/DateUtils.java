package com.growthbeat.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	public static Date dateFromDateString(String dateString) {
		return dateFromString("yyyy-MM-dd", dateString);
	}

	public static Date dateFromDateTimeString(String dateTimeString) {
		return dateFromString("yyyy-MM-dd HH:mm:ss", dateTimeString);
	}

	public static Date dateFromDateTimeStringIsoType(String dateTimeStringIsoType) {
		return dateFromString("yyyy-MM-dd'T'HH:mm:ssX", dateTimeStringIsoType);
	}

	public static Date dateFormTimeString(String timeString) {
		return dateFromString("hh:mm:ss", timeString);
	}

	public static String dateTimeStringFromDate(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

	public static String dateTimeStringFromDateWithFormat(Date date, String format) {
		return new SimpleDateFormat(format).format(date);
	}

	public static String dateTimeStringFromDateWithFormat(Date date, String format, TimeZone timeZone) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setTimeZone(timeZone);
		return dateFormat.format(date);
	}

	public static Date dateFromString(String format, String string) {

		try {
			return new SimpleDateFormat(format).parse(string);
		} catch (ParseException e) {
			return null;
		}

	}

	public static Date convertTimeZone(Date date, TimeZone timeZone) {

		long time = date.getTime();
		int offset = timeZone.getOffset(time) - TimeZone.getDefault().getOffset(time);
		return new Date(time + offset);

	}

	public static boolean compareDate(Date begin, Date end, Date now) {

		if (begin != null && begin.after(now))
			return false;
		if (end != null && end.before(now))
			return false;
		return true;

	}

	public static Date firstDateOfThisMonth(Date date) {
		return firstDateOfMonth(date, 0);
	}

	public static Date firstDateOfPreviousMonth(Date date) {
		return firstDateOfMonth(date, -1);
	}

	public static Date firstDateOfNextMonth(Date date) {
		return firstDateOfMonth(date, 1);
	}

	public static Date firstDateOfMonth(Date date, int offset) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + offset);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();

	}

	public static Date dateAfterOffset(Date date, int offset) {

		Calendar dateCalendar = Calendar.getInstance();
		dateCalendar.setTime(date);

		Calendar calendar = Calendar.getInstance();
		calendar.set(dateCalendar.get(Calendar.YEAR), dateCalendar.get(Calendar.MONTH), dateCalendar.get(Calendar.DATE) + offset, 0, 0, 0);
		return calendar.getTime();
	}

	public static Date dateAfterOffsetIncledeTime(Date date, int offset) {

		Calendar dateCalendar = Calendar.getInstance();
		dateCalendar.setTime(date);

		Calendar calendar = Calendar.getInstance();
		calendar.set(dateCalendar.get(Calendar.YEAR), dateCalendar.get(Calendar.MONTH), dateCalendar.get(Calendar.DATE) + offset,
				dateCalendar.get(Calendar.HOUR), dateCalendar.get(Calendar.SECOND), dateCalendar.get(Calendar.MILLISECOND));
		return calendar.getTime();
	}

	public static int getActualMaximum(Date date, int field) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return calendar.getActualMaximum(field);

	}

}
