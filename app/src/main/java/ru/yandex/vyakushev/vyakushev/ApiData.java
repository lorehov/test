package ru.yandex.vyakushev.vyakushev;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by user on 09.08.16.
 */
public class ApiData {

    private Page page;
    private ArrayList<Body> bodies;

    public Page getPage() {
        return page;
    }

    public ArrayList<Body> getBodies() {
        return bodies;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public void setBodies(ArrayList<Body> bodies) {
        this.bodies = bodies;
    }

    public static class Page {
        private String current;
        private String total;

        public String getCurrent() {
            return current;
        }

        public void setCurrent(String current) {
            this.current = current;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }
    }

    public static class Body {
        private String value;
        private String title;
        private String detail;
        @SerializedName("add_values") private ArrayList<String> addValues;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public ArrayList<String> getAddValues() {
            return addValues;
        }

        public void setAddValues(ArrayList<String> addValues) {
            this.addValues = addValues;
        }
    }
}
