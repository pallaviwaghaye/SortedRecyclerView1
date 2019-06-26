package com.tutorials.hp.recyclerviewsort.retrofit.service;



import com.tutorials.hp.recyclerviewsort.DeviceDetails;
import com.tutorials.hp.recyclerviewsort.Heros;
import com.tutorials.hp.recyclerviewsort.retrofit.ApiConstants;

import org.json.JSONArray;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiService {

    // --------------------User APIS-------------------------

    @GET(ApiConstants.heroes)
    Call<List<Heros>> gethero();

    /*@GET(ApiConstants.getDeviceList)
    Call<DeviceDetails> getAllDevices();*/
}
