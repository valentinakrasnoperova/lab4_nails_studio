package nailsstudio.repository;

import nailsstudio.entity.AdditionalServices;
import nailsstudio.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class ServiceRepository {
    private static List<AdditionalServices> services = new ArrayList<>();

    private static long id = 1;

    public static List<AdditionalServices> getAllService() {
        return new ArrayList<>(services);
    }

    public static AdditionalServices getServiceById(final long id) {
        return services.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "service with id {" + id + "} not found"));
    }

    public static AdditionalServices saveService(final AdditionalServices additionalServices) {
        additionalServices.setId(id);

        ++id;
        ServiceRepository.services.add(additionalServices);
        return additionalServices;
    }

    public static AdditionalServices updateService(final AdditionalServices additionalServices) {

        final AdditionalServices savedAdditionalServices = getServiceById(additionalServices.getId());

        savedAdditionalServices.setPrice(additionalServices.getPrice());
        savedAdditionalServices.setTitle(additionalServices.getTitle());

        return savedAdditionalServices;
    }

    public static void deleteServiceById(final long id) {
        services = services.stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }
}