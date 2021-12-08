package nailsstudio.service;

import nailsstudio.DTO.ServiceDTO;

import java.util.List;

public interface ServiceService {
    List<ServiceDTO> getAllServices();

    ServiceDTO getServiceById(long id);

    ServiceDTO saveService(ServiceDTO serviceDTO);

    ServiceDTO updateService(ServiceDTO serviceDTO);

    void deleteServiceById(long id);
}
