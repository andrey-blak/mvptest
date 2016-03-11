package blak.mvx.model;

import blak.mvx.model.dto.Repository;
import rx.Observable;

import java.util.List;

public interface IModel {
    Observable<List<Repository>> getRepositories(String user);
}
