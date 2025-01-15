package Patient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Patient.dao.PatientDao;
import Patient.dao.TypeDao;
import Patient.pojo.Patient;
import Patient.pojo.PatientParam;
import Patient.pojo.Type;
import Patient.service.com.PatientService;
@Service("patientService")
public class PatientServicelmpl implements PatientService {
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private TypeDao typeDao;

	@Override
	public int addPatient(PatientParam patientParam) {
		Patient patient = new Patient();
		patient.setId(patientParam.getId());
		patient.setName(patientParam.getName());
		patient.setAge(patientParam.getAge());
		patient.setSex(patientParam.getSex());
		patient.setAccount(patientParam.getAccount());
		patient.setPassword(patientParam.getPassword());
		Type type = typeDao.getById(patientParam.getTypeId());
		patient.setType(type);

		return patientDao.addPatient(patient);
	}

	@Override
	public int updataPatient(PatientParam patientParam) {
		Patient patient = new Patient();
		patient.setId(patientParam.getId());
		patient.setName(patientParam.getName());
		patient.setAge(patientParam.getAge());
		patient.setSex(patientParam.getSex());
		patient.setAccount(patientParam.getAccount());
		patient.setPassword(patientParam.getPassword());
		Type type = typeDao.getById(patientParam.getTypeId());
		patient.setType(type);
		
		return patientDao.updataPatient(patient);
	}

	@Override
	public int deletePatient(int id) {
		return patientDao.deletePatient(id);
	}

	@Override
	public List<Patient> query() {
		return patientDao.query();
	}

	@Override
	public List<Patient> search(PatientParam patientParam) {
		Patient patient = new Patient();
		patient.setId(patientParam.getId());
		patient.setName(patientParam.getName());
		patient.setAge(patientParam.getAge());
		patient.setSex(patientParam.getSex());
		patient.setAccount(patientParam.getAccount());
		patient.setPassword(patientParam.getPassword());
		
		return patientDao.search(patient);
	}

	@Override
	public boolean isExistent(PatientParam patientParam) {
		Patient patient = new Patient();
		patient.setAccount(patientParam.getAccount());
		patient.setPassword(patientParam.getPassword());
		
		if(patientDao.isExistent(patient)>0){
			return true;
		}else{
			return false;
		}	
	}
}
