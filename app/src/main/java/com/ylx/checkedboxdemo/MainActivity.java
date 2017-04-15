package com.ylx.checkedboxdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<DataHolder> dataList = new ArrayList<DataHolder>();
        for (int i = 0; i < 10; i++) {
            dataList.add(new DataHolder("harvicµÄblog------" + i, "harvic"));
        }
        ListitemAdapter adapter = new ListitemAdapter(MainActivity.this,
                dataList);
        final ListView listView = (ListView) findViewById(R.id.list);
        /**
         * 这里设置单选
         */
//        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        /**
         * 设置多选
         */
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        Button all_sel = (Button) findViewById(R.id.all_sel);
        Button all_unsel = (Button) findViewById(R.id.all_unsel);
        all_sel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                for (int i = 0; i < dataList.size(); i++) {
                    listView.setItemChecked(i, true);
                }
            }
        });

        // È«²¿È¡Ïû°´Å¥´¦Àí
        all_unsel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                for (int i = 0; i < dataList.size(); i++) {
                    listView.setItemChecked(i, false);
                }
            }
        });
    }
}
