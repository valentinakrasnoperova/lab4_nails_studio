package nailsstudio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private User user;
    private Map<AdditionalServices, Integer> serviceMap = new HashMap<>(); // Integer - number of services
    private Double totalPrice;
    private LocalDateTime orderTime;
    private ServiceDetails serviceDetails;
}