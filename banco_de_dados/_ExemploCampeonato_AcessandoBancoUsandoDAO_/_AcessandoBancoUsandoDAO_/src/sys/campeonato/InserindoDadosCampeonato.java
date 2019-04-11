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
		
		List jogos = new ArrayList();
		List jogadores = new ArrayList();
		List times = new ArrayList();
		
		int op = 0; int cod=0; 
		
		while(true){
			
			System.out.println("-------MENU---------");
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir Time");
			System.out.println("2 - Inserir Jogador");		
			System.out.println("3 - Inserir Jogo");
			System.out.println("4 - Listar os jogos");
			System.out.println("5 - Listar os jogadores");
			System.out.println("6 - Listar os times");
			System.out.println("7 - Deletar time");
			System.out.println("8 - Deletar jogador");
			System.out.println("9 - Deletar jogo");
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
			case 5: 
				Jogador jogador2;
				jogadores = jogadordao.listarTodosJogadores();
				for (int i=0; i<jogadores.size(); i++) {
					jogador2 = (Jogador) jogadores.get(i);
					System.out.println("codigo:" + jogador2.getCod());
					System.out.println("nome:" + jogador2.getNome());
					System.out.println("idade:" + jogador2.getIdade());
					System.out.println("time_cod:" + jogador2.getTime_cod());
					System.out.println("-----------------------");
				}
				break;
			case 6:
				Time time;
				times = timedao.listarTodosTimes();
				break;
			case 7: 
				System.out.println("Digite o código do time:");
				cod = dados.nextInt();
				time = timedao.verTimePorCodigo(cod);
				timedao.deletarTime(time);
				break;
			case 8: 
				System.out.println("Digite o código do jogador:");
				cod = dados.nextInt();
				jogador = jogadordao.verJogadorPorCodigo(cod);
				jogadordao.deletarJogador(jogador);
				break;
			case 9:
				System.out.println("Digite o código do jogo:");
				cod = dados.nextInt();
				jogo = jogodao.verJogoPorCodigo(cod);
				jogodao.deletarJogo(jogo);
				break;
			default:
				break;
			}
			
		}
	}

}
