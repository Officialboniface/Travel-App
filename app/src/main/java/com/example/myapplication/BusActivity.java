package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class BusActivity extends AppCompatActivity implements RecyclerAdapter.ItemClickListener {
  RecyclerAdapter recyclerAdapter;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        FloatingActionButton fab = findViewById(R.id.fab_icon_id);
        ArrayList<String> busList = new ArrayList<>();
        busList.add("Kallada Transports");
        busList.add("KPN Transports");
        busList.add("SRM Transports");
        busList.add("Kallada Transports");
        busList.add("KPN Transports");
        busList.add("SRM Transports");
        busList.add("KPN Transports");
        busList.add("SRM Transports");





       fab.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               BottomSheetDialog bottomSheet = new BottomSheetDialog();
               bottomSheet.show(getSupportFragmentManager(), "hello");


           }
       });

        textView = findViewById(R.id.Choose_ur_Bus_Tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        RecyclerView recyclerView = findViewById(R.id.RecyclerviewId);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        recyclerAdapter = new RecyclerAdapter(this, busList);
        recyclerView.setAdapter(recyclerAdapter);







    }




    @Override
    public void onItemClick(View view, int position) {
    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
    }
}
