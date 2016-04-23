package com.kun.everythingcity.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.kun.everythingcity.Model.PlaceDetailInfo;
import com.kun.everythingcity.R;

import java.util.List;

/**
 * Created by Kun on 23,April,2016
 * Viegrid JSC, Hanoi.
 */
public class PlaceDetailAdapter extends RecyclerView.Adapter<PlaceDetailAdapter.PlaceDetailHolder> {

    private List<PlaceDetailInfo> lst;
    private Context context;

    public PlaceDetailAdapter(Context context, List<PlaceDetailInfo> lst) {
        this.context = context;
        this.lst = lst;
    }

    @Override
    public PlaceDetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_placetdetail_item, parent, false);
        return new PlaceDetailHolder(v);
    }

    @Override
    public void onBindViewHolder(PlaceDetailHolder holder, int position) {
        if (holder != null) {
            PlaceDetailInfo info = lst.get(position);
            holder.txtName.setText(info.getName());
            holder.txtAddress.setText(!info.getFormatted_address().equals("") ? info.getFormatted_address() : context.getString(R.string.noaddress));
            String r = info.getRating();
            float rf = 0f;
            if (r != null && !r.equals("")) {
                rf = Float.parseFloat(r);
            }
            if (rf != 0f) {
                holder.rbRating.setRating(rf);
                holder.txtNoRating.setVisibility(View.GONE);
                holder.rbRating.setVisibility(View.VISIBLE);
            } else {
                holder.rbRating.setVisibility(View.GONE);
                holder.txtNoRating.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return lst != null ? lst.size() : 0;
    }

    public class PlaceDetailHolder extends RecyclerView.ViewHolder {

        protected TextView txtName, txtAddress, txtNoRating;
        protected RatingBar rbRating;

        public PlaceDetailHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtAddress = (TextView) itemView.findViewById(R.id.txtAddress);
            txtNoRating = (TextView) itemView.findViewById(R.id.txtNoRating);
            rbRating = (RatingBar) itemView.findViewById(R.id.ratingbar);
        }
    }
}
