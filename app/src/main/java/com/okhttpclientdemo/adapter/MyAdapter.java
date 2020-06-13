package com.okhttpclientdemo.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.okhttpclientdemo.R;
import com.okhttpclientdemo.databinding.MyTextViewBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<String> mDataset;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(ArrayList<String> myDataset, Context context) {
        mDataset = myDataset;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyTextViewBinding viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.my_text_view, parent, false);
        return new MyViewHolder(viewDataBinding);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mDataset.get(position));

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public MyViewHolder(MyTextViewBinding v) {
            super(v.getRoot());
            textView = v.textview;
        }
    }
}


