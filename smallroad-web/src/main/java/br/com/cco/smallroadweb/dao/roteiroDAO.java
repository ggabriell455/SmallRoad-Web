package br.com.cco.smallroadweb.dao;

import java.util.List;

import br.com.cco.smallroadweb.entity.Nf;
import br.com.cco.smallroadweb.entity.Roteiro;

public interface roteiroDAO {

	public void cadastrarRoteiro(Roteiro roteiro);

	public void deletarRoteiro(Integer ids);

	public List<Roteiro> getRoteiros();

	public void pesquisarRoteiroById(Integer id);

	public Roteiro getRoteiroByid(Integer id);



}
