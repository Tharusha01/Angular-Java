package controllers;

public class DVD extends LibraryItem {

    private String dvdISBN;
    private String dvdTitle;
    private String dvdSector;
    private String dvdLabguage;
    private String dvdSub;
    private String dvdProduser;
    private String dvdActor;
    private String status;

    //Constructor
    public DVD(String dvdISBN, String dvdTitle, String dvdSector,String dvdLabguage, String dvdSub, String dvdProduser, String dvdActor, String status) {
        this.dvdISBN = dvdISBN;
        this.dvdTitle = dvdTitle;
        this.dvdSector = dvdSector;
        this.dvdLabguage = dvdLabguage;
        this.dvdSub = dvdSub;
        this.dvdProduser = dvdProduser;
        this.dvdActor = dvdActor;
        this.status = status;
    }

    //Getter and Setters
    public String getDvdLabguage() {
        return dvdLabguage;
    }

    public void setDvdLabguage(String dvdLabguage) {
        this.dvdLabguage = dvdLabguage;
    }

    public String getDvdISBN() {
        return dvdISBN;
    }

    public void setDvdISBN(String dvdISBN) {
        this.dvdISBN = dvdISBN;
    }

    public String getDvdTitle() {
        return dvdTitle;
    }

    public void setDvdTitle(String dvdTitle) {
        this.dvdTitle = dvdTitle;
    }

    public String getDvdSector() {
        return dvdSector;
    }

    public void setDvdSector(String dvdSector) {
        this.dvdSector = dvdSector;
    }

    public String getDvdSub() {
        return dvdSub;
    }

    public void setDvdSub(String dvdSub) {
        this.dvdSub = dvdSub;
    }

    public String getDvdProduser() {
        return dvdProduser;
    }

    public void setDvdProduser(String dvdProduser) {
        this.dvdProduser = dvdProduser;
    }

    public String getDvdActor() {
        return dvdActor;
    }

    public void setDvdActor(String dvdActor) {
        this.dvdActor = dvdActor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
