package br.com.cco.smallroadweb.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "roteiro")
public class Roteiro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@OneToMany(mappedBy = "roteiro", cascade = CascadeType.REMOVE)
	private List<Nf> nfs;
	
	@Column(name="finalizado")
	private String finalizado;
	
	public List<Nf> getNfs() {
		return nfs;
	}

	public void setNfs(List<Nf> nfs) {
		this.nfs = nfs;
	}

	public Roteiro() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(String finalizado) {
		this.finalizado = finalizado;
	}

	@Override
	public String toString() {
		return "Roteiro [id=" + id + ", nome=" + nome + ", nfs=" + nfs + ", finalizado=" + finalizado + "]";
	}
	
	



}
