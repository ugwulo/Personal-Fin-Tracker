package dev.ugwulo.firestorm_personal_fin_tracker.baseClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class BaseActivity extends AppCompatActivity {
    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }
}

