package blak.mvx.view.repo;

import blak.mvx.BaseTest;
import blak.mvx.R;
import blak.mvx.activities.MainActivity;
import blak.mvx.model.IModel;
import blak.mvx.model.dto.Repository;
import blak.mvx.presenter.repo.IRepositoriesPresenter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.robolectric.Robolectric;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class RepositoriesFragmentTest extends BaseTest {
    private IModel model;
    private IRepositoriesPresenter presenter;
    private RepositoriesFragment fragment;
    private Bundle bundle;
    private MainActivity activity;

    @Override
    @Before
    public void setUp() {
        super.setUp();

        model = component.getModel();
        presenter = component.getRepositoriesPresenter();
        mockModel(model, Matchers.anyString(), new Repository(), new Repository());
        bundle = Bundle.EMPTY;

        activity = Robolectric.setupActivity(MainActivity.class);
        fragment = RepositoriesFragment.newInstance();
        fragment.onCreate(null);
    }

    @Test
    public void testOnDestroy() {
        fragment.onDestroyView();
        Mockito.verify(presenter).detachView();
    }

    @Test
    public void testOnStop() {
        fragment.onStop();
        Mockito.verify(presenter).onStop();
    }

    @Test
    public void testSaveState() {
        fragment.onSaveInstanceState(bundle);
        Mockito.verify(presenter).saveState(bundle);
    }

    @Test
    public void testRestoreNullState() {
        fragment.onCreateView(LayoutInflater.from(activity), (ViewGroup) activity.findViewById(R.id.mvx__main_container), null);
        Mockito.verify(presenter).restoreState(null);
    }

    @Test
    public void testRestoreState() {
        fragment.onCreateView(LayoutInflater.from(activity), (ViewGroup) activity.findViewById(R.id.mvx__main_container), bundle);
        Mockito.verify(presenter).restoreState(bundle);
    }
}
