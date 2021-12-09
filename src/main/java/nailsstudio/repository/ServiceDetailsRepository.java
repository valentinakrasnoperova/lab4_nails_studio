package nailsstudio.repository;

import nailsstudio.entity.ServiceDetails;
import nailsstudio.entity.enumeration.ServiceType;
import nailsstudio.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ServiceDetailsRepository {
    private final List<ServiceDetails> serviceDetailsList = new ArrayList<>();

    private long id = 1;

    
    public List<ServiceDetails> getAllServiceDetails() {
        return serviceDetailsList.stream().filter(e -> e.getServiceType() == ServiceType.ACTIVE).collect(Collectors.toList());
    }

    public List<ServiceDetails> getAllServiceDetailsForManager() {
        return new ArrayList<>(serviceDetailsList);
    }


    public ServiceDetails getServiceDetailsById(final long id) {
        return serviceDetailsList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "service with id {" + id + "} not found"));
    }


    public ServiceDetails getServiceDetailsByNailsColor(final String nailsColor) {
        return serviceDetailsList.stream()
                .filter(e -> e.getNailsColor().equals(nailsColor))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "service with name {" + nailsColor + "} not found"));
    }

    public ServiceDetails getServiceDetailsByNailsShape(final String nailsShape) {
        return serviceDetailsList.stream()
                .filter(e -> e.getNailsShape().equals(nailsShape))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "service with name {" + nailsShape + "} not found"));
    }


    public ServiceDetails saveServiceDetails(final ServiceDetails serviceDetails) {
        serviceDetails.setId(id);
        ++id;
        serviceDetailsList.add(serviceDetails);
        return serviceDetails;
    }

    public ServiceDetails updateServiceDetails(final ServiceDetails serviceDetails) {

        final ServiceDetails savedServiceDetails = getServiceDetailsById(serviceDetails.getId());

        savedServiceDetails.setNailsColor(serviceDetails.getNailsColor());
        savedServiceDetails.setNailsShape(serviceDetails.getNailsShape());
        savedServiceDetails.setPolishType(serviceDetails.getPolishType());
        savedServiceDetails.setMaterialsPrice(serviceDetails.getMaterialsPrice());
        savedServiceDetails.setPriceSell(serviceDetails.getPriceSell());
        savedServiceDetails.setServiceType(serviceDetails.getServiceType());

        return savedServiceDetails;
    }
}