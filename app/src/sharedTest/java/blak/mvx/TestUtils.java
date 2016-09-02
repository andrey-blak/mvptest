package blak.mvx;

import blak.mvx.model.IModel;
import blak.mvx.model.dto.Repository;
import org.mockito.Mockito;
import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class TestUtils {
    public static void mockModel(IModel model, String matcher, Repository... repositories) {
        List<Repository> repositoriesList = Arrays.asList(repositories);
        Observable<List<Repository>> observable = Observable.just(repositoriesList);
        Mockito.when(model.getRepositories(matcher))
                .thenReturn(observable);
    }
}
