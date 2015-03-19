package com.drc.des.sunshine;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final Button backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onBackPressed(); same thing maybe
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();
        String weekDay = bundle.getString("WeekDay");
        int icon1 = bundle.getInt("Icon");
        String  condition = bundle.getString("Condition");
        String highTemp = bundle.getString("HighTemp");
        String lowTemp = bundle.getString("LowTemp");
        String windSpeed = bundle.getString("WindSpeed");
        String airPressure = bundle.getString("Pressure");
        String humid = bundle.getString("Humidity");

        TextView day = (TextView) findViewById(R.id.detail_day_textview);
        day.setText(weekDay);

        TextView high = (TextView) findViewById(R.id.detail_high_textview);
        high.setText(highTemp);

        TextView condit = (TextView) findViewById(R.id.detail_forecast_textview);
        condit.setText(condition);

        TextView low = (TextView) findViewById(R.id.detail_low_textview);
        low.setText(lowTemp);

        ImageView icon = (ImageView) findViewById(R.id.detail_icon);
        icon.setImageResource(icon1);

        TextView wind = (TextView) findViewById(R.id.detail_wind_textview);
        wind.setText(windSpeed);

        TextView press = (TextView) findViewById(R.id.detail_pressure_textview);
        press.setText(airPressure);

        TextView humidity = (TextView) findViewById(R.id.detail_humidity_textview);
        humidity.setText(humid);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
