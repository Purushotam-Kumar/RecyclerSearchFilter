package com.example.recyclersearchfilter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private SearchAdapter searchAdapter;
    private EditText edtSearch;
    private List<SearchModel> searchModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        addDataToList();
        initViews();
    }

    private void addDataToList() {
        searchModelList = new ArrayList<>();
        searchModelList.add(new SearchModel(R.drawable.ic_launcher_background, "One", "Ten"));
        searchModelList.add(new SearchModel(R.drawable.ic_launcher_background, "Two", "Eleven"));
        searchModelList.add(new SearchModel(R.drawable.ic_launcher_background, "Three", "Twelve"));
        searchModelList.add(new SearchModel(R.drawable.ic_launcher_background, "Four", "Thirteen"));
        searchModelList.add(new SearchModel(R.drawable.ic_launcher_background, "Five", "Fourteen"));
        searchModelList.add(new SearchModel(R.drawable.ic_launcher_background, "Six", "Fifteen"));
        searchModelList.add(new SearchModel(R.drawable.ic_launcher_background, "Seven", "Sixteen"));
        searchModelList.add(new SearchModel(R.drawable.ic_launcher_background, "Eight", "Seventeen"));
        searchModelList.add(new SearchModel(R.drawable.ic_launcher_background, "Nine", "Eighteen"));
    }

    private void initViews() {
        edtSearch = findViewById(R.id.edt_search);
        RecyclerView recyclerView = findViewById(R.id.recycler_search);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        searchAdapter = new SearchAdapter(searchModelList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(searchAdapter);

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                searchAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                searchAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
