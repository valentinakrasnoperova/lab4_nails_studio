package nailsstudio.service;

import nailsstudio.DTO.ManagerDTO;
import nailsstudio.DTO.ServiceDetailsDTO;

import java.util.List;

public interface ServiceDetailsService {

    List<ServiceDetailsDTO> getAllServiceDetails();

    ServiceDetailsDTO getServiceDetailsById(long id);

    ServiceDetailsDTO saveServiceDetails(ServiceDetailsDTO fuelDTO);

    ServiceDetailsDTO updateServiceDetails(ServiceDetailsDTO fuelDTO);

    void deleteServiceDetailsById(long id);

    List<ManagerDTO> getAllServiceDetailsForManager();

}