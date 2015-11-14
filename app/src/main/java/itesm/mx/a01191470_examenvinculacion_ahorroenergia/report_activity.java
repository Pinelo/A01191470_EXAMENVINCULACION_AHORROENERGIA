package itesm.mx.a01191470_examenvinculacion_ahorroenergia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;

import java.util.ArrayList;
import java.util.List;

public class report_activity extends AppCompatActivity {

    NumberPicker monthNP;
    NumberPicker dayNP;
//    Button generateReportBT;
    DeviceOperations dbo;
    List<device> reportDevices;
    ListView reportLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_activity);

        dbo = new DeviceOperations(this);
        reportLV = (ListView)findViewById(R.id.reportLV);
        monthNP = (NumberPicker)findViewById(R.id.monthNP);
        dayNP = (NumberPicker)findViewById(R.id.dayNP);
//        generateReportBT = (Button)findViewById(R.id.genReportBT);

        monthNP.setMaxValue(12);
        monthNP.setMinValue(1);
        monthNP.setWrapSelectorWheel(false);

        dayNP.setMaxValue(31);
        dayNP.setMinValue(1);
        dayNP.setWrapSelectorWheel(false);

//        generateReportBT.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        int month = monthNP.getValue();
//                        int day = dayNP.getValue();
//
//                        reportDevices = generateReport(month, day);
//
//                        final RepListAdapter selectionListAdapter = new
//                                RepListAdapter(getApplicationContext(), reportDevices);
//                        reportLV.setAdapter(selectionListAdapter);
//                    }
//                }
//        );


    }

    private List<device> generateReport(int month, int day) {
        List<device> devices = dbo.findDevicesByDate(month, day);
        List<device> filterDevice = compressList(devices);

        return filterDevice;




    }

    private List<device> compressList(List<device> devices) {
        List<device> filterDevice = new ArrayList<>();
        device device;
        device nDevice;
        int i, x;
        for(i = 0; i < devices.size(); i++) {
            nDevice = devices.get(i);
            if (filterDevice.size() == 0) {
                filterDevice.add(nDevice);
            } else {
                boolean found = false;
                for (x = 0; x < filterDevice.size(); x++) {

                    if (filterDevice.get(x).get_name().equals(nDevice.get_name())) {
                        found = true;
                        int newHours = filterDevice.get(x).get_hours() + nDevice.get_hours();
                        filterDevice.get(x).set_hours(newHours);
                        break;
                    }
                }
                if (!found) {
                    filterDevice.add(nDevice);
                }
            }
        }
        return filterDevice;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.report_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.reportMenu) {
            int month = monthNP.getValue();
            int day = dayNP.getValue();

            reportDevices = generateReport(month, day);

            final RepListAdapter selectionListAdapter = new
                    RepListAdapter(getApplicationContext(), reportDevices);
            reportLV.setAdapter(selectionListAdapter);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
