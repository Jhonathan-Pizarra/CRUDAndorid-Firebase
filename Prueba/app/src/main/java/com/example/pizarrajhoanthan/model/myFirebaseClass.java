package com.example.pizarrajhoanthan.model;

import com.google.firebase.database.FirebaseDatabase;

public class myFirebaseClass extends android.app.Application{

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
