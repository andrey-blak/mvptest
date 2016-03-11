package blak.mvx.model;

import blak.mvx.Config;
import blak.mvx.model.dto.Repository;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

import java.util.List;

public class GithubModel implements IModel {
    private GitHub api;

    public GithubModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(GitHub.class);
    }

    @Override
    public Observable<List<Repository>> getRepositories(String user) {
        return api.getRepositories(user);
    }
}
