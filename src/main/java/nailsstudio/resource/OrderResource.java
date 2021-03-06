package nailsstudio.resource;

import nailsstudio.DTO.OrderDTO;
import nailsstudio.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderResource {

    private final OrderService orderService;

    public OrderResource(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public OrderDTO getOrderById(@PathVariable final long id) {
        return orderService.getOrderById(id);
    }


    @PostMapping(value = "/orders", produces = "application/json", consumes = "application/json")
    public OrderDTO saveOrder(@RequestBody final OrderDTO orderDTO) {
        return orderService.saveOrder(orderDTO);
    }


    @PutMapping(value = "/orders", produces = "application/json", consumes = "application/json")
    public OrderDTO updateOrder(@RequestBody  final OrderDTO orderDTO) {
        return orderService.updateOrder(orderDTO);
    }


    @DeleteMapping("/orders/{id}")
    public ResponseEntity deleteOrderById(@PathVariable final long id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.ok().build();
    }
}
