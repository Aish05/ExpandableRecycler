package com.androaish.com.expandable.View.View.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androaish.com.expandable.Model.MainListItem;
import com.androaish.com.expandable.R;
import com.androaish.com.expandable.adapter.ExpandableRecyclerAdapter;
import com.androaish.com.expandable.beans.ExampleMainListViewHolder;
import com.androaish.com.expandable.beans.Detail;
import com.androaish.com.expandable.beans.Example;
import com.androaish.com.expandable.beans.DetailsChildViewHolder;

import java.util.List;


public class MainAdapter extends ExpandableRecyclerAdapter<ExampleMainListViewHolder, DetailsChildViewHolder> {

    private LayoutInflater mInflator;

    public MainAdapter(Activity context, @NonNull List<? extends MainListItem> parentItemList) {
        super(parentItemList);
        mInflator = LayoutInflater.from(context);
    }


    @Override
    public ExampleMainListViewHolder onCreateMainViewHolder(ViewGroup parentViewGroup) {
        View vehicleView = mInflator.inflate(R.layout.row, parentViewGroup, false);
        return new ExampleMainListViewHolder(vehicleView);
    }

    @Override
    public DetailsChildViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View detailsView = mInflator.inflate(R.layout.child_layout, childViewGroup, false);
        return new DetailsChildViewHolder(detailsView);    }

    @Override
    public void onBindMainViewHolder(ExampleMainListViewHolder MainViewHolder, int position, MainListItem MainListItem) {
        Example vehicle = (Example) MainListItem;
        MainViewHolder.bind(vehicle);
    }

    @Override
    public void onBindChildViewHolder(DetailsChildViewHolder childViewHolder, int position, Object childListItem) {
        Detail vehicleFeature = (Detail) childListItem;
        childViewHolder.bind(vehicleFeature);
    }

}
