package Patient.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Patient.pojo.Doctor;

@Repository("doctorDao")
public interface DoctorDao {
    List<Doctor> findAllDoctors(); // 获取所有医生
}