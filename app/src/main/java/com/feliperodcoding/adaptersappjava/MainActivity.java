package com.feliperodcoding.adaptersappjava;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //1-Adapter view
        listView = findViewById(R.id.listview);

        //2-data source
        String[] countries = {"CA","USA","FR","JP"};

        //3- Create Adapter
        //OOB version
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
        //                                                    android.R.layout.simple_list_item_1,
        //                                                    countries);

        //Customized version
        MyCustomAdapter customAdapter= new MyCustomAdapter(this,countries);

        //4-link
        listView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}