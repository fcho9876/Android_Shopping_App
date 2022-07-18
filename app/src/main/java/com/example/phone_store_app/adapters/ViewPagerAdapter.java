package com.example.phone_store_app.adapters;

//Required imports to run code
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.phone_store_app.R;

import java.util.ArrayList;
import java.util.Objects;

public class ViewPagerAdapter extends PagerAdapter {

    // Context object
    private Context context;

    // Layout Inflater initialised
    private LayoutInflater mLayoutInflater;

    // Array of images
    private int[] images;


    // Viewpager to collect and display images
    public ViewPagerAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // return the number of images
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        // inflates activity slideshow
        View itemView = mLayoutInflater.inflate(R.layout.activity_slideshow, container, false);

        // A reference to the image view main
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageViewMain);

        // Placing images in image view
        imageView.setImageResource(images[position]);

        // Adding view
        Objects.requireNonNull(container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //Removes the image
        container.removeView((LinearLayout) object);
    }
}
