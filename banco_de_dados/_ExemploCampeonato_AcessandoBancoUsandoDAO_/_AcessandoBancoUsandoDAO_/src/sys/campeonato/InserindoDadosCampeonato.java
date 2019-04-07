package sys.campeonato;

import java.util.Scanner;
import campeonato.*;
import dao.*;
import java.util.List;
import java.util.ArrayList;

public class InserindoDadosCampeonato {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Scanner dados = new Scanner(System.in);
		TimeDAO timedao = new TimeImpl();
		JogadorDAO jogadordao = new JogadorImpl();
		JogoDAO jogodao = new JogoImpl();
		
		int op = 0; int cod=0; 
		
		while(true){
			
			System.out.println("-------MENU---------");
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir Time");
			System.out.println("2 - Inserir Jogador");		
			System.out.println("3 - Inserir Jogo");
			System.out.println("4 - Listar os jogos");
			
			op = dados.nextInt();
			
			switch (op) {
			case 0: 
				break;
			case 1:
				System.out.println("Digite o código do time");
				cod = dados.nextInt();
				dados.nextLine();
				dados = new Scanner(System.in);
				System.out.println("Digite o nome do time");
				String nomeTime = dados.nextLine();
				System.out.println("Digite data fundação do time");
				String datafundacao = dados.nextLine();
				Time t = new Time(cod,nomeTime,datafundacao);
				timedao.salvarTime(t);
				break;
			case 2:
				System.out.println("Digite o código do jogador");
				cod = dados.nextInt();
				dados.nextLine();
				System.out.println("Digite o nome do jogador");
				String nomeJogador = dados.nextLine();
				System.out.println("Digite a idade do jogador");
				int idadeJogador = dados.nextInt();
				System.out.println("Digite o código do time");
				int codTime = dados.nextInt();
				Jogador jogador = new Jogador (cod, nomeJogador, idadeJogador, codTime);
				jogadordao.salvarJogador(jogador);
				break;
			case 3:
				System.out.println("Digite o codigo do jogo");
				cod = dados.nextInt();
				dados.nextLine();
				System.out.println("Digite o codigo do primeiro time");
				int codTimeA = dados.nextInt();
				System.out.println("Digite o codigo do segundo time");
				int codTimeB = dados.nextInt();
				dados.nextLine();
				System.out.println("Digite o resultado do jogo");
				String resultado = dados.nextLine();
				Jogo jogo = new Jogo (cod, codTimeA, codTimeB, resultado);
				jogodao.salvarJogo(jogo);
				break;
			case 4:
				List jogos = new ArrayList();
				Jogo jogo2;
				jogos = jogodao.listarTodosJogos();
				for (int i=0; i<jogos.size(); i++){
					jogo2 = (Jogo) jogos.get(i);
					System.out.println("codigo:" + jogo2.getCod());
					System.out.println("timea_cod:" + jogo2.getTimea_cod());
					System.out.println("timeb_cod:" + jogo2.getTimeb_cod());
					System.out.println("resultado:" + jogo2.getResultado());
					System.out.println("-----------------------");
				}
				break;
			default:
				break;
			}
			
		}
	}

}
