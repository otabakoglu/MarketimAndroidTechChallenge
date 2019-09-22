package com.bluefish.marketimandroidtechchallenge.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bluefish.marketimandroidtechchallenge.R;
import com.bluefish.marketimandroidtechchallenge.data.models.Order;
import com.bluefish.marketimandroidtechchallenge.ui.adapter.OrdersAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    private MainViewModel mainViewModel;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        recyclerView = findViewById(R.id.rv_order_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        mainViewModel.getOrderResponse().observe(this, new Observer<List<Order>>() {
            @Override
            public void onChanged(List<Order> orders) {
                Log.i("RESPONSE", orders.toString());

                recyclerView.setAdapter(new OrdersAdapter(orders));
            }
        });

        //burasının view modelde olması gerek zaman kalırsa bak
        ((Button)findViewById(R.id.btn_logout)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
                finish();
            }
        });

    }

    private void signOut(){
        SharedPreferences sp =  getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("rememberMe",false);
        editor.apply();
    }
}
