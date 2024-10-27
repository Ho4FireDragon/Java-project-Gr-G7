package com.shopkoi.shopkoi.Service;

import com.shopkoi.shopkoi.model.entity.ServiceEntity;
import com.shopkoi.shopkoi.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    // Lấy danh sách tất cả các dịch vụ
    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    // Lưu hoặc cập nhật dịch vụ và trả về đối tượng dịch vụ đã lưu
    public ServiceEntity saveService(ServiceEntity service) {
        // Thực hiện lưu đối tượng ServiceEntity vào cơ sở dữ liệu
        return serviceRepository.save(service);  // Trả về đối tượng đã lưu
    }

    // Lấy dịch vụ theo ID
    public ServiceEntity getServiceById(Long id) {
        // Trả về dịch vụ nếu tìm thấy theo ID hoặc null nếu không tìm thấy
        return serviceRepository.findById(id).orElse(null);
    }

    // Xóa dịch vụ theo ID
    public void deleteService(Long id) {
        // Thực hiện xóa dịch vụ theo ID
        serviceRepository.deleteById(id);
    }
}
