import java.util.Scanner;

public class Knight 
{
	Scanner keyboard = new Scanner(System.in);
	public static final int TOP_ROW = 0;
	public static final int BOT_ROW = 7;
	public static final int LEFT_COL = 0;
	public static final int RIGHT_COL = 7;
	
	static int[][] pixMatrix = new int[BOT_ROW + 1][RIGHT_COL + 1];
	
	public static void main (String[] args)
	{
		Knight game = new Knight();
		System.out.println("Start with Knight Tour: ");
		game.fillKnightMove(pixMatrix, 0, 0, 1);
	}
	
	public void fillKnightMove(int[][] pixel, int row, int col, int nextMove)
	{
		
		if (pixel[row][col] != 0)
			return;
		pixel[row][col] = nextMove;
		
		if (nextMove==64)
		{
			this.printOutput();
			keyboard.nextLine();
		}
		
		nextMove++;
		
		if (row < BOT_ROW && col+1 < RIGHT_COL && pixel[row+1][col+2]==0)
			this.fillKnightMove(pixMatrix, row+1, col+2, nextMove);
		
		if (row +1 < BOT_ROW && col < RIGHT_COL && pixel[row+2][col+1]==0)
			this.fillKnightMove(pixMatrix, row+2, col+1, nextMove);
		
		if (row +1 < BOT_ROW && col > LEFT_COL && pixel[row+2][col-1]==0)
			this.fillKnightMove(pixMatrix, row+2, col-1, nextMove);
		
		if (row < BOT_ROW && col -1 > LEFT_COL && pixel[row+1][col-2]==0)
			this.fillKnightMove(pixMatrix, row+1, col-2, nextMove);
		
		if (row > TOP_ROW && col - 1 > LEFT_COL && pixel[row-1][col-2]==0)
			this.fillKnightMove(pixMatrix, row-1, col-2, nextMove);
		
		if (row-2 >= TOP_ROW  && col-1 >= LEFT_COL)
			if (pixel[row-2][col-1]==0)
		{
			this.fillKnightMove(pixMatrix, row-2, col-1, nextMove);
		}
		
		if (row -1 >TOP_ROW && col < RIGHT_COL && pixel[row-2][col+1]==0)
			this.fillKnightMove(pixMatrix, row-2, col+1, nextMove);
		
		if (row > TOP_ROW && col+1 < RIGHT_COL && pixel[row-1][col+2]==0)
			this.fillKnightMove(pixMatrix, row-1, col+2, nextMove);
		
		pixel[row][col] = 0;
		nextMove--;
			
	}
	public void printOutput()
	{
		System.out.println("The result is: ");
		System.out.println(this);
	}
	
	public String toString()
	{
		String answer = "";
		for (int i=0; i<= BOT_ROW; i++)
		{
			for (int j=0; j<=RIGHT_COL; j++)
			{
				if (pixMatrix[i][j]>9)
					answer = answer + "  " + pixMatrix[i][j] + " ";
				else
					answer = answer + "  " + pixMatrix[i][j] + "  ";
			}
			answer = answer + "\n\n";
		}
		return answer;
	}
	
	

}
