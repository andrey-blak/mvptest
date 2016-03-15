package blak.mvx.di;

import blak.mvx.model.GithubApi;
import dagger.Module;
import dagger.Provides;
import org.mockito.Mockito;

import javax.inject.Singleton;

@Module
public class ApiTestModule extends ApiModule {
    @Override
    @Provides
    @Singleton
    public GithubApi provideApi() {
        return Mockito.mock(GithubApi.class);
    }
}
