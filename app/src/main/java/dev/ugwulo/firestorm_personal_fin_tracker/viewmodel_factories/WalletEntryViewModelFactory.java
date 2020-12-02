package dev.ugwulo.firestorm_personal_fin_tracker.viewmodel_factories;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import dev.ugwulo.firestorm_personal_fin_tracker.viewmodel.WalletEntryBaseViewModel;

public class WalletEntryViewModelFactory implements ViewModelProvider.Factory {
    private final String entryId;
    private final String uid;

    private WalletEntryViewModelFactory(String uid, String entryId) {
        this.uid = uid;
        this.entryId = entryId;

    }
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new WalletEntryBaseViewModel(uid, entryId);
    }

    public static WalletEntryBaseViewModel getModel(String uid, String entryId, FragmentActivity activity) {
        return ViewModelProviders.of(activity, new WalletEntryViewModelFactory(uid, entryId)).get(WalletEntryBaseViewModel.class);
    }


}