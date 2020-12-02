package dev.ugwulo.firestorm_personal_fin_tracker.viewmodel;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.Query;

import dev.ugwulo.firestorm_personal_fin_tracker.firebase.FirebaseElement;
import dev.ugwulo.firestorm_personal_fin_tracker.firebase.FirebaseObserver;
import dev.ugwulo.firestorm_personal_fin_tracker.firebase.FirebaseQueryLiveDataSet;
import dev.ugwulo.firestorm_personal_fin_tracker.model.WalletEntry;

public class WalletEntriesBaseViewModel extends ViewModel {
    protected final FirebaseQueryLiveDataSet<WalletEntry> liveData;
    protected final String uid;

    public WalletEntriesBaseViewModel(String uid, Query query) {
        this.uid=uid;
        liveData = new FirebaseQueryLiveDataSet<>(WalletEntry.class, query);
    }

    public void observe(LifecycleOwner owner, final FirebaseObserver<FirebaseElement<ListDataSet<WalletEntry>>> observer) {
        observer.onChanged(liveData.getValue());
        liveData.observe(owner, new Observer<FirebaseElement<ListDataSet<WalletEntry>>>() {
            @Override
            public void onChanged(@Nullable FirebaseElement<ListDataSet<WalletEntry>> element) {
                if(element != null) observer.onChanged(element);
            }
        });
    }

    public void removeObserver(Observer<FirebaseElement<ListDataSet<WalletEntry>>> observer) {
        liveData.removeObserver(observer);
    }


}

