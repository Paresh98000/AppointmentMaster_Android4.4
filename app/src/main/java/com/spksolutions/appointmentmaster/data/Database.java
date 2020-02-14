package com.spksolutions.appointmentmaster.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.util.Log;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.spksolutions.appointmentmaster.DatabaseProvider;
import com.spksolutions.appointmentmaster.MainActivity;

public class Database {

    private static SQLiteDatabase data;

    // if database file is deleted
    private boolean flag_data_lost;

    public Database(){

    }

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
                    "  `global_id` varchar UNIQUE ,\n" +
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
                            "  `global_id` varchar UNIQUE ,\n" +
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
                            "  `global_id` varchar UNIQUE ,\n" +
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
                            "  `global_id` varchar UNIQUE ,\n" +
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
                            "  `global_id` varchar UNIQUE ,\n" +
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
                            "  `global_id` varchar ,\n" +
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
                            "  `global_id` varchar UNIQUE ,\n" +
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
                            "`global_id` varchar UNIQUE ,\n" +
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
                            "(id int(11) PRIMARY KEY,\n" +
                            "tbl varchar,\n" +
                            "col varchar,\n" +
                            "val varchar,\n" +
                            "qry varchar,\n" +
                            "tbl_r_id varchar,\n" +
                            "md varchar(3)" +
                            ");";

            data.execSQL(createSync);

            //data.execSQL("commit;");

        } catch (Exception e) {
            Log.d("Database Message: ", e.toString());
        }
        Log.d(" - Database Message: ", path);
    }

    public Cursor query(String query, String[] args) {
        return data.rawQuery(query, args);
    }

    public Uri insert(String table, ContentValues values) {
        long effect_rows = data.insert(table, null, values);
        if (effect_rows > 0) {

            insert_to_sync(table,values,"insert","off");

            return Uri.parse(DatabaseProvider.AUTHORITY + "/" + table + "/" + values.getAsString("id"));

        } else return Uri.parse(" Database Error ");
    }

    private void insert_to_sync(String table,ContentValues values,String qry,String mode){
        long id;
        Cursor c = data.rawQuery("Select count(*) from " + table, null);
        if (c.moveToFirst()) {
            id = c.getInt(0);
            c.close();
            Set<String> keys = values.keySet();
            Iterator<String> it_k = keys.iterator();
            ContentValues val_sync = new ContentValues();

            do {
                String k_str = it_k.next();

                if(k_str.equals("id")) {
                    continue;
                }

                val_sync.put("id", id);
                id++;
                val_sync.put("tbl", table);
                val_sync.put("tbl_r_id", values.getAsString("id"));
                val_sync.put("col", k_str);
                val_sync.put("val", values.getAsString(k_str));
                val_sync.put("qry",qry);
                val_sync.put("md",mode);
                if(data.insert("sync", null, val_sync)>0){
                    Log.d(" Sync "+mode," table"+table+" "+val_sync.toString());
                }else{
                    Log.d(" Sync fail","Mode "+mode+" table "+table+" "+val_sync.toString());
                }
                val_sync.clear();
            } while (it_k.hasNext());

        } else {
            Log.d(" Sync data lost", " Database "+qry+" "+table+" "+values.toString());
        }
    }

    public int update(String table, ContentValues values, String whereClause, String[] args) {
        int updated = data.update(table, values, whereClause, args);
        if(updated>0) {
            insert_to_sync(table, values, "update", "off");
            return updated;
        }else
            return 0;
    }

    //perform deletion
    public int delete(String table, String whereClause, String[] args){
        int deleted = data.delete(table, whereClause, args);
        if(deleted>0){
            ContentValues vals = new ContentValues();
            for(int i=0;i<args.length;i++){
                vals.put("col","ids");
                vals.put("val",args[0]);
            }
            // args[0] = (1,2,3,4,5,6)
            insert_to_sync(table,vals,"delete","off");
            return deleted;
        }
        return 0;
    }

    static Cursor getSyncData(){
        if (data!=null)
        return data.rawQuery("Select * from Sync where Mode in(?,?) and qry = ?",new String[]{"On","on","insert"});
        else
            return null;
    }
}
