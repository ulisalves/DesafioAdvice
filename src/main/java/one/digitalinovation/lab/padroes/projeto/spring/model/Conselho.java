package one.digitalinovation.lab.padroes.projeto.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Conselho {
	
	@Id
	private String advice;

	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}


}
