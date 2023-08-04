package com.example.tms.model;

import com.google.gson.annotations.SerializedName;

public class Event {
    @SerializedName("eventId")
    private long eventId;
    @SerializedName("eventName")
    private String eventName;
    @SerializedName("eventDescription")
    private String eventDescription;
    @SerializedName("eventType")
    private String eventType;
    @SerializedName("venue")
    private String venue;

    public Event(long eventId, String eventName, String eventDescription, String eventType, String venue) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventType = eventType;
        this.venue = venue;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
