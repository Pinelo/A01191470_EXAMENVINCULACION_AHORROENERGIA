package itesm.mx.a01191470_examenvinculacion_ahorroenergia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class addObjActivity extends AppCompatActivity {

    ListView selDeviceLV;
    String[] devices;
    int[] values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_obj);

        devices = getApplicationContext().getResources()
                .getStringArray(R.array.electrodomestics);

        values = getApplicationContext().getResources()
                .getIntArray(R.array.watts);


        final ListAdapter selectionListAdapter = new SelListAdapter(this, devices, values);

        selDeviceLV = (ListView)findViewById(R.id.addObjLV);
        selDeviceLV.setAdapter(selectionListAdapter);


//        Se despliega la actividad donde aparece el formulario para agregar ese producto.
        selDeviceLV.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(addObjActivity.this, newObjForm.class);
                        String deviceName = devices[position];
                        int consumption = values[position];
                        intent.putExtra("name", deviceName);
                        intent.putExtra("consumption", consumption);
                        startActivity(intent);
                    }
                }
        );





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_obj, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
