package itesm.mx.a01191470_examenvinculacion_ahorroenergia;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by hugo on 11/10/15.m
 */
public class DeviceAdapter extends ArrayAdapter{

    List<device> devices;
    Context context;

    TextView deviceNameTV;
    TextView deviceBrandTV;
    TextView dateTV;
    TextView timeTV;
    TextView wattsPHTV;
    TextView totalWattsTV;

    public DeviceAdapter(Context context, List<device> devices) {
        super(context,R.layout.device_row ,devices);
        this.context = context;
        this.devices = devices;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater rowInflater = LayoutInflater.from(getContext());
        View row = rowInflater.inflate(R.layout.device_row, parent, false);

        TextView deviceNameTV = (TextView)row.findViewById(R.id.ProdNameTV);
        TextView deviceBrandTV = (TextView)row.findViewById(R.id.prodBrandTV);
        TextView dateTV = (TextView)row.findViewById(R.id.dateDT);
        TextView timeTV = (TextView)row.findViewById(R.id.timeDT);
        TextView wattsPHTV = (TextView)row.findViewById(R.id.WattsVTV);
        TextView totalWattsTV = (TextView)row.findViewById(R.id.totalWattsTV);



        device device = devices.get(position);
//        Log.d("CREATION", String.valueOf(articulo.getNumSerie()));
        deviceNameTV.setText(device.get_name());
        deviceBrandTV.setText(device.get_brand());
        wattsPHTV.setText(Integer.toString(device.get_consumption()));
        String total_watts = Integer.toString((device.get_consumption() * device.get_hours()));
        totalWattsTV.setText(total_watts);

        long yourmilliseconds = device.get_time();
        SimpleDateFormat sd = new SimpleDateFormat("MMM dd,yyyy");
        SimpleDateFormat st = new SimpleDateFormat("HH:mm");
        Date resultdate = new Date(yourmilliseconds);

        dateTV.setText(sd.format(resultdate));
        timeTV.setText(st.format(resultdate));

        return row;
    }
}
