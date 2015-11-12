package aplicacao;

import java.util.List;
import java.util.Scanner;

import dominio.Banda;
import dominio.Espetaculo;
import dominio.Participacao;
import servico.BandaServico;
import servico.EspetaculoServico;
import servico.ParticipacaoServico;
import servico.ServicoFactory;

public class Questao02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int op = 0;
		EspetaculoServico es;
		BandaServico bs;
		ParticipacaoServico ps;

		do {
			
			System.out.println("1 - Cadastrar espet�culo e participa��es nele");
			System.out.println("2 - Mostrar os dados de um espet�culo");
			System.out.println("3 - Sair");
			System.out.println("Digite uma op��o: ");
			op = Integer.parseInt(sc.nextLine());
			
			switch (op) {
			case 1:
				System.out.println("Digite o nome do espet�culo a ser cadastrado: ");
				String nome = sc.nextLine();
				Espetaculo esp = new Espetaculo(null, nome);
				es = ServicoFactory.criarEspetaculoServico();
				es.inserirAtualizar(esp);
				
				System.out.println("\nQuantas participa��es este espet�culo vai ter? ");
				int N = Integer.parseInt(sc.nextLine());
				
				bs = ServicoFactory.criarBandaServico();
				List<Banda> listaBandas = bs.buscarTodos();
				System.out.println("\nBandas existentes:");
				for (Banda x : listaBandas) {
					System.out.println(x);
				}
				
				ps = ServicoFactory.criarParticipacaoServico();
				
				for (int i=1; i<=N; i++) {
					System.out.println("Digite o c�digo da "+i+"a. banda do espet�culo: ");
					int cod = Integer.parseInt(sc.nextLine());
					Banda banda = bs.buscar(cod);
					Participacao part = new Participacao(null, i, banda, esp);
					ps.inserirAtualizar(part);
				}
				
				break;
			case 2:
				System.out.println("Digite o c�digo do espet�culo a ser buscado: ");
				int codEsp = Integer.parseInt(sc.nextLine());
				es = ServicoFactory.criarEspetaculoServico();
				Espetaculo espetaculo = es.buscar(codEsp);

				if (espetaculo == null) {
					System.out.println("C�digo inexistente!");
				}
				else {
					System.out.println("Nome: " + espetaculo.getNome());
					System.out.println("Pre�o total: R$ " + espetaculo.precoTotal());
					System.out.println("Participa��es: ");
					for (Participacao x : espetaculo.getParticipacoes()) {
						System.out.println(x.getOrdem()+": "+x.getBanda().getNome());
					}
				}
				
				break;
				
			case 3:
				System.out.println("Fim do programa!");
				
			default: 
				System.out.println("Op��o inv�lida!");
			}
		} while (op != 3);
		
		sc.close();
	}

}
