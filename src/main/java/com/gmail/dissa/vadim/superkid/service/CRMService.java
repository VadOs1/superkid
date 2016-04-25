package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.*;

import java.util.List;

public interface CRMService {

    public Client saveNewClient(String name, String email, String phone);

    public OrderStatus findDefaultOrderStatus();

    public Order saveOrder(String name, String email, String phone);

    public void saveSales(ShoppingCart shoppingCart, Order order);

    public String getAuthentificatedUserName();

    public List<Sales> getSalesByOrder(Order order);
}
