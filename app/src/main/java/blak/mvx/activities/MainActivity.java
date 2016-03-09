package blak.mvx.activities;

import blak.mvx.App;
import blak.mvx.R;
import blak.mvx.model.GitHub;
import blak.mvx.model.dto.Repository;
import retrofit2.Call;
import retrofit2.Response;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import java.io.IOException;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private static final String USER = "andrey-blak";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadRepositories();
    }

    private void loadRepositories() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                GitHub api = App.getApi();
                Call<List<Repository>> call = api.getRepositories(USER);
                try {
                    Response<List<Repository>> response = call.execute();
                    Log.v("@@@", "Repositories");
                    for (Repository repository : response.body()) {
                        Log.v("@@@", repository.fulName);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
