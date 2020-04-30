package com.myapplicationdev.android.p02_sgholidays;

public class Holiday {
    private String holidayType;
    private String holidayName;
    private String date;

    public Holiday(String holidayType, String holidayName, String date) {
        this.holidayType = holidayType;
        this.holidayName = holidayName;
        this.date = date;
    }

    public String getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(String holidayType) {
        this.holidayType = holidayType;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}