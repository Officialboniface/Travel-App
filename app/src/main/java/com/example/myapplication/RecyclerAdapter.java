package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ItemClickListener mClickListener;
    private LayoutInflater mInflater;
    private List<String> mData;


    RecyclerAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;

    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.bus_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        String Bus = mData.get(position);
        holder.transportTextView.setText(Bus);




    }




    @Override
    public int getItemCount() {
        return mData.size();
    }






    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView transportTextView;
        TextView priceTextView;

  private  ViewHolder(View itemView) {
            super(itemView);
            transportTextView = itemView.findViewById(R.id.Bus_NameTv);

            itemView.setOnClickListener(this);

        }




        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());

        }
    }

    String getItem(int id) {
        return mData.get(id);
    }
    void setClickListener (ItemClickListener itemClickListener){
        this. mClickListener = itemClickListener;
    }
    public  interface ItemClickListener {
        void onItemClick (View view, int position);
    }



}
