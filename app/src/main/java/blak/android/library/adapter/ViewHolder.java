package blak.android.library.adapter;

import android.support.annotation.LayoutRes;
import android.view.View;

public interface ViewHolder<Item> {
    @LayoutRes
    int getLayoutResourceId();

    void init(View view);
    void bind(Item item);
}
