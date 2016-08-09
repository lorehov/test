package ru.yandex.vyakushev.vyakushev;

import android.os.Handler;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by user on 09.08.16.
 */
public class MainPresenter {

    private WeakReference<MainView> mainViewRef;

    public MainPresenter(MainView mainView) {
        this.mainViewRef = new WeakReference<MainView>(mainView);
        loadData();
    }

    private void loadData() {
        MainView mainView = mainViewRef.get();
        if (mainView == null) {
            return;
        }

        mainView.viewProgress();

        OkHttpClient client = MainApp.getInstance().getClient();
        client.newCall(new Request.Builder().url(BuildConfig.API_URL).get().build())
            .enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    MainView mainView = mainViewRef.get();
                    if (mainView != null) {
                        mainView.viewError(e.getMessage());
                    }
                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    new Handler().post(new Runnable() {
                        @Override
                        public void run() {
                            ApiData data = new Gson().fromJson(response.body().charStream(), ApiData.class);
                            if (data == null || data.getBodies() == null) {
                                return;
                            }

                            List<ListData> result = new ArrayList<ListData>();
                            for (ApiData.Body body : data.getBodies()) {
                                if (body != null) {
                                    result.add(new ListData(body.getValue(), body.getTitle(), body.getAddValues()));
                                }
                            }


                            MainView mainView = mainViewRef.get();
                            if (mainView == null) {
                                return;
                            }

                            mainView.setListData(result);
                            mainView.hideProgress();
                        }
                    });
                }
            });
    }

}
