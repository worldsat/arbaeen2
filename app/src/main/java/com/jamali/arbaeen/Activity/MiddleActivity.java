package com.jamali.arbaeen.Activity;

import android.os.Bundle;
import android.view.View;

import com.jamali.arbaeen.Adapter.MiddleListAdapter;
import com.jamali.arbaeen.Domain.MiddleList;
import com.jamali.arbaeen.Kernel.Activity.BaseActivity;
import com.jamali.arbaeen.Kernel.Controller.Interface.CallbackGet;
import com.jamali.arbaeen.R;

import java.util.ArrayList;
import java.util.Collection;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MiddleActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<MiddleList> response = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        initview();
        setVariable();
    }

    private void setVariable() {
        controller().Get(MiddleList.class, null, 0, 0, true, new CallbackGet() {
            @Override
            public <T> void onSuccess(ArrayList<T> result, int count) {

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MiddleActivity.this);
                recyclerView.setLayoutManager(linearLayoutManager);
                response.addAll((Collection<? extends MiddleList>) result);
                adapter = new MiddleListAdapter(response);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(String error) {

            }
        });

    }

    private void initview() {
        recyclerView = findViewById(R.id.view);
    }
}
