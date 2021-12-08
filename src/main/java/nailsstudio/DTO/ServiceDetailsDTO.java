package nailsstudio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nailsstudio.entity.enumeration.ServiceType;
import nailsstudio.validation.CrossCheck;
import nailsstudio.validation.enumeration.Condition;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

@CrossCheck(field1 = "materialsPrice", condition = Condition.GREATER_THAN, field2 = "priceSell", message = "You need to set higher price")
public class ServiceDetailsDTO {
    private Long id;

    @NotBlank
    private String name;

    @Min(1)
    @NotNull
    private String nailsColor;

    @Min(1)
    @NotNull
    private String nailsShape;

    @Min(1)
    @NotNull
    private String polishType;

    @Min(1)
    @NotNull
    private Double materialsPrice;

    @Min(1)
    @NotNull
    private Double priceSell;

    private ServiceType serviceType;

}