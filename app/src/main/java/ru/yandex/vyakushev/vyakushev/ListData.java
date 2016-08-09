package ru.yandex.vyakushev.vyakushev;

import java.util.List;

/**
 * Created by user on 09.08.16.
 */
public class ListData {
    private String value;
    private String title;
    private List<String> addValues;

    public ListData(String value, String title, List<String> addValues) {
        this.value = value;
        this.title = title;
        this.addValues = addValues;
    }

    public String getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAddValues() {
        return addValues;
    }
}
