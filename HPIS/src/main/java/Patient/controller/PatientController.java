package Patient.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Patient.pojo.Doctor;
import Patient.pojo.Patient;
import Patient.pojo.PatientParam;
import Patient.service.com.DoctorService;
import Patient.service.com.PatientService;

@Controller
@RequestMapping("patient")
public class PatientController {
	@Autowired
	private PatientService patientService;
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping("query.do")
	public String query(Model model){
		List<Patient> patientList = patientService.query();
		model.addAttribute("patientList", patientList);
		List<Doctor> doctors = doctorService.getAllDoctors();
    	model.addAttribute("doctorList", doctors);
        model.addAttribute("doctorList", doctorService.getAllDoctors());
		return "view";
	}
	
	@RequestMapping("delete.do")
	public String delete(Integer id){
		patientService.deletePatient(id);
		return "redirect:query.do";
	}
	
	@RequestMapping("getbyid.do")
	public String getById(Integer id, Model model){
		PatientParam patientParam = new PatientParam();
		patientParam.setId(id);
		List<Patient> patientList = patientService.search(patientParam);  
       Patient patient2 = patientList.get(0);
		model.addAttribute("patient", patient2);
		return "update";
	}
	
	@RequestMapping(value="update.do", method=RequestMethod.POST)
	public String update(PatientParam patientParam){
		patientService.updataPatient(patientParam);
		return "redirect:query.do";
	}
	
	@RequestMapping("add.do")
	public String add(PatientParam patientParam){
		patientService.addPatient(patientParam);
		return "redirect:query.do";
	}
	
	@RequestMapping("find.do")
	public String find(PatientParam patientParam,Model model){
		List<Patient> patientList =patientService.search(patientParam);
		model.addAttribute("patientList", patientList);
		return "view";
	}
	
	@RequestMapping("addpage.do")
	public String addPage(){
		return "add";
	}
}
