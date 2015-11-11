package itesm.mx.a01191470_examenvinculacion_ahorroenergia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

public class deviceList extends AppCompatActivity {

    DeviceOperations dbo;
    List<device> devices;
    ListView devicesLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);

        dbo = new DeviceOperations(this);
        devices = dbo.getAllDevices();
        devicesLV = (ListView)findViewById(R.id.devicesLV);

        final DeviceAdapter selectionListAdapter = new DeviceAdapter(getApplicationContext(), devices);


        devicesLV.setAdapter(selectionListAdapter);
    }
}
