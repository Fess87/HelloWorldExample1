package com.example.example612;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences TxtSharedPref;
    private static String LARGE_TEXT = "large_text";
    private List<Map<String, String>> contentList;
    private BaseAdapter listContentAdapter;
    private SwipeRefreshLayout swipeLayout;
    private ArrayList<Integer> indexDelItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        saveInSharedPreferences();
        initList();
        initSwipeToRefresh();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList("key", indexDelItems);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<Integer> delItems = savedInstanceState.getIntegerArrayList("key");
        for (Integer val: delItems) {
            contentList.remove(val.intValue());
        }
    }

    @NonNull
    private SimpleAdapter createAdapter(String[] stringsTxt) {
        contentList = new ArrayList<>();
        prepareAdapterContent(stringsTxt);
        return new SimpleAdapter(this, contentList, R.layout.list_with_heading, new String[]{"text","length"}, new int[]{R.id.textViewWithTxt, R.id.textViewWithNumberOfChars});
    }

    @NonNull
    private List<Map<String, String>> prepareAdapterContent(String[] stringsTxt) {
        Map<String, String> mapForList;
        for (String value: stringsTxt) {
            mapForList = new HashMap<>();
            mapForList.put("text",value);
            mapForList.put("length",Integer.toString(value.length()));
            contentList.add(mapForList);
        };
        return contentList;
    }

    private String[] prepareCotent(){
        String[] arrayContent = TxtSharedPref.getString(LARGE_TEXT, "").split("\n\n");
        return arrayContent;
    }

    private void initList() {
        ListView list = findViewById(R.id.list);
        listContentAdapter = createAdapter(prepareCotent());
        list.setAdapter(listContentAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contentList.remove(position);
                indexDelItems.add(position);
                listContentAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initSwipeToRefresh (){
        swipeLayout = findViewById(R.id.swiperefresh);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                indexDelItems = new ArrayList<>();
                updateList();
                swipeLayout.setRefreshing(false);
            }
        });
    }

    private void updateList(){
        contentList.clear();
        prepareAdapterContent(prepareCotent());
        listContentAdapter.notifyDataSetChanged();
    }

    private void saveInSharedPreferences(){
        TxtSharedPref = getSharedPreferences("LargeTxt", MODE_PRIVATE);
        if (!TxtSharedPref.getString(LARGE_TEXT, "").equals(getString(R.string.large_text))){
            SharedPreferences.Editor myEditor = TxtSharedPref.edit();
            String LargeTxt = getString(R.string.large_text);
            myEditor.putString(LARGE_TEXT, LargeTxt);
            myEditor.apply();
        }
    }
}