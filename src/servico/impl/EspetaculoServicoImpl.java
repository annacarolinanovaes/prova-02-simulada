package servico.impl;

import java.util.List;

import dao.DaoFactory;
import dao.impl.EM;

import dao.EspetaculoDao;

import dominio.Espetaculo;
import servico.EspetaculoServico;

public class EspetaculoServicoImpl implements EspetaculoServico {

	private EspetaculoDao dao;
		
		public EspetaculoServicoImpl() {
			dao = DaoFactory.criarEspetaculo();
		}
		
		@Override
		public void inserirAtualizar(Espetaculo x) {
			EM.getLocalEm().getTransaction().begin();
			dao.inserirAtualizar(x);
			EM.getLocalEm().getTransaction().commit();
		}
		
		@Override
		public void excluir(Espetaculo x) {
			EM.getLocalEm().getTransaction().begin();
			dao.excluir(x);
			EM.getLocalEm().getTransaction().commit();
		}
		
		@Override
		public Espetaculo buscar(int codEspetaculo) {
			return dao.buscar(codEspetaculo);
		}
		
		@Override
		public List<Espetaculo> buscarTodos() {
			return dao.buscarTodos();
		}
	
}
