package blak.mvx.view.repo;

import blak.mvx.model.dto.Repository;

import java.util.List;

public interface IRepositoriesView {
    void onLoadingStarted();
    void onLoadingFinished();
    void showRepositories(List<Repository> repositories);
    void showError(String message);
}
