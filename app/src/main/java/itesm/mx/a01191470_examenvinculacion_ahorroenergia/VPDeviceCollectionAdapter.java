package itesm.mx.a01191470_examenvinculacion_ahorroenergia;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by hugo on 11/13/15.
 */

//
public class VPDeviceCollectionAdapter extends FragmentStatePagerAdapter {
    List<device> devices;


    public VPDeviceCollectionAdapter(FragmentManager fm, List<device> devices1) {
        super(fm);
//        Resources resources = context.getResources();
//        devices = resources.getStringArray(R.array.devices);
        devices = devices1;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new DeviceInfoFragment();
        Bundle args = new Bundle();
        device device = devices.get(i);

        args.putString(DeviceInfoFragment.COLUMN_TYPE, device.get_name());
        args.putString(DeviceInfoFragment.COLUMN_BRAND, device.get_brand());
        args.putInt(DeviceInfoFragment.COLUMN_CONSUMPTION, device.get_consumption());
        args.putByteArray(DeviceInfoFragment.COLUMN_BLOB, device.get_image());
        args.putInt(DeviceInfoFragment.COLUMN_HOURS, device.get_hours());
        args.putLong(DeviceInfoFragment.COLUMN_DATETIME, device.get_time());


        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return devices.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return devices.get(position).get_name();
    }
}
