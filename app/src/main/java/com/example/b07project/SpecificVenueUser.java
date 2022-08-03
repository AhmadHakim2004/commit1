package com.example.b07project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashSet;

public class SpecificVenueUser extends AppCompatActivity {

    ArrayList<Venue> venues = new ArrayList<Venue>();
    AdapterUpcomingEvents adapter;

    //have to wait for ahmads code for this to work

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        setUpVenues();
        boolean found = false;
        Venue theVenue = new Venue();
        for(Venue v: venues){
            if (v.getVenueName().equals(getIntent().getStringExtra("venueName"))){
                theVenue = v;
                found = true;
            }
        }

        if (found){
            setContentView(R.layout.activity_scroll);
            RecyclerView recyclerView = findViewById(R.id.recycler_view);
            adapter = new AdapterUpcomingEvents(this, new ArrayList<Event>(theVenue.getEvents()));
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

    }

    public void setUpVenues() {

        HashSet<Event> eventsAll = new HashSet<Event>() {};
        eventsAll.add(new Event("Emirates Stadium", 5, 0, 7, 0, 22, "panam", "july"));
        eventsAll.add(new Event("bbb",  3, 0,5, 0,10, "panam", "july"));
        eventsAll.add(new Event("ddd", 3, 30,5, 0,10, "panam", "july"));
        eventsAll.add(new Event("eee", 3, 0,5, 0,10, "panam", "july"));
        eventsAll.add(new Event("fff",  10, 0,12, 0,2, "panam", "july"));
        eventsAll.add(new Event("ggg",  5, 0,7, 0,22, "panam", "july"));
        eventsAll.add(new Event("Emirates Stadium", 0,8, 10,  5, 7, "panam", "july"));

        //read venues from from database
        venues.add(new Venue("somehaschode", "Pan am", 1, 0,  4, 0, "august", "morningside avneue", eventsAll));
        venues.add(new Venue("somehaschode", "drake smd", 1, 0,  4, 0, "august", "morningside avneue", eventsAll));
        venues.add(new Venue("somehaschode", "no name", 1, 0,  4, 0, "august", "morningside avneue", eventsAll));
        venues.add(new Venue("somehaschode", "please word", 1, 0,  4, 0, "august", "morningside avneue", eventsAll));
        venues.add(new Venue("somehaschode", "ronaldo goat ", 1, 0,  4, 0, "august", "morningside avneue", eventsAll));

    }
}