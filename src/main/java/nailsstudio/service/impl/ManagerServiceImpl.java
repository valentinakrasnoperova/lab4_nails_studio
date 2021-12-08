package nailsstudio.service.impl;

import nailsstudio.entity.ServiceDetails;
import nailsstudio.entity.enumeration.ServiceType;
import nailsstudio.exception.ServiceException;
import nailsstudio.repository.ServiceDetailsRepository;
import nailsstudio.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ServiceDetailsRepository serviceDetailsRepository;

    @Override
    public void approve(final Long sdId) {
        final ServiceDetails serviceDetails = serviceDetailsRepository.getServiceDetailsById(sdId);

        serviceDetails.setServiceType(ServiceType.ACTIVE);

        serviceDetailsRepository.updateServiceDetails(serviceDetails);
    }

    @Override
    public void deactivate(final Long sdId) {
        final ServiceDetails serviceDetails = serviceDetailsRepository.getServiceDetailsById(sdId);

        if(serviceDetails.getServiceType() != ServiceType.ACTIVE){
            throw new ServiceException(400, "Fuel should be in active state", "Current state: " + serviceDetails.getServiceType());
        }

        serviceDetails.setServiceType(ServiceType.DELETED.NOT_ACTIVE);

        serviceDetailsRepository.updateServiceDetails(serviceDetails);
    }

    @Override
    public void delete(final Long sdId) {
        final ServiceDetails serviceDetails = serviceDetailsRepository.getServiceDetailsById(sdId);

        serviceDetails.setServiceType(ServiceType.DELETED);

        serviceDetailsRepository.updateServiceDetails(serviceDetails);
    }
}