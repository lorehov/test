package ru.yandex.vyakushev.vyakushev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter presenter;
    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void viewProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setListData(List<ListData> data) {
        list.setAdapter(new MyAdapter(data));
    }

    @Override
    public void viewError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        private List<ListData> datas = new ArrayList<>();

        public MyAdapter(List<ListData> data) {
            this.datas = data;
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.api_body, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            if (datas.size() < position) {
                ListData item = datas.get(position);
                if (item == null) {
                    return;
                }
                StringBuilder builder = new StringBuilder();
                for (String addValue : item.getAddValues()) {
                    builder.append(addValue).append(",");
                }
                holder.init(item.getValue(), item.getTitle(), builder.toString());
            }
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView value;
            TextView title;
            TextView addValues;

            public ViewHolder(View v) {
                super(v);
            }

            public void init(String value, String title, String addValues) {
                this.value.setText(value);
                this.title.setText(title);
                this.addValues.setText(addValues);
            }
        }

    }
}
