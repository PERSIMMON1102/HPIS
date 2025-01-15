package Patient.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Patient.pojo.Registration;


@Repository("registrationDao")
public interface RegistrationDao {
	int isRegistration(Registration registration);
    int addRegistration(Registration registration);
    int updateRegistration(Registration registration);
    int deleteRegistration(int id);
    List<Registration> findAllRegistrations();
}
