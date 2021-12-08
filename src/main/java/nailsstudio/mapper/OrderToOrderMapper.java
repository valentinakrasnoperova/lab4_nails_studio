package nailsstudio.mapper;

import nailsstudio.DTO.OrderDTO;
import nailsstudio.entity.Order;
import nailsstudio.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OrderToOrderMapper {

    @Autowired
    private ServiceDetailsToServiceDetailsDTOMapper serviceDetailsMapper;
    @Autowired
    private UserToUserDTOMapper userMapper;


    @Autowired
    private ServiceRepository serviceRepository;

    public Order toEntity(final OrderDTO orderDTO) {
        final Order order = new Order();


        order.setId(orderDTO.getId());
        order.setOrderTime(orderDTO.getOrderTime());
        order.setTotalPrice(orderDTO.getTotalPrice());

        order.setUser(userMapper.toEntity(orderDTO.getUser()));
        order.setServiceDetails(serviceDetailsMapper.toEntity(orderDTO.getServiceDetails()));

        order.setServiceMap(orderDTO.getServiceMap().entrySet().stream().collect(Collectors.toMap(e -> {
            return serviceRepository.getServiceById(e.getKey());
        }, Map.Entry::getValue)));


        return order;
    }

    public OrderDTO toDTO(final Order order) {
        final OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setOrderTime(order.getOrderTime());
        orderDTO.setTotalPrice(order.getTotalPrice());

        orderDTO.setUser(userMapper.toDTO(order.getUser()));
        orderDTO.setServiceDetails(serviceDetailsMapper.toDTO(order.getServiceDetails()));
      //  orderDTO.getServiceMap(order.getServiceMap().entrySet().stream().collect(Collectors.toMap(e -> e.getKey().getId(), Map.Entry::getValue)));

        return orderDTO;
    }
}