package telran.spring.college.service;

import telran.spring.college.dto.*;

public interface CollegeService {
PersonDto addStudent(PersonDto person);
PersonDto addLecturer(PersonDto person);
SubjectDto addSubject(SubjectDto subject);
MarkDto addMark(MarkDto mark);
}
