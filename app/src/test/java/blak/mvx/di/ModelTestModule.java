package blak.mvx.di;

import blak.mvx.model.IModel;
import dagger.Module;
import dagger.Provides;
import org.mockito.Mockito;

import javax.inject.Singleton;

@Module
public class ModelTestModule {
    @Provides
    @Singleton
    public IModel provideModel() {
        return Mockito.mock(IModel.class);
    }
}
