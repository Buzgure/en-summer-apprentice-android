package com.example.tms;
import com.example.tms.R;
import com.example.tms.model.Event;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EventFragment eventFragment;
    private OrderFragment orderFragment;
    private ViewStub titleSubEvent;
    private ViewStub titleSubOrder;
    private ViewStub titleSub;
    TextView textView;
    RecyclerView eventsRecycleView;

    FrameLayout fragmentContainer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eventsRecycleView = findViewById(R.id.event_recycle_view);


        setSupportActionBar(findViewById(R.id.my_toolbar));
        titleSub = findViewById(R.id.title_sub);
        View inflatedView = titleSub.inflate();
        textView = inflatedView.findViewById(R.id.title_template);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pages_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.item_events){
            textView.setText("Events");
            showEventsList();
            return true;

        } else if (item.getItemId() == R.id.item_orders) {
            textView.setText("Orders");
            showOrdersList();
            return true;

        }else {
            return super.onOptionsItemSelected(item);
        }

    }

    private void showEventsList() {


        fragmentContainer = findViewById(R.id.event_fragment_container);
        eventFragment = new EventFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, eventFragment).commit();
//        List<String> eventsList = new ArrayList<>();
//        eventsList.add("Event 1");
//        eventsList.add("Event 2");
//        eventsList.add("Event 3");
//        eventsList.add("Event 4");
//        eventsList.add("Event 5");
//        eventsList.add("Event 6");
//        eventFragment.updateEventsList(eventsList);
        getEvents();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, eventFragment)
                .commit();
    }

    private void showOrdersList(){



        fragmentContainer = findViewById(R.id.order_fragment_container);

        orderFragment = new OrderFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, orderFragment).commit();
        List<String> ordersList = new ArrayList<>();
        ordersList.add("Order 1");
        ordersList.add("Order 2");
        ordersList.add("Order 3");
        ordersList.add("Order 4");
        ordersList.add("Order 5");
        ordersList.add("Order 6");
        orderFragment.updateOrdersList(ordersList);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, orderFragment)
                .commit();
    }


    public void getEvents(){
        Call<List<Event>> call = RetrofitClient.getInstance().getMyApi().getAllEvents();
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(@NonNull Call<List<Event>> call, @NonNull Response<List<Event>> response) {
//                eventFragment = new EventFragment();
//                fragmentContainer = findViewById(R.id.event_fragment_container);
//                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, eventFragment).commit();
//                List<Event> myEventList = response.body();
//                eventFragment.updateEventsList(myEventList);
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragment_container, eventFragment)
//                        .commit();
                if(response.isSuccessful()){
                    List<Event> myEventList = response.body();
                    eventFragment.updateEventsList(myEventList);
                }
                else{
                    throw new IllegalStateException("Not success");
                }
            }


            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                throw new IllegalStateException(t);
            }
        });

    }
}

