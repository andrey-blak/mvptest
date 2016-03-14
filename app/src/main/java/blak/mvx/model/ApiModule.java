package blak.mvx.model;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class ApiModule {
    private IModel model;

    @Provides
    @Singleton
    public IModel provideModel() {
        return new GithubModel();
    }
}
