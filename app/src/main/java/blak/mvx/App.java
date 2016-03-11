package blak.mvx;

import blak.mvx.model.GitHub;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import android.app.Application;

public class App extends Application {
    private static App instance;

    private GitHub api;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
    }

    public static App getInstance() {
        return instance;
    }

    public static GitHub getApi() {
        return instance.api;
    }

    private void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(GitHub.class);
    }
}
