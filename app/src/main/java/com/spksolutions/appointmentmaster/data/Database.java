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
                    "  `clientid_id` int(11) NOT NULL,\n" +
                    "  `serviceid_id` int(11) NOT NULL,\n" +
                    "  `time` time(6) NOT NULL,\n" +
                    "  `date` date NOT NULL,\n" +
                    "  `description` varchar(288) NOT NULL,\n" +
                    "  `status` varchar(10) NOT NULL,\n" +
                    "  `payment_status` varchar(10) NOT NULL\n" +
                    ");\n";

            data.execSQL(createAppointment);

            String createCity =
                    "CREATE TABLE IF NOT EXISTS `city` (\n" +
                            "  `id` int(11) ,\n" +
                            "  `name` varchar(30) NOT NULL\n" +
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
                            "  `id` int(11) NOT NULL Primary Key,\n" +
                            "  `name` varchar(30)  NOT NULL,\n" +
                            "  `gender` varchar(6)  NOT NULL,\n" +
                            "  `password` varchar(30)  NOT NULL,\n" +
                            "  `phone_no` varchar(10)  NOT NULL,\n" +
                            "  `email` varchar(128)  NOT NULL,\n" +
                            "  `city` varchar(20)  NOT NULL\n" +
                            ");\n";

            data.execSQL(createClient);

            String createOrders =
                    "CREATE TABLE IF NOT EXISTS `orders` (\n" +
                            "  `id` int(11) NOT NULL Primary Key,\n" +
                            "  `date_and_time` datetime(6) NOT NULL,\n" +
                            "  `status` varchar(10) NOT NULL,\n" +
                            "  `amount` double NOT NULL,\n" +
                            "  `appointmentid_id` int(11) NOT NULL\n" +
                            ");\n";

            data.execSQL(createOrders);

            String createService =
                    "CREATE TABLE IF NOT EXISTS `service` (\n" +
                            "  `id` int(11) NOT NULL Primary Key,\n" +
                            "  `title` varchar(30)  NOT NULL,\n" +
                            "  `providerid_id` int(11) NOT NULL,\n" +
                            "  `city` varchar(15)  NOT NULL,\n" +
                            "  `day` varchar(10)  NOT NULL,\n" +
                            "  `location` varchar(30)  NOT NULL,\n" +
                            "  `description` varchar(300)  NOT NULL,\n" +
                            "  `time_start_h` varchar(2)  NOT NULL,\n" +
                            "  `time_start_m` varchar(2)  NOT NULL,\n" +
                            "  `time_end_h` varchar(2)  NOT NULL,\n" +
                            "  `time_end_m` varchar(2)  NOT NULL,\n" +
                            "  `status` varchar(10)  NOT NULL,\n" +
                            "  `stype` varchar(10)  NOT NULL,\n" +
                            "  `cost` double NOT NULL,\n" +
                            "  `phone_no` varchar(10)  NOT NULL,\n" +
                            "  `image` varchar(30)  NOT NULL\n" +
                            ");\n";

            data.execSQL(createService);

            String createServiceType =
                    "CREATE TABLE IF NOT EXISTS `servicetype` (\n" +
                            "  `id` int(11) NOT NULL Primary Key,\n" +
                            "  `name` varchar(30) NOT NULL\n" +
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
                            "  `id` int(11) NOT NULL Primary Key,\n" +
                            "  `name` varchar(20)  NOT NULL,\n" +
                            "  `email` varchar(128)  NOT NULL,\n" +
                            "  `phone_no` varchar(10)  NOT NULL,\n" +
                            "  `password` varchar(30)  NOT NULL,\n" +
                            "  `city` varchar(20)  NOT NULL,\n" +
                            "  `status` varchar(10)  NOT NULL\n" +
                            ");\n";

            data.execSQL(createSP);

            String createMessage =
                    "Create table if not EXISTS message\n" +
                            "(id int(11) PRIMARY KEY,\n" +
                            "aptid int(11),\n" +
                            "message varchar(32) NOT NULL,\n" +
                            "type_of_msg varchar(6),\n" +
                            "FOREIGN KEY(aptid) REFERENCES appointment(id)\n" +
                            ");";

            data.execSQL(createMessage);

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
