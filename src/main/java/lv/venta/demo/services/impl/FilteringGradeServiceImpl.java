package lv.venta.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.model.Grade;
import lv.venta.demo.repo.ICourseRepo;
import lv.venta.demo.repo.IGradeRepo;
import lv.venta.demo.repo.IStudentRepo;
import lv.venta.demo.services.IFilteringGradeService;

@Service
public class FilteringGradeServiceImpl implements IFilteringGradeService{

	@Autowired
	private IGradeRepo gradeRepo;
	@Autowired
	private IStudentRepo studRepo;
	@Autowired
	private ICourseRepo courseRepo;
	
	@Override
	public ArrayList<Grade> filterStudentGrades(int id) throws Exception {
		//TODO pāŗbaudi, vai tds students vispāŗ eksistē?
		if(studRepo.existsById(id))
		{
			ArrayList<Grade> result = gradeRepo.findByStudentIdSt(id);
			return result;
		}
		else
			throw new Exception("Nav atbilstošs id");
	}

	@Override
	public ArrayList<Grade> filterGradesByCourse(int id) throws Exception {
		if(courseRepo.existsById(id))
		{
			ArrayList<Grade> result = gradeRepo.findByCourseIdCo(id);
			return result;
		}
		else
			throw new Exception("Nav atbilstošs id");
	}

	@Override
	public ArrayList<Grade> filterGradesByStudentNameSurname(String name, String surname) throws Exception {
		if(studRepo.existsByNameAndSurname(name, surname))
		{
			ArrayList<Grade> result = 
				gradeRepo.findByStudentNameAndStudentSurname(name, surname);
			return result;
		}
		else
			throw new Exception("Students ar tādu vārdu un uzvārdu neeksistē");
	}

	@Override
	public ArrayList<Grade> filterNonPassingGradesAndStudents() {
		// TODO Auto-generated method stub
		return gradeRepo.findByValueLessThan(4);
	}

	@Override
	public float calcAverageOfCourse(int id) throws Exception {
		if(courseRepo.existsById(id))
		{
			return gradeRepo.calculateAVGByCourseId(id);
		}
		throw new Exception("Nav atbilstošs id");
	}

	@Override
	public float calcAverageOfStudent(int id) throws Exception {
		if(studRepo.existsById(id))
		{
			return gradeRepo.calculateAVGByStudentId(id);
		}
		else
			throw new Exception("Nav atbilstošs id");
	}

	@Override
	public ArrayList<Grade> filterNonPassingGradesByCourseId(int id) throws Exception {
		if(courseRepo.existsById(id))
		{
			return gradeRepo.findByCourseIdCoAndValueLessThan(id,4);
		}
		else
			throw new Exception("Nav atbilstošs id");
	}

}
