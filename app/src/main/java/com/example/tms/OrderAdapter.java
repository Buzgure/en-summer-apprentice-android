package com.example.tms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    List<String> ordersList;
    int itemSpacing;

    public OrderAdapter( List<String> ordersList, int itemSpacing) {
        this.ordersList = ordersList;
        this.itemSpacing = itemSpacing;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
            String order = ordersList.get(position);
            holder.orderTextView.setText(order);
    }

    @Override
    public int getItemCount() {
        return ordersList.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder{
        TextView orderTextView;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            orderTextView = itemView.findViewById(R.id.orderNameTextView);
        }
    }
}
