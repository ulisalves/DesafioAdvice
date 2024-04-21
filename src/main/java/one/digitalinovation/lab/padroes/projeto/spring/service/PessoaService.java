package one.digitalinovation.lab.padroes.projeto.spring.service;

import one.digitalinovation.lab.padroes.projeto.spring.model.Pessoa;

public interface PessoaService {
	
	Iterable<Pessoa> buscarTodos();
	
	Pessoa buscarPorId (Long id);
	
	void inserir (Pessoa pessoa);
	
	void atualizar (Long id, Pessoa pessoa);
	
	void deletar (Long id);
	

}
