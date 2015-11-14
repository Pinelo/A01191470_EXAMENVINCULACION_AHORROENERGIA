package itesm.mx.a01191470_examenvinculacion_ahorroenergia;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class DeviceInfoActivity extends FragmentActivity {

    VPDeviceCollectionAdapter mDemoCollectionPagerAdapter;
    ViewPager mViewPager;
    DeviceOperations dbo;
    List<device> devices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_info);

        dbo = new DeviceOperations(this);
        devices = dbo.getAllDevices();

        Intent intent = getIntent();



        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.
        mDemoCollectionPagerAdapter =
                new VPDeviceCollectionAdapter(
                        getSupportFragmentManager(), devices);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mDemoCollectionPagerAdapter);
        mViewPager.setCurrentItem(intent.getIntExtra("pos", 0), true);
    }
}
