package com.omrobbie.cataloguemovieuiux.feature.now_playing;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.omrobbie.cataloguemovieuiux.BuildConfig;
import com.omrobbie.cataloguemovieuiux.R;
import com.omrobbie.cataloguemovieuiux.model.now_playing.ResultsItem;
import com.omrobbie.cataloguemovieuiux.util.DateTime;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by omrobbie on 09/10/2017.
 */

class NowPlayingViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img_poster)
    ImageView img_poster;

    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.tv_overview)
    TextView tv_overview;

    @BindView(R.id.tv_release_date)
    TextView tv_release_date;

    @BindView(R.id.btn_detail)
    Button btn_detail;

    @BindView(R.id.btn_share)
    Button btn_share;

    public NowPlayingViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(ResultsItem item) {
        tv_title.setText(item.getTitle());
        tv_overview.setText(item.getOverview());
        tv_release_date.setText(DateTime.getLongDate(item.getReleaseDate()));
        Glide.with(itemView.getContext())
                .load(BuildConfig.BASE_URL_IMG + "w154" + item.getPosterPath())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.placeholder)
                        .centerCrop()
                )
                .into(img_poster);

        btn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Button Detail Clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Button Share Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
