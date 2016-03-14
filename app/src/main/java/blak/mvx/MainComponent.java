package blak.mvx;

import blak.mvx.model.ApiModule;
import blak.mvx.model.IModel;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ApiModule.class})
public interface MainComponent {
    IModel getModel();
}
