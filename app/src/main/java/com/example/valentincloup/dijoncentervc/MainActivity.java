package com.example.valentincloup.dijoncentervc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.valentincloup.dijoncentervc.Model.PointOfInterest;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnTest;
    ListView lvPoi;
    ArrayList<PointOfInterest> lesPois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lesPois = new ArrayList<>();

        btnTest =  (Button)findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        lvPoi = (ListView)findViewById(R.id.lvPoi);

        ArrayAdapter<PointOfInterest> poiAdapter = new ArrayAdapter<PointOfInterest>(MainActivity.this, android.R.layout.simple_list_item_1, lesPois);
        lvPoi.setAdapter(poiAdapter);
    }
}
