package blak.mvx.view.repo;

import blak.android.library.adapter.HolderAdapter;
import blak.android.library.adapter.ViewHolder;
import blak.mvx.model.dto.Repository;

public class RepositoryAdapter extends HolderAdapter<Repository> {
    @Override
    protected ViewHolder<? extends Repository> createHolder(int position) {
        return new RepositoryViewHolder();
    }
}
