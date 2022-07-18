package com.example.phone_store_app.adapters;

//Imports needed to run the code
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phone_store_app.models.PhoneInfo;
import com.example.phone_store_app.R;

import java.util.ArrayList;
import java.util.List;

//Adapter for the phone information which holds/sets the information we want
public class PhoneInfoAdapter extends RecyclerView.Adapter<PhoneInfoAdapter.ViewHolder> implements Filterable {
    //Onclick listener will be used to swap between ListActivity and DetailsActivity
    private RecycleViewClickerListener listener;
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //Initialising variables needed
        private TextView name, price;
        private ImageView images;


        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);

            name = v.findViewById(R.id.phone_name);
            price = v.findViewById(R.id.price);
            images = v.findViewById(R.id.samsung_image_view);
        }

        @Override
        public void onClick(View v) {
            listener.onClickPhone(v, getAdapterPosition());
        }
    }

    //Initialising variables needed
    private List<PhoneInfo> phoneInfo;
    private Context aContext;

    private List<PhoneInfo> phoneListFull;

    //Passes the information into phoneInfo variable
    public PhoneInfoAdapter(Context aCt, List<PhoneInfo> info, RecycleViewClickerListener listener){
        this.aContext = aCt;
        this.phoneInfo = info;
        this.listener = listener;

        phoneListFull = new ArrayList<>(phoneInfo);
    }


    //Inflates the layout that we want to show
    @NonNull
    @Override
    public PhoneInfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        aContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(aContext);

        View phoneView = inflater.inflate(R.layout.activity_phonecardholder, parent, false);

        ViewHolder holder = new ViewHolder(phoneView);

        return holder;
    }

    //Setting the TextViews to information given
    @Override
    public void onBindViewHolder(@NonNull PhoneInfoAdapter.ViewHolder holder, int position) {
        PhoneInfo thisPhone = phoneInfo.get(position);

        holder.name.setText(thisPhone.getName());
        holder.price.setText(thisPhone.getPrice());
        holder.images.setImageResource(thisPhone.getImage());

    }

    //Mandatory method
    @Override
    public int getItemCount() {
        return phoneInfo.size();
    }

    public interface RecycleViewClickerListener{
        void onClickPhone(View v, int position);
    }


    // Set up filter methods to be used in SearchActivity
    @Override
    public Filter getFilter() {
        return phoneFilter;
    }

    private Filter phoneFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<PhoneInfo> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(phoneListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (PhoneInfo item : phoneListFull) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            phoneInfo.clear();
            phoneInfo.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

}
