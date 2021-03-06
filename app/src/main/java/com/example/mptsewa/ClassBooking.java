package com.example.mptsewa;

public class ClassBooking {
    private String fromDate;
    private String toDate;
    private Integer jamkenduri, jambadminton, jammajlis ;

    public ClassBooking(){

    }

    public ClassBooking(String fromDate, String toDate, Integer jamkenduri, Integer jambadminton, Integer jammajlis){
        this.fromDate = fromDate;
        this.toDate = fromDate;
        this.jamkenduri = jamkenduri;
        this.jambadminton = jambadminton;
        this.jammajlis = jammajlis;

    }

    public String getFromDate(){
        return fromDate;
    }
    public void setFromDate (String fromDate){
        this.fromDate = fromDate;
    }
    public String getToDate(){
        return toDate;
    }
    public void setToDate(String toDate){
        this.toDate = toDate;
    }
    public Integer getJamkenduri(){
        return jamkenduri;
    }
    public void setJamkenduri(int jamkenduri){
        this.jamkenduri = jamkenduri;
    }
    public Integer getJambadminton(){
        return jambadminton;
    }
    public void setJambadminton(int jambadminton){
        this.jambadminton = jambadminton;
    }
    public Integer getJammajlis(){
        return jammajlis;
    }
    public void setJammajlis(int jammajlis){
        this.jammajlis = jammajlis;
    }
}



