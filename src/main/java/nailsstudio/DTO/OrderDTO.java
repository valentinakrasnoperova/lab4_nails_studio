package nailsstudio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nailsstudio.entity.AdditionalServices;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private UserDTO user;
    private AdditionalServices additionalServices;
    private Double totalPrice;
    private String orderTime;
    private ServiceDetailsDTO serviceDetails;
}


