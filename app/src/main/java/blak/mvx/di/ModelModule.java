package blak.mvx.di;

import blak.mvx.model.GithubModel;
import blak.mvx.model.IModel;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class ModelModule {
    @Singleton
    @Provides
    public IModel provideModel() {
        return new GithubModel();
    }
}
