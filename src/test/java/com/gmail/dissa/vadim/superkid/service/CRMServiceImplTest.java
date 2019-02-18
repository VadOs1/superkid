package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.*;
import com.gmail.dissa.vadim.superkid.repository.ClientRepository;
import com.gmail.dissa.vadim.superkid.repository.OrderRepository;
import com.gmail.dissa.vadim.superkid.repository.OrderStatusRepository;
import com.gmail.dissa.vadim.superkid.repository.SalesRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class CRMServiceImplTest {

    private CRMService crmService;
    private OrderRepository orderRepository;
    private ClientRepository clientRepository;
    private OrderStatusRepository orderStatusRepository;
    private SalesRepository salesRepository;
    private ShoppingCart shoppingCart;
    private ShoppingCartService shoppingCartService;
    private Client client;
    private OrderStatus orderStatus;
    private Order order;

    @Before
    public void setUp() {
        orderRepository = mock(OrderRepository.class);
        clientRepository = mock(ClientRepository.class);
        orderStatusRepository = mock(OrderStatusRepository.class);
        salesRepository = mock(SalesRepository.class);
        shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(mock(Product.class));
        shoppingCartService = new ShoppingCartServiceImpl(shoppingCart);
        crmService = new CRMServiceImpl(orderRepository,
                clientRepository,
                orderStatusRepository,
                salesRepository,
                shoppingCartService);
        client = new Client("name", "email", "phone");
        orderStatus = new OrderStatus();
        order = new Order();

        when(clientRepository.save(any(Client.class))).thenReturn(client);
        when(orderStatusRepository.findById(1L)).thenReturn(orderStatus);
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        when(salesRepository.save(any(Sales.class))).thenReturn(mock(Sales.class));
        when(salesRepository.findByOrderId(order.getId())).thenReturn(new ArrayList<Sales>());

    }

    @Test
    public void testSaveNewClient() {
        Client clientExpected = crmService.saveNewClient("name", "email", "phone");
        assertEquals(clientExpected, client);
        verify(clientRepository, times(1)).save(any(Client.class));
    }

    @Test
    public void testFindDefaultOrderStatus() {
        OrderStatus orderStatusExpected = crmService.findDefaultOrderStatus();
        assertEquals(orderStatusExpected, orderStatus);
    }

    @Test
    public void testSaveSales() {
        crmService.saveSales(shoppingCart, order);
        verify(salesRepository, times(1)).save(any(Sales.class));
    }


    @Test
    public void testGetSalesByOrder() {
        List<Sales> expectedSales = crmService.getSalesByOrder(order);
        assertNotNull(expectedSales);
    }

    @Test
    public void testSaveOrder() {
        Order expectedOrder = crmService.saveOrder("name", "email", "phone");
        assertNotNull(expectedOrder);
    }
}