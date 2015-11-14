package itesm.mx.a01191470_examenvinculacion_ahorroenergia;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by hugo on 11/13/15.
 */
public class DeviceInfoFragment extends Fragment{

     static final String COLUMN_TYPE = "TYPE";
    static final String COLUMN_BRAND= "BRAND";
    static final String COLUMN_CONSUMPTION = "CONSUMPTION";
    static final String COLUMN_HOURS = "HOURS";
    static final String COLUMN_DATETIME = "DATETIME";
    static final String COLUMN_BLOB = "BLOBL";

    TextView type;
    TextView brand;
    TextView fecha;
    TextView horas;
    TextView total;
    ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(
                R.layout.fragment_collection_object, container, false);

        type = (TextView)rootView.findViewById(R.id.infoType);
        brand = (TextView)rootView.findViewById(R.id.infoBrand);
        fecha = (TextView)rootView.findViewById(R.id.dateTime);
        horas = (TextView)rootView.findViewById(R.id.repConsumedTV);
        total = (TextView)rootView.findViewById(R.id.repTotalTV);
        img = (ImageView)rootView.findViewById(R.id.repDeviceIV);


        Bundle args = getArguments();
        if (args != null) {
            String dName = args.getString(DeviceInfoFragment.COLUMN_TYPE);
            String dBrand = args.getString(DeviceInfoFragment.COLUMN_BRAND);
            int dCons = args.getInt(DeviceInfoFragment.COLUMN_CONSUMPTION);
            byte[] dImage = args.getByteArray(DeviceInfoFragment.COLUMN_BLOB);
            int dHours = args.getInt(DeviceInfoFragment.COLUMN_HOURS);
            long date = args.getLong(DeviceInfoFragment.COLUMN_DATETIME);

            setValues(rootView, dName, dBrand, dCons, dImage, dHours, date);
        }

        return rootView;
    }

    private void setValues(View rootView, String dName, String dBrand, int dCons, byte[] dImage, int dHours, long date) {
        type.setText(dName);
        brand.setText(dBrand);
        horas.setText(Integer.toString(dHours));
        total.setText(Integer.toString(dHours * dCons));
        Bitmap bitmap = BitmapFactory.decodeByteArray(dImage, 0, dImage.length);
        img.setImageBitmap(bitmap);

        SimpleDateFormat sd = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultdate = new Date(date);

        fecha.setText(sd.format(resultdate));
    }
}
