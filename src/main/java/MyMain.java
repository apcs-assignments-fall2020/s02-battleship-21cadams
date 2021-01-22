public class MyMain {
    // This method returns true/false if there 
    // was a boat the specified coordinates. This
    // method also prints out an appropriate message
    public static boolean hit(boolean[][] board, int row, int col) { 
        if (board[row][col]==true){
            System.out.print("There was a hit!");
            return true;
        }else{
            System.out.print("You missed a boat!");
            return false;
        }

    }


    // Places a boat onto the board
    // The top-left piece of the board is located at (row, col)
    // The remaining pieces are placed in the direction given
    // by the direction input
    public static boolean[][] placeBoat(boolean[][] board, String direction, int boatLength, int row, int col) { 
        
		for (int r = 0; r < board.length; r++) {
			for (int  c = 0; c < board[0].length; c++) {
                if(direction=="right"){
                    if(r==row && c>=col && c< col + boatLength){
                        board[r][c]= true;
                    }
                }else{
                    if(c==col && r>=row && r< row + boatLength){
                        board[r][c]= true;
                    }
                }
            }    
        }
        return board;
    }

    // Returns true if the every row in the 2D array
    // is in both alphabetical order and in order of 
    // increasing length
    // You may assume that all Strings are lowercase 
    public static boolean inOrder(String[][] words) { 
        int temp_len = 0;
        int len = 0;
        int temp_let = 0;
        int low = 0; 
        String word = null;
        for (int row = 0; row < words.length; row++) {
			for (int  col= 0; col < words[0].length; col++) {
                word = words[row][col];
                
                temp_let = (int) word.charAt(0);
                System.out.println(temp_let);
                System.out.println(low);
                temp_len = word.length();
                if(temp_let > low && temp_len > len){
                    low = temp_let;
                    len = temp_len;
                }else{
                    return false;
                }
            }
            low=0;
            len=0;
        }
        return true;
    }

    public static void main(String[] args) {
    String[][] let = { {"anchor", "boating", "catamaran"}, {"boat", "cruise", "fishing"}}; 
    boolean[][] battleship = { {true, true, true, true, true, true},
                            {true, true, true, true, true, true},
                            {true, true, true, true, true, true},
                            {true, true, true, true, true, true},
                            {true, true, true, true, true, true},
                            {true, true, true, true, true, true}, };
    placeBoat(battleship, "right", 3, 2, 3);
    inOrder(let);

    }
}
