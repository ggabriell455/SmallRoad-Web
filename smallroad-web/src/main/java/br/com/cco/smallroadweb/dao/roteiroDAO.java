package br.com.cco.smallroadweb.dao;

import java.util.List;

import br.com.cco.smallroadweb.entity.Roteiro;

public interface roteiroDAO {

	public void cadastrarRoteiro(Roteiro roteiro);

	public void deletarRoteiro(Integer ids);

	public List<Roteiro> getRoteiros();

	public Roteiro getRoteiroByid(Integer id);

	public List<Roteiro> getRoteirosNaoFinalizados();

	public List<Roteiro> getRoteiroByNome(String nome);



}
