package blak.mvx.adapters;

import blak.mvx.adapter.HolderAdapter;
import blak.mvx.adapter.ViewHolder;
import blak.mvx.model.dto.Repository;
import blak.mvx.viewholders.RepositoryViewHolder;

public class RepositoryAdapter extends HolderAdapter<Repository> {
    @Override
    protected ViewHolder<? extends Repository> createHolder(int position) {
        return new RepositoryViewHolder();
    }
}
