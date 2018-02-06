package ie.gasgit.mysensors;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import static ie.gasgit.mysensors.R.layout;

public class MainActivity extends AppCompatActivity {

    private ListView sensor_list_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        sensor_list_view = findViewById(R.id.sensor_list_view);


        SensorManager mySM = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> myListSensors = null;


        if(mySM != null) {
            myListSensors = mySM.getSensorList(Sensor.TYPE_ALL);
        }



        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myListSensors);
        sensor_list_view.setAdapter(adapter);
    }
}
