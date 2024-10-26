package com.shopkoi.shopkoi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopkoi.shopkoi.repository.ServiceRepository;
import com.shopkoi.shopkoi.entity.ServiceEntity;


import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    public void saveService(ServiceEntity service) {
        serviceRepository.save(service);
    }

    public ServiceEntity getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
