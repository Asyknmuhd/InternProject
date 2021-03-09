package com.example.mptsewa;

public class ClassBooking {
    private String fromDate;
    private String toDate;
    private Integer jamkenduri, jambadminton, jammajlis ;
    private String hallName;

    public ClassBooking(){

    }

    public ClassBooking(String fromDate, String toDate, Integer jamkenduri, Integer jambadminton, Integer jammajlis){
        this.fromDate = fromDate;
        this.toDate = toDate;
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
    public void setJamkenduri(Integer jamkenduri){
        this.jamkenduri = jamkenduri;
    }
    public Integer getJambadminton(){
        return jambadminton;
    }
    public void setJambadminton(Integer jambadminton){
        this.jambadminton = jambadminton;
    }
    public Integer getJammajlis(){
        return jammajlis;
    }
    public void setJammajlis(Integer jammajlis){
        this.jammajlis = jammajlis;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }
}


