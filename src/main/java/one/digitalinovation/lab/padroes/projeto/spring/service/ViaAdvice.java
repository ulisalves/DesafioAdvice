package one.digitalinovation.lab.padroes.projeto.spring.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import one.digitalinovation.lab.padroes.projeto.spring.model.Conselho;

@FeignClient(name = "advices", url = "https://api.adviceslip.com/")
public interface ViaAdvice {
	
	@GetMapping("/advice/{advice}/")
	Conselho consultarConselho (@PathVariable("advice") String advice);
	
}
