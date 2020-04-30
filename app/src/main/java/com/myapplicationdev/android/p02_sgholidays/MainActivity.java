package com.myapplicationdev.android.p02_sgholidays;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<HolidayType> holidayTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) this.findViewById(R.id.lvType);

        holidayTypes = new ArrayList<HolidayType>();
        holidayTypes.add(new HolidayType("Secular"));
        holidayTypes.add(new HolidayType("Ethnic & Religion"));

        aa = new HolidayTypeAdapter(this, R.layout.row, holidayTypes);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HolidayType selectedType = holidayTypes.get(position);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("type",selectedType.getName());
                Toast.makeText(MainActivity.this, selectedType.getName(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });


    }
}
