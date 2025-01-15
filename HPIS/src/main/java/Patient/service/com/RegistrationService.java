package Patient.service.com;

import java.util.List;
import Patient.pojo.Registration;
public interface RegistrationService {
	//检查挂号是否成功
	boolean register(Registration registration);
	//生成挂号记录
	public int addRegistration(Registration registration);
	//更新挂号信息
	public int updataRegistration(Registration registration);
	//删除挂号信息
	public int deleteRegistration(int id);
	//查询所有挂号信息
	public List<Registration> query();
}
