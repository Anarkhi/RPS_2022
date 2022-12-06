import java.util.Scanner;
import java.util.concurrent.Semaphore;


public class Main {
	
	public static void main(String[]args) 
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Quantidade de Jogadas: ");
		int jogadas = console.nextInt();
		
		Thread[] threads = new Thread[3];
		Semaphore semaphore = new Semaphore(1);
		
		Player player1 = new Player("Vitinho", jogadas, semaphore);
		Player player2 = new Player("Carlão", jogadas, semaphore);
		Manager manager = new Manager(player1, player2, jogadas);
		
		threads[0] = player1;
		threads[1] = player2;
		threads[2] = manager;
		
		for (int i = 0; i < threads.length; i++){
			
			threads[i].start();
			
			try {
				threads[i].join();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}			
				
		System.out.println("-=FIM DE JOGO=-");		
		System.out.println("Pontos de " + player1.name + ": " + player1.pontuaçao);
		System.out.println("Pontos de " + player2.name + ": " + player2.pontuaçao);
		
		}
	
	}
