package com.spksolutions.appointmentmaster.data;

import com.google.firebase.firestore.FirebaseFirestore;

public class OnlineData {

    FirebaseFirestore fireData;

    public OnlineData(){
        fireData = FirebaseFirestore.getInstance();

    }

}
