package Patient.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Patient.pojo.Doctor;
import Patient.pojo.Patient;
import Patient.pojo.PatientParam;
import Patient.service.com.DoctorService;
import Patient.service.com.PatientService;

@Controller
public class LoginController {
	
	@Autowired
	private PatientService patientService;
	@Autowired
	private DoctorService doctorService; // 注入 DoctorService
	
	@RequestMapping(value="login.do")
	public String loginPage(String username, String password, Model model, HttpSession session){
	
		if(username!=null && password!=null){
			PatientParam patientParam = new PatientParam();
			patientParam.setAccount(username);
			patientParam.setPassword(password);
			if(patientService.isExistent(patientParam)){
				List<Patient> list= patientService.search(patientParam);
				Patient pat = list.get(0);
				session.setAttribute("account", pat); 
				// 查询所有医生信息
				List<Doctor> doctorList = doctorService.getAllDoctors(); // 查询医生信息
				model.addAttribute("doctorList", doctorList); // 将医生列表添加到模型中
				return "redirect:patient/query.do";
			}else{
				model.addAttribute("msg", "用户名或密码错误");
			}
		} 
		return "loginPage";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:login.do";
	}
}
