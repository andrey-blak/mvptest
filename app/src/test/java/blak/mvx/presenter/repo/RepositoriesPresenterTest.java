package blak.mvx.presenter.repo;

import blak.mvx.BaseTest;
import blak.mvx.TestUtils;
import blak.mvx.model.IModel;
import blak.mvx.model.dto.Repository;
import blak.mvx.view.repo.IRepositoriesView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Matchers;
import org.mockito.Mockito;
import rx.Observable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RepositoriesPresenterTest extends BaseTest {
    private static final String USER = "Test";

    private IModel model;
    private IRepositoriesView view;
    private IRepositoriesPresenter presenter;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        model = component.getModel();
        view = Mockito.mock(IRepositoriesView.class);

        presenter = new RepositoriesPresenter();
        presenter.attachView(view);
    }

    @Test
    public void testLoadRepositories() {
        Repository[] repositories = {new Repository(), new Repository()};
        List<Repository> repositoriesList = Arrays.asList(repositories);
        TestUtils.mockModel(model, Matchers.anyString(), repositories);

        InOrder inOrder = Mockito.inOrder(model, view);

        presenter.loadRepositories(USER);

        inOrder.verify(view, Mockito.times(1)).onLoadingStarted();
        inOrder.verify(model, Mockito.times(1)).getRepositories(Matchers.anyString());
        inOrder.verify(view, Mockito.times(1)).onLoadingFinished();
        inOrder.verify(view, Mockito.times(1)).showRepositories(repositoriesList);
    }

    @Test
    public void testOnError() {
        String message = "Error message";
        Mockito.doAnswer(invocation -> Observable.error(new Exception(message)))
                .when(model)
                .getRepositories(Matchers.anyString());

        InOrder inOrder = Mockito.inOrder(model, view);

        presenter.loadRepositories(USER);

        inOrder.verify(view, Mockito.times(1)).showError(message);
        inOrder.verify(view, Mockito.times(1)).onLoadingFinished();
        inOrder.verify(view, Mockito.times(1)).showRepositories(Collections.emptyList());
    }
}
