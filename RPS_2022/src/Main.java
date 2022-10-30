import java.util.Scanner;

public class Main {
	
	public static void main(String[]args) 
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Quantidade de Jogadas?");
		int jogadas = console.nextInt();
		
		Player player1 = new Player("Vitinho");
		Player player2 = new Player("Carlão");						
		
		for(int i = 0; i < jogadas; i++) {			
			
			System.out.println("---- Jogada " + (i+1) + " ----");
			System.out.println();
				
				player1.run();
				player2.run();					
			
			if (player1.jogada == player2.jogada)
			{
				 System.out.println("Empate");
			}
			
			else if (player1.jogada == "Rock" && player2.jogada == "Paper") 
			{
					System.out.println(player2.name + " Venceu");
					player2.pontuaçao ++;
			}
			else if (player1.jogada == "Rock" && player2.jogada == "Scissors") 
			{
					System.out.println(player1.name + " Venceu");
					player1.pontuaçao ++;
			}
			
			else if (player1.jogada == "Paper" && player2.jogada == "Scissors") 
			{
					System.out.println(player2.name + " Venceu");
					player2.pontuaçao ++;
			}
			else if (player1.jogada == "Paper" && player2.jogada == "Rock") 
			{
					System.out.println(player1.name + " Venceu");
					player1.pontuaçao ++;
			}
			
			else if (player1.jogada == "Scissors" && player2.jogada == "Rock") 
			{
					System.out.println(player2.name + " Venceu");
					player2.pontuaçao ++;
			}
			else if (player1.jogada == "Scissors" && player2.jogada == "Paper") 
			{
					System.out.println(player1.name + " Venceu");
					player1.pontuaçao ++;
			}
		
			System.out.println();
		}

		System.out.println("--- FIM DE JOGO ---");		
		System.out.println("Pontuação do " + player1.name + ": " + player1.pontuaçao);
		System.out.println("Pontuação do " + player2.name + ": " + player2.pontuaçao);
				
	}
	
}
