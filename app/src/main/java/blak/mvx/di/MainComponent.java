package blak.mvx.di;

import blak.mvx.model.GithubApi;
import blak.mvx.model.IModel;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ApiModule.class, ModelModule.class})
public interface MainComponent {
    GithubApi getApi();
    IModel getModel();
}
