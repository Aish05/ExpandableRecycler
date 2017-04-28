package com.androaish.com.expandable.View.View.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androaish.com.expandable.MainInterfaceHolder;
import com.androaish.com.expandable.Model.MainModel;
import com.androaish.com.expandable.Presenter.Presenter;
import com.androaish.com.expandable.R;
import com.androaish.com.expandable.View.View.adapter.MainAdapter;
import com.androaish.com.expandable.beans.Example;
import com.androaish.com.expandable.commons.StateMaintainer;

import java.util.List;

/**
 * Created by Aishwarya on 11/15/2016.
 */
public class MainFragment extends Fragment implements MainInterfaceHolder.PresenterToView {

    private StateMaintainer stateMaintainer;
    private Presenter mPresenter;
    private Activity mContext;
    private RecyclerView rvCharity;
    private List<Example> charitymain;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment,container,false);
        setUpMVP();
        return view;
    }

    private void setUpMVP() {
        try{


            if(stateMaintainer.firstTimeIn()){
                Presenter presenter=new Presenter(this);
                MainModel model=new MainModel(presenter);
                presenter.setModel(model);
                stateMaintainer.put(presenter);
                stateMaintainer.put(model);
                mPresenter=presenter;
            }else {
                mPresenter = stateMaintainer.get(Presenter.class.getName());
                if (mPresenter != null) {
                    mPresenter.setView(this);

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stateMaintainer=new StateMaintainer(getFragmentManager(),MainFragment.class.getName());
        mContext = getActivity();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpView();
    }

    private void setUpView() {
        rvCharity = (RecyclerView) mContext. findViewById(R.id.recycler_view);
      //  rvCharity.addItemDecoration(new SimpleDividerItemDecoration(getContext()));

        mPresenter.getData();


    }

    @Override
    public Context getAppContext() {
        return null;
    }

    @Override
    public Context getActivityContext() {
        return null;
    }

    @Override
    public void onResponseSuccess(List<Example> mainbean) {
        this.charitymain = mainbean;
/*
        for (CharityMain event : charitymain) {
            ngoLists = event.getNgoList();
          }*/
        showNews();
    }


    private void showNews() {

            rvCharity.setAdapter(new MainAdapter(mContext,charitymain));
            LinearLayoutManager llmanager = new LinearLayoutManager(mContext);
            rvCharity.setLayoutManager(llmanager);

    }
}
