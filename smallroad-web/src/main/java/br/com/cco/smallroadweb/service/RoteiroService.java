package br.com.cco.smallroadweb.service;

import java.util.List;

import br.com.cco.smallroadweb.entity.Roteiro;

public interface RoteiroService {

	public void cadastrarRoteiro(Roteiro roteiro);

	public List<Roteiro> getRoteiros();

	public Roteiro getRoteiroByid(Integer id);

}
