package com.bluefish.marketimandroidtechchallenge.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bluefish.marketimandroidtechchallenge.data.models.Order;
import com.bluefish.marketimandroidtechchallenge.databinding.ItemOrderBinding;

import java.util.List;


public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {

    List<Order> orderList;

    public OrdersAdapter(List<Order> orderList){
        this.orderList = orderList;
    }


    @NonNull
    @Override
    public OrdersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemOrderBinding itemBinding = ItemOrderBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull final OrdersAdapter.ViewHolder holder, int position) {
        holder.binding.setExpanded(View.GONE);
        holder.bind(orderList.get(position), new OnClickOrder() {
            @Override
            public void onClickOrder() {
                holder.binding.setExpanded(holder.binding.getExpanded() == View.GONE ? View.VISIBLE : View.GONE );
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ItemOrderBinding binding;

        public ViewHolder(ItemOrderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void bind(Order order, OnClickOrder onClickOrder){
            binding.setVariable(com.bluefish.marketimandroidtechchallenge.BR.data, order);
            binding.setOnClick(onClickOrder);
            binding.executePendingBindings();

        }
    }
}
