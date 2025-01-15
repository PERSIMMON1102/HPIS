package Patient.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Patient.pojo.Patient;

@Repository("patientDao")
public interface PatientDao {
		//添加病人信息
		public int addPatient(Patient patient);
		//更新病人信息
		public int updataPatient(Patient patient);
		//删除病人信息
		public int deletePatient(int id);
		//查询所有病人信息
		public List<Patient> query();
		//根据条件查询病人信息
		public List<Patient> search(Patient patient);
		//获得指定账号和密码的病人个数
		public int isExistent(Patient patient);
}
