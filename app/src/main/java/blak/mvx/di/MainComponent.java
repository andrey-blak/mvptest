package blak.mvx.di;

import blak.mvx.Constants;
import blak.mvx.model.GithubApi;
import blak.mvx.model.IModel;
import blak.mvx.presenter.repo.IRepositoriesPresenter;
import dagger.Component;
import rx.Scheduler;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Component(modules = {ApiModule.class, ModelModule.class, RxModule.class, PresentersModule.class})
public interface MainComponent {
    GithubApi getApi();
    IModel getModel();

    IRepositoriesPresenter getRepositoriesPresenter();

    @Named(Constants.SCHEDULER_UI)
    Scheduler getUiScheduler();

    @Named(Constants.SCHEDULER_IO)
    Scheduler getIoScheduler();
}
