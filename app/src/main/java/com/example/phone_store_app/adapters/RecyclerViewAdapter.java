package com.example.phone_store_app.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phone_store_app.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private onPopClickListener mListener;

    //Interface to allow clicking of popular phones
    public interface onPopClickListener{
        void onPopClick(int position);
    }

    //Setting the Popular phone listener
    public void setOnPopClickListener(onPopClickListener listener){
        mListener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView myImage;

        public MyViewHolder(@NonNull View itemView, onPopClickListener listener) {
            super(itemView);
            myImage = itemView.findViewById(R.id.myImageView);

            //Setting up on click listener for the Most Popular images
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position !=  RecyclerView.NO_POSITION){
                            listener.onPopClick(position);
                        }
                    }
                }
            });
        }
    }

    private int images[];
    private Context context;

    public RecyclerViewAdapter(Context ct, int img[]) {
        context = ct;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_recycler_view, parent, false);
        return new MyViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

}
