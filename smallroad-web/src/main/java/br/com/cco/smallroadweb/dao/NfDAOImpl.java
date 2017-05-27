package br.com.cco.smallroadweb.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cco.smallroadweb.entity.Nf;
import br.com.cco.smallroadweb.entity.Roteiro;
import br.com.cco.smallroadweb.grafo.Rota;
import br.com.cco.smallroadweb.service.RotaService;

@Repository
public class NfDAOImpl implements NfDAO {

	// injeta a fabrica de seção
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private RotaService rotaService;

	@Override
	public List<Nf> getNfs() {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<Nf> consulta = currentSession.createQuery("from Nf order by numero", Nf.class);
		List<Nf> nfs = consulta.getResultList();
		return nfs;

	}

	@Override
	public void saveNf(Nf nf) {
		Session currentSession = sessionFactory.getCurrentSession();
		// saveDistancia(nf);
		currentSession.saveOrUpdate(nf);
	}

	@Override
	public void saveDistancia(Nf nf) {

		Session currentSession = sessionFactory.getCurrentSession();
		Rota request = new Rota();
		String origins = nf.getEndOrigem();
		String destinations = nf.getEndDestino();
		String retorno = "xml";

		String url_request = "https://maps.googleapis.com/maps/api/distancematrix/" + retorno + "?origins=" + origins
				+ "&destinations=" + destinations + "&mode=driving" + "&language=pt-BR" + "&key="
				+ request.getApiKey1();

		String xml;
		try {
			xml = rotaService.run(url_request);
			String tagValue = rotaService.getTagValue("distance", xml);
			String distanciaText = rotaService.getTagValue("text", tagValue);
			String distanciaString = distanciaText.replaceAll("km", "").replaceAll(",", ".").trim();
			BigDecimal distancia = new BigDecimal(distanciaString);
			request.setDistancia(distancia);
			nf.setDistancia(request.getDistancia());
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	@Override
	public Nf getNf(Integer numero) {
		Session currentSession = sessionFactory.getCurrentSession();
		Nf nf = currentSession.get(Nf.class, numero);
		return nf;

	}

	public Nf getNfByNumero(Integer numeroProcurado) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Nf> consulta = currentSession.createQuery("from Nf where numero = :numero", Nf.class);
		consulta.setParameter("numero", numeroProcurado);
		Nf nf = consulta.getSingleResult();
		return nf;

	}

	@Override
	public void deleteNf(Integer nfNumero) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query consulta = currentSession.createQuery("delete from Nf where numero=:nfNumero");
		consulta.setParameter("nfNumero", nfNumero);

		consulta.executeUpdate();

	}

	@Override
	public void deleteNfByNumero(Integer nfNumero) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query consulta = currentSession.createQuery("delete from nf where numero=:nfnumero");
		consulta.setParameter("nfnumero", nfNumero);

		consulta.executeUpdate();

	}

	@Override
	public List<Nf> procuraNfsByNumero(Integer numeroProcurado) {
		// pega a seção atual do hibernate
		Session currentSession = sessionFactory.getCurrentSession();

		Query consulta = null;

		//
		// so procura pelo nome se nao for nullo ou vazio
		//
		if (numeroProcurado != null) {

			// procura pelo nome ... caso insensitive
			consulta = currentSession.createQuery("from Nf where numero = :numeroProcurado ", Nf.class);
			consulta.setParameter("numeroProcurado", numeroProcurado);
			System.out.println(numeroProcurado);

		} else {
			// se o nome for vazio, traga todos os usuarios
			consulta = currentSession.createQuery("from Nf", Nf.class);
		}

		// executa a consulta e guarda na lista
		List<Nf> nfs = consulta.getResultList();

		// retorna o resultado
		return nfs;
	}

	@Override
	public List<Nf> listaNotaSemRoteiro() {
		Session session = sessionFactory.getCurrentSession();
		Query<Nf> consulta = session.createQuery("from Nf where roteiro is null");
		List<Nf> nfs = consulta.getResultList();
		return nfs;

	}

	@Override
	public void addRoteiroOnNf(Roteiro roteiro) {
		Session session = sessionFactory.getCurrentSession();
		Query consulta = session.createQuery("From Nf where Roteiro=:roteiro");
		consulta.setParameter("Roteiro", roteiro);

		consulta.executeUpdate();

	}

}
