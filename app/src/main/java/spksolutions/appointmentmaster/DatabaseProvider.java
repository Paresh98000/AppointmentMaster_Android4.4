package spksolutions.appointmentmaster;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;

import java.nio.file.spi.FileSystemProvider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.CursorLoader;
import spksolutions.appointmentmaster.data.Database;

public class DatabaseProvider extends ContentProvider {

    public final static String AUTHORITY = "spksolutions.appointmentmaster.suggestionProvider";
    public final static String CONTENT_URI = AUTHORITY;
    public final static Uri URI = Uri.parse(AUTHORITY);

    //tables
    public final static String TABLE_APPOINTMENT = AUTHORITY+"/"+"APPOINTMENT";
    public final static String TABLE_CLIENT = AUTHORITY+"/"+"CLIENT";
    public final static String TABLE_ORDER = AUTHORITY+"/"+"ORDER";
    public final static String TABLE_SERVICE = AUTHORITY+"/"+"SERVICE";
    public final static String TABLE_SP = AUTHORITY+"/"+"SP";
    public final static String TABLE_CITY = AUTHORITY+"/"+"CITY";
    public final static String TABLE_SERVICE_TYPE = AUTHORITY+"/"+"SERVICE_TYPE";

    //columns of table appointment
    public final static String APPOINTMENT_ID = "id";
    public final static String APPOINTMENT_CLIENT_ID = "client_id";
    public final static String APPOINTMENT_SERVICE_ID = "service_id";
    public final static String APPOINTMENT_TIME = "time";
    public final static String APPOINTMENT_DATE = "date";
    public final static String APPOINTMENT_DESCRIPTION = "description";
    public final static String APPOINTMENT_STATUS = "status";
    public final static String APPOINTMENT_PAYMENT_STATUS = "payment_status";

    //columns of table city
    public final static String CITY_ID = "id";
    public final static String CITY_NAME = "name";

    //columns of table client
    public final static String CLIENT_ID = "id";
    public final static String CLIENT_NAME = "name";
    public final static String CLIENT_GENDER = "gender";
    public final static String CLIENT_PASSWORD = "password";
    public final static String CLIENT_PHONE_NO = "phone_no";
    public final static String CLIENT_EMAIL = "email";
    public final static String CLIENT_CITY = "city";

    //column of table order
    public static final String ORDER_ID = "id";
    public static final String ORDER_STATUS = "status";
    public static final String ORDER_AMOUNT = "amount";
    public static final String ORDER_APPOINTMENT_ID = "appointment_id";
    public static final String ORDER_DATE_AND_TIME = "date_and_time";

    //column of table service
    public static final String SERVICE_ID = "id";
    public static final String SERVICE_TITLE = "title";
    public static final String SERVICE_PROVIDER_ID = "providerid_id";
    public static final String SERIVICE_CITY = "city";
    public static final String SERVICE_DAY = "day";
    public static final String SERVICE_LOCATION = "location";
    public static final String SERVICE_DESCRIPTION = "description";
    public static final String SERVICE_TIME_START_H = "time_start_h";
    public static final String SERVICE_TIME_START_M = "time_start_m";
    public static final String SERVICE_TIME_END_H = "time_end_h";
    public static final String SERVICE_TIME_END_M = "time_END_m";
    public static final String SERVICE_STATUS = "status";
    public static final String SERVICE_STYPE = "stype";
    public static final String SERVICE_COST = "cost";
    public static final String SERVICE_PHONE = "phone_no";
    public static final String SERVICE_IMAGE = "image";

    // columns of table service type
    public final static String SERVICETYPE_ID = "id";
    public final static String SERVICETYPE_NAME = "name";

    //columns of table sp
    public static final String SP_ID = "id";
    public static final String SP_NAME = "name";
    public static final String SP_EMAIL = "email";
    public static final String SP_PHONE_NO = "phone_no";
    public static final String SP_PASSWORD = "password";
    public static final String SP_CITY = "city";
    public static final String SP_STATUS = "status";

    private Database database;


    // Creates a UriMatcher object.
    /*private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        *//*
         * The calls to addURI() go here, for all of the content URI patterns that the provider
         * should recognize. For this snippet, only the calls for table 3 are shown.
         *//*

        *//*
         * Sets the integer value for multiple rows in table 3 to 1. Notice that no wildcard is used
         * in the path
         *//*
        uriMatcher.addURI(AUTHORITY, TABLE_APPOINTMENT, 1);
        uriMatcher.addURI(AUTHORITY, TABLE_CLIENT, 1);
        uriMatcher.addURI(AUTHORITY, TABLE_SERVICE, 1);
        uriMatcher.addURI(AUTHORITY, TABLE_ORDER, 1);
        uriMatcher.addURI(AUTHORITY, TABLE_CITY, 1);
        uriMatcher.addURI(AUTHORITY, TABLE_SERVICE_TYPE, 1);
        uriMatcher.addURI(AUTHORITY, TABLE_SP, 1);
        *//*
         * Sets the code for a single row to 2. In this case, the "#" wildcard is
         * used. "content://com.example.app.provider/table3/3" matches, but
         * "content://com.example.app.provider/table3 doesn't.
         *//*
        uriMatcher.addURI(AUTHORITY, TABLE_APPOINTMENT + "/#", 2);
        uriMatcher.addURI(AUTHORITY, TABLE_CLIENT + "/#", 2);
        uriMatcher.addURI(AUTHORITY, TABLE_SERVICE + "/#", 2);
        uriMatcher.addURI(AUTHORITY, TABLE_ORDER + "/#", 2);
        uriMatcher.addURI(AUTHORITY, TABLE_CITY + "/#", 2);
        uriMatcher.addURI(AUTHORITY, TABLE_SERVICE_TYPE + "/#", 2);
        uriMatcher.addURI(AUTHORITY, TABLE_SP + "/#", 2);
    }*/

    public DatabaseProvider(){
        database = new Database();
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        /*
         * Choose the table to query and a sort order based on the code returned for the incoming
         * URI. Here, too, only the statements for table 3 are shown.
         */
//        Log.d(" - Log Message","Last Segment : "+uri.getLastPathSegment());
//        Log.d(" - Log Message","Last Path : "+uri.getPathSegments().get(1));
        /*switch (uriMatcher.match(uri)) {


            // If the incoming URI was for all of table3
            case 1:

                if (TextUtils.isEmpty(sortOrder)) sortOrder = "_ID ASC";
                break;

            // If the incoming URI was for a single row
            case 2:

                *//*
                 * Because this URI was for a single row, the _ID value part is
                 * present. Get the last path segment from the URI; this is the _ID value.
                 * Then, append the value to the WHERE clause for the query
                 *//*
                selection = selection + "_ID = " + uri.getLastPathSegment();
                Log.d(" - Log Message ",selection);
                break;

            default:

                // If the URI is not recognized, you should do some error handling here.
        }*/



        // call the code to actually do the query


        String table = uri.getPathSegments().get(1);
        String extra_query = "";
        try {
            String index = uri.getPathSegments().get(2);
            extra_query = "where Id = "+index;
        }catch(Exception e){
            Log.d(" - Log Error",e.toString());
            return database.query("Select 'Error message: ?';",new String[]{e.toString()});
        }

        Cursor c = database.query("Select * from ? ?;",new String[]{table,extra_query});

        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
