package com.example.phone_store_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phone_store_app.adapters.PhoneInfoAdapter;
import com.example.phone_store_app.models.DataProvider;
import com.example.phone_store_app.models.PhoneInfo;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private ArrayList<PhoneInfo> aApple, aXiaomi, allPhonesList;
    private RecyclerView rvPhone;
    private PhoneInfoAdapter adapter;
    private PhoneInfoAdapter.RecycleViewClickerListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Styling for status bar
        Window window = SearchActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(SearchActivity.this, R.color.homePurp));

        setContentView(R.layout.activity_search);
        generateData();
        setOnClickListener();
        setUpRecyclerView();
    }

    // set up recycler view to display phones
    private void setUpRecyclerView() {
        rvPhone = (RecyclerView) findViewById(R.id.rvPhones);
        adapter = new PhoneInfoAdapter(this, allPhonesList, listener);
        rvPhone.setAdapter(adapter);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rvPhone.setLayoutManager(lm);
    }

    // generate data for all three phone categories
    private void generateData() {
        allPhonesList = DataProvider.generateSamsungData();
        aApple = DataProvider.generateAppleData();
        allPhonesList.addAll(aApple);
        aXiaomi = DataProvider.generateXiaomiData();
        allPhonesList.addAll(aXiaomi);
    }


    // set up search menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        // ensures search dialog is open when search view is invoked
        searchItem.expandActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                TextView textview = findViewById(R.id.error_message);
                rvPhone = (RecyclerView) findViewById(R.id.rvPhones);
                adapter.getFilter().filter(query);

                // if there are no results, display a message
                if (adapter.getItemCount() < 1) {
                    textview.setVisibility(View.VISIBLE);
                    rvPhone.setVisibility(View.GONE);
                } else {
                    rvPhone.setVisibility(View.VISIBLE);
                    textview.setVisibility(View.GONE);
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                //setContentView(R.layout.activity_no_result_message);
                TextView textview = findViewById(R.id.error_message);
                rvPhone = (RecyclerView) findViewById(R.id.rvPhones);

                // if there are no results, display a message
                if (adapter.getItemCount()<1) {
                    // for testing
                    Log.d("ID", "DISPLAY no result error message");
                    textview.setVisibility(View.VISIBLE);
                    rvPhone.setVisibility(View.GONE);
                } else {
                    // results visible, hide error message
                    Log.d("ID", "HIDE error message");
                    rvPhone.setVisibility(View.VISIBLE);
                    textview.setVisibility(View.GONE);
                }

                return false;
            }
        });
        return true;
    }
    private void setOnClickListener() {
        listener = new PhoneInfoAdapter.RecycleViewClickerListener() {
            @Override
            public void onClickPhone(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("price",allPhonesList.get(position).getPrice());
                intent.putExtra("storage",allPhonesList.get(position).getStorage());
                intent.putExtra("screensize",allPhonesList.get(position).getScreenSize());
                intent.putExtra("camera",allPhonesList.get(position).getCamera());
                intent.putExtra("battery",allPhonesList.get(position).getBattery());
                intent.putExtra("memory",allPhonesList.get(position).getMemory());
                intent.putExtra("data",allPhonesList.get(position).getDataCon());
                intent.putExtra("colour",allPhonesList.get(position).getColour());
                intent.putExtra("name",allPhonesList.get(position).getName());
                intent.putExtra("imageArray",allPhonesList.get(position).getImageArray());
                startActivity(intent);

                // get clicks for the most popular section
                Context context = getApplicationContext();
                DataProvider.addClick(context, allPhonesList.get(position).getID());
                DataProvider.getTopFour(getApplicationContext()); // for testing
            }
        };
    }
}
