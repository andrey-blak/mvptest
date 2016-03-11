package blak.mvx.adapter;

import blak.mvx.util.AdapterUtils;
import blak.mvx.util.CollectionUtils;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class HolderAdapter<Item> extends BaseAdapter {
    private final List<Item> items;

    public HolderAdapter() {
        this(new ArrayList<Item>());
    }

    public HolderAdapter(List<Item> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setItems(@Nullable Collection<Item> items) {
        this.items.clear();
        CollectionUtils.addAll(this.items, items);
    }

    protected List<Item> getItems() {
        return items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder<Item> holder;
        if (convertView == null) {
            holder = (ViewHolder<Item>) createHolder(position);
            view = AdapterUtils.createView(holder, parent);
            holder.init(view);
        } else {
            view = convertView;
            holder = AdapterUtils.getViewHolder(view);
        }
        Item item = getItem(position);
        bindView(holder, item, position, view, parent);
        return view;
    }

    protected void bindView(ViewHolder<Item> holder, Item item, int position, View view, ViewGroup parent) {
        holder.bind(item);
    }

    protected abstract ViewHolder<? extends Item> createHolder(int position);
}
