package one.digitalinovation.lab.padroes.projeto.spring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConselhoRepository extends CrudRepository<Conselho, String>{

}
