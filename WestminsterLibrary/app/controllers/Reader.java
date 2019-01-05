package controllers;

public class Reader {
    //declaring variables
    private String uName, uEmail,uPhoneNumber;
    private int uId;

    //Constructor
    public Reader(int uId,String uName, String uEmail, String uPhoneNumber) {
        this.uId = uId;
        this.uName = uName;
        this.uEmail = uEmail;
        this.uPhoneNumber = uPhoneNumber;
    }


    //Method for borrow item
    public void borrowedItem(){

        //itemlist.add(barrowBookDetail);
        //itemlist.add(barrowDVDDetail);

    }

    //Getters and Setters
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPhoneNumber() {
        return uPhoneNumber;
    }

    public void setuPhoneNumber(String uPhoneNumber) {
        this.uPhoneNumber = uPhoneNumber;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

}
