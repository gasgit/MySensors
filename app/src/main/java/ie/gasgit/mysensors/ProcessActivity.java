package ie.gasgit.mysensors;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ProcessActivity extends AppCompatActivity {

    TextView tvProcesses;
    ActivityManager aMan;
    Context ctx;
    List<ActivityManager.RunningAppProcessInfo> RPInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);

        tvProcesses = findViewById(R.id.tvProcesses);
        ctx = getApplicationContext();

        aMan = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
        RPInfo = aMan.getRunningAppProcesses();

       for(ActivityManager.RunningAppProcessInfo rpi : RPInfo){
           if(rpi != null){


               tvProcesses.setText("PID: " + rpi.pid +
                       "\n" + "Process Name: " + rpi.processName);

           }
       }








    }
}
