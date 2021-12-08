package nailsstudio.service.impl;

import nailsstudio.DTO.ServiceDetailsDTO;
import nailsstudio.DTO.ManagerDTO;
import nailsstudio.entity.ServiceDetails;
import nailsstudio.entity.enumeration.ServiceType;
import nailsstudio.mapper.ServiceDetailsToServiceDetailsDTOMapper;
import nailsstudio.mapper.ManagerMapper;
import nailsstudio.repository.ServiceDetailsRepository;
import nailsstudio.service.ServiceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceDetailsServiceImpl implements ServiceDetailsService {
    @Autowired
    private ServiceDetailsRepository ServiceDetailsRepository;

    @Autowired
    private ServiceDetailsToServiceDetailsDTOMapper ServiceDetailsMapper;

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public List<ServiceDetailsDTO> getAllServiceDetails() {
        return ServiceDetailsRepository.getAllServiceDetails().stream().map(ServiceDetailsMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ManagerDTO> getAllServiceDetailsForManager() {
        return ServiceDetailsRepository.getAllServiceDetailsForManager().stream().map(managerMapper::toManagerDTO).collect(Collectors.toList());
    }


    @Override
    public ServiceDetailsDTO getServiceDetailsById(final long id) {
        return ServiceDetailsMapper.toDTO(ServiceDetailsRepository.getServiceDetailsById(id));
    }

    @Override
    public ServiceDetailsDTO saveServiceDetails(final ServiceDetailsDTO ServiceDetailsDTO) {
        final ServiceDetails ServiceDetails = ServiceDetailsMapper.toEntity(ServiceDetailsDTO);

        ServiceDetails.setServiceType(ServiceType.NOT_APPROVED);

        return ServiceDetailsMapper.toDTO(ServiceDetailsRepository.saveServiceDetails(ServiceDetails));
    }

    @Override
    public ServiceDetailsDTO updateServiceDetails(final ServiceDetailsDTO ServiceDetailsDTO) {
        final ServiceDetails ServiceDetails = ServiceDetailsMapper.toEntity(ServiceDetailsDTO);

        ServiceDetails.setServiceType(ServiceType.NOT_APPROVED);

        return ServiceDetailsMapper.toDTO(ServiceDetailsRepository.updateServiceDetails(ServiceDetails));
    }

    @Override
    public void deleteServiceDetailsById(final long id) {
        final ServiceDetails savedServiceDetails = ServiceDetailsRepository.getServiceDetailsById(id);
        savedServiceDetails.setServiceType(ServiceType.DELETED);
        ServiceDetailsRepository.saveServiceDetails(savedServiceDetails);
    }
}