package itesm.mx.a01191470_examenvinculacion_ahorroenergia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by hugo on 11/10/15.m
 */
public class SelListAdapter extends ArrayAdapter{

    String[] devices;
    int[] device_watts;

    public SelListAdapter(Context context, String[] devices, int[] values) {
        super(context, R.layout.electrodomestic_sel_row, devices);
        this.devices = devices;
        this.device_watts = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater selListInflater = LayoutInflater.from(getContext());
        View rowView = selListInflater.inflate(R.layout.electrodomestic_sel_row, parent, false);
        TextView selProdName = (TextView)rowView.findViewById(R.id.selProdNameTV);
        TextView wattsVTV = (TextView)rowView.findViewById(R.id.selWattsVTV);

        selProdName.setText(devices[position]);
        wattsVTV.setText(Integer.toString(device_watts[position]));

        return rowView;



    }
}
