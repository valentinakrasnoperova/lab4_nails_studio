package nailsstudio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private User user;
    private AdditionalServices additionalServices;
    private Double totalPrice;
    private String orderTime;
    private ServiceDetails serviceDetails;
}