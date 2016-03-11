package blak.mvx;

import blak.mvx.model.GithubModel;
import blak.mvx.model.IModel;

import android.app.Application;

public class App extends Application {
    private static App instance;

    private IModel model;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
    }

    public static App getInstance() {
        return instance;
    }

    public static IModel getModel() {
        return instance.model;
    }

    private void init() {
        model = new GithubModel();
    }
}
