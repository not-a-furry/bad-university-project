/**
 * The class <b>TicTacToeGame</b> is the
 * class that implements the Tic Tac Toe Game.
 * It contains the grid and tracks its progress.
 * It automatically maintain the current state of
 * the game as players are making moves.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class TicTacToeGame {

// FINISH THE VARIABLE DECLARATION
   /**
	* The board of the game, stored as a one dimension array.
	*/
	
	private CellValue[] board;

   /**
	* level records the number of rounds that have been
	* played so far. 
	*/
	
	private int level;

   /**
	* gameState records the current state of the game.
	*/
	
	private GameState gameState;


   /**
	* lines is the number of lines in the grid
	*/
	
	private int lines;

   /**
	* columns is the number of columns in the grid
	*/
	
	private int columns;


   /**
	* sizeWin is the number of cell of the same type
	* that must be aligned to win the game
	*/
	
	private int sizeWin;


   /**
	* default constructor, for a game of 3x3, which must
	* align 3 cells
	*/
	
	public TicTacToeGame(){

		// YOUR CODE HERE 
		
		this.lines = 3;
		this.columns = 3; //maybe need to make lines = 3 and columns = 3?
		this.sizeWin = 3;
		level = 0;
		gameState = GameState.PLAYING;
		
		board = new CellValue[9];
        
        for(int i = 0; i < board.length; i++){
		
            board[i] = CellValue.EMPTY;
        
        }
        
	}

   /**
	* constructor allowing to specify the number of lines
	* and the number of columns for the game. 3 cells must
	* be aligned.
   	* @param lines
    *  the number of lines in the game
    * @param columns
    *  the number of columns in the game
  	*/
  	
	public TicTacToeGame(int lines, int columns){

		// YOUR CODE HERE 
		
		this.lines = lines;
		this.columns = columns;
		this.sizeWin = 3;
		level = 0;
		gameState = GameState.PLAYING;
		
		board = new CellValue[lines*columns];
		
        for(int i = 0; i < board.length; i++){
		
            board[i] = CellValue.EMPTY;
        
        }
        
	}

   /**
	* constructor allowing to specify the number of lines
	* and the number of columns for the game, as well as 
	* the number of cells that must be aligned to win.
   	* @param lines
    *  the number of lines in the game
    * @param columns
    *  the number of columns in the game
    * @param sizeWin
    *  the number of cells that must be aligned to win.
  	*/
  	
	public TicTacToeGame(int lines, int columns, int sizeWin){

		// YOUR CODE HERE 
		
		this.lines = lines;
		this.columns = columns;
		this.sizeWin = sizeWin;
		level = 0;
		gameState = GameState.PLAYING;
		
		board = new CellValue[lines*columns];
		
		for(int i = 0; i < board.length; i++){
		
            board[i] = CellValue.EMPTY;
        
        }
        
	}

   /**
	* getter for the variable lines
	* @return
	* 	the value of lines
	*/
	
	public int getLines(){

		return this.lines;

	}

   /**
	* getter for the variable columns
	* @return
	* 	the value of columns
	*/
	
	public int getColumns(){

		// YOUR CODE HERE 
		
		return this.columns;

	}

   /**
	* getter for the variable level
	* @return
	* 	the value of level
	*/
	public int getLevel(){

		// YOUR CODE HERE 
		
		return level;

	}

  	/**
	* getter for the variable sizeWin
	* @return
	* 	the value of sizeWin
	*/
	public int getSizeWin(){

		// YOUR CODE HERE 

		return this.sizeWin;
		
	}

   /**
	* getter for the variable gameState
	* @return
	* 	the value of gameState
	*/
	public GameState getGameState(){

		// YOUR CODE HERE 

		return gameState;
		
	}

   /**
	* returns the cellValue that is expected next,
	* in other word, which played (X or O) should 
	* play next.
	* This method does not modify the state of the
	* game.
	* @return 
    *  the value of the enum CellValue corresponding
    * to the next expected value.
  	*/
	public CellValue nextCellValue(){

		// YOUR CODE HERE 
		
		if(level%2 == 0){
		
            return CellValue.X;
        
        }
        
        
        else{
        
            return CelValue.O;
		
		}

	}

   /**
	* returns the value  of the cell at
	* index i.
	* If the index is invalid, an error message is
	* printed out. The behaviour is then unspecified
   	* @param i
    *  the index of the cell in the array board
    * @return 
    *  the value at index i in the variable board.
  	*/
  	
	public CellValue valueAt(int i) {

		// YOUR CODE HERE 
		
		if(i < board.length){
            
            return board[i];
            
        }
        
        else{
            
            System.out.println("index out of range");
            return null;
            
        }
            
            
    }

   /**
	* This method is called when the next move has been
	* decided by the next player. It receives the index
	* of the cell to play as parameter.
	* If the index is invalid, an error message is
	* printed out. The behaviour is then unspecified
	* If the chosen cell is not empty, an error message is
	* printed out. The behaviour is then unspecified
	* If the move is valid, the board is updated, as well
	* as the state of the game.
	* To faciliate testing, is is acceptable to keep playing
	* after a game is already won. If that is the case, the
	* a message should be printed out and the move recorded. 
	* the  winner of the game is the player who won first
   	* @param i
    *  the index of the cell in the array board that has been 
    * selected by the next player
  	*/
  	
	public void play(int i) {

		// YOUR CODE HERE 
		
        int index;
		index = i - 1; //due to the given index starting at 1, it is subtracted by one to match that of the array
        
        if(valueAt(index) == null){
            
            //the valueAt call should automatically print the error message
            
        }
        
        if(!valueAt(index) == CellValue.EMPTY){
            
            System.out.println("invalid cell, pick another");
            
        }
            
        else{
                
            level++;
            
            CellValue x_or_o;
            x_or_o = new nextCellValue(); 
            
            board[index] = x_or_o;
            
            
            
            if(!gameState == GameState.PLAYING){
                
                System.out.println("the game has already been won/tied"); //remove this later as games should still be played after winning
                
            }
            
            else{
            
                int win;
                win = 1;
                
                CellValue winning_player; //this variable is redundant as x_or_o exists

                for(int x=0; x < board.length && win < this.sizeWin ;x++){ //horizontal
                    
                    if (x %% this.lines == 0){ //to prevent "hopping lines"
                    
                        win = 1;
                        
                    }
                    
                    if(!winningplayer == board[x]){
                    
                        winningplayer = board[x];
                        win = 1;
                        
                    }
                    
                    if(winning_player == board[x]){
                        
                        win++;
                    
                    }
                    
                }
                
                win = 1;
                
                for(int x=0; x < this.lines && win < this.sizeWin ;x++){ //vertical
                    
                    for(int y=0; y < this.columns | win < this.sizeWin ; y++){
                    
                        int cell_index = (y*this.lines) + x;
                        
                        if (!winning_player == board[cell_index]){
                            
                            winning_player = board[cell_index];
                            win = 1;
                            
                        }
                        
                        if(winning_player == board[cell_index]){
                        
                            win++;
                            
                        }
                        
                    }
                    
                }
                    
                //diagonal - index search
                
                int a = 1;
                win = 1;
                winning_player = board[index]; //since the loop will not start at the beginning index point
                
                while((index-((a*this.columns)+a)) >= 0 && (index-((a*this.columns)+a)) < board.length && win < this.sizeWin){
                    
                    int cell_index = (index - ((a * this.columns) + a);
                    a++;
                    
                    if (!winning_player == board[cell_index]){
                        
                        winning_player = board[cell_index];
                        win = 1;
                        
                    }
                    
                    if (winning_player == board[cell_index]){
                    
                        win++;
                    
                    }

                }
                
                a = 1 //win not reset since these two are on same diagonal
                winning_player = board[index];
                
                while((index+((a*this.columns)+a)) >= 0 && (index+((a*this.columns)+a)) < board.length && win < this.sizeWin){
                    
                    int cell_index = (index + ((a * this.columns) + a);
                    a++;
                    
                    if (!winning_player == board[cell_index]){
                        
                        winning_player = board[cell_index];
                        win = 1;
                        
                    }
                    
                    if (winning_player == board[cell_index]){
                    
                        win++;
                    
                    }

                }

                a = 1;
                win = 1; //new diagonal
                winning_player = board[index];
                
                while((index+((a*this.columns)-a)) >= 0 && (index+((a*this.columns)-a)) < board.length && win < this.sizeWin){
                    
                    int cell_index = (index + ((a * this.columns) - a);
                    a++;
                    
                    if (!winning_player == board[cell_index]){
                        
                        winning_player = board[cell_index];
                        win = 0;
                        
                    }
                    
                    if (winning_player == board[cell_index]){
                    
                        win++;
                    
                    }

                }
                
                a = 1;
                winning_player = board[index];
                
                while((index-((a*this.columns)-a)) >= 0 && (index-((a*this.columns)-a)) < board.length && win < this.sizeWin){
                    
                    int cell_index = (index - ((a * this.columns) - a);
                    a++;
                    
                    if (!winning_player == board[cell_index]){
                        
                        winning_player = board[cell_index];
                        win = 0;
                        
                    }
                    
                    if (winning_player == board[cell_index]){
                    
                        win++;
                    
                    }

                }
             
            if(win == this.sizeWin){
            
                if winning_player == CellValue.X{
                    
                    gameState = GameState.XWIN;
                
                }
                
                else{
                    
                    gameState = GameState.OWIN;
                
                }
            
            }
            
            int tie = 0
            
            for(int x=0;x<board.length;x++){ //tie condition
            
                if(!board[x] == EMPTY){
                
                    tie++;
                }
            
            if(tie == board.length){
                
                gameState = GameState.TIE;
                
                }
        
        
                
                        
        }
        
        }
        
    }
        
        


   /**
	* A helper method which updates the gameState variable
	* correctly after the cell at index i was just set in
	* the method play(int i)
	* The method assumes that prior to setting the cell
	* at index i, the gameState variable was correctly set.
	* it also assumes that it is only called if the game was
	* not already finished when the cell at index i was played
	* (i.e. the game was playing). Therefore, it only needs to 
	* check if playing at index i has concluded the game, and if
	* set the oucome correctly
	* 
   	* @param i
    *  the index of the cell in the array board that has just 
    * been set
  	*/


	private void setGameState(int i){

		// YOUR CODE HERE 

	}



   /**
	* Returns a String representation of the game matching
	* the example provided in the assignment's description
	* 
   	* @return
    *  String representation of the game
  	*/

	public String toString(){

		// YOUR CODE HERE 

	}

}
