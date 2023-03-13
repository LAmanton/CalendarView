package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    ImageButton ib;
    CalendarView cv;
    String selectedDateString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cv = findViewById(R.id.calendarView2);



// Définir un listener pour le changement de date
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // Créer un objet Calendar pour la date sélectionnée
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(Calendar.YEAR, year);
                selectedDate.set(Calendar.MONTH, month);
                selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                // Afficher la date sélectionnée dans le format souhaité
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM:yy", Locale.FRANCE);
                selectedDateString = dateFormat.format(selectedDate.getTime());

            }
        });
    }
    public void BBack(View v){
        Intent intent = new Intent();
        intent.putExtra("date", selectedDateString);
        setResult(MainActivity2.RESULT_OK, intent);
        finish();
    }
}