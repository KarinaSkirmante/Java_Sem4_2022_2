package lv.venta.demo.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.Grade;

public interface IGradeRepo extends CrudRepository <Grade, Integer> {

}
