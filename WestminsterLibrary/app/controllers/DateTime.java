package controllers;

import java.text.DecimalFormat;

public class DateTime {

    private int day;
    private int month;
    private int year;
    private int minute;
    private int hours;

    //creating constructor for DateTime class
    public DateTime(int day, int month, int year, int hours, int minute) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hours = hours;
        this.minute = minute;
    }
    //create getters and setters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHours() {
        return hours;
    }

    public int getMinute() {
        return minute;
    }

    //Returning Book return date
    public String getBookReturnDate(int bookDay){
        boolean leapYear = false;
        int dLimit = 0;
        int lastDayOfMonth = 0;
        String d = "";
        String m = "";
        String y = "";
        String returnDate = "";
        //checking leap year
        if((year%4 == 0) && (year%100 == 0) || year%400 == 0){
            leapYear = true;
        }
        //if leap year february has 29 days
        switch (month){
            case 2:
                if(leapYear==true){
                    dLimit = 22;
                    lastDayOfMonth = 29;
                }else {
                    //else 28 days
                    dLimit = 21;
                    lastDayOfMonth = 28;
                }
                break;
            //April, June,September, and November has 30 days
            case 4: case 6: case 9: case 11:
                dLimit = 23;
                lastDayOfMonth = 30;
                break;
            //other months has 31 days
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                dLimit = 24;
                lastDayOfMonth = 31;
                break;

            default: returnDate = "invalid input";
        }
        //if day equal or less than 22 returning
        if(day<=dLimit){
            d = String.valueOf(day+bookDay);
            m = String.valueOf(month);
            y = String.valueOf(year);
        }else {
            if(month==12){
                int newDay = bookDay - (lastDayOfMonth - day);
                d = String.valueOf(newDay);
                m = "1";
                y = String.valueOf(year + 1);
            }else {
                int newDay = bookDay - (lastDayOfMonth - day);
                d = String.valueOf(newDay);
                m = String.valueOf(month + 1);
                y = String.valueOf(year);
            }
        }
        returnDate= (y+"-"+m+"-"+d);

        return returnDate;
    }

    //Returning DVD return date
    public String getDVDReturnDate(int dvdDay){
        boolean leapYear = false;
        int dvdDLimit = 0;
        int lastDayOfMonth = 0;
        String d = "";
        String m = "";
        String y = "";
        String returnDate = "";
        //checking leap year
        if((year%4 == 0) && (year%100 == 0) || year%400 == 0){
            leapYear = true;
        }
        //if leap year february has 29 days
        switch (month){
            case 2:
                if(leapYear==true){
                    dvdDLimit = 26;
                    lastDayOfMonth = 29;
                }else {
                    //else 28 days
                    dvdDLimit = 25;
                    lastDayOfMonth = 28;
                }
                break;
            //April, June,September, and November has 30 days
            case 4: case 6: case 9: case 11:
                dvdDLimit = 27;
                lastDayOfMonth = 30;
                break;
            //other months has 31 days
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                dvdDLimit = 28;
                lastDayOfMonth = 31;
                break;

            default: returnDate = "invalid input";
        }
        //if day equal or less than 22 returning
        if(day<=dvdDLimit){
            d = String.valueOf(day+dvdDay);
            m = String.valueOf(month);
            y = String.valueOf(year);
        }else {
            if(month==12){
                int newDay = dvdDay - (lastDayOfMonth - day);
                d = String.valueOf(newDay);
                m = "1";
                y = String.valueOf(year + 1);

            }else {
                int newDay = dvdDay - (lastDayOfMonth - day);
                d = String.valueOf(newDay);
                m = String.valueOf(month + 1);
                y = String.valueOf(year);

            }
        }
        returnDate= (y+"-"+m+"-"+d);

        return returnDate;
    }

    public String getReturnTime(){

        String h = "";
        String m = "";

        h = String.valueOf(hours);
        m = String.valueOf(minute);

        //Returning Time
        return h +":"+ m;
    }

    public static DecimalFormat df2 = new DecimalFormat(".##");

    public double getFine(int day){
        double fine = 0;
        int newDay = 0;
        if(day<=3){
            fine = day*(0.2*24);
        }
        else{
            newDay = day - 3;
            fine = 3*(0.2*24) + newDay*(0.5*24);
            df2.format(fine);
        }
        return fine;
    }
}
