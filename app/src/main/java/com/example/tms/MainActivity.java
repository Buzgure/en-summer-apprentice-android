package com.example.tms;
import com.example.tms.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EventFragment eventFragment;
    FrameLayout fragmentContainer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.my_toolbar));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pages_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.item_events){
            showEventsList();
            return true;
        } else if (item.getItemId() == R.id.item_orders) {
            Toast.makeText(this, "Orders selected", Toast.LENGTH_SHORT).show();
            return true;

        }else {
            return super.onOptionsItemSelected(item);
        }

    }

    private void showEventsList() {
        fragmentContainer = findViewById(R.id.fragment_container);

        eventFragment = new EventFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, eventFragment).commit();
        List<String> eventsList = new ArrayList<>();
        eventsList.add("Event 1");
        eventsList.add("Event 2");
        eventsList.add("Event 3");
        eventsList.add("Event 4");
        eventsList.add("Event 5");
        eventsList.add("Event 6");
        eventFragment.updateEventsList(eventsList);
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, eventFragment)
//                .commit();
    }

}

