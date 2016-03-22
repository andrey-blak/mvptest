package blak.mvx.presenter.repo;

import blak.android.library.log.Log;
import blak.android.library.log.LoggerType;
import blak.android.library.util.RxUtils;
import blak.mvx.App;
import blak.mvx.di.MainComponent;
import blak.mvx.model.IModel;
import blak.mvx.model.dto.Repository;
import blak.mvx.view.repo.IRepositoriesView;

import java.util.Collections;

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
                .compose(RxUtils.observableTransformer())
                .doOnError(throwable -> view.showError(throwable.getMessage()))
                .onErrorReturn(throwable -> Collections.emptyList())
                .subscribe(repositories -> {
                    Log.logger(LoggerType.LOGCAT).trace("Repositories");

                    for (Repository repository : repositories) {
                        Log.logger(LoggerType.LOGCAT).trace("{}", repository.fulName);
                    }

                    view.onLoadingFinished();
                    view.showRepositories(repositories);
                });
    }
}
