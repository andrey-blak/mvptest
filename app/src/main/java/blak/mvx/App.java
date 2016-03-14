package blak.mvx;

import android.app.Application;

public class App extends Application {
    private static App instance;

    private MainComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
    }

    public static App getInstance() {
        return instance;
    }

    public static MainComponent getComponent() {
        return instance.component;
    }

    private void init() {
        component = DaggerMainComponent.create();
    }
}
