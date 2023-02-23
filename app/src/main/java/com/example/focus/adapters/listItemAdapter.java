package com.example.focus.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.focus.R;
import com.example.focus.entities.Items;

import java.util.ArrayList;

public class listItemAdapter extends RecyclerView.Adapter<listItemAdapter.ItemViewHolder> {
    ArrayList<Items> listItems;

    public listItemAdapter(ArrayList<Items> listItems) {
        this.listItems = listItems;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, null, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.viewTitle.setText(listItems.get(position).getTitle());
        holder.viewDesc.setText(listItems.get(position).getDescr());
        holder.viewDate.setText(listItems.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return listItems.size();

    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView viewTitle, viewDesc, viewDate;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            viewTitle = itemView.findViewById(R.id.viewTitle);
            viewDesc = itemView.findViewById(R.id.viewDesc);
            viewDate = itemView.findViewById(R.id.viewDate);
        }
    }
}
