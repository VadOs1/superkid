package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.*;
import com.gmail.dissa.vadim.superkid.exception.CheckoutException;
import com.gmail.dissa.vadim.superkid.repository.ClientRepository;
import com.gmail.dissa.vadim.superkid.repository.OrderRepository;
import com.gmail.dissa.vadim.superkid.repository.OrderStatusRepository;
import com.gmail.dissa.vadim.superkid.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CRMServiceImpl implements CRMService {

    private OrderRepository orderRepository;
    private ClientRepository clientRepository;
    private OrderStatusRepository orderStatusRepository;
    private SalesRepository salesRepository;
    private ShoppingCartService shoppingCartService;

    @Autowired
    public CRMServiceImpl(OrderRepository orderRepository,
                          ClientRepository clientRepository,
                          OrderStatusRepository orderStatusRepository,
                          SalesRepository salesRepository,
                          ShoppingCartService shoppingCartService){
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.orderStatusRepository = orderStatusRepository;
        this.salesRepository = salesRepository;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Client saveNewClient(String name, String email, String phone) {
        return clientRepository.save(new Client(name, email, phone));
    }

    @Override
    public OrderStatus findDefaultOrderStatus() {
        return orderStatusRepository.findOne((long) 1);
    }

    @Override
    public Order saveOrder(String name, String email, String phone) {
        if (name == null || email == null || phone == null ||
                shoppingCartService.getShoppingCart().getProducts().size() == 0) {
            throw new CheckoutException("Empty objects in checkout");
        }
        OrderStatus orderStatus = findDefaultOrderStatus();
        Client client = saveNewClient(name.trim(), email.trim(), phone.trim());
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart();
        Order order = new Order(new Date(), orderStatus, client, "No address provided", "No details provided", "No comments");
        orderRepository.save(order);
        saveSales(shoppingCart, order);
        order.setSalesList(getSalesByOrder(order));
        return order;
    }

    @Override
    public void saveSales(ShoppingCart shoppingCart, Order order) {
        shoppingCart.getProducts().stream().forEach((product) -> salesRepository.save(new Sales(order, product, (int) product.getPrice())));
    }

    @Override
    public String getAuthentificatedUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user.getUsername().toUpperCase();
    }

    @Override
    public List<Sales> getSalesByOrder(Order order) {
        return salesRepository.findByOrderId(order.getId());
    }
}
