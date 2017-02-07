package blak.mvx.di;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ApiTestModule.class, ModelTestModule.class, PresentersModule.class, RxTestModule.class})
public interface AndroidTestComponent extends MainComponent {
}
