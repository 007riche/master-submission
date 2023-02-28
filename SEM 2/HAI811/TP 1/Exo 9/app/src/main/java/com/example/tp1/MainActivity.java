package com.example.tp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TimePicker;

import com.example.tp1.CustomWidget.CustomCalendarView;
import com.example.tp1.CustomWidget.ExtentedCalendarView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private  static CustomCalendarView calendarView;
    private static ListView eventListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = (CustomCalendarView)  findViewById(R.id.calendarView);
        eventListView = (ListView) findViewById(R.id.eventListView);
        calendarView.setLongClickable(true);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//                view.setOnLongClickListener(new View.OnLongClickListener() {
//                    @Override
//                    public boolean onLongClick(View v) {
//                        if (v.isLongClickable()) {
//                            System.out.println("Long click,  Selected Date: "+dayOfMonth+" "+month+" "+year);
//                        }
//                        System.out.println("Long click,  Selected Date: "+dayOfMonth+" "+month+" "+year);
//                        return true;
//                    }
//                });
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int min = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    }
                }, hour, min, true );
                timePickerDialog.show();
                System.out.println(" Selected Date: "+dayOfMonth+" "+month+" "+year);
            }
        });

        for (int i = 0; i < calendarView.getChildCount(); i++) {
            final View child = calendarView.getChildAt(i);
            child.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View v) {
                    // do something when the date cell is long clicked
                    System.out.println("LONG CLICK EVENT occured");
                    return true; // return true to indicate that the long click event has been consumed
                }
            });
        }

    }
}



