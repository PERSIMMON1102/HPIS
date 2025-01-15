package Patient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Patient.dao.DoctorDao;
import Patient.pojo.Doctor;
import Patient.service.com.DoctorService;

@Service("doctorService") // 使用 @Service 注解将该类标记为 Spring 管理的 Bean
public class DoctorServiceImpl implements DoctorService {

    @Autowired // 自动注入 DoctorDao
    private DoctorDao doctorDao;

    @Override
    public List<Doctor> getAllDoctors() {
        // 使用 DoctorDao 获取所有医生
        return doctorDao.findAllDoctors(); // 假设 DoctorDao 中有这个方法
    }
}
