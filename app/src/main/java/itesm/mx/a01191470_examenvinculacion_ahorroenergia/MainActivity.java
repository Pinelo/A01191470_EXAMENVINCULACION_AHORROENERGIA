package itesm.mx.a01191470_examenvinculacion_ahorroenergia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addBT;
    Button listBT;
    Button reportBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        addBT = (Button)findViewById(R.id.addBT);
        listBT = (Button)findViewById(R.id.listBT);
        reportBT = (Button)findViewById(R.id.reportBT);

        addBT.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent addDeviceIntent = new Intent(MainActivity.this, addObjActivity.class);
                        startActivity(addDeviceIntent);
                    }
                }
        );

        listBT.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent deviceListIntent = new Intent(MainActivity.this, deviceList.class);
                        startActivity(deviceListIntent);
                    }
                }
        );

        reportBT.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent reportIntent = new Intent(MainActivity.this, report_activity.class);
                        startActivity(reportIntent);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
