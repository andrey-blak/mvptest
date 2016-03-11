package blak.mvx.presenter;

public interface IPresenter<V> {
    void attachView(V view);
    void detachView();
}
