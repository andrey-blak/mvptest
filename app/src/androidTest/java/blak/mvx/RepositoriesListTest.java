package blak.mvx;

import blak.mvx.activities.MainActivity;
import blak.mvx.di.MainComponent;
import blak.mvx.model.IModel;
import blak.mvx.model.dto.Owner;
import blak.mvx.model.dto.Repository;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Matchers;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;

import java.util.Arrays;
import java.util.List;

@LargeTest
public class RepositoriesListTest {
    private static final String USERNAME = "test";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
    private MainComponent component;
    private IModel model;

    @Before
    public void setUp() {
        component = (MainComponent) App.getComponent();
        model = component.getModel();
    }

    @Test
    public void test() {
        Owner owner = new Owner(0, "user", "http://invalid.url");
        Repository repository1 = new Repository(1, "hello", "user/hello", owner, true, "Short description");
        Repository repository2 = new Repository(1, "goodbye", "user/goodbye", owner, true, "Description");
        Repository[] repositories = {repository1, repository2};
        List<Repository> repositoriesList = Arrays.asList(repositories);
        TestUtils.mockModel(model, Matchers.anyString(), repositories);

        Espresso.onView(ViewMatchers.withId(R.id.mvx__repositories_user_edit))
                .perform(ViewActions.typeTextIntoFocusedView(USERNAME));
        Espresso.onView(ViewMatchers.withId(R.id.mvx__repositories_load_button))
                .perform(ViewActions.click());

        Espresso.onData(CoreMatchers.anything())
                .inAdapterView(ViewMatchers.withId(R.id.mvx__repositories_list))
                .atPosition(0)
                .check(ViewAssertions.matches(ViewMatchers.hasDescendant(ViewMatchers.withText("user/hello"))));

        Espresso.onData(CoreMatchers.anything())
                .inAdapterView(ViewMatchers.withId(R.id.mvx__repositories_list))
                .atPosition(0)
                .check(ViewAssertions.matches(ViewMatchers.hasDescendant(ViewMatchers.withText("user/goodbye"))));
    }
}
