package spksolutions.appointmentmaster.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.provider.ContactsContract;
import android.util.Log;

import java.io.File;

public class Database {

    private SQLiteDatabase data;


    public Database(String path){
        try {
            data = SQLiteDatabase.openOrCreateDatabase(path+"/database", null);
            Log.d(" - Log Message: "," Successfull");
            data.rawQuery("Create table Appointment (Id int,ClientId int,ServiceId int,Date string,Time string);",null);
        }
        catch (Exception e){
            Log.d(" - Log Message Error: ",e.toString());
        }
        Log.d(" - LogMessage: ",path);
    }
}
