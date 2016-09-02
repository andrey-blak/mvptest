package blak.mvx.di;

import blak.mvx.presenter.repo.IRepositoriesPresenter;
import dagger.Module;
import dagger.Provides;
import org.mockito.Mockito;

import javax.inject.Singleton;

@Module
public class PresentersTestModule {
    @Singleton
    @Provides
    IRepositoriesPresenter provideRepositoriesPresenter() {
        return Mockito.mock(IRepositoriesPresenter.class);
    }
}
