package my.edu.um.mycroft.rest;

import com.google.gson.JsonArray;

import my.edu.um.mycroft.model.Heartrate;
import my.edu.um.mycroft.model.Reminder;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ARL on 9/21/2016.
 */
public interface ApiInterface {
    @GET("heartrate")
    Call<JsonArray> getHeartrate();

    @GET("heartrate/latest")
    Call<Heartrate> getLatestHeartrate(@Query("api_key") String apiKey);

    @GET("reminder/latest")
    Call<Reminder> getLatestReminder(@Query("reminder") String apiKey);
}
