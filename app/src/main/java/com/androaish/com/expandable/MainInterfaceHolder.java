package com.androaish.com.expandable;

import android.content.Context;

import com.androaish.com.expandable.beans.Example;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by 1033826 on 11/10/2016.
 */

public class MainInterfaceHolder {

    public interface ViewToPresenter {
        public void setView(PresenterToView view);
        public void onDestroy(boolean isConfigChange);
        public List<Example> getData();

    }

    public interface PresenterToModel {
        public void onDestroy(boolean isConfigChange);
        public List<Example> getData();
    }

    public interface ModelToPresenter {
        public Context getAppContext();
        public Context getActivityContext();
        public void onResponseSuccess(List<Example> mainbean);
    }

    public interface PresenterToView {
        public Context getAppContext();
        public Context getActivityContext();
        public void onResponseSuccess(List<Example> mainbean);

    }

    public interface Service {
        @GET("android.json")
        Call<List<Example>> getCharity();
    }

}
