package com.example.tms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tms.model.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    List<Event> eventsList;
    int itemSpacing;

    public EventAdapter(List<Event> eventsList, int itemSpacing) {
        this.eventsList = eventsList;
        this.itemSpacing = itemSpacing;
    }

    @NonNull
    @Override
    public EventAdapter.EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        return new EventViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = eventsList.get(position);
        holder.eventIdText.setText(String.valueOf(event.getEventId()));
        holder.eventNameText.setText(event.getEventName());
        holder.eventDescriptionText.setText(event.getEventDescription());
        holder.eventTypeText.setText(event.getEventType());
        holder.eventVenueText.setText(event.getVenue());
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder{

        TextView eventIdText;
        TextView eventNameText;
        TextView eventDescriptionText;
        TextView eventTypeText;
        TextView eventVenueText;


        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            eventIdText = itemView.findViewById(R.id.event_id_text);
            eventNameText = itemView.findViewById(R.id.event_name_text);
            eventDescriptionText = itemView.findViewById(R.id.event_description_text);
            eventTypeText = itemView.findViewById(R.id.event_type_text);
            eventVenueText = itemView.findViewById(R.id.event_venue_text);
        }
    }
}
