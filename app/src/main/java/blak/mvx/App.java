package blak.mvx;

import blak.mvx.model.GitHub;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

import android.app.Application;

public class App extends Application {
    private static App sInstance;

    private GitHub mApi;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        init();
    }

    public static App getInstance() {
        return sInstance;
    }

    public static GitHub getApi() {
        return sInstance.mApi;
    }

    private void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApi = retrofit.create(GitHub.class);
    }
}
