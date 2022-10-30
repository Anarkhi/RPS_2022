import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Player extends Thread{
	
	String name, jogada;
	String[] opçoes = {"Rock", "Paper", "Scissors"};
	int pontuaçao;
	Random random;
	static Semaphore semaphore = new Semaphore(1);
	private ReentrantLock mutex = new ReentrantLock();
	
	public Player(String _name)
	{
		this.name = _name;
		this.pontuaçao = 0;
		//this.random = new Random(System.currentTimeMillis());
	}
	
		public String play() {
		int x = this.random.nextInt(3);	
		this.jogada = opçoes[x];
		System.out.println("Jogada de " + this.name + ": " + this.jogada);
		return jogada;
	}
		
	public void run() {
		
		mutex.lock();
		this.random = new Random(System.currentTimeMillis());
		mutex.unlock();
		try
		{	
			semaphore.acquire();
						
			System.out.println("Vez de: " + this.name);
			
			try
				{
					this.play();
					System.out.println();
					Thread.sleep(1000);			
				}
			
			finally
			{
				semaphore.release();
			}
			
		}
		catch (InterruptedException e) {e.printStackTrace();}		
	}
}
