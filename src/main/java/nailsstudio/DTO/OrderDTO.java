package nailsstudio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private UserDTO user;
    private Map<Long, Integer> serviceMap; // Integer - number of services
    private Double totalPrice;
    private LocalDateTime orderTime;
    private ServiceDetailsDTO serviceDetails;
}


