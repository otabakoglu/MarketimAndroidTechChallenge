package com.bluefish.marketimandroidtechchallenge.data;

import androidx.lifecycle.MutableLiveData;

import com.bluefish.marketimandroidtechchallenge.data.models.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private static Repository repository;
    private OrdersApi ordersApi;

    public Repository() {
        ordersApi = RetrofitService.cteateService(OrdersApi.class);
    }

    public static Repository getRepository() {
        if(repository == null) repository = new Repository();
        return repository;
    }

    //Login işlemi servis kısmı olmadıgı için api yazılmadı.
    public MutableLiveData<String> doLogin(String username, String password){
        final MutableLiveData<String> result = new MutableLiveData<>();

        if(username.equals("kariyer") && password.equals("2019ADev")){
            result.setValue("success");
        }else{
            result.setValue("fail");
        }
        return result;
    }

    public MutableLiveData<List<Order>> getOrders(){

        final MutableLiveData<List<Order>> data = new MutableLiveData<>();

        ordersApi.getOrderList().enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

}
