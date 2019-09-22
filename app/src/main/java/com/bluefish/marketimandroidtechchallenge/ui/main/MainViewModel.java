package com.bluefish.marketimandroidtechchallenge.ui.main;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.bluefish.marketimandroidtechchallenge.data.Repository;
import com.bluefish.marketimandroidtechchallenge.data.models.Order;

import java.util.List;

public class MainViewModel extends ViewModel {

    public LiveData<List<Order>> getOrderResponse(){
        return Repository.getRepository().getOrders();
    }


}
