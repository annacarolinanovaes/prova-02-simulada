package dao.impl;

import dao.impl.EM;
//	import dao.impl.EMF;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ParticipacaoDao;
import dominio.Participacao;
//	import dominio.Banda;
//	import dominio.Espetaculo;

public class ParticipacaoDaoImpl implements ParticipacaoDao {

	private EntityManager em;
	
	public ParticipacaoDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Participacao x) {
		if (x.getCodParticipacao() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}
	
	@Override
	public void excluir(Participacao x) {
		x = em.merge(x);
		em.remove(x);
	}
	
	@Override
	public Participacao buscar(int codParticipacao) {
		return em.find(Participacao.class, codParticipacao);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Participacao> buscarTodos() {
		String jpql = "SELECT x FROM Participacao x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
}
