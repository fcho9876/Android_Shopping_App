package com.example.phone_store_app;

//Imports needed to run the code
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.phone_store_app.adapters.PhoneInfoAdapter;
import com.example.phone_store_app.models.DataProvider;
import com.example.phone_store_app.models.PhoneInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SamsungActivity extends AppCompatActivity{

    //Initialising variables
    private ArrayList<PhoneInfo> phoneInfo;
    private PhoneInfoAdapter adapter;
    private RecyclerView rvPhone;
    private PhoneInfoAdapter.RecycleViewClickerListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hides title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        Window window = SamsungActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(SamsungActivity.this, R.color.samBlue));

        setContentView(R.layout.activity_samsung);

        //Setting up layout using recycle view
        rvPhone = (RecyclerView) findViewById(R.id.rvPhones);

        //Generating phone information
        phoneInfo = DataProvider.generateSamsungData();

        setOnClickListener();

        //Passing information to adapter to set information
        adapter = new PhoneInfoAdapter(this, phoneInfo, listener);

        //Setting the adapter to our recycle viewer
        rvPhone.setAdapter(adapter);

        //Creating layout manager for recycle view
        LinearLayoutManager lm = new LinearLayoutManager(this);
        //Setting new layout manager to recycle view
        rvPhone.setLayoutManager(lm);
    }

    private void setOnClickListener() {
        listener = new PhoneInfoAdapter.RecycleViewClickerListener() {
            @Override
            public void onClickPhone(View v, int position) {
                //Sending information needed for details activity
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("price",phoneInfo.get(position).getPrice());
                intent.putExtra("storage",phoneInfo.get(position).getStorage());
                intent.putExtra("screensize",phoneInfo.get(position).getScreenSize());
                intent.putExtra("camera",phoneInfo.get(position).getCamera());
                intent.putExtra("battery",phoneInfo.get(position).getBattery());
                intent.putExtra("memory",phoneInfo.get(position).getMemory());
                intent.putExtra("data",phoneInfo.get(position).getDataCon());
                intent.putExtra("colour",phoneInfo.get(position).getColour());
                intent.putExtra("name",phoneInfo.get(position).getName());
                intent.putExtra("imageArray",phoneInfo.get(position).getImageArray());
                startActivity(intent);

                // get clicks for the most popular section
                Context context = getApplicationContext();
                DataProvider.addClick(context, phoneInfo.get(position).getID());
                DataProvider.getTopFour(getApplicationContext());
            }
        };
    }

}