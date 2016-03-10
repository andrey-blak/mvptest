package blak.mvx.util;

import android.view.View;

public class ViewUtils {
    /**
     * Set {@link View#VISIBLE} visibility
     */
    public static void show(View view) {
        view.setVisibility(View.VISIBLE);
    }

    /**
     * Set {@link View#GONE} visibility
     */
    public static void hide(View view) {
        view.setVisibility(View.GONE);
    }

    /**
     * Set {@link View#VISIBLE} visibility if {@code show} is true, {@link View#GONE} otherwise
     * @see #hide(View, boolean)
     */
    public static void show(View view, boolean show) {
        int visibility = (show) ? View.VISIBLE : View.GONE;
        view.setVisibility(visibility);
    }

    /**
     * Set {@link View#GONE} visibility if {@code isHidden} is true, {@link View#VISIBLE} otherwise
     * @see #show(View, boolean)
     */
    public static void hide(View view, boolean isHidden) {
        show(view, !isHidden);
    }

    public static boolean isVisible(View view) {
        return view.getVisibility() == View.VISIBLE;
    }

    /**
     * Set {@link View#VISIBLE} visibility if {@code visible} is true, {@link View#INVISIBLE} otherwise
     * @see #setInvisible(View, boolean)
     */
    public static void setVisible(View view, boolean visible) {
        int visibility = (visible) ? View.VISIBLE : View.INVISIBLE;
        view.setVisibility(visibility);
    }

    /**
     * Set {@link View#INVISIBLE} visibility if {@code invisible} is true, {@link View#VISIBLE} otherwise
     * @see #setVisible(View, boolean)
     */
    public static void setInvisible(View view, boolean invisible) {
        setVisible(view, !invisible);
    }
}
