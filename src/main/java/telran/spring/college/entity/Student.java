package telran.spring.college.entity;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import lombok.Getter;
import telran.spring.college.dto.PersonDto;

@Entity
@OnDelete(action = OnDeleteAction.CASCADE)
public class Student extends Person {

  public Student() {
    
  }

  private Student(PersonDto person) {
    super(person);
    
  }
  public static Student of(PersonDto person) {
	return new Student(person);
  }
  @Getter
  @OneToMany(mappedBy="student")
	List<Mark> marks;
}