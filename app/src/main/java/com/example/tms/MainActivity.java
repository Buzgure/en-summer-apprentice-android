package com.example.tms;
import com.example.tms.R;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
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
//        switch (item.getItemId()){
//            case R.id.item_events:
//                Toast.makeText(this, "Events selected", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.item_orders:
//                Toast.makeText(this, "Orders selected", Toast.LENGTH_SHORT).show();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
        if (item.getItemId() == R.id.item_events){
            Toast.makeText(this, "Events selected", Toast.LENGTH_SHORT).show();
                return true;
        } else if (item.getItemId() == R.id.item_orders) {
            Toast.makeText(this, "Orders selected", Toast.LENGTH_SHORT).show();
            return true;

        }else {
            return super.onOptionsItemSelected(item);
        }

    }

}

