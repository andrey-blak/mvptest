package blak.mvx.model;

import blak.mvx.model.dto.Repository;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface GitHub {
    @GET("users/{user}/repos")
    Call<List<Repository>> getRepositories(@Path("user") String user);
}
