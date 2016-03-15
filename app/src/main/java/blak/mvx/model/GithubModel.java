package blak.mvx.model;

import blak.mvx.App;
import blak.mvx.model.dto.Repository;
import rx.Observable;

import java.util.List;

public class GithubModel implements IModel {
    @Override
    public Observable<List<Repository>> getRepositories(String user) {
        return getApi().getRepositories(user);
    }

    private GithubApi getApi() {
        return App.getComponent().getApi();
    }
}
