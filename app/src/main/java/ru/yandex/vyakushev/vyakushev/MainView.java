package ru.yandex.vyakushev.vyakushev;

import java.util.List;

/**
 * Created by user on 09.08.16.
 */
interface MainView {
    void viewProgress();
    void hideProgress();
    void setListData(List<ListData> data);
}
