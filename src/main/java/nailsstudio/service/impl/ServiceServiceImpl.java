package nailsstudio.service.impl;

import nailsstudio.DTO.ServiceDTO;
import nailsstudio.entity.AdditionalServices;
import nailsstudio.mapper.ServiceToServiceDTOMapper;
import nailsstudio.repository.ServiceRepository;
import nailsstudio.service.ServiceService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceServiceImpl implements ServiceService {

    private ServiceToServiceDTOMapper serviceDTOMapper;
    private ServiceRepository serviceRepository;


    public ServiceServiceImpl(final ServiceToServiceDTOMapper serviceDTOMapper, final ServiceRepository serviceRepository) {
        this.serviceDTOMapper = serviceDTOMapper;
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<ServiceDTO> getAllServices() {
        return ServiceRepository.getAllService().stream()
                .map(e -> serviceDTOMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public ServiceDTO getServiceById(final long id) {
        return serviceDTOMapper.toDTO(ServiceRepository.getServiceById(id));
    }

    @Override
    public ServiceDTO saveService(final ServiceDTO ServiceDTO) {

        final AdditionalServices AdditionalServices = serviceDTOMapper.toEntity(ServiceDTO);

        ServiceRepository.saveService(AdditionalServices);

        return serviceDTOMapper.toDTO(AdditionalServices);
    }

    @Override
    public ServiceDTO updateService(final ServiceDTO ServiceDTO) {
        final AdditionalServices AdditionalServices = serviceDTOMapper.toEntity(ServiceDTO);

        return serviceDTOMapper.toDTO(ServiceRepository.updateService(AdditionalServices));
    }

    @Override
    public void deleteServiceById(final long id) {
        ServiceRepository.deleteServiceById(id);
    }
}