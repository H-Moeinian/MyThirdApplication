package com.example.mythirdapplication;

import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class TestRecyclerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recycler);
        RecyclerView recycler = findViewById(R.id.recycler);

        Button btnName = findViewById(R.id.btnName);
        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout navDrawer = findViewById(R.id.drawerLayout);
                // If the navigation drawer is not open then open it, if its already open then close it.
               // if(!navDrawer.isDrawerOpen(Gravity.START))
                    navDrawer.openDrawer(Gravity.START);
               // else navDrawer.closeDrawer(Gravity.END);

            }
        });


        List<String> list = new ArrayList<>();
        list.add("Dial");
        list.add("Profile");
        list.add("Calendar");


        TestRecyclerAdapter adapter = new TestRecyclerAdapter(list,this);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(TestRecyclerActivity.this,RecyclerView.VERTICAL,false));


    }
}
