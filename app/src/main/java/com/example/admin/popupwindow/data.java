package com.example.admin.popupwindow;

public class data {

    String sfname;
    String slname;
    String semail;
    String sennumber;
    String spnumber;
    String spass;
    String sid;

    public data(){

    }

    public data(String sid,String sfname, String slname, String semail, String sennumber, String spnumber, String spass) {
        this.sfname = sfname;
        this.slname = slname;
        this.semail = semail;
        this.sennumber = sennumber;
        this.spnumber = spnumber;
        this.spass = spass;
        this.sid = sid;
    }

    public String getSfname() {
        return sfname;
    }

    public String getSlname() {
        return slname;
    }

    public String getSemail() {
        return semail;
    }

    public String getSennumber() {
        return sennumber;
    }

    public String getSpnumber() {
        return spnumber;
    }

    public String getSpass() {
        return spass;
    }

    public String getSid() {
        return sid;
    }
}
