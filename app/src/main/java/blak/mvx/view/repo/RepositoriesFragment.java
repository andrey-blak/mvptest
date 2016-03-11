package blak.mvx.view.repo;

import blak.android.library.util.ViewUtils;
import blak.mvx.R;
import blak.mvx.model.dto.Repository;
import blak.mvx.presenter.repo.IRepositoriesPresenter;
import blak.mvx.presenter.repo.RepositoriesPresenter;
import butterknife.Bind;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

public class RepositoriesFragment extends Fragment implements IRepositoriesView {
    @Bind(R.id.mvx__repositories_list)
    ListView repositoriesListView;

    @Bind(R.id.mvx__repositories_progress)
    View progressView;

    private RepositoryAdapter adapter;
    private IRepositoriesPresenter presenter;

    public static RepositoriesFragment newInstance() {
        Bundle args = new Bundle();
        RepositoriesFragment fragment = new RepositoriesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mvx__repositories, container, false);
        ButterKnife.bind(this, view);
        initGui();
        initPresenter();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.loadRepositories();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

    @Override
    public void onLoadingStarted() {
        ViewUtils.show(progressView);
    }

    @Override
    public void onLoadingFinished() {
        ViewUtils.hide(progressView);
    }

    @Override
    public void showRepositories(List<Repository> repositories) {
        adapter.setItems(repositories);
        adapter.notifyDataSetChanged();
    }

    private void initGui() {
        adapter = new RepositoryAdapter();
        repositoriesListView.setAdapter(adapter);
    }

    private void initPresenter() {
        presenter = new RepositoriesPresenter();
        presenter.attachView(this);
    }
}
