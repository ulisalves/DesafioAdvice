package one.digitalinovation.lab.padroes.projeto.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinovation.lab.padroes.projeto.spring.model.Pessoa;
import one.digitalinovation.lab.padroes.projeto.spring.model.PessoaRepository;
import one.digitalinovation.lab.padroes.projeto.spring.model.Conselho;
import one.digitalinovation.lab.padroes.projeto.spring.model.ConselhoRepository;
import one.digitalinovation.lab.padroes.projeto.spring.service.PessoaService;
import one.digitalinovation.lab.padroes.projeto.spring.service.ViaAdvice;

import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService{
	
	//Singleton: Injetar os componentes do Spring com @Autowired
	
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private ConselhoRepository conselhoRepository;
	@Autowired
	private ViaAdvice viaAdvice;
	
	//Strategy: implementar os métodos definidos na interface 
	//Facade: abstrair integrações com subsistemas		

	@Override
	public Iterable<Pessoa> buscarTodos() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa buscarPorId(Long id) {
		 Optional <Pessoa> cliente = pessoaRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Pessoa pessoa) {
		salvarPessoa(pessoa);
	}

	@Override
	public void atualizar(Long id, Pessoa pessoa) {
		// Buscar cliente por id
		 Optional <Pessoa> pessoaBd = pessoaRepository.findById(id);
		 if (pessoaBd.isPresent()) {
			 salvarPessoa(pessoa);
		 }
		
	}
	
	@Override
	public void deletar(Long id) {
		// Deletar Cliente por id
		pessoaRepository.deleteById(id);
		
	}
	
	private void salvarPessoa(Pessoa pessoa) {
		//Verificar se o endereço do cliente já existe pelo cep
		String advice = pessoa.getConselho().getAdvice();
		Conselho conselho = conselhoRepository.findById(advice).orElseGet(() -> {
			//caso não existe integrar com o ViaCep e persistir o retorno
			Conselho novoConselho = viaAdvice.consultarConselho(advice);
			conselhoRepository.save(novoConselho);
			return novoConselho;
		});
		pessoa.setConselho(conselho);
		//Inserir cliente
		pessoaRepository.save(pessoa);
	}

}
