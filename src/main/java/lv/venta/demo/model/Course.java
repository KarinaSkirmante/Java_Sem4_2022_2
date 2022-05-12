package lv.venta.demo.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
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
public class Course {
	//1.mainigie
		@Column(name = "IdCo")
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Setter(value=AccessLevel.NONE)
		private int idCo;
		
		@Size(min = 3, max = 60)
		@Pattern(regexp="[A-Z]{1}[a-z\\s]+")
		@Column(name = "Title")
		private String title;
		
		@Min(0)
		@Max(25)
		@Column(name = "Cp")
		private int cp;
		
		
		//1. vienam kursam ir tikai viens pasniedzejs
		
		//viens-pret-viens
		@OneToOne
		//joinColumn uz otrāš klases id kolonu
		@JoinColumn(name="IdPr")
		private Professor professor;
		
		
		@OneToMany(mappedBy="course")
		@ToString.Exclude
		private Collection<Grade> grades;


		public Course(@Size(min = 3, max = 60) @Pattern(regexp = "[A-Z]{1}[a-z\\s]+") String title,
				@Min(0) @Max(25) int cp, Professor professor) {
			super();
			this.title = title;
			this.cp = cp;
			this.professor = professor;
		}
		
		
		
		
		
		
		//2. vienam kursam ir viens pasniedzejs
		/*
		//daudz-pret-viens
		@ManyToOne
		@JoinColumn(name="IdPr")
		private Professor professor;
		*/
		
		//3. vienam kursam ir vairāki psneidzeji
		//daudzi-pret-daudziem
		/*@ManyToMany
		@JoinTable(name="Prof_Course",
		joinColumns=@JoinColumn(name="IdPr"),
		inverseJoinColumns=@JoinColumn(name="IdCo"))
		private Collection<Professor> professors;
		 */
		
		
		
		
		
		
		
}
