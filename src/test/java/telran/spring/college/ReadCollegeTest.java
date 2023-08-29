package telran.spring.college;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import telran.spring.college.service.CollegeService;
import telran.spring.college.dto.IdName;
import telran.spring.college.dto.StudentMark;
@SpringBootTest
class ReadCollegeTest {
@Autowired
CollegeService service;
	
	@Test
	@Sql(scripts = {"college-read-test-script.sql"})
	void bestStudentLecturerTest() {
		List<IdName> actual = service.bestStudentsLecturer(321, 2);
		assertEquals(2, actual.size());
		assertEquals(127, actual.get(0).getId());
		assertEquals("Rivka", actual.get(0).getName());
		assertEquals(123, actual.get(1).getId());
		assertEquals("Vasya", actual.get(1).getName());
	}
	@Test
	@Sql(scripts = {"college-read-test-script.sql"})
	void studentsAvgMarksGreaterCollegeAvg() {
		
        List<IdName> actual = service.studentsAvgMarksGreaterCollegeAvg(2); 
        assertEquals(2, actual.size());
		assertEquals(127, actual.get(0).getId());
		assertEquals("Rivka", actual.get(0).getName());
		assertEquals(123, actual.get(1).getId());
		assertEquals("Vasya", actual.get(1).getName());
        
     	}
	@Test
	@Sql(scripts = {"college-read-test-script.sql"})
	void allStudentsAvgMarksTest() {
		List<StudentMark> actual = service.allStudentsAvgMarks();
		assertEquals(5,actual.size());
		assertEquals(127, actual.get(0).getId());
		assertEquals("Rivka", actual.get(0).getName());
		assertEquals(123, actual.get(1).getId());
		assertEquals("Vasya", actual.get(1).getName());
		assertEquals(126, actual.get(4).getId());
		assertEquals("David", actual.get(4).getName());
	}

}