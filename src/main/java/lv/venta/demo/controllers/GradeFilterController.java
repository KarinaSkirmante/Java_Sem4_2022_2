package lv.venta.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.demo.model.Grade;
import lv.venta.demo.services.IFilteringGradeService;

@Controller
@RequestMapping("/grade/filter")
public class GradeFilterController {
	
	@Autowired
	private IFilteringGradeService grService;
	
	@GetMapping("/student/{id}") //localhost:8080/grade/filter/student/2
	public String getGradesByStudent(@PathVariable(name="id") int id,
			Model model)
	{
		try {
			model.addAttribute("package", grService.filterStudentGrades(id));
			return "grades-all-page";//atveram grades-all-page.html
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error-page";
		}
		
	}
	
	
}
