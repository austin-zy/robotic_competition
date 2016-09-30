package my.edu.um.mycroft.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ARL on 9/21/2016.
 */
public class Reminder {
    @SerializedName("id")
    private int id;
    @SerializedName("userid")
    private int userid;
    @SerializedName("message")
    private String message;
    @SerializedName("appointmentdate")
    private String appointmentdate;
    @SerializedName("appointmenttime")
    private String appointmenttime;

    public Reminder(int id, int userid, String message, String appointmentdate, String appointmenttime) {
        this.id = id;
        this.userid = userid;
        this.message = message;
        this.appointmentdate = appointmentdate;
        this.appointmenttime = appointmenttime;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAppointmentdate() {
        return appointmentdate;
    }

    public void setAppointmentdate(String appointmentdate) {
        this.appointmentdate = appointmentdate;
    }

    public String getAppointmenttime() {
        return appointmenttime;
    }

    public void setAppointmenttime(String appointmenttime) {
        this.appointmenttime = appointmenttime;
    }
}
