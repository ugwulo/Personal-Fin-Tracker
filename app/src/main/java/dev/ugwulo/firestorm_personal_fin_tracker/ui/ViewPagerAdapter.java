package dev.ugwulo.firestorm_personal_fin_tracker.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private static int TAB_COUNT = 3;

    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 0;

    public ViewPagerAdapter(@NonNull FragmentManager  fm) {
//        super(fm);
//        super(@NonNull FragmentManager fm);
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return HomeFragment.getInstance();
            case 1:
                return HistoryFragment.getInstance();
            case 2:
                return ChartFragment.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return HomeFragment.TITLE;

            case 1:
                return HistoryFragment.TITLE;

            case 2:
                return ChartFragment.TITLE;
        }
        return super.getPageTitle(position);
    }
}