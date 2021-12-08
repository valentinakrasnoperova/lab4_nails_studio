package nailsstudio.service;

public interface ManagerService {
    void approve(Long serviceDetailsId);
    void deactivate(Long serviceDetailsId);
    void delete(Long serviceDetailsId);
}
