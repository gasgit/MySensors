package ie.gasgit.mysensors;

import android.content.Intent;
import android.hardware.Sensor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class ListItemDisplay extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_display);

        Intent i = getIntent();
        Bundle b = i.getBundleExtra("b");

        String name = b.getString("sensor");
        String vendor = b.getString("vendor");
        String version = b.getString("version");
        String type = b.getString("type");
        String maxRange = b.getString("maxRange");
        String resolution = b.getString("resolution");
        String power = b.getString("power");
        String minDelay = b.getString("minDelay");



        System.out.println(version);




        TextView tvSensorDetail = findViewById(R.id.tvSensorDetail);
        TextView tvVendorDetail = findViewById(R.id.tvVendorDetail);
        TextView tvVersionDetail = findViewById(R.id.tvVersionDetail);



        tvSensorDetail.setText(name);
        tvVendorDetail.setText(vendor);
        tvVersionDetail.setText(version);



    }

}
