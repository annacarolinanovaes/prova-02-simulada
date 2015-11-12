package aplicacao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import dominio.Banda;
import servico.BandaServico;
import servico.ServicoFactory;

public class Questao03 {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite um preço mínimo de banda: ");
		BigDecimal min = new BigDecimal(sc.nextLine());
		System.out.println("Digite um preço máximo de banda: ");
		BigDecimal max = new BigDecimal(sc.nextLine());
		
		BandaServico bs = ServicoFactory.criarBandaServico();
		
		List<Banda> lista = bs.bandasPorFaixaDePreco(min, max);
		
		System.out.println("Bandas na faixa de preço informada: ");
		for (Banda b : lista) {
			System.out.println(b);
		}
		
		sc.close();
	}
}
