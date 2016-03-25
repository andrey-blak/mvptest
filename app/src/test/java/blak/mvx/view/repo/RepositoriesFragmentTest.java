package blak.mvx.view.repo;

import blak.mvx.BaseTest;
import blak.mvx.model.IModel;
import blak.mvx.model.dto.Repository;
import blak.mvx.presenter.repo.IRepositoriesPresenter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

public class RepositoriesFragmentTest extends BaseTest {
    private IModel model;
    private IRepositoriesPresenter presenter;
    private RepositoriesFragment fragment;

    @Override
    @Before
    public void setUp() {
        super.setUp();

        model = component.getModel();
        presenter = component.getRepositoriesPresenter();
        mockModel(model, Matchers.anyString(), new Repository(), new Repository());

        fragment = RepositoriesFragment.newInstance();
        fragment.onCreate(null);
    }

    @Test
    public void testOnDestroy() {
        fragment.onDestroyView();
        Mockito.verify(presenter).detachView();
    }
}
