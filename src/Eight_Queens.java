/**
 * Erick Williams
 * Lab Assignment 3- "8 Queens"
 * 2/15/16
 * This program finds spaces on an 8x8 chess board where 8 queens may be placed without endangering one another.
 */
public class Eight_Queens 
{

	public static void main(String[] args) 
	{
		int[] ray = new int[8];
		solve(0, ray);

	}
/**
 * solve
 * @param row - index of a row
 * @param array - array of possible positions
 * This method determines whether or not placing a queen at a position will endanger it or other queens.
 */
	public static void solve(int row, int[] array) 
	{
		for (int i = 0; i < 8; i++) 
		{
			if (validate(array, row, i)) 
			{
				array[row] = i;
				if (row != 7) 
				{
					solve(row + 1, array);
					
				} 
				else 
				{
					printBoard(array);
					System.exit(1);
				}
			}
		}
	}
/**
 * validate
 * @param array - array of possible positions
 * @param row - current row being checked
 * @param n - space that, if it holds a queen, is invalid
 * @return boolean showing whether a position is valid or not
 * This method checks to see whether or not a queen CAN be placed in a position.
 */
	public static boolean validate(int[] array, int row, int n) 
	{
		for (int i = 0; i < row; i++) 
		{
			int queen = array[i];
			if (queen == n) 
			{
				return false;
			} 
			else if (queen + (row - i) == n) 
			{
				return false;
			} 
			else if (queen - (row - i) == n) 
			{
				return false;
			}
		}
		return true;
	}
/**
 * printBoard
 * @param array - array of 'x' and 'q' to be printed
 * This method prints the "chess board", placing Q's where the queens should go and X's where the spaces are blank.
 */
	public static void printBoard(int[] array) 
	{
		for (int i = 0; i < 8; i++) 
		{
			for (int j = 0; j < 8; j++) 
			{
				if (j == array[i]) 
				{
					System.out.print("Q");
				} 
				else 
				{
					System.out.print("X");
				}
			}
			System.out.println();
		}
	}
}
