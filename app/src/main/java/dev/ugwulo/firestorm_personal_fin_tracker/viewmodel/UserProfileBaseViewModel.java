package dev.ugwulo.firestorm_personal_fin_tracker.viewmodel;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.FirebaseDatabase;

import dev.ugwulo.firestorm_personal_fin_tracker.firebase.FirebaseElement;
import dev.ugwulo.firestorm_personal_fin_tracker.firebase.FirebaseObserver;
import dev.ugwulo.firestorm_personal_fin_tracker.firebase.FirebaseQueryLiveDataElement;
import dev.ugwulo.firestorm_personal_fin_tracker.model.User;

public class UserProfileBaseViewModel extends ViewModel {
    private final FirebaseQueryLiveDataElement<User> liveData;

    public UserProfileBaseViewModel(String uid) {
        liveData = new FirebaseQueryLiveDataElement<>(User.class, FirebaseDatabase.getInstance().getReference()
                .child("users").child(uid));
    }

    public void observe(LifecycleOwner owner, final FirebaseObserver<FirebaseElement<User>> observer) {
        if(liveData.getValue() != null) observer.onChanged(liveData.getValue());
        liveData.observe(owner, new Observer<FirebaseElement<User>>() {
            @Override
            public void onChanged(@Nullable FirebaseElement<User> firebaseElement) {
                if(firebaseElement != null) observer.onChanged(firebaseElement);

            }
        });
    }

}
