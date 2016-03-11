package blak.android.library.adapter;

import blak.mvx.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AdapterUtils {
    public static View createView(ViewHolder holder, ViewGroup parent) {
        int resourceId = holder.getLayoutResourceId();
        View view = inflate(parent.getContext(), resourceId, parent);
        view.setTag(R.id.holder, holder);
        return view;
    }

    public static <T extends ViewHolder> T getViewHolder(View view) {
        return (T) view.getTag(R.id.holder);
    }

    private static View inflate(Context context, int resource, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource, parent, false);
        return view;
    }
}
