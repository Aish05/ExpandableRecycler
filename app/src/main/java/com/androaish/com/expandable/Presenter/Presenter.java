package com.androaish.com.expandable.Presenter;

import android.content.Context;

import com.androaish.com.expandable.MainInterfaceHolder;
import com.androaish.com.expandable.Model.MainModel;
import com.androaish.com.expandable.beans.Example;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by 1033826 on 11/16/2016.
 */
public class Presenter implements MainInterfaceHolder.ViewToPresenter, MainInterfaceHolder.ModelToPresenter {

    MainInterfaceHolder.PresenterToModel mModel;
    private WeakReference<MainInterfaceHolder.PresenterToView> mView;

    public Presenter(MainInterfaceHolder.PresenterToView view) {

        this.mView=new WeakReference<MainInterfaceHolder.PresenterToView>(view);
        this.mModel=new MainModel(this);
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
        if(mainbean!=null){
            mView.get().onResponseSuccess(mainbean);
        }
    }

    @Override
    public void setView(MainInterfaceHolder.PresenterToView view) {
        this.mView=new WeakReference<MainInterfaceHolder.PresenterToView>(view);

    }

    @Override
    public void onDestroy(boolean isConfigChange) {
        if(!isConfigChange){
            mModel.onDestroy(isConfigChange);
        }
    }

    @Override
    public List<Example> getData() {
        return mModel.getData();

    }

    public void setModel(MainInterfaceHolder.PresenterToModel model) {
        mModel = model;
    }

}
