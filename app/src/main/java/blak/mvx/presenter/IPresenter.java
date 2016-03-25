package blak.mvx.presenter;

import android.os.Bundle;

public interface IPresenter<V> {
    void attachView(V view);
    void detachView();

    void onStart();
    void onStop();

    void saveState(Bundle bundle);
    void restoreState(Bundle bundle);
}
