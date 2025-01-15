package Patient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Patient.dao.RegistrationDao;
import Patient.pojo.Registration;
import Patient.service.com.RegistrationService;

@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService{
	// 注入RegistrationMapper，用于数据库操作
    @Autowired
    private RegistrationDao registrationdao;

    @Override
    public boolean register(Registration registration) {
        // 首先检查是否已有重复的挂号记录
        if (registrationdao.isRegistration(registration) > 0) {
            return false; 
        } else {
            // 插入新的挂号记录
            int result = registrationdao.addRegistration(registration); 
            return result > 0; 
        }
    }

    @Override
    public int addRegistration(Registration registration){
    	Registration reg=new Registration();
    	reg.setId(registration.getId());
		reg.setPatientId(registration.getPatientId());
		reg.setDoctorId(registration.getDoctorId());
		reg.setDate(registration.getDate());
        return registrationdao.addRegistration(reg);
    }

    @Override
    public int updataRegistration(Registration registration) {
    	Registration reg=new Registration();
    	reg.setId(registration.getId());
		reg.setPatientId(registration.getPatientId());
		reg.setDoctorId(registration.getDoctorId());
		reg.setDate(registration.getDate());
        return registrationdao.updateRegistration(reg);
    }

    @Override
    public int deleteRegistration(int id) {
        return registrationdao.deleteRegistration(id);
    }

    @Override
    public List<Registration> query() {
        return registrationdao.findAllRegistrations();

    }
}
