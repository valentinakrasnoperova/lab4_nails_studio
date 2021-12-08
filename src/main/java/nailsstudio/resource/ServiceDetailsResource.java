package nailsstudio.resource;

import nailsstudio.DTO.ServiceDetailsDTO;
import nailsstudio.service.ServiceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ServiceDetailsResource {
    @Autowired
    private ServiceDetailsService serviceDetailsService;

    @GetMapping("/service-details")
    public List<ServiceDetailsDTO> getAllServiceDetails() {
        return serviceDetailsService.getAllServiceDetails();
    }

    @GetMapping("/service-details/{id}")
    public ServiceDetailsDTO getServiceDetailsById(@PathVariable final long id) {
        return serviceDetailsService.getServiceDetailsById(id);
    }

    @PostMapping("/service-details")
    public ServiceDetailsDTO saveServiceDetails(@RequestBody @Validated final ServiceDetailsDTO serviceDetailsDTO) {
        return serviceDetailsService.saveServiceDetails(serviceDetailsDTO);
    }

    @PutMapping("/service-details")
    public ServiceDetailsDTO updateServiceDetails(@RequestBody @Validated final ServiceDetailsDTO serviceDetailsDTO) {
        return serviceDetailsService.updateServiceDetails(serviceDetailsDTO);
    }

    @DeleteMapping("/service-details/{id}")
    public ResponseEntity deleteServiceDetailsById(@PathVariable final long id) {
        serviceDetailsService.deleteServiceDetailsById(id);
        return ResponseEntity.ok().build();
    }
}