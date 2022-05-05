package lv.venta.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
