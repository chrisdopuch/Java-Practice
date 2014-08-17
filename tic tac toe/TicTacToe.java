public class TicTacToe{

	public int solve( int[][] array ) {

		int previous = -1;
		int current = 0;

		// check each column
		for ( int col = 0; col < array[0].length; col++ ) {
			for ( int row = 0; row < array.length; row++ ) {

				current = array[row][col];

				if ( previous == -1 ) {
					previous = current;
					continue;
				}

				if ( current != previous ) {
					break;
				} 

				previous = current;

				if ( current == 0 ) {
					break;
				}

				if ( row == array.length - 1 ) {
					return current;
				}

			}

			previous = -1;
			current = 0;

		}

		previous = -1;
		current = 0;

		// check each row
		for ( int row = 0; row < array.length; row++ ) {
			for ( int col = 0; col < array[0].length; col++ ) {

				current = array[row][col];

				if ( previous == -1 ) {
					previous = current;
					continue;
				}

				if ( current != previous ) {
					break;
				} 

				previous = current;

				if ( current == 0 ) {
					break;
				}

				if ( row == array.length - 1 ) {
					return current;
				}

			}

			previous = -1;
			current = 0;

		}

		previous = -1;
		current = 0;

		// check diagonals
		for ( int i = 0; i < array.length; i++ ) {
			current = array[i][i];

			if ( previous == -1 ) {
				previous = current;
				continue;
			}

			if ( current != previous ) {
				break;
			} 

			previous = current;

			if ( current == 0 ) {
				break;
			}

			if ( i == array.length - 1 ) {
				return current;
			}		
		}

		int j;
		previous = -1;
		current = 0;

		for ( int i = 0; i < array.length; i++ ) {

			j = Math.abs( i - 2 );

			current = array[i][j];

			if ( previous == -1 ) {
				previous = current;
				continue;
			}

			if ( current != previous ) {
				break;
			} 
			
			previous = current;

			if ( current == 0 ) {
				break;
			}

			if ( i == array.length - 1 ) {
				return current;
			}		
		}


		// no winner
		return 0;
	}

	public static void main( String[] args ) {

		TicTacToe game = new TicTacToe();

		int[][] board = new int[][]{ 
			{1, 2, 2},
			{1, 1, 2},
			{2, 0, 1}
		};

		System.out.println( game.solve(board) );

	}

}