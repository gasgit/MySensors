package ie.gasgit.mysensors;

import android.content.Context;
import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ubuntu on 06/02/18.
 */

public class SensorAdapter extends BaseAdapter {

    private Context myCtx;
    private LayoutInflater myLOI;
    private ArrayList<Sensor> mySensorList;

    public SensorAdapter(Context context, ArrayList<Sensor> sens){
        myCtx = context;
        mySensorList = sens;
        myLOI = (LayoutInflater) myCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mySensorList.size();
    }

    @Override
    public Object getItem(int i) {
        return mySensorList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View row = myLOI.inflate(R.layout.layout_sensor_item, viewGroup, false);

        TextView txSensor = row.findViewById(R.id.sensor);

        //TextView txVendor = row.findViewById(R.id.vendor);

        Sensor senZor = (Sensor) getItem(i);

        txSensor.setText(senZor.getName());

        //txVendor.setText(senZor.getVendor());

        return row;
    }
}
