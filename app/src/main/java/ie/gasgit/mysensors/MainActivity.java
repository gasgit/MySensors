package ie.gasgit.mysensors;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv =null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        SensorManager mySM = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> myListSensors = null;
        if (mySM != null) {
            myListSensors = mySM.getSensorList(Sensor.TYPE_ALL);
        }

        if (myListSensors != null) {
            for (int i = 0; i<myListSensors.size(); i++){

                tv.append(Html.fromHtml(
                        "<!DOCTYPE html>" +
                        "<table style='width:100%'>" +

                        "<tr style='background-color:rgb(192,192,192)'><h1 ><font color='#c5c5c5'>" + myListSensors.get(i).getName().toUpperCase() + "</font></h1></tr>" +
                               "<tr><h2>" + myListSensors.get(i).getVendor() + "</h2></tr>" +
                                "<tr><h2>" + myListSensors.get(i).getVersion() + "<h3></tr>" +
                                "</table>"

                ));


            }
        }
    }
}
