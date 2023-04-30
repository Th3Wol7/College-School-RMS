package model;

public class Date {
	private int day;
	private int month;
	private int year;
	
	Date() {
		this.day = 0;
		this.month = 00;
		this.year = 0000;
	}
	
	//Primary Constructor
	Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	//Copy Constructor
	Date(Date obj) {
		this.day = obj.day;
		this.month = obj.month;
		this.year = obj.year;
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
