package blak.mvx;

import blak.mvx.di.DaggerTestComponent;
import blak.mvx.di.MainComponent;

public class TestApp extends App {
    @Override
    protected MainComponent buildComponent() {
        return DaggerTestComponent.create();
    }
}
