package nailsstudio.resource;

import nailsstudio.DTO.ManagerDTO;
import nailsstudio.service.ManagerService;
import nailsstudio.service.ServiceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ManagerResource {
    @Autowired
    private ServiceDetailsService serviceDetailsService;

    @Autowired
    private ManagerService managerService;

    @GetMapping("/manager/service-details")
    public List<ManagerDTO> getAllServiceDetails() {
        return serviceDetailsService.getAllServiceDetailsForManager();
    }

    @GetMapping("/manager/approve/{sdId}")
    public ResponseEntity approveServiceDetailsById(final @PathVariable Long sdId) {
        managerService.approve(sdId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/manager/deactivate/{sdId}")
    public ResponseEntity deactivateServiceDetails(final @PathVariable Long sdId) {
        managerService.deactivate(sdId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}