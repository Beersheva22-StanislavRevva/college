package telran.spring.college.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import telran.spring.college.dto.IdName;
import telran.spring.college.dto.StudentMark;
import telran.spring.college.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query(value="select sl.id as id, sl.name as name from (select * from students_lecturers where dtype='Student') sl"
			+ " join marks on sl.id=student_id join subjects sbj on subject_id=sbj.id where lecturer_id=:lecturerId"
			+ " group by sl.id order by avg(mark) desc limit :nStudents", nativeQuery = true)
	List<IdName>findBestStudentsLecturer(@Param(value = "lecturerId") long lecturerId,@Param(value = "nStudents") int nStudents);
	
	@Query(value="select sl.id as id, sl.name as name from (select * from students_lecturers where dtype='Student') sl"
			+ " join marks on sl.id=student_id"
			+ " join subjects sbj on subject_id=sbj.id"
			+ " group by sl.id"
			+ " having count(mark) >- :nMarksThreshold"
			+ " and avg(mark) > (select avg(mark) from marks)"
			+ " order by avg(mark) desc", nativeQuery = true)
	List<IdName>findStudentsAvgMarksGreaterCollegeAvg(@Param(value = "nMarksThreshold" ) int nMarksThreshold);
	@Query(value="select sl.id as id, sl.name from (select * from students_lecturers where dtype='Student') sl"
			+ " left join marks on sl.id=student_id"
			+ " group by sl.id order by avg(mark) desc", nativeQuery = true)
	List<StudentMark> getAllStudentsAvgMarks();
}
