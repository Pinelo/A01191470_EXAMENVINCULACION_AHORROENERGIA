package itesm.mx.a01191470_examenvinculacion_ahorroenergia;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class newObjForm extends AppCompatActivity {

    int deviceConsumption;
    String deviceName;
    Bitmap photo;

    TextView nameTv;
    TextView brandET;
    ImageView cameraIV;
    NumberPicker hoursNP;
    Button takePicBT;
    Button finishBT;
    DeviceOperations dbo;

    static final int REQUEST_IMAGE_CAPTURE= 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_obj_form);

        dbo = new DeviceOperations(this);

        nameTv = (TextView)findViewById(R.id.deviceNameTV);
        brandET = (EditText)findViewById(R.id.addObjMarcaET);
        cameraIV = (ImageView)findViewById(R.id.cameraIV);
        finishBT = (Button)findViewById(R.id.addObjFinishBT);
        takePicBT = (Button)findViewById(R.id.picBT);
        hoursNP = (NumberPicker)findViewById(R.id.hoursNP);

        hoursNP.setMaxValue(1000);
        hoursNP.setMinValue(0);
        hoursNP.setWrapSelectorWheel(false);

        Intent intent = getIntent();
        deviceName = intent.getStringExtra("name");
        deviceConsumption = intent.getIntExtra("consumption", 0);
        nameTv.setText(deviceName);

        takePicBT.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchCamera(v);
                    }
                }
        );

        finishBT.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (brandET.getText().toString() == "" || hoursNP.getValue() == 0) {
                            Toast.makeText(getApplicationContext(), "Faltan datos por llenar", Toast.LENGTH_LONG).show();
                        } else {
                            addDevice(v);
                        }
                    }
                }
        );

    }

    private void addDevice(View v) {
        String deviceBrand = brandET.getText().toString();
        int hours = hoursNP.getValue();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        photo.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] imageBytes = stream.toByteArray();

        device newDevice = new device(deviceConsumption, hours, deviceName, deviceBrand, imageBytes);
        dbo.addDevice(newDevice);
        Toast.makeText(getApplicationContext(), "Operación Exitosa", Toast.LENGTH_LONG).show();
        finish();
    }

    //    checa si el usuario tiene una camara
    private boolean hasCamera() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

//    toma foto
    public void launchCamera(View view) {
        Intent camIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camIntent, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            photo = (Bitmap)extras.get("data");
            cameraIV.setImageBitmap(photo);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_obj_form, menu);
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
