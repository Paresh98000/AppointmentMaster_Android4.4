package com.spksolutions.appointmentmaster.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.util.Log;

import java.io.File;

import com.spksolutions.appointmentmaster.DatabaseProvider;
import com.spksolutions.appointmentmaster.MainActivity;

public class Database {

    private static SQLiteDatabase data;


    public Database(String path, String backup) {

        Log.d(" Preference Path", path);

        if (path == null) {
            path = "/data/data/" + backup;
        }

        path = path + "/databases";
        File f = new File(path);
        if (!f.exists()) {
            if (f.mkdir()) {
                path = f.getAbsolutePath();
            }
        }
        path = path + "/database.db";
        try {
            data = SQLiteDatabase.openOrCreateDatabase(path, null);
            Log.d(" - Log Message: ", " Successfull");
            String createAppointment = "CREATE TABLE IF NOT EXISTS `appointment` (\n" +
                    "  `id` int(11) PRIMARY KEY ,\n" +
                    "  `clientid_id` int(11) ,\n" +
                    "  `serviceid_id` int(11) ,\n" +
                    "  `order_time` time(6) ,\n" +
                    "  `order_date` date ,\n" +
                    "  `description` varchar(288) ,\n" +
                    "  `status` varchar(10) ,\n" +
                    "  `payment_status` varchar(10) \n" +
                    ");\n";

            data.execSQL(createAppointment);

            String createCity =
                    "CREATE TABLE IF NOT EXISTS `city` (\n" +
                            "  `id` int(11) primary key,\n" +
                            "  `name` varchar(30) \n" +
                            ");\n";

            data.execSQL(createCity);

            String insertCity =
                    "INSERT INTO `city` (`id`, `name`) VALUES\n" +
                            "(1, 'Rajkot'),\n" +
                            "(2, 'Bhavnagar'),\n" +
                            "(3, 'Surat'),\n" +
                            "(4, 'Dwarka'),\n" +
                            "(5, 'Junagad'),\n" +
                            "(6, 'Vadodra');\n";

            data.execSQL(insertCity);

            String createClient =
                    "CREATE TABLE IF NOT EXISTS `client` (\n" +
                            "  `id` int(11) primary key,\n" +
                            "  `name` varchar(30)  ,\n" +
                            "  `gender` varchar(6)  ,\n" +
                            "  `password` varchar(30)  ,\n" +
                            "  `phone_no` varchar(10)  ,\n" +
                            "  `email` varchar(128)  ,\n" +
                            "  `city` varchar(20)  \n" +
                            ");\n";

            data.execSQL(createClient);

            String createOrders =
                    "CREATE TABLE IF NOT EXISTS `orders` (\n" +
                            "  `id` int(11) primary key,\n" +
                            "  `order_date` date ,\n" +
                            "  `order_time` time ,\n" +
                            "  `status` varchar(10) ,\n" +
                            "  `amount` double ,\n" +
                            "  `appointmentid_id` int(11) \n" +
                            ");\n";

            data.execSQL(createOrders);

            String createService =
                    "CREATE TABLE IF NOT EXISTS `service` (\n" +
                            "  `id` int(11) primary key,\n" +
                            "  `title` varchar(30)  ,\n" +
                            "  `providerid_id` int(11) ,\n" +
                            "  `city` varchar(15)  ,\n" +
                            "  `day` varchar(10)  ,\n" +
                            "  `location` varchar(30)  ,\n" +
                            "  `description` varchar(300)  ,\n" +
                            "  `time_start` time  ,\n" +
                            "  `time_end` time  ,\n" +
                            "  `status` varchar(10)  ,\n" +
                            "  `stype` varchar(10)  ,\n" +
                            "  `cost` double ,\n" +
                            "  `date_start` date ,\n" +
                            "  `phone_no` varchar(10)  ,\n" +
                            "  `image` varchar(30)  \n" +
                            ");\n";

            data.execSQL(createService);

            String createServiceType =
                    "CREATE TABLE IF NOT EXISTS `servicetype` (\n" +
                            "  `id` int(11) primary key,\n" +
                            "  `name` varchar(30)\n" +
                            ");\n";

            data.execSQL(createServiceType);

            String insertServiceTyoe =
                    "INSERT INTO `servicetype` (`id`, `name`) VALUES\n" +
                            "(1, 'Doctor'),\n" +
                            "(2, 'Business'),\n" +
                            "(3, 'Education'),\n" +
                            "(4, 'Transport'),\n" +
                            "(5, 'Celebrity'),\n" +
                            "(6, 'New Type');\n" +
                            "\n";

            data.execSQL(insertServiceTyoe);

            String createSP =
                    "CREATE TABLE IF NOT EXISTS `sp` (\n" +
                            "  `id` int(11) primary key,\n" +
                            "  `name` varchar(20)  ,\n" +
                            "  `email` varchar(128)  ,\n" +
                            "  `phone_no` varchar(10)  ,\n" +
                            "  `password` varchar(30)  ,\n" +
                            "  `city` varchar(20)  ,\n" +
                            "  `status` varchar(10)  \n" +
                            ");\n";

            data.execSQL(createSP);

            String createMessage =
                    "Create table if not EXISTS message\n" +
                            "(id int(11) primary key,\n" +
                            "aptid int(11),\n" +
                            "message varchar(32) ,\n" +
                            "message_time time ,\n" +
                            "message_date date ,\n" +
                            "type_of_msg varchar(6),\n" +
                            "FOREIGN KEY(aptid) REFERENCES appointment(id)\n" +
                            ");";

            data.execSQL(createMessage);

            String createSync =
                    "Create table if not EXISTS sync\n" +
                            "(id int(11) primary key,\n" +
                            "tbl varchar,\n" +
                            "col varchar,\n" +
                            "val varchar,\n" +
                            "md varchar(2)"+
                            ");";

            data.execSQL(createSync);

            //data.execSQL("commit;");

        } catch (Exception e) {

            Log.d(" - Log Message Error: ", e.toString());
        }
        Log.d(" - LogMessage: ", path);
    }

    public Cursor query(String query, String[] args) {
        return data.rawQuery(query, args);
    }

    public Uri insert(String table, ContentValues values) {

        long effect_rows = data.insert(table, null, values);
        if (effect_rows > 0) {
            return Uri.parse(DatabaseProvider.AUTHORITY + "/" + table + "/" + values.getAsString("id"));
        } else return null;
    }

    public int update(String table, ContentValues values, String whereClause, String[] args) {
        return data.update(table, values, whereClause, args);
    }

    public int delete(String table, String whereClause, String[] args) {
        return data.delete(table, whereClause, args);
    }
}
