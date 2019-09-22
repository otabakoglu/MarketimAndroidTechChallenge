package com.bluefish.marketimandroidtechchallenge.data.models;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bluefish.marketimandroidtechchallenge.utils.DateUtils;
import com.bluefish.marketimandroidtechchallenge.utils.ViewUtils;

public class Order {

    private String date;
    private String marketName;
    private String month;
    private String productState;
    private String productPrice;
    private String orderName;
    private ProductDetail productDetail;

    @BindingAdapter("monthText")
    public static void getMonthText(TextView textView, String text){
        textView.setText(DateUtils.getMonth(text));
    }

    @BindingAdapter("statusText")
    public static void getStatusText(TextView textView, String text){
        textView.setTextColor(ViewUtils.getStatusColor(text));
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date='" + date + '\'' +
                ", marketName='" + marketName + '\'' +
                ", month='" + month + '\'' +
                ", productState='" + productState + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", orderName='" + orderName + '\'' +
                ", productDetail=" + productDetail +
                '}';
    }
}
