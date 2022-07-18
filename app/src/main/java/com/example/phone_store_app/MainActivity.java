package com.example.phone_store_app;

//Imports needed to run this code
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.phone_store_app.adapters.RecyclerViewAdapter;
import com.example.phone_store_app.models.DataProvider;
import com.example.phone_store_app.models.PhoneInfo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Creating new CardView variables to be used to swap activities
    private CardView samCard, appleCard, xiamoiCard;

    //RecyclerView variables
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;


    //Variables used to set up Most Popular section of MainActivity
    private int id[] = {2, 8, 12, 24};
    private int images[] = DataProvider.generateTopFour(id);

    private ArrayList<PhoneInfo> samPhone = DataProvider.generateSamsungData();
    private ArrayList<PhoneInfo> applePhone = DataProvider.generateAppleData();
    private ArrayList<PhoneInfo> xiaomiPhone = DataProvider.generateXiaomiData();
    private ArrayList<PhoneInfo> allPhoneInfo = DataProvider.generateAllPhones(samPhone, applePhone, xiaomiPhone);

    private int[] images2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Window window = MainActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.homePurp));


        setContentView(R.layout.activity_main);

        // reset shared preferences for click count
        SharedPreferences pref = getApplicationContext().getSharedPreferences("click_count", Context.MODE_PRIVATE);
        DataProvider.resetClick(getApplicationContext(), pref);

        images2 = DataProvider.generateTopFour(DataProvider.getTopFour(getApplicationContext()));

        //Associates the clicking of the card view to link to new page
        samCard = (CardView) findViewById(R.id.samsung_card);
        appleCard = (CardView) findViewById(R.id.apple_card);
        xiamoiCard = (CardView) findViewById(R.id.xiaomi_card);

        //Sets the card views for onclick listeners
        samCard.setOnClickListener(this);
        appleCard.setOnClickListener(this);
        xiamoiCard.setOnClickListener(this);

        // RecyclerView initialization
        recyclerView = findViewById(R.id.hello);
        layoutManager =  new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(this,images);
        recyclerView.setAdapter(adapter);

        adapter.setOnPopClickListener(new RecyclerViewAdapter.onPopClickListener() {
            @Override
            public void onPopClick(int position) {
                //Gets the id of the images in the slideshow to get to index of all the phone info
                int useThisPos = id[position];
                Intent intent;
                PhoneInfo thisPhone = allPhoneInfo.get(useThisPos);
                //Sending all the information to details activity
                intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("price",thisPhone.getPrice());
                intent.putExtra("storage",thisPhone.getStorage());
                intent.putExtra("screensize",thisPhone.getScreenSize());
                intent.putExtra("camera",thisPhone.getCamera());
                intent.putExtra("battery",thisPhone.getBattery());
                intent.putExtra("memory",thisPhone.getMemory());
                intent.putExtra("data",thisPhone.getDataCon());
                intent.putExtra("colour",thisPhone.getColour());
                intent.putExtra("name",thisPhone.getName());
                intent.putExtra("imageArray",thisPhone.getImageArray());
                startActivity(intent);

                // get clicks for the most popular section
                Context context = getApplicationContext();
                DataProvider.addClick(context, allPhoneInfo.get(useThisPos).getID());
                DataProvider.getTopFour(getApplicationContext());
            }
        });
    }

    //
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.main_action_search){
            Intent i = new Intent(this, SearchActivity.class);
            startActivity(i);
            return true;
        }
        return true;
    }


    // refreshes the main activity on BACK BUTTON press
    // this is for the most popular section
    @Override
    public void onRestart() {
        super.onRestart();
        // generate the data
        images2 = DataProvider.generateTopFour(DataProvider.getTopFour(getApplicationContext()));

        // RecyclerView initialization
        recyclerView = findViewById(R.id.hello);
        layoutManager =  new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(this,images2);
        recyclerView.setAdapter(adapter);

        adapter.setOnPopClickListener(new RecyclerViewAdapter.onPopClickListener() {
            @Override
            public void onPopClick(int position) {
                //Gets the id of the images in the slideshow to get to index of all the phone info
                int useThisPos = DataProvider.getTopFour(getApplicationContext())[position];
                Intent intent;
                PhoneInfo thisPhone = allPhoneInfo.get(useThisPos);
                //Sending all the information to details activity
                intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("price",thisPhone.getPrice());
                intent.putExtra("storage",thisPhone.getStorage());
                intent.putExtra("screensize",thisPhone.getScreenSize());
                intent.putExtra("camera",thisPhone.getCamera());
                intent.putExtra("battery",thisPhone.getBattery());
                intent.putExtra("memory",thisPhone.getMemory());
                intent.putExtra("data",thisPhone.getDataCon());
                intent.putExtra("colour",thisPhone.getColour());
                intent.putExtra("name",thisPhone.getName());
                intent.putExtra("imageArray",thisPhone.getImageArray());
                startActivity(intent);

                // get clicks for the most popular section
                Context context = getApplicationContext();
                DataProvider.addClick(context, allPhoneInfo.get(useThisPos).getID());
                DataProvider.getTopFour(getApplicationContext());
            }
        });
    }

    //Method to swap windows
    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.samsung_card:
                i = new Intent(this, SamsungActivity.class);
                startActivity(i);
                break;
            case R.id.apple_card:
                i = new Intent(this, AppleActivity.class);
                startActivity(i);
                break;
            case R.id.xiaomi_card:
                i = new Intent(this, XiaomiActivity.class);
                startActivity(i);
                break;
        }
    }

    // set up search menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_search_menu, menu);
        return true;
    }

}