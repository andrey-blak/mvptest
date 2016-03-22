package blak.mvx.di;

import blak.mvx.Constants;
import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class RxModule {
    @Provides
    @Singleton
    @Named(Constants.SCHEDULER_UI)
    Scheduler provideSchedulerUi() {
        return AndroidSchedulers.mainThread();
    }


    @Provides
    @Singleton
    @Named(Constants.SCHEDULER_IO)
    Scheduler provideSchedulerIo() {
        return Schedulers.io();
    }
}
