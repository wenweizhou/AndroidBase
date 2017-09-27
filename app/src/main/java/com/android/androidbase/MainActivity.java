package com.android.androidbase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String[] stringList = {"常用控件","自定义控件","数据库","网络"};
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(mOnItemClickListener);
    }

    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this,"position: "+position,Toast.LENGTH_SHORT).show();
            switch (position){
                case 0:
                    break;
                case 1:
                    break;
            }
        }
    };

    private BaseAdapter mAdapter = new BaseAdapter(){
        private TextView mTextView;

        @Override
        public int getCount() {
            return stringList.length;
        }

        @Override
        public Object getItem(int position) {
            return stringList[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.main_activity_list_item, parent,false);
            mTextView = (TextView) convertView.findViewById(R.id.text_view);
            mTextView.setText((String)getItem(position));
            return convertView;
        }
    };
}
