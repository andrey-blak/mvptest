package blak.mvx;

import blak.mvx.activities.InputActivity;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;

@LargeTest
public class ChangeTextTest {
    private static final String TEXT = "TEXT";

    @Rule
    public ActivityTestRule<InputActivity> mActivityRule = new ActivityTestRule<>(InputActivity.class);

    @Test
    public void changeTextTest() {
        onView(withId(R.id.mvx__input_edit))
                .perform(typeText(TEXT), closeSoftKeyboard());
        onView(withId(R.id.mvx__input_send))
                .perform(click());
        onView(withId(R.id.mvx__input_label))
                .check(matches(withText(TEXT)));
    }
}
