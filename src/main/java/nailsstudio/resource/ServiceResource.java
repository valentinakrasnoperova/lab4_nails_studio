package nailsstudio.resource;


import nailsstudio.DTO.ServiceDTO;
import nailsstudio.service.ServiceService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ServiceResource {

    private ServiceService service;

    public ServiceResource(final ServiceService service) {
        this.service = service;
    }

    @GetMapping("/service")
    public List<ServiceDTO> getAllItems() {
        return service.getAllServices();
    }

    @GetMapping("/service/{id}")
    public ServiceDTO getServiceById(@PathVariable final long id) {
        return service.getServiceById(id);
    }


    @PostMapping("/service")
    public ServiceDTO saveItem(@RequestBody @Validated final ServiceDTO serviceDTO) {
        return service.saveService(serviceDTO);
    }


    @PutMapping("/items")
    public ServiceDTO updateItem(@RequestBody @Validated final ServiceDTO serviceDTO) {
        return service.updateService(serviceDTO);
    }


    @DeleteMapping("/items/{id}")
    public ResponseEntity deleteItemById(@PathVariable final long id) {
        service.deleteServiceById(id);
        return ResponseEntity.ok().build();
    }
}