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

import com.example.tms.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventFragment extends Fragment {

    private List<Event> eventsList = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.events_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.event_recycle_view);
        int spacingInPixels = getResources().getDimensionPixelOffset(R.dimen.item_spacing);
        recyclerView.addItemDecoration(new SpaceItemDecorator(spacingInPixels));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        EventAdapter eventAdapter = new EventAdapter(eventsList, spacingInPixels);
        recyclerView.setAdapter(eventAdapter);
        return view;
    }
    public void updateEventsList(List<Event> events) {
        eventsList.clear();
        eventsList.addAll(events);

    }
}
