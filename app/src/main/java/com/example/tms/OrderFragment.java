package com.example.tms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends Fragment {
    private List<String> ordersList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.orders_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.order_recycle_view);
        int spacingInPixels = getResources().getDimensionPixelOffset(R.dimen.item_spacing);
        recyclerView.addItemDecoration(new SpaceItemDecorator(spacingInPixels));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        OrderAdapter orderAdapter = new OrderAdapter(ordersList, spacingInPixels);
        recyclerView.setAdapter(orderAdapter);
        return view;
    }
    public void updateOrdersList(List<String> orders){
        ordersList.clear();
        ordersList.addAll(orders);
    }
}
