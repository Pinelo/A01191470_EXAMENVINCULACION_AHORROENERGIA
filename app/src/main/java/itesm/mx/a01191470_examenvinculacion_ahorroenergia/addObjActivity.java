package itesm.mx.a01191470_examenvinculacion_ahorroenergia;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_obj);

        String[] devices = getApplicationContext().getResources()
                .getStringArray(R.array.electrodomestics);

        int[] values = getApplicationContext().getResources()
                .getIntArray(R.array.watts);


        ListAdapter selectionListAdapter = new SelListAdapter(this, devices, values);

        selDeviceLV = (ListView)findViewById(R.id.addObjLV);
        selDeviceLV.setAdapter(selectionListAdapter);

        selDeviceLV.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(addObjActivity.this, "string", Toast.LENGTH_SHORT).show();
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
