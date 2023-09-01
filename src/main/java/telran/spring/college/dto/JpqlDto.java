package telran.spring.college.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class JpqlDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String query;
}
