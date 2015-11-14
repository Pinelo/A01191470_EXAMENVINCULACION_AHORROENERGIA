package itesm.mx.a01191470_examenvinculacion_ahorroenergia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.widget.Toast;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by hugo on 11/10/15.
 */
public class DeviceOperations {
    private SQLiteDatabase db;
    private DBHandler dbhandler;

    private static final String DATABASE_NAME = "parcial2DB.db";
    private static final String TABLE_PRODUCT = "devices";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_BRAND = "brand";
    private static final String COLUMN_CONSUMPTION = "consumption";
    private static final String COLUMN_HOURS = "hours";
    private static final String COLUMN_PIC = "pictures";
    private static final String COLUMN_DATETIME = "datetime";

    public DeviceOperations(Context context) {
        dbhandler = DBHandler.getInstace(context);
    }

    public void addDevice(device device) {
        db = dbhandler.getWritableDatabase();
        try{
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, device.get_name());
            values.put(COLUMN_BRAND, device.get_brand());
            values.put(COLUMN_CONSUMPTION, device.get_consumption());
            values.put(COLUMN_HOURS, device.get_hours());
            values.put(COLUMN_PIC, device.get_image());
            values.put(COLUMN_DATETIME, device.get_time());

            db.insert(TABLE_PRODUCT, null, values);
            Log.d("tag", "Product added successfully");

        }catch (SQLiteException e) {
            Log.d("tag", "Error while trying to add product to database");
        }
    }

    public List<device> getAllDevices() {
        String query = "SELECT * FROM " + TABLE_PRODUCT + " WHERE 1";
        ArrayList<device> devices = new ArrayList<device>();

        device device = null;
        db = dbhandler.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        int i;
        while(cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            String brand = cursor.getString(cursor.getColumnIndex(COLUMN_BRAND));
            int consumption = cursor.getInt(cursor.getColumnIndex(COLUMN_CONSUMPTION));
            int hours = cursor.getInt(cursor.getColumnIndex(COLUMN_HOURS));
            long time = cursor.getLong(cursor.getColumnIndex(COLUMN_DATETIME));
            byte[] image = cursor.getBlob(cursor.getColumnIndex(COLUMN_PIC));

            device = new device(consumption, hours, time, name, brand, image);
            devices.add(device);
        }
        return devices;
    }

    public List<device> findDevicesByDate(int month, int day) {
        List<device> devices = getAllDevices();
        List<device> filterDevices = new ArrayList<>();
        int i;
        device device;

        long milliseconds;
        Date resultdate;

        Calendar calendar = Calendar.getInstance();


        for(i = 0; i < devices.size(); i++) {
            device = devices.get(i);
            milliseconds = device.get_time();
//            resultdate = new Date(milliseconds);
            calendar.setTimeInMillis(milliseconds);

            int month1 = calendar.get(Calendar.MONTH) + 1;
            int day1 = calendar.get(Calendar.DAY_OF_MONTH);

            if (month == month1 && day == day1) {
                filterDevices.add(device);
            }


        }
        return filterDevices;
    }
}
