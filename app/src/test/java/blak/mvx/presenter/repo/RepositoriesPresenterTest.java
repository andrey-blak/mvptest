package blak.mvx.presenter.repo;

import blak.mvx.BaseTest;
import blak.mvx.model.IModel;
import blak.mvx.model.dto.Repository;
import blak.mvx.view.repo.IRepositoriesView;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class RepositoriesPresenterTest extends BaseTest {
    @Test
    public void testLoadRepositories() throws Exception {
        IModel model = component.getModel();
        IRepositoriesView view = Mockito.mock(IRepositoriesView.class);

        Repository[] repositories = {new Repository(), new Repository()};
        List<Repository> repositoriesList = Arrays.asList(repositories);
        Observable<List<Repository>> observable = Observable.just(repositoriesList);

        Mockito.when(model.getRepositories(Mockito.anyString()))
            .thenReturn(observable);

        InOrder inOrder = Mockito.inOrder(model, view);

        IRepositoriesPresenter presenter = new RepositoriesPresenter();
        presenter.attachView(view);

        presenter.loadRepositories();

        inOrder.verify(view, Mockito.times(1)).onLoadingStarted();
        inOrder.verify(model, Mockito.times(1)).getRepositories(Mockito.anyString());
        inOrder.verify(view, Mockito.times(1)).onLoadingFinished();
        inOrder.verify(view, Mockito.times(1)).showRepositories(repositoriesList);
    }
}
