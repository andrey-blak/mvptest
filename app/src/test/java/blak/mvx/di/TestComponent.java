package blak.mvx.di;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ApiTestModule.class, ModelTestModule.class, RxTestModule.class, PresentersTestModule.class})
public interface TestComponent extends MainComponent {
}
