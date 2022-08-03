package com.example.b07project;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class ViewVenuesUser extends  AppCompatActivity implements ViewVenuesInterface, RecycleViewInterface{

    ArrayList<Venue> venues = new ArrayList<>();
    AdapterVenues adapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_venues_user);

        RecyclerView recyclerView  = findViewById(R.id.recycleViewVenueUser);

        //pass the list of venues from the database to setUpVenues()
        setUpVenues();

        SpacingItemDecorator itemDecorator = new SpacingItemDecorator(10);
        //recyclerView.addItemDecoration(itemDecorator);
        adapter = new AdapterVenues(this, venues, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setUpVenues() {

        HashSet<Event> eventsAll = new HashSet<Event>() {};
        LocalDate date1 = LocalDate.of(2022, 8, 2);
        LocalDate date2 = LocalDate.of(2022, 8, 3);
        LocalDate date3 = LocalDate.of(2022, 8, 4);
        LocalDate date4 = LocalDate.of(2022, 8, 5);
        eventsAll.add(new Event("dropIn", "Emirates Stadium", "soccer", 5, 7, 0, 0, 22, 22, date2));
        eventsAll.add(new Event("dropIn", "bbb", "basketball",  3, 5, 0, 0,10, 10, date1 ));
        eventsAll.add(new Event("dropIn","ddd", "basketball", 3, 5, 30, 0,10, 0, date2));
        eventsAll.add(new Event("dropIn","eee", "basketball", 3, 5, 0, 0,10, 10, date2));
        eventsAll.add(new Event("dropIn","fff", "tennis", 10, 12, 0, 0,2, 2, date3));
        eventsAll.add(new Event("dropIn","ggg", "soccer", 5, 7, 0, 0,22, 2, date3));

        //read venues from from database
        venues.add(new Venue("somehaschode", "Pan am", 1, 0,  4, 0, "august", "morningside avneue", eventsAll));
        venues.add(new Venue("somehaschode", "drake smd", 1, 0,  4, 0, "august", "morningside avneue", eventsAll));
        venues.add(new Venue("somehaschode", "no name", 1, 0,  4, 0, "august", "morningside avneue", eventsAll));
        venues.add(new Venue("somehaschode", "please word", 1, 0,  4, 0, "august", "morningside avneue", eventsAll));
        venues.add(new Venue("somehaschode", "ronaldo goat ", 1, 0,  4, 0, "august", "morningside avneue", eventsAll));

    }

   @Override
    public void onItemClick(int position) {
       Intent intent = new Intent(ViewVenuesUser.this, SpecificVenueUser.class);
       Bundle bundle = new Bundle();
//       bundle.putSerializable("venue_events", venues.get(position).getEvents());
       intent.putExtra("venueName", venues.get(position).getVenueName());
       startActivity(intent);
    }

    public void clickUp(View view){
        Intent intent = new Intent(getApplicationContext(), Scroll.class);
        intent.putExtra("ind", "up");
        startActivity(intent);
    }

    public void clickMy(View view){
        Intent intent = new Intent(getApplicationContext(), Scroll.class);
        intent.putExtra("ind", "my");
        startActivity(intent);
    }

    public void clickV(View view){
        Intent intent = new Intent(getApplicationContext(), ViewVenuesUser.class);
        startActivity(intent);
    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}