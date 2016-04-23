package com.kun.everythingcity.Adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kun.everythingcity.Model.PlaceTypeInfo;
import com.kun.everythingcity.R;

import java.util.List;

/**
 * Created by Kun on 23,April,2016
 * Viegrid JSC, Hanoi.
 */
public class PlaceTypeAdapter extends RecyclerView.Adapter<PlaceTypeAdapter.PlaceTypeHolder> {

    private List<PlaceTypeInfo> lst;
    private Context context;

    public PlaceTypeAdapter(Context context, List<PlaceTypeInfo> lst) {
        this.context = context;
        this.lst = lst;
    }

    @Override
    public PlaceTypeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_placetype_item, parent, false);
        return new PlaceTypeHolder(v);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(PlaceTypeHolder holder, int position) {
        if (holder != null) {
            PlaceTypeInfo info = lst.get(position);
            try {
                holder.img.setImageResource(info.getImg());
            } catch (Exception e) {
            }
            holder.txtName.setText(info.getName());
        }
    }

    @Override
    public int getItemCount() {
        return lst != null ? lst.size() : 0;
    }

    public class PlaceTypeHolder extends RecyclerView.ViewHolder {
        protected ImageView img;
        protected TextView txtName;

        public PlaceTypeHolder(View item) {
            super(item);
            img = (ImageView) item.findViewById(R.id.img);
            txtName = (TextView) item.findViewById(R.id.txtName);
        }
    }
}
