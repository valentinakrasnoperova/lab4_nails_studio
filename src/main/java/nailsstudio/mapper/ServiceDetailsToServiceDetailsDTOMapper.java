package nailsstudio.mapper;

import nailsstudio.DTO.ServiceDetailsDTO;
import nailsstudio.entity.ServiceDetails;
import org.springframework.stereotype.Component;

@Component
public class ServiceDetailsToServiceDetailsDTOMapper {
    public ServiceDetails toEntity(final ServiceDetailsDTO serviceDetailsDTO) {
        final ServiceDetails serviceDetails = new ServiceDetails();

        serviceDetails.setId(serviceDetailsDTO.getId());
        serviceDetails.setNailsColor(serviceDetailsDTO.getNailsColor());
        serviceDetails.setNailsShape(serviceDetailsDTO.getNailsShape());
        serviceDetails.setPolishType(serviceDetailsDTO.getPolishType());
        serviceDetails.setMaterialsPrice(serviceDetailsDTO.getMaterialsPrice());
        serviceDetails.setPriceSell(serviceDetailsDTO.getPriceSell());

        return serviceDetails;
    }

    public ServiceDetailsDTO toDTO(final ServiceDetails serviceDetails) {
        final ServiceDetailsDTO serviceDetailsDTO = new ServiceDetailsDTO();

        serviceDetailsDTO.setId(serviceDetails.getId());
        serviceDetailsDTO.setNailsColor(serviceDetails.getNailsColor());
        serviceDetailsDTO.setNailsShape(serviceDetails.getNailsShape());
        serviceDetailsDTO.setPolishType(serviceDetails.getPolishType());
        serviceDetailsDTO.setMaterialsPrice(serviceDetails.getMaterialsPrice());
        serviceDetailsDTO.setPriceSell(serviceDetails.getPriceSell());

        return serviceDetailsDTO;
    }
}