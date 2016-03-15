package blak.mvx.model;

import blak.mvx.BaseTest;
import blak.mvx.model.dto.Repository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rx.Observable;
import rx.observers.TestSubscriber;

import java.util.Arrays;
import java.util.List;

public class GithubModelTest extends BaseTest {
    private static final String TEST_OWNER = "TEST_OWNER";

    GithubApi api;

    @Before
    public void setup() {
        api = component.getApi();
    }

    @Test
    public void testGetRepositories() {
        IModel model = new GithubModel();

        Repository[] repositories = new Repository[]{
                new Repository(),
                new Repository(),
                new Repository(),
        };

        Mockito.when(api.getRepositories(TEST_OWNER)).
                thenReturn(Observable.just(Arrays.asList(repositories)));

        TestSubscriber<List<Repository>> testSubscriber = new TestSubscriber<>();
        model.getRepositories(TEST_OWNER)
                .subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);

        List<Repository> actual = testSubscriber.getOnNextEvents().get(0);

        Mockito.verify(api).getRepositories(TEST_OWNER);
        Assert.assertEquals(3, actual.size());
    }
}
