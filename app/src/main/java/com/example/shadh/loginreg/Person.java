package com.example.shadh.loginreg;

public class Person {
    public static String fname, sname, dob, phno, usern, passw, email;

    public void putdetails(String fname, String sname, String dob, String phno, String usern, String passw, String email) {
        this.fname = fname;
        this.sname = sname;
        this.email = email;
        this.dob = dob;
        this.phno = phno;
        this.usern = usern;
        this.passw = passw;


    }

    public static String getFname() {
        return fname;
    }

    public static String getSname() {
        return sname;
    }

    public static String getDob() {
        return dob;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPhno() {
        return phno;
    }

    public static String getUsern() {
        return usern;
    }

    public static String getPassw() {
        return passw;
    }
}
