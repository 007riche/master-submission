package com.example.tp1.CustomWidget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.icu.util.Calendar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.tp1.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExtentedCalendarView extends CalendarView  {

    private List<Date> dates = new ArrayList<Date>();
    private CalendarView.OnLongClickListener onLongClickListener;

    private OnDateChangeListener onDateChangeListener;


    private int selectedDayBackgroundColor;
    private int todayBackgroundColor;


    public ExtentedCalendarView(@NonNull Context context) {
        super(context);
//        init(context, null);
    }

    public ExtentedCalendarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        init(context, attrs);
    }

    public ExtentedCalendarView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        init(context, attrs);
    }

    public ExtentedCalendarView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
//        init(context, attrs);
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
        invalidate();
    }

    private void init(Context context, AttributeSet attrs) {
        selectedDayBackgroundColor = ContextCompat.getColor(context, R.color.indigo_500);
        todayBackgroundColor = ContextCompat.getColor(context, R.color.purple_200);

        setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            if (onDateChangeListener != null) {
                onDateChangeListener.onSelectedDayChange(view, year, month, dayOfMonth);
            }
        });
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        for (int i = 0; i < getChildCount(); i++) {
            final View child = getChildAt(i);
            child.setOnLongClickListener(new OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    // get the date of the cell that was clicked
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

    @Override
    public void setOnDateChangeListener(OnDateChangeListener listener)  {
        onDateChangeListener = listener;
        super.setOnDateChangeListener(listener);
    }


    public void setOnLongClickListener(OnLongClickListener listener) {
        super.setOnLongClickListener(listener);

        System.out.println("OCCURED LONG CLICK EVENT FROM THE CLASS");
        onLongClickListener = listener;
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Get the current month and year
        java.util.Calendar c = java.util.Calendar.getInstance();

        int month = c.get(java.util.Calendar.MONTH);
        int year = c.get(java.util.Calendar.YEAR);

        // Set up the paint object
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        // Draw a custom background for the highlighted dates
        for (Date date : dates) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            if (calendar.get(Calendar.MONTH) == month && calendar.get(Calendar.YEAR) == year) {
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                int cellWidth = getWidth() / 7;
                int cellHeight = getHeight() / 6;
                int x = (dayOfMonth - 1) % 7 * cellWidth;
                int y = (dayOfMonth - 1) / 7 * cellHeight;
                paint.setColor(Color.RED);
                canvas.drawRect(x, y, x + cellWidth, y + cellHeight, paint);
            }
        }
    }



}
