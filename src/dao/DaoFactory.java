package dao;

import dao.BandaDao;
import dao.ParticipacaoDao;
import dao.EspetaculoDao;
import dao.impl.*;

public class DaoFactory {

	public static BandaDao criarBanda() {
		return new BandaDaoImpl();
	}
	
	public static ParticipacaoDao criarParticipacao() {
		return new ParticipacaoDaoImpl();
	}
	
	public static EspetaculoDao criarEspetaculo() {
		return new EspetaculoDaoImpl();
	}
	
}
