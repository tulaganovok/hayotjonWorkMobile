package com.example.task3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final List<String> itemList;
    private final Context context;

    public MyAdapter(Context context, List<String> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemText;

        public ViewHolder(View view) {
            super(view);
            itemText = view.findViewById(R.id.itemText);
        }
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        String item = itemList.get(position);
        holder.itemText.setText(item);

        holder.itemView.setOnClickListener(v ->
                Toast.makeText(context, "Clicked: " + item, Toast.LENGTH_SHORT).show());
    }
    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
