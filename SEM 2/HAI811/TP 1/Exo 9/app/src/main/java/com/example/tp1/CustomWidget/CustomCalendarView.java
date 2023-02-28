package com.example.tp1.CustomWidget;

import android.content.Context;
import android.icu.util.Calendar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CalendarView;

import java.util.Date;

public class CustomCalendarView extends CalendarView {

    public CustomCalendarView(Context context) {
        super(context);
    }

    public CustomCalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomCalendarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        // loop through all the child views of the calendar and add a long click listener
        for (int i = 0; i < getChildCount(); i++) {
            final View child = getChildAt(i);
            child.setOnLongClickListener(new OnLongClickListener() {
                /**
                 * Called when a view has been clicked and held.
                 *
                 * @param v The view that was clicked and held.
                 * @return true if the callback consumed the long click, false otherwise.
                 */
                @Override
                public boolean onLongClick(View v) {
                    Date date = new Date(getDate());
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    calendar.add(Calendar.DATE, child.getTag() != null ? (int) child.getTag() : 0);
                    Date clickedDate = calendar.getTime();

                    // do something with the clicked date
                    System.out.println("CustomCalendarView Clicked on date: " + clickedDate.toString());

                    return true;
                }


            });
        }
    }
}

