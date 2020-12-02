package dev.ugwulo.firestorm_personal_fin_tracker.firebase;

public interface FirebaseObserver<T> {
    void onChanged(T t);
}

