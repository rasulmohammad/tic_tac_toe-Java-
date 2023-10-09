import java.util.Scanner;
public class Game {
    public static void main(String[] args){
        

        Scanner input = new Scanner(System.in);
        int turns = 1;
        String playerTurn = "X";
        String[] gameBoard =   {"0", "1", "2",
                                "3", "4", "5",
                                "6", "7", "8"};

        boolean winnerExists = false;
                            
    
        while(!(winnerExists)){

            // Board must print on the very first turn no matter what
            if(turns == 1){

                System.out.println("Enter the spot you'd like to play: ");
                printBoard(gameBoard);
                turns++;
            } 




            String userInput = input.nextLine();
            
            // Check for valid inputs
            if(userInput == ""){
                System.out.println("Hello bro enter a number");
            } else if (Integer.parseInt(userInput) > 8 || Integer.parseInt(userInput) < 0){
                System.out.println("Please enter a valid number");
            } else {
                System.out.println("Enter the spot you'd like to play");
                playerTurn = player(playerTurn, userInput, gameBoard, winnerExists, turns);
                printBoard(gameBoard);
                winnerExists = checkWin(playerTurn, gameBoard, winnerExists);
            }
            
            if(turns == 9){
                System.out.println("It's a tie!");
                winnerExists = false;
            }

        }

    

    }

    public static void printBoard(String[] gameBoard){

        System.out.println("-------------");
        System.out.println("| " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " |");
        System.out.println("-------------");
        System.out.println("| " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " |");
        System.out.println("-------------");
        System.out.println("| " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8] + " |");
        System.out.println("-------------");

    }

    public static String player(String playerTurn, String position, String[] gameBoard,boolean winnerExists, int turns){

        int temp = Integer.parseInt(position);  

        
        if(gameBoard[temp] == "X" || gameBoard[temp] == "O"){
            System.out.println("That spot is already taken!");
            return playerTurn;
        }


        gameBoard[temp] = playerTurn;

        // checking for win condition and ending loop if yes
        if(checkWin(playerTurn, gameBoard, winnerExists)){
            winnerExists = checkWin(playerTurn, gameBoard, winnerExists);
            System.out.println("You are the winner, " + playerTurn + "!");
        }

        turns++;

        // Updating turns
        if(playerTurn == "X"){
            playerTurn = "O";
        }
        else {
            playerTurn = "X";
        }

        return playerTurn;
    }


    public static boolean checkWin(String playerTurn, String[] gameBoard, boolean winnerExists){

        // Win cases
        if(gameBoard[0] == gameBoard[1] && gameBoard[1] == gameBoard[2]
        ||
        gameBoard[3] == gameBoard[4] && gameBoard[4] == gameBoard[5]
        ||
        gameBoard[6] == gameBoard[7] && gameBoard[7] == gameBoard[8]
        ||
        gameBoard[0] == gameBoard[3] && gameBoard[3] == gameBoard[6]
        ||
        gameBoard[1] == gameBoard[4] && gameBoard[4] == gameBoard[7]
        ||
        gameBoard[2] == gameBoard[5] && gameBoard[5] == gameBoard[8]
        ||
        gameBoard[0] == gameBoard[4] && gameBoard[4] == gameBoard[8]
        ||
        gameBoard[2] == gameBoard[4] && gameBoard[4] == gameBoard[6])
        {
            return true;
        } 

        return false;


    }

}
