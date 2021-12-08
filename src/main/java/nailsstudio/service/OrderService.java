package nailsstudio.service;

import nailsstudio.DTO.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(long id);
    OrderDTO saveOrder(OrderDTO order);
    OrderDTO updateOrder(OrderDTO order);
    void deleteOrderById(long id);
}
