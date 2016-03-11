package blak.mvx.activities.repos;

import blak.mvx.App;
import blak.mvx.R;
import blak.mvx.adapters.RepositoryAdapter;
import blak.mvx.model.dto.Repository;
import blak.mvx.util.ViewUtils;
import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class RepositoriesFragment extends Fragment {
    private static final String USER = "andrey-blak";

    @Bind(R.id.mvx__repositories_list)
    ListView repositoriesListView;

    @Bind(R.id.mvx__repositories_progress)
    View progressView;

    private RepositoryAdapter adapter;

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
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        loadRepositories();
    }

    private void initGui() {
        adapter = new RepositoryAdapter();
        repositoriesListView.setAdapter(adapter);
    }

    private void showProgress() {
        ViewUtils.show(progressView);
    }

    private void hideProgress() {
        ViewUtils.hide(progressView);
    }

    private void loadRepositories() {
        showProgress();

        App.getApi().getRepositories(USER)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace)
                .subscribe(repositories -> {
                    hideProgress();
                    adapter.setItems(repositories);
                    adapter.notifyDataSetChanged();

                    Log.v("@@@", "Repositories");
                    for (Repository repository : repositories) {
                        Log.v("@@@", repository.fulName);
                    }
                });
    }
}
