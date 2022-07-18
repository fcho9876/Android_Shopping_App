package com.example.phone_store_app;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.phone_store_app.adapters.ViewPagerAdapter;

public class DetailsActivity extends AppCompatActivity {

    //Initialising ViewPager
    private ViewPager mViewPager;
    private LinearLayout slideShowDot;
    private int dotCount;
    private ImageView[] dots;

    //Image array to be used
    private int[] images;

    // Creating Object of ViewPagerAdapter
    private ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Hides title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        Window window = DetailsActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(DetailsActivity.this, R.color.white));

        setContentView(R.layout.activity_phone_details);
        //Creating variables to set the layout fields to
        String name, price, screenSize, battery, memory, storage, camera, data, colour;
        TextView nameText, priceText, screenSizeText, batteryText, memoryText, storageText,
                cameraText, dataText, colourText;
        //Image array to be used
        int[] imageArray;


        priceText = findViewById(R.id.price);
        screenSizeText = findViewById(R.id.screen_size);
        batteryText = findViewById(R.id.bat_cap);
        memoryText = findViewById(R.id.memory);
        storageText = findViewById(R.id.storage);
        cameraText = findViewById(R.id.camera);
        dataText = findViewById(R.id.data_con);
        nameText = findViewById(R.id.name);
        colourText = findViewById(R.id.colour);

        //Initializing the ViewPager Object
        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);

        slideShowDot = (LinearLayout) findViewById(R.id.SliderDots);


        //Grabbing all the extra intent information to place into the DetailsActivity layout
        Bundle extras = getIntent().getExtras();
        if (extras == null){
            price = null;
            storage = null;
            screenSize = null;
            camera = null;
            battery = null;
            memory = null;
            data = null;
            name = null;
            colour = null;
            imageArray = null;
        }
        else{
            price = extras.getString("price");
            storage = extras.getString("storage");
            screenSize = extras.getString("screensize");
            camera = extras.getString("camera");
            battery = extras.getString("battery");
            memory = extras.getString("memory");
            data = extras.getString("data");
            name = extras.getString("name");
            colour = extras.getString("colour");
            imageArray = extras.getIntArray("imageArray");

            priceText.setText(price);
            storageText.setText(storage);
            screenSizeText.setText(screenSize);
            cameraText.setText(camera);
            batteryText.setText(battery);
            memoryText.setText(memory);
            dataText.setText(data);
            nameText.setText(name);
            colourText.setText(colour);
            images = imageArray;

        }

        //Initializing the ViewPagerAdapter
        mViewPagerAdapter = new ViewPagerAdapter(DetailsActivity.this, images);

        //Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);

        //Getting the amount of images in the ViewPager
        dotCount = mViewPagerAdapter.getCount();

        //Setting dots to a new ImageView with size of dot count
        dots = new ImageView[dotCount];

        //Looping through to set each dot to inactive and placing it inside the layout
        for (int i = 0; i < dotCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams parameters = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            parameters.setMargins(4,0,4,0);

            slideShowDot.addView(dots[i], parameters);
        }
        //First dot is defaulted to active as it is the first image shown
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        //Setting onpagelistener to change the active and non active dots to respective position
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //Must have method
            }
            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i< dotCount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                //Must have method
            }
        });
    }
}