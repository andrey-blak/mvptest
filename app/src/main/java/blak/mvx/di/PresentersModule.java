package blak.mvx.di;

import blak.mvx.presenter.repo.IRepositoriesPresenter;
import blak.mvx.presenter.repo.RepositoriesPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class PresentersModule {
    @Provides
    IRepositoriesPresenter provideRepositoriesPresenter() {
        return new RepositoriesPresenter();
    }
}
