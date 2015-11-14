package itesm.mx.a01191470_examenvinculacion_ahorroenergia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class deviceList extends AppCompatActivity {

    DeviceOperations dbo;
    List<device> devices;
    ListView devicesLV;
    DeviceAdapter selectionListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);

        dbo = new DeviceOperations(this);
        devices = dbo.getAllDevices();
        devicesLV = (ListView)findViewById(R.id.devicesLV);

        selectionListAdapter = new DeviceAdapter(getApplicationContext(), devices);
        devicesLV.setAdapter(selectionListAdapter);
        registerForContextMenu(devicesLV);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.device_menu_context, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int id = item.getItemId();
        int index = info.position;

        if (id == R.id.confirm) {
            removeDevice(index);
            return true;
        } else if (id == R.id.cancel) {
            Toast.makeText(getApplicationContext(), "Operación Cancelada", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }

    public void removeDevice(int pos) {


        device device = devices.get(pos);
        boolean result = dbo.deleteDevice(Integer.toString(device.get_id()));

        if (result) {
            devices.remove(pos);
            selectionListAdapter.notifyDataSetChanged();
        }
    }
}
