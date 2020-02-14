package com.spksolutions.appointmentmaster.data;

import android.database.Cursor;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;

import androidx.annotation.NonNull;

public class OnlineData {

    FirebaseFirestore fireData;

    public OnlineData() {
        fireData = FirebaseFirestore.getInstance();

        HashMap<String, String> obj = new HashMap<>();
        obj.put("Hellow", "Paresh");
        obj.put("Hi", "Radhey");

        fireData.collection("Appointment").add(obj).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(" Log Message ", " Online Data id: " + documentReference.getId());
            }
        });

        fireData
                .collection("Appointment")
                .whereEqualTo("Hellow", "Paresh")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot snapshot: task.getResult()){
                                Log.d(" Log Message"," OnlineData "+snapshot.getData().toString());
                            }
                        }
                    }
                })
        ;


    }

    public void synchronize() {
        try (Cursor cursor = Database.getSyncData()) {
            assert cursor != null;
            if (cursor.moveToFirst()) {

                String table = cursor.getString(cursor.getColumnIndex("tbl"));
                String row_id = cursor.getString(cursor.getColumnIndex("tbl_r_id"));
                String col = cursor.getString(cursor.getColumnIndex("col"));
                String val = cursor.getString(cursor.getColumnIndex("val"));

            }
        } catch (Exception e) {
            Log.d(" Log Error", " Error in Onlinedata->synchronize");
        }
    }

    public void download(){

    }

}
