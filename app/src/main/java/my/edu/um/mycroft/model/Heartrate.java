package my.edu.um.mycroft.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ARL on 9/21/2016.
 */
public class Heartrate {
    @SerializedName("id")
    private int id;
    @SerializedName("userid")
    private int userid;
    @SerializedName("rate")
    private String rate;
    @SerializedName("date")
    private String date;

    public Heartrate(int id,int userid, String rate, String date){
        this.id = id;
        this.userid = id;
        this.rate = rate;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

