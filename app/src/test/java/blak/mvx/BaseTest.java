package blak.mvx;

import blak.mvx.di.TestComponent;
import blak.mvx.model.IModel;
import blak.mvx.model.dto.Repository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import rx.Observable;

import android.support.annotation.CallSuper;

import java.util.Arrays;
import java.util.List;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,
        application = TestApp.class,
        sdk = 21)
public abstract class BaseTest {
    protected TestComponent component;

    @CallSuper
    @Before
    public void setUp() {
        component = (TestComponent) App.getComponent();
    }

    public static void mockModel(IModel model, String matcher, Repository... repositories) {
        List<Repository> repositoriesList = Arrays.asList(repositories);
        Observable<List<Repository>> observable = Observable.just(repositoriesList);
        Mockito.when(model.getRepositories(matcher))
                .thenReturn(observable);
    }
}
