package blak.mvx.activities.repos;

import blak.mvx.App;
import blak.mvx.R;
import blak.mvx.adapters.RepositoryAdapter;
import blak.mvx.model.GitHub;
import blak.mvx.model.dto.Repository;
import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Response;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

public class RepositoriesFragment extends Fragment {
    private static final String USER = "andrey-blak";

    @Bind(R.id.mvx__repositories_list)
    ListView mRepositoriesListView;

    private RepositoryAdapter mAdapter;

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
        mAdapter = new RepositoryAdapter();
        mRepositoriesListView.setAdapter(mAdapter);
    }

    private void loadRepositories() {
        AsyncTask<Void, Void, List<Repository>> task = new AsyncTask<Void, Void, List<Repository>>() {
            @Override
            protected List<Repository> doInBackground(Void... params) {
                GitHub api = App.getApi();
                Call<List<Repository>> call = api.getRepositories(USER);
                try {
                    Response<List<Repository>> response = call.execute();
                    List<Repository> repositories = response.body();
                    return repositories;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(List<Repository> repositories) {
                mAdapter.setItems(repositories);
                mAdapter.notifyDataSetChanged();

                Log.v("@@@", "Repositories");
                for (Repository repository : repositories) {
                    Log.v("@@@", repository.fulName);
                }
            }
        };
        task.execute();
    }
}
