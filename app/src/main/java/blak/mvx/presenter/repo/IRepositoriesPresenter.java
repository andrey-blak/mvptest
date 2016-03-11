package blak.mvx.presenter.repo;

import blak.mvx.presenter.IPresenter;
import blak.mvx.view.repo.IRepositoriesView;

public interface IRepositoriesPresenter extends IPresenter<IRepositoriesView> {
    void loadRepositories();
}
