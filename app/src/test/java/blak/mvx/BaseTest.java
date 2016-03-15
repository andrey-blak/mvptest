package blak.mvx;

import blak.mvx.di.TestComponent;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,
        application = TestApp.class,
        sdk = 21)
public abstract class BaseTest {
    protected TestComponent component;

    @Before
    public void setUp() {
        component = (TestComponent) App.getComponent();
    }
}
