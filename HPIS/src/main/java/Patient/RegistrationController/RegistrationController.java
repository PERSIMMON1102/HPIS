package Patient.RegistrationController;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Patient.pojo.Doctor;
import Patient.pojo.Patient;
import Patient.pojo.PatientParam;
import Patient.pojo.Registration;
import Patient.service.com.DoctorService;
import Patient.service.com.PatientService;
import Patient.service.com.RegistrationService;

@Controller
@RequestMapping("registration")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final DoctorService doctorService;
	private final PatientService patientService;

    @Autowired
    public RegistrationController(RegistrationService registrationService, DoctorService doctorService,PatientService patientService) {
        this.registrationService = registrationService;
        this.doctorService = doctorService;
        this.patientService=patientService;
    }

    @RequestMapping(value = "registration.do", method = RequestMethod.POST)
    public String register(
            @RequestParam("doctorId") int doctorId, 
            @RequestParam("date") String date, 
            HttpSession session, 
            RedirectAttributes redirectAttributes) {

        // 获取当前会话中的 Patient 对象
        Patient account = (Patient) session.getAttribute("account");
        
        // 检查 account 是否为 null
        if (account == null) {
            redirectAttributes.addFlashAttribute("msg", "请先登录账户。");
            return "redirect:loginPage"; 
        }

        // 创建 Registration 对象并设置属性
        Registration registration = new Registration();
        registration.setPatientId(account.getId()); // 使用 session 中的患者 ID
        registration.setDoctorId(doctorId);         // 从表单中获取医生 ID
        registration.setDate(date);                  // 从表单中获取挂号日期
        
        // 调用服务层的方法来注册
        boolean isRegistered = registrationService.register(registration);
        
        // 根据是否成功注册来设置消息
        if (isRegistered) {
            redirectAttributes.addFlashAttribute("msg", "挂号成功！");
        } else {
            redirectAttributes.addFlashAttribute("msg", "挂号失败，请重试。");
        }
        
        return "redirect:queryReg.do"; // 重定向到查询页面
    }
    

    @RequestMapping("queryReg.do")
    public String query(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        // 验证用户是否登录
        Patient account = (Patient) session.getAttribute("account");
        
        if (account == null) {
            redirectAttributes.addFlashAttribute("msg", "请先登录账户。");
            return "redirect:loginPage"; // 确保重定向到正确的登录地址
        }
        
        List<Registration> registrationList = registrationService.query();
        model.addAttribute("registrationList", registrationList);
        return "check";
    }

    @RequestMapping("deleteReg.do")
    public String delete(Integer id, HttpSession session, RedirectAttributes redirectAttributes) {
        // 验证用户是否登录
        Patient account = (Patient) session.getAttribute("account");
        
        if (account == null) {
            redirectAttributes.addFlashAttribute("msg", "请先登录账户。");
            return "redirect:loginPage"; // 确保重定向到正确的登录地址
        }
        
        registrationService.deleteRegistration(id);
        return "redirect:queryReg.do"; // 确保重定向到正确的页面
    }

    @RequestMapping(value="updateReg.do", method=RequestMethod.POST)
    public String update(Registration registration, HttpSession session, RedirectAttributes redirectAttributes) {
        // 验证用户是否登录
        Patient account = (Patient) session.getAttribute("account");
        
        if (account == null) {
            redirectAttributes.addFlashAttribute("msg", "请先登录账户。");
            return "redirect:loginPage"; // 确保重定向到正确的登录地址
        }
        
        registrationService.updataRegistration(registration);
        return "redirect:queryReg.do";
    }
    
    @RequestMapping("add.do")
    public String add(Registration registration, HttpSession session, RedirectAttributes redirectAttributes) {
        // 验证用户是否登录
        Patient account = (Patient) session.getAttribute("account");
        
        if (account == null) {
            redirectAttributes.addFlashAttribute("msg", "请先登录账户。");
            return "redirect:loginPage"; // 确保重定向到正确的登录地址
        }
        
        registrationService.addRegistration(registration);
        return "redirect:queryReg.do";
    }
    
}