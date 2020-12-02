package dev.ugwulo.firestorm_personal_fin_tracker.baseClasses;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class BaseFragment extends Fragment {
    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }
}

