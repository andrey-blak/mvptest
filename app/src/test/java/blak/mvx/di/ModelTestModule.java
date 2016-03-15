package blak.mvx.di;

import blak.mvx.model.IModel;
import dagger.Module;
import dagger.Provides;
import org.mockito.Mockito;

import javax.inject.Singleton;

@Module
public class ModelTestModule extends ModelModule {
    @Override
    @Singleton
    @Provides
    public IModel provideModel() {
        return Mockito.mock(IModel.class);
    }
}
