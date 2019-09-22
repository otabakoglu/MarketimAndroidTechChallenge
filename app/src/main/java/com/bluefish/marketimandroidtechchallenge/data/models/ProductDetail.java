package com.bluefish.marketimandroidtechchallenge.data.models;

public class ProductDetail {

    private String summaryPrice;
    private String orderDetail;

    public String getSummaryPrice() {
        return summaryPrice;
    }

    public void setSummaryPrice(String summaryPrice) {
        this.summaryPrice = summaryPrice;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "summaryPrice='" + summaryPrice + '\'' +
                ", orderDetail='" + orderDetail + '\'' +
                '}';
    }
}
