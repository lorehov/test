package ru.yandex.vyakushev.vyakushev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void viewProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setListData(List<ListData> data) {

    }
}
