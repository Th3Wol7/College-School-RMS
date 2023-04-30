package model;

public class Date {
	private int day;
	private int month;
	private int year;
	
	Date() {
		setDay(0);
		setMonth(00);
		setYear(0000);
	}
	
	//Primary Constructor
	Date(int day, int month, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
	}
	
	//Copy Constructor
	Date(Date obj) {
		setDay(obj.day);
		setMonth(obj.month);
		setYear(obj.year);
	}
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Date [getDay()=" + getDay() + ", getMonth()=" + getMonth() + ", getYear()=" + getYear() + "]";
	}

}
