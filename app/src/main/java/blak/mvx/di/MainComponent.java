package blak.mvx.di;

import blak.mvx.Constants;
import blak.mvx.model.GithubApi;
import blak.mvx.model.IModel;
import dagger.Component;
import rx.Scheduler;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Component(modules = {ApiModule.class, ModelModule.class, RxModule.class})
public interface MainComponent {
    GithubApi getApi();
    IModel getModel();

    @Named(Constants.SCHEDULER_UI)
    Scheduler getUiScheduler();

    @Named(Constants.SCHEDULER_IO)
    Scheduler getIoScheduler();
}
