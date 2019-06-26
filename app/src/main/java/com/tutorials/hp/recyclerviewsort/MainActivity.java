package com.tutorials.hp.recyclerviewsort;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tutorials.hp.recyclerviewsort.retrofit.ApiConstants;
import com.tutorials.hp.recyclerviewsort.retrofit.service.RestClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv;
    Button sortBtn;
    HerosAdapter herosAdapter;
    HomeAdapter homeAdapter;
    private ProgressDialog progressDialogForAPI;
   // String[] spacecrafts={"Juno","Hubble","Casini","WMAP","Spitzer","Pioneer","Columbia","Challenger","Apollo","Curiosity"};


    //DATA
    //List<Heros> list = new ArrayList<Heros>();
    private boolean ascending = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initializeViews();
        //this.fillSpacecrafts();
        if (NetworkUtil.hasConnectivity(MainActivity.this)) {
            callgetHeroAPI();
            //getRetrofit();
        } else {
            // Toast.makeText(CategoryActivity.this, R.string.no_internet_message, Toast.LENGTH_SHORT).show();
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage("No internet available!!")
                    .setPositiveButton("OK", null)
                    .show();
        }

    }


    //INITIALIZE VIEWS
    private void initializeViews()
    {
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        sortBtn = (Button) findViewById(R.id.sortBtn);


    }

    private void callgetHeroAPI() {

        progressDialogForAPI = new ProgressDialog(this);
        progressDialogForAPI.setCancelable(false);
        progressDialogForAPI.setIndeterminate(true);
        progressDialogForAPI.setMessage("Please wait...");
        progressDialogForAPI.show();


        final Call<List<Heros>> requestCallback = RestClient.getApiService(ApiConstants.BASE_URL).gethero();
        requestCallback.enqueue(new Callback<List<Heros>>() {
            @Override
            public void onResponse(Call<List<Heros>> call, Response<List<Heros>> response) {
                if (response.isSuccessful() && response.body() != null && response.code() == 200) {

                    final List<Heros> result = response.body();
                    herosAdapter = new HerosAdapter(MainActivity.this, result);
                    rv.setAdapter(herosAdapter);

                    sortBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            sortData(ascending,result);
                            ascending = !ascending;
                        }
                    });

                } else {
                    // Response code is 401
                      Toast.makeText(MainActivity.this, "Server error!!", Toast.LENGTH_SHORT).show();

                }

                if (progressDialogForAPI != null) {
                    progressDialogForAPI.cancel();
                }
            }

            @Override
            public void onFailure(Call<List<Heros>> call, Throwable t) {

                if (t != null) {

                    if (progressDialogForAPI != null) {
                        progressDialogForAPI.cancel();
                    }
                    if (t.getMessage() != null)
                        Log.e("error", t.getMessage());
                }

            }
        });
    }

    /*private void getRetrofit() {


        Call<DeviceDetails> requestCallback = RestClient.getApiService(ApiConstants.BASE_URL).getAllDevices();
        requestCallback.enqueue(new Callback<DeviceDetails>() {
            @Override
            public void onResponse(Call<DeviceDetails> call, Response<DeviceDetails> response) {
                if (response.isSuccessful() && response.body() != null && response.code() == 200) {

                    DeviceDetails details = response.body();

                    if (details != null && details.getStatus() == true) {

                        //handleStationPlatformData(details);
                        //textViewNoData.setVisibility(View.GONE);



                        rv.setVisibility(View.VISIBLE);

                        final List<DeviceDetails.Datum> devicelist = details.getData();
                        sortData(ascending,devicelist);
                        ascending = !ascending;
                        LinearLayoutManager layoutManager1 = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL, false);
                        rv.setLayoutManager(layoutManager1);
                        rv.setAdapter(new HomeAdapter(MainActivity.this, devicelist));
                    }
                    else{
                        //textViewNoData.setVisibility(View.VISIBLE);
                        rv.setVisibility(View.GONE);
                    }

                } else {
                    // Response code is 401
                }

                *//*if (isCallFromPullDown) {
                    swipeContainer.setRefreshing(false);
                    isCallFromPullDown = false;
                } else {*//*
                    if (progressDialogForAPI != null) {
                        progressDialogForAPI.cancel();
                    }
                //}
            }

            @Override
            public void onFailure(Call<DeviceDetails> call, Throwable t) {

                if (t != null) {

                    *//*if (isCallFromPullDown) {
                        swipeContainer.setRefreshing(false);
                        isCallFromPullDown = false;
                    } else {*//*
                        if (progressDialogForAPI != null) {
                            progressDialogForAPI.cancel();
                        }
                    //}
                    if (t.getMessage() != null)
                        Log.e("error", t.getMessage());
                }

            }
        });


    }*/



    private void sortData(boolean asc, List<Heros> list)
    {

        //SORT ARRAY ASCENDING AND DESCENDING
        if (asc)
        {
            Collections.sort(list);

            //OR

            /*Collections.sort(list, new Comparator<DeviceDetails.Datum>(){
                public int compare(DeviceDetails.Datum a1, DeviceDetails.Datum a2) {
                    return (a1.getDoi()).compareToIgnoreCase(a2.getDoi());
                }
            });*/
        }
        else
        {
            Collections.reverse(list);
        }

 //ADAPTER
        herosAdapter = new HerosAdapter(MainActivity.this, list);
        rv.setAdapter(herosAdapter);


    }

    /*
    FILL SPACECRAFTS DATA
     */
   /* private void fillSpacecrafts() {

        spacecrafts.clear();
        spacecrafts.add("Kepler");
        spacecrafts.add("Casini");
        spacecrafts.add("Voyager");
        spacecrafts.add("New Horizon");
        spacecrafts.add("James Web");
        spacecrafts.add("Apollo 15");
        spacecrafts.add("WMAP");
        spacecrafts.add("Enterprise");
        spacecrafts.add("Spitzer");
        spacecrafts.add("Galileo");
        spacecrafts.add("Challenger");
        spacecrafts.add("Atlantis");
        spacecrafts.add("Apollo 19");
        spacecrafts.add("Huygens");
        spacecrafts.add("Hubble");
        spacecrafts.add("Juno");
        spacecrafts.add("Aries");
        spacecrafts.add("Columbia");

        //ADAPTER
        adapter = new MyAdapter(this, spacecrafts);
        rv.setAdapter(adapter);

    }*/

}
