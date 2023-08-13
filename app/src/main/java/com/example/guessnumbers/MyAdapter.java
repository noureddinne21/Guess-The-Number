package com.example.guessnumbers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.ViweHolder> {

    private List<String> mData;

    MyAdapter(List<String> data) {
        mData = data;
    }

    @NonNull
    @Override
    public MyAdapter.ViweHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gusses, parent, false);
        return new ViweHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViweHolder holder, int position) {
        holder.textView.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViweHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViweHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView4);

        }
    }
}
