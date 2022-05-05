package lv.venta.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table
@Entity
public class Professor {

	//1.mainigie
	@Column(name = "IdPr")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value=AccessLevel.NONE)
	private int idPr;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Surname")
	private String surname;
	
	@Column(name = "Degree")
	private ProfDegree degree;

	
	//2. get un set no lombok
	//3.1. bezargumenta konstruktors - lombok
	//3.2. argumenta konstruktors
	public Professor(String name, String surname, ProfDegree degree) {
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}
	
	//4.toString - lombok
	
	
}
