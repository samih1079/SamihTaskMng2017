package com.samih.abs.samihtaskmng2017.data;

/**
 * Created by samih on 11/07/2017.
 */

public class MyTasks
{
    private String tKey;
    private String text;
    private boolean isCompleted;
    private long createdAt;
    private double loc_lat,loc_lng;
    private String address;
    private String gKey,uKey;//the group and user that it belong

    public MyTasks() {
    }

    public String gettKey() {
        return tKey;
    }

    public void settKey(String tKey) {
        this.tKey = tKey;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public double getLoc_lat() {
        return loc_lat;
    }

    public void setLoc_lat(double loc_lat) {
        this.loc_lat = loc_lat;
    }

    public double getLoc_lng() {
        return loc_lng;
    }

    public void setLoc_lng(double loc_lng) {
        this.loc_lng = loc_lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getgKey() {
        return gKey;
    }

    public void setgKey(String gKey) {
        this.gKey = gKey;
    }

    public String getuKey() {
        return uKey;
    }

    public void setuKey(String uKey) {
        this.uKey = uKey;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "MyTasks{" +
                "tKey='" + tKey + '\'' +
                ", text='" + text + '\'' +
                ", isCompleted=" + isCompleted +
                ", createdAt=" + createdAt +
                ", loc_lat=" + loc_lat +
                ", loc_lng=" + loc_lng +
                ", address='" + address + '\'' +
                ", gKey='" + gKey + '\'' +
                ", uKey='" + uKey + '\'' +
                '}';
    }
}
