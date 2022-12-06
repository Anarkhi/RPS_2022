
public class Manager extends Thread{

	int jogadas;
	Player player1, player2;
	
	public Manager (Player _player1, Player _player2, int _jogadas)
	{
		jogadas = _jogadas;
		player1 = _player1;
		player2 = _player2;
	}
	
	public void run() {
		
		for (int i = 0; i < jogadas; i++)
		{
			match(i);
		}
		
	}
	public void match (int r)
	{
		System.out.println("---- Jogada " + (r+1) + " ----");
		System.out.println();
		System.out.println(player1.name + " escolheu " + player1.escolha[r]);
		System.out.println();
		System.out.println(player2.name + " escolheu " + player2.escolha[r]);
		System.out.println();
		
		if (player1.escolha[r] == player2.escolha[r])
		{
			 System.out.println("Empate");
		}
		
		else if (player1.escolha[r] == player1.opçoes[0]) 
		{
			if(player2.escolha[r] == player2.opçoes[2]) {
				System.out.println(player1.name + " Venceu");
				player1.pontuaçao ++;
			}
			else {
				System.out.println(player2.name + " Venceu");
				player2.pontuaçao ++;
			}
		}
		
		else if (player1.escolha[r] == player1.opçoes[1]) 
		{
			if(player2.escolha[r] == player2.opçoes[0]) {
				System.out.println(player1.name + " Venceu");
				player1.pontuaçao ++;
			}
			else {
				System.out.println(player2.name + " Venceu");
				player2.pontuaçao ++;
			}
		}
		
		else if (player1.escolha[r] == player1.opçoes[2]) 
		{
			if(player2.escolha[r] == player2.opçoes[1]) {
				System.out.println(player1.name + " Venceu");
				player1.pontuaçao ++;
			}
			else {
				System.out.println(player2.name + " Venceu");
				player2.pontuaçao ++;
			}
		}
	
		System.out.println();
	}

}
