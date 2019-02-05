package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.*;

import java.util.List;

public interface CRMService {

    Client saveNewClient(String name, String email, String phone);

    OrderStatus findDefaultOrderStatus();

    Order saveOrder(String name, String email, String phone);

    void saveSales(ShoppingCart shoppingCart, Order order);

    String getAuthenticatedUserName();

    List<Sales> getSalesByOrder(Order order);
}
