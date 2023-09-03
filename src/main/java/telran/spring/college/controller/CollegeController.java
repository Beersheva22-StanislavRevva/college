package telran.spring.college.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import telran.spring.college.dto.JpqlDto;
import telran.spring.college.service.CollegeService;

@RestController
@RequestMapping("college")
@AllArgsConstructor
@CrossOrigin
@Slf4j

public class CollegeController {
	
CollegeService service;

@PostMapping
public List<String> jpqlQuery(@RequestBody @Valid JpqlDto jpqlQuery) {
	List<String> res = null;
	try {
	 res = service.jpqlQuery(jpqlQuery);
	} catch (Exception e) {
		log.error("Unnable to perfom query - " + jpqlQuery.getQuery(),  e);
		throw new IllegalStateException(e.getMessage());
	}
	return res;
}

@PostConstruct
void init() {
	log.info("context restored");
}
	
@PreDestroy
void shutDown() {
	log.info("context closed");
}
}
