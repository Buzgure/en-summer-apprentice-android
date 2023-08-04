package com.example.tms;

import com.example.tms.model.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

      String BASE_URL = "https://10.0.2.2:7203";
      @GET("api/Event/GetAll")
    Call<List<Event>> getAllEvents();


}
