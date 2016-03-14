package blak.mvx.presenter.repo;

import blak.mvx.MainComponent;
import blak.mvx.App;
import blak.mvx.model.IModel;
import blak.mvx.model.dto.Repository;
import blak.mvx.view.repo.IRepositoriesView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import android.util.Log;

public class RepositoriesPresenter implements IRepositoriesPresenter {
    private static final String USER = "andrey-blak";

    private IRepositoriesView view;

    @Override
    public void attachView(IRepositoriesView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void loadRepositories() {
        view.onLoadingStarted();

        MainComponent component = App.getComponent();
        IModel model = component.getModel();
        model.getRepositories(USER)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace)
                .subscribe(repositories -> {
                    Log.v("@@@", "Repositories");
                    for (Repository repository : repositories) {
                        Log.v("@@@", repository.fulName);
                    }

                    view.onLoadingFinished();
                    view.showRepositories(repositories);
                });
    }
}
