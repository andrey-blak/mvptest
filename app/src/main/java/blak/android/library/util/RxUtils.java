package blak.android.library.util;

import blak.mvx.App;
import blak.mvx.di.MainComponent;
import blak.mvx.model.dto.Repository;
import rx.Observable;

import android.support.annotation.NonNull;

import java.util.List;

public class RxUtils {
    @NonNull
    public static Observable.Transformer<List<Repository>, List<Repository>> observableTransformer() {
        MainComponent component = App.getComponent();
        return observable -> observable.subscribeOn(component.getIoScheduler())
                .observeOn(component.getUiScheduler());
    }
}
