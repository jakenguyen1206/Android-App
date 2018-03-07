package com.ptit.nhom8.ptit_app;

import android.graphics.Color;
import android.graphics.Paint;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {
    CompactCalendarView compactCalendarView;

    TextView month ;
    TextView date;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM-yyyy", Locale.getDefault());
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("EEE-d-MMMM-yyyy", Locale.getDefault());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null);


        date = (TextView)  findViewById(R.id.txtVieưDate);
        month = (TextView) findViewById(R.id.txtViewMonth);
        date.setPaintFlags(date.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        compactCalendarView =(CompactCalendarView) findViewById(R.id.compactcalendar_view);
        compactCalendarView.setUseThreeLetterAbbreviation(true);
        compactCalendarView.setFirstDayOfWeek(Calendar.MONDAY);
        date.setText(dateFormat2.format(Calendar.DATE));
        Event event1 = new Event(Color.RED,1520341145,"Bala");
        compactCalendarView.addEvent(event1);
        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                date.setText(dateFormat2.format(dateClicked));


            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                month.setText(dateFormat.format(firstDayOfNewMonth)) ;
            }
        });

    }
}