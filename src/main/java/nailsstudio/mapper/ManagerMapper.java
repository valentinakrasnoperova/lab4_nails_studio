package nailsstudio.mapper;


import nailsstudio.DTO.ManagerDTO;
import nailsstudio.entity.ServiceDetails;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapper {
    public ManagerDTO toManagerDTO(final ServiceDetails serviceDetails) {

        final ManagerDTO managerDTO = new ManagerDTO();

        managerDTO.setId(serviceDetails.getId());
        managerDTO.setNailsColor(serviceDetails.getNailsColor());
        managerDTO.setNailsShape(serviceDetails.getNailsShape());
        managerDTO.setPolishType(serviceDetails.getPolishType());
        managerDTO.setMaterialsPrice(serviceDetails.getMaterialsPrice());
        managerDTO.setPriceSell(serviceDetails.getPriceSell());
        managerDTO.setServiceType(serviceDetails.getServiceType());

        return managerDTO;
    }
}