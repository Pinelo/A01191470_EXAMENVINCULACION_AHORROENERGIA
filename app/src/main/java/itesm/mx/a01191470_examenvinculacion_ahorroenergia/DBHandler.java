package itesm.mx.a01191470_examenvinculacion_ahorroenergia;

import android.bluetooth.BluetoothClass;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by hugo on 11/10/15.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "parcial2DB.db";
    private static final String TABLE_PRODUCT = "devices";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_BRAND = "brand";
    private static final String COLUMN_CONSUMPTION = "consumption";
    private static final String COLUMN_HOURS = "hours";
    private static final String COLUMN_PIC = "pictures";
//    private static final String COLUMN_TIME = "time";
//    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_DATETIME = "datetime";


    ;
    private static DBHandler dbHandlerInstace;

    public static synchronized DBHandler getInstace(Context context) {
        if (dbHandlerInstace == null) {
            dbHandlerInstace = new DBHandler(context.getApplicationContext());
        }
        return dbHandlerInstace;
    }


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                                        TABLE_PRODUCT +
                                        "(" +
                                        COLUMN_ID + " INTEGER PRIMARY KEY, " +
                                        COLUMN_NAME + " TEXT, " +
                                        COLUMN_BRAND + " TEXT, " +
                                        COLUMN_CONSUMPTION + " INTEGER, " +
                                        COLUMN_HOURS + " INTEGER, " +
                                        COLUMN_PIC + " BLOB, " +
                                        COLUMN_DATETIME + " INTEGER " +
                                        ")";

        db.execSQL(CREATE_PRODUCTS_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
            Log.d("db", "updated database");
            onCreate(db);
        }

    }



}
