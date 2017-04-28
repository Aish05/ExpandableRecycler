package com.androaish.com.expandable.Model;

import android.util.Log;

import com.androaish.com.expandable.beans.Example;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.androaish.com.expandable.MainInterfaceHolder;
import com.androaish.com.expandable.Presenter.Presenter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by 1033826 on 11/16/2016.
 */
public class MainModel implements MainInterfaceHolder.PresenterToModel {


    private List<Example> main = new ArrayList<Example>();

    private MainInterfaceHolder.ModelToPresenter mPresenter;


    public MainModel(Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onDestroy(boolean isConfigChange) {

    }

    @Override
    public List<Example> getData() {
        getCharity();
        return main;
    }

    private void getCharity() {
        OkHttpClient client = new OkHttpClient();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.interceptors().add(interceptor);
        client.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
//                        .header("Accept", "application/json")
//                        .header("Authorization", "auth-token")
                        .method(original.method(), original.body())
                        .build();
                Response response = chain.proceed(request);
                return response;
            }
        });

        //Retrofit object
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://myservice-a0824.firebaseio.com/")
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        MainInterfaceHolder.Service service = retrofit.create(MainInterfaceHolder.Service.class);
        Call<List<Example>> call = service.getCharity();
        call.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(retrofit.Response<List<Example>> response, Retrofit retrofit) {

                try {
                    if (response.isSuccess()) {


                           List<Example> mainData = response.body();
                            if (mainData.size() > 0) {

                                for (int i = 0; i < mainData.size(); i++) {
                                    Example maindata = mainData.get(i);
                                    main.add(maindata);
                                }

                                //selected_event = mainData.get(0).getCause();
                             mPresenter.onResponseSuccess(main);



                            } else

                        {
                            int statusCode = response.code();
                            ResponseBody errorBody = response.errorBody();
                            Log.d("Error occurred" + " Error ", response.message());
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable t) {

                try {
                    Log.d("Response fail" + " Error ",t.getMessage() );

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }


}
