package servico;

import servico.impl.BandaServicoImpl;
import servico.impl.EspetaculoServicoImpl;
import servico.impl.ParticipacaoServicoImpl;

public class ServicoFactory {

	public static BandaServico criarBandaServico() {
		return new BandaServicoImpl();
	}
	
	public static ParticipacaoServico criarParticipacaoServico() {
		return new ParticipacaoServicoImpl();
	}
	
	public static EspetaculoServico criarEspetaculoServico() {
		return new EspetaculoServicoImpl();
	}
	
}