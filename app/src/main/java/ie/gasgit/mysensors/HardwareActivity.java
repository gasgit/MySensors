package ie.gasgit.mysensors;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class HardwareActivity extends AppCompatActivity {

    private TextView tvHardware;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvHardware = findViewById(R.id.tvHardWare);




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Snackbar.make(view, "List Hardware", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                tvHardware.setText("hello world!!" +
                        "\n" + "Board: " + Build.BOARD +
                        "\n" + "Model: " + Build.MODEL +
                        "\n" + "Manufacturer: " + Build.MANUFACTURER +
                        "\n" + "Device: " + Build.DEVICE +
                        "\n" + "Brand:  " + Build.BRAND +
                        "\n" + "Display: " + Build.DISPLAY +
                        "\n" + "User: " + Build.USER +
                        "\n" + "Host: " + Build.HOST +
                        "\n" + "ID: " + Build.ID


                );}





        });
    }

}
