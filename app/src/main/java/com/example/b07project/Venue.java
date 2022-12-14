package com.example.b07project;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashSet;

public class Venue implements Parcelable {
    String venueHashCode;
    String venueName;
    int startHour; //24 hour format
    int startMin;
    int endHour; //24 Hour format
    int endMin;
    String date;
    String location;
    HashSet<Event> events;

    public Venue(String venueHashCode, String venueName, int starthour, int startmin, int endhour, int endmin, String date, String location, HashSet<Event> events) {
        this.venueHashCode = venueHashCode;
        this.venueName = venueName;
        this.startHour = starthour;
        this.startMin = startmin;
        this.endHour = endhour;
        this.endMin = endmin;
        this.date = date;
        this.location = location;
        this.events = events;
    }


    public Venue(){

    }

    protected Venue(Parcel in) {
        venueHashCode = in.readString();
        venueName = in.readString();
        startHour = in.readInt();
        startMin = in.readInt();
        endHour = in.readInt();
        endMin = in.readInt();
        date = in.readString();
        location = in.readString();
    }

    public static final Creator<Venue> CREATOR = new Creator<Venue>() {
        @Override
        public Venue createFromParcel(Parcel in) {
            return new Venue(in);
        }

        @Override
        public Venue[] newArray(int size) {
            return new Venue[size];
        }
    };

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMin() {
        return startMin;
    }

    public void setStartMin(int startMin) {
        this.startMin = startMin;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getEndMin() {
        return endMin;
    }

    public void setEndMin(int endMin) {
        this.endMin = endMin;
    }

    public String getVenueName() {
        return venueName;
    }
    public String endtime(){
        String em=  String.valueOf(getEndMin()).trim();
        String eh = String.valueOf(getEndHour()).trim();
        if (em.length() == 1) {
            em = "0"+em;
        }
        if (eh.length()==1){
            eh = "0"+eh;
        }


        String ti = eh + ":"+em;
        return ti;
    }
    public String starttime(){
        String em=  String.valueOf(getStartMin()).trim();
        String eh = String.valueOf(getStartHour()).trim();
        if (em.length() == 1) {
            em = "0"+em;
        }
        if (eh.length()==1){
            eh = "0"+eh;
        }


        String ti = eh + ":"+em;
        return ti;
    }

    public String getVenueHashCode() {
        return venueHashCode;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public void setVenueHashCode(String venueHashCode) {
        this.venueHashCode = venueHashCode;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public HashSet<Event> getEvents() {
        return events;
    }

    public void setEvents(HashSet<Event> events) {
        this.events = events;
    }

    public void addEvent(Event event) { events.add(event); }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(venueHashCode);
        parcel.writeString(venueName);
        parcel.writeInt(startHour);
        parcel.writeInt(startMin);
        parcel.writeInt(endHour);
        parcel.writeInt(endMin);
        parcel.writeString(date);
        parcel.writeString(location);
    }
}
