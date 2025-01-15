package Patient.service.com;

import java.util.List;

import Patient.pojo.Patient;
import Patient.pojo.PatientParam;


public interface PatientService {
		//添加病人信息
		public int addPatient(PatientParam patienttParam);
		//更新病人信息
		public int updataPatient(PatientParam patienttParam);
		//删除病人信息
		public int deletePatient(int id);
		//查询所有病人信息
		public List<Patient> query();
		//根据条件查询病人信息
		public List<Patient> search(PatientParam patienttParam);
		//判断指定账户和密码的用户是否存在
		public boolean isExistent(PatientParam patienttParam);
}
