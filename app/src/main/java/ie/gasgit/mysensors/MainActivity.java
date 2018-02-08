package ie.gasgit.mysensors;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static ie.gasgit.mysensors.R.layout;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private ListView sensor_list_view;
    private List<Sensor> myListSensors = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        sensor_list_view = findViewById(R.id.sensor_list_view);
        SensorManager mySM = (SensorManager) getSystemService(SENSOR_SERVICE);
        if(mySM != null) {
            myListSensors = mySM.getSensorList(Sensor.TYPE_ALL);
        }
        tv = findViewById(R.id.tv);
        tv.setVisibility(View.VISIBLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_array_adapter:
                tv.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(),"ArrayAdapter selected",Toast.LENGTH_LONG).show();
                ArrayAdapter<Sensor> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myListSensors);
                sensor_list_view.setAdapter(adapter);
                return true;

            case R.id.menu_sensor_adapter:
                tv.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(),"Sensor Adapter Selected",Toast.LENGTH_LONG).show();
                ArrayList<Sensor> alSens = new ArrayList<>(myListSensors.size());
                alSens.addAll(myListSensors);
                SensorAdapter sa = new SensorAdapter(this, alSens);
                sensor_list_view.setAdapter(sa);

                sensor_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(MainActivity.this, ListItemDisplay.class);
                        Sensor obj = (Sensor) adapterView.getAdapter().getItem(i);
                        Bundle myBundle = new Bundle();


                        myBundle.putString("sensor", obj.getName());
                        myBundle.putString("vendor", obj.getVendor());
                        myBundle.putString("version", String.valueOf(obj.getVersion()));
                        myBundle.putString("type", String.valueOf(obj.getType()));
                        myBundle.putString("maxRange", String.valueOf(obj.getMaximumRange()));
                        myBundle.putString("resolution", String.valueOf(obj.getResolution()));
                        myBundle.putString("power", String.valueOf(obj.getPower()));
                        myBundle.putString("minDelay", String.valueOf(obj.getMinDelay()));

                        intent.putExtra("b", myBundle);

                        startActivity(intent);
                    }
                });
                return true;

            case R.id.item3:
                Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);


        }

    }




}
