package blak.mvx.model;

import blak.mvx.model.dto.Repository;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

import java.util.List;

public interface GitHub {
    @GET("users/{user}/repos")
    Observable<List<Repository>> getRepositories(@Path("user") String user);
}
