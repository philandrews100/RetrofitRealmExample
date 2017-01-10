package com.retrofitrealm.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.retrofitrealm.R;
import com.retrofitrealm.database.Photo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Phil on 10/01/2017.
 */

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> {
    private List<Photo> mDataset;
    private Context photoContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivImage)
        ImageView ivImage;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public PhotosAdapter(List<Photo> myDataset, Context context) {
        mDataset = myDataset;
        photoContext = context;
    }

    @Override
    public PhotosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photo_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Photo photo = mDataset.get(position);
        Glide.with(photoContext)
                .load(photo.getUrls().getRegular())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.ic_error_load)
                .into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}