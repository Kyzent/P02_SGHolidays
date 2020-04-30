package com.myapplicationdev.android.p02_sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HolidayNameAdapter extends ArrayAdapter {
    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvHolidayName;
    private TextView tvDate;
    private ImageView ivHoliday;

    public HolidayNameAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        // Store the objects that is passed to this adapter
        holiday = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.rownames, parent, false);

        tvHolidayName = (TextView) rowView.findViewById(R.id.tvHolidayName);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        ivHoliday = (ImageView) rowView.findViewById(R.id.ivHoliday);

        Holiday currentHoliday = holiday.get(position);

        tvHolidayName.setText(currentHoliday.getHolidayName());
        tvDate.setText(currentHoliday.getDate());

        if(currentHoliday.getHolidayType().equals("Secular")){
            if (position == 0) {
                ivHoliday.setImageResource(R.drawable.new_year);
            }else if(position == 1){
                ivHoliday.setImageResource(R.drawable.labour_day);
            }else{
                ivHoliday.setImageResource(R.drawable.national_day);
            }
        }
        else if(currentHoliday.getHolidayType().equals("Ethnic & Religion")){
            if (position == 0) {
                ivHoliday.setImageResource(R.drawable.cny);
            }if (position == 1) {
                ivHoliday.setImageResource(R.drawable.good_friday);
            }if (position == 2) {
                ivHoliday.setImageResource(R.drawable.vesak_day);
            }if (position == 3) {
                ivHoliday.setImageResource(R.drawable.hari_raya_puasa);
            }if (position == 4) {
                ivHoliday.setImageResource(R.drawable.hari_raya_haji);
            }if (position == 5) {
                ivHoliday.setImageResource(R.drawable.deepavali);
            }if (position == 6) {
                ivHoliday.setImageResource(R.drawable.christmas);
            }
        }

        // Return the nicely done up View to the ListView
        return rowView;
    }
}
