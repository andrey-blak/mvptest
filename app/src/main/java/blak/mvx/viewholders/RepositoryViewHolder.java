package blak.mvx.viewholders;

import blak.mvx.adapter.ViewHolder;
import blak.mvx.model.dto.Repository;
import butterknife.Bind;
import butterknife.ButterKnife;

import android.view.View;
import android.widget.TextView;

public class RepositoryViewHolder implements ViewHolder<Repository> {
    @Bind(android.R.id.text1)
    TextView nameView;

    @Override
    public int getLayoutResourceId() {
        return android.R.layout.simple_list_item_1;
    }

    @Override
    public void init(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void bind(Repository repository) {
        nameView.setText(repository.fulName);
    }
}
