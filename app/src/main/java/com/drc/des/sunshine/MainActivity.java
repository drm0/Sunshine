package com.drc.des.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

//    private ArrayAdapter<String> mForecastAdapter;
    private ArrayAdapter<Weather> mForecastAdapter;
    public int sunny = R.mipmap.sunny;
    public int rain = R.mipmap.rain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.search_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final EditText edittext = (EditText) findViewById(R.id.editText);
                GetWeather(edittext.getText().toString());
            }
        });


    }

    public void GetWeather(String SearchText) {

        final ArrayList<Weather> forecastArray = new ArrayList<Weather>();
        //                              day condition high low current humidity wind pressure
        forecastArray.add(new Weather("Today","Sunny", "88", "63", "30", "95", "5", "1004"));
        forecastArray.add(new Weather("Tomorrow", "Rainy", "70", "46", "50", "95", "5", "1004"));
        forecastArray.add(new Weather("Weds","Sunny", "72", "63", "30", "95", "5", "1004"));
        forecastArray.add(new Weather("Thurs", "Rainy", "64", "51", "30", "95", "5", "1004"));
        forecastArray.add(new Weather("Fri","Foggy", "35", "93", "70", "95", "5", "1004"));
        forecastArray.add(new Weather("Sat", "Rainy", "57", "43", "16", "95", "5", "1004"));
        forecastArray.add(new Weather("Sun","Sunny", "85", "93", "40", "95", "5", "1004"));
        MyAdapter adapter = new MyAdapter(this, R.layout.weather_text, forecastArray);


        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Weather forecast = mForecastAdapter.getItem(position);
//                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//                final int result = 1;
//
//                intent.putExtra("forecast", forecast.toString());
//                startActivity(intent);
                Weather weather = forecastArray.get(position);

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("WeekDay", weather.getWeekDay());
                bundle.putInt("Icon", weather.getImage());
                bundle.putString("Condition", weather.getCondition());
                bundle.putString("HighTemp", weather.getTempHigh());
                bundle.putString("LowTemp", weather.getTempLow());
                bundle.putString("WindSpeed", weather.getWind());
                bundle.putString("Humidity", weather.getHumid());
                bundle.putString("Pressure", weather.getPressure());
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

//        new AlertDialog.Builder(this)
//                .setTitle("Delete entry")
//                .setMessage(SearchText)
//                .show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
