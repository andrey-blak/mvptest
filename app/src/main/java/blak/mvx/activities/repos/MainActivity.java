package blak.mvx.activities.repos;

import blak.mvx.R;
import blak.mvx.activities.repos.RepositoriesFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvx__activity_main);
        restoreState(savedInstanceState);
        if (savedInstanceState == null) {
            showFragment(createInitialFragment());
        }
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.mvx__main_container, fragment);
        ft.commit();
    }

    private void restoreState(@Nullable Bundle savedInstanceState) {
    }

    private Fragment createInitialFragment() {
        return RepositoriesFragment.newInstance();
    }
}
