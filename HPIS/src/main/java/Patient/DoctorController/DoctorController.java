package Patient.DoctorController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Patient.pojo.Doctor;
import Patient.service.com.DoctorService;

@Controller
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("doctor.do") // 定义一个 endpoint
    public String listDoctors(Model model) {
        // 从服务层获取医生列表
    	List<Doctor> doctors = doctorService.getAllDoctors();
    	model.addAttribute("doctorList", doctors);
        model.addAttribute("doctorList", doctorService.getAllDoctors());
        return "redirect:patient/doctor.do"; // 返回 JSP 页面名称
    }
}