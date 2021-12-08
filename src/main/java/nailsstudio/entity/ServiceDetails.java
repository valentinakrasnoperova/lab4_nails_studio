package nailsstudio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nailsstudio.entity.enumeration.ServiceType;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDetails {
    private Long id;
    private String nailsColor;
    private String nailsShape;
    private String polishType;
    private Double materialsPrice;
    private Double priceSell;
    private ServiceType serviceType;
}