package blak.mvx;

import blak.mvx.di.DaggerAndroidTestComponent;
import blak.mvx.di.MainComponent;

public class AndroidTestApp extends App {
    @Override
    protected MainComponent buildComponent() {
        return DaggerAndroidTestComponent.create();
    }
}
