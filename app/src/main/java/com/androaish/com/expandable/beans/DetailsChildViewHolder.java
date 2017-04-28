package com.androaish.com.expandable.beans;

import android.view.View;
import android.widget.TextView;

import com.androaish.com.expandable.R;
import com.androaish.com.expandable.viewholder.ChildViewHolder;

/**
 * Created by 1033826 on 11/16/2016.
 */

public class DetailsChildViewHolder extends ChildViewHolder {
    /**
     * Default constructor.
     *
     * @param itemView The {@link View} being hosted in this ViewHolder
     */
    private TextView ApiLevelTextView;
    private TextView VersionTextView;

    public DetailsChildViewHolder(View itemView) {
        super(itemView);
        ApiLevelTextView = (TextView) itemView.findViewById(R.id.ApiLevelTextView);
        VersionTextView = (TextView) itemView.findViewById(R.id.VersionTextView);
    }
    public void bind(Detail vehicleFeature) {
        ApiLevelTextView.setText("API Level : "+vehicleFeature.getApilevel());
        VersionTextView.setText("Version Number :"+vehicleFeature.getVersion());
    }
}
