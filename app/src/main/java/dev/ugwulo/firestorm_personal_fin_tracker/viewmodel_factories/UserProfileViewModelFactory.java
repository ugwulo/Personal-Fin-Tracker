package dev.ugwulo.firestorm_personal_fin_tracker.viewmodel_factories;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.google.firebase.database.FirebaseDatabase;

import dev.ugwulo.firestorm_personal_fin_tracker.model.User;
import dev.ugwulo.firestorm_personal_fin_tracker.viewmodel.UserProfileBaseViewModel;

public class UserProfileViewModelFactory implements ViewModelProvider.Factory {
    private String uid;

    private UserProfileViewModelFactory(String uid) {
        this.uid = uid;

    }

    public static void saveModel(String uid, User user) {
        FirebaseDatabase.getInstance().getReference()
                .child("users").child(uid).setValue(user);
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new UserProfileBaseViewModel(uid);
    }

    public static UserProfileBaseViewModel getModel(String uid, FragmentActivity activity) {
        return ViewModelProviders.of(activity, new UserProfileViewModelFactory(uid)).get(UserProfileBaseViewModel.class);
    }



}
