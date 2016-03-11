package blak.java.library.util;

import android.support.annotation.Nullable;

import java.util.Collection;

public class CollectionUtils {
    public static <T> void addAll(@Nullable Collection<T> to, @Nullable Collection<T> from) {
        if ((to == null) || (from == null)) {
            return;
        }
        to.addAll(from);
    }
}
