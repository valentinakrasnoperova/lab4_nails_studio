package nailsstudio.mapper;

import nailsstudio.DTO.ServiceDTO;
import nailsstudio.entity.AdditionalServices;
import org.springframework.stereotype.Component;

@Component
public class ServiceToServiceDTOMapper {
    public AdditionalServices toEntity(final ServiceDTO itemDTO) {
        final AdditionalServices item = new AdditionalServices();

        item.setId(itemDTO.getId());
        item.setTitle(itemDTO.getTitle());
        item.setPrice(itemDTO.getPrice());
        return item;
    }

    public ServiceDTO toDTO(final AdditionalServices item) {
        final ServiceDTO itemDTO = new ServiceDTO();

        itemDTO.setId(item.getId());
        itemDTO.setTitle(item.getTitle());
        itemDTO.setPrice(item.getPrice());

        return itemDTO;
    }
}