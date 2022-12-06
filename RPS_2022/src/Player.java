import java.util.Random;
import java.util.concurrent.Semaphore;

public class Player extends Thread{
	
	String name, jogada;
	String[] opçoes = {"Rock", "Paper", "Scissors"};
	String[] escolha;
	int pontuaçao, rodadas;
	boolean pronto;
	Random random;
	Semaphore semaphore;
		
	public Player(String _name, int _rodadas, Semaphore semaphore)
	{
		this.name = _name;
		this.pontuaçao = 0;
		this.rodadas = _rodadas;
		this.random = new Random();
		this.semaphore = semaphore;
	}
	
		public String play()
	{
		int x = this.random.nextInt(3);	
		this.jogada = opçoes[x];
		return jogada;
	}
		
	public void run() {
		
		try
		{	
			semaphore.acquire();
		}
		
		catch (InterruptedException e) {
			e.printStackTrace();
			}
			
		this.escolha = new String[rodadas];
			
			for(int i = 0; i < rodadas; i++) {
				
				
				this.escolha[i] = this.play();
				this.pronto = true;
			
			}
				semaphore.release();
				
				
			}
	}