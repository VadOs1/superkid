package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.*;
import com.gmail.dissa.vadim.superkid.exception.SuperkidException;
import com.gmail.dissa.vadim.superkid.repository.ClientRepository;
import com.gmail.dissa.vadim.superkid.repository.OrderRepository;
import com.gmail.dissa.vadim.superkid.repository.OrderStatusRepository;
import com.gmail.dissa.vadim.superkid.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
// TODO: refactoring required
public class CRMServiceImpl implements CRMService {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final OrderStatusRepository orderStatusRepository;
    private final SalesRepository salesRepository;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public CRMServiceImpl(OrderRepository orderRepository,
                          ClientRepository clientRepository,
                          OrderStatusRepository orderStatusRepository,
                          SalesRepository salesRepository,
                          ShoppingCartService shoppingCartService) {
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
        return orderStatusRepository.findById(1L);
    }

    @Override
    public Order saveOrder(String name, String email, String phone) {
        if (name == null || email == null || phone == null ||
                shoppingCartService.getShoppingCart().getProducts().size() == 0) {
            throw new SuperkidException("Empty objects in checkout");
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
        shoppingCart.getProducts()
                .forEach((product) -> salesRepository.save(new Sales(order, product, (int) product.getPrice())));
    }

    @Override
    public List<Sales> getSalesByOrder(Order order) {
        return salesRepository.findByOrderId(order.getId());
    }
}
