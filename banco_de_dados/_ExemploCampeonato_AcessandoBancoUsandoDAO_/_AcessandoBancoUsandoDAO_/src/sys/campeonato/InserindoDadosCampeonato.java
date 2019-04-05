package sys.campeonato;

import java.util.Scanner;

import campeonato.Time;
import dao.TimeDAO;
import dao.TimeImpl;
import dao.JogadorDAO;
import dao.JogadorImpl;
import dao.JogoDAO;
import dao.JogoImpl;

public class InserindoDadosCampeonato {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Scanner dados = new Scanner(System.in);
		TimeDAO timedao = new TimeImpl();
		JogadorDAO jogadordao = new JogadorImpl();
		JogoDAO jogodao = new JogoImpl();
		
		int op; 
		
		while(true){
			
			System.out.println("-------MENU---------");
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir Time");
			System.out.println("2 - Inserir Jogador");		
			System.out.println("3 - Inserir Jogo");
			
			op = dados.nextInt();
			
			switch (op) {
			case 1:
				System.out.println("Digite o codigo do time");
				int cod = dados.nextInt();
				dados = new Scanner(System.in);
				System.out.println("Digite o nome do time");
				String nomeTime = dados.nextLine();
				System.out.println("Digite data fundação do time");
				String datafundacao = dados.nextLine();
				Time t = new Time(cod,nomeTime, datafundacao);
				timedao.salvarTime(t);
				break;
			case 2:
				//Código Inserir jogador
				break;
			case 3:
				//Código Inserir jogo
				break;
			}
			
		}
	}

}
