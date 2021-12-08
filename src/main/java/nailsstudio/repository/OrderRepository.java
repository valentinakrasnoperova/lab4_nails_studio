package nailsstudio.repository;

import nailsstudio.entity.Order;
import nailsstudio.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class OrderRepository {

    private List<Order> orders = new ArrayList<>();
    private long id = 1;

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }

    public Order getOrderById(final long id) {
        return orders.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Order with id {" + id + "} not found"));
    }

    public Order saveOrder(final Order order) {
        order.setId(id);

        ++id;

        orders.add(order);
        return order;
    }

    public Order updateOrder(final Order order) {

        final Order savedOrder = getOrderById(order.getId());

        savedOrder.setTotalPrice(order.getTotalPrice());
        savedOrder.setServiceMap(order.getServiceMap());
        savedOrder.setServiceDetails(order.getServiceDetails());
        savedOrder.setOrderTime(order.getOrderTime());
        savedOrder.setUser(order.getUser());

        return savedOrder;
    }

    public void deleteOrderById(final long id) {
        orders = orders.stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }

}
