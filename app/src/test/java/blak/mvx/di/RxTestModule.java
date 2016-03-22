package blak.mvx.di;

import blak.mvx.Constants;
import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class RxTestModule {
    @Provides
    @Singleton
    @Named(Constants.SCHEDULER_UI)
    Scheduler provideSchedulerUi() {
        return Schedulers.immediate();
    }


    @Provides
    @Singleton
    @Named(Constants.SCHEDULER_IO)
    Scheduler provideSchedulerIo() {
        return Schedulers.immediate();
    }
}
