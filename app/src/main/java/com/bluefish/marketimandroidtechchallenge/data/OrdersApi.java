package com.bluefish.marketimandroidtechchallenge.data;

import com.bluefish.marketimandroidtechchallenge.data.models.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OrdersApi {

    @GET(".")
    Call<List<Order>> getOrderList();


}
