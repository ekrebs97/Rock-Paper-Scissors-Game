import java.util.Scanner;
import java.util.Random;

/**
 * This class handles the entire code for a Rock Paper Scissors Game
 * 
 * @author Ellen Krebs
 *
 */
public class RPSGame {

	// New scanner that has been initialized
	private static Scanner input = new Scanner(System.in);

	// Random number generator
	private static Random generator = new Random();

	// Name for player 1
	private static String player1Name;

	// Name for player 2
	private static String player2Name;

	// Name for player (when playing against the computer)
	private static String playerName;

	// Stores the computer's choice of rock, paper, or scissors
	private static String computerChoice;

	private static String computerString = "Computer";

	// Computer's choice of 1, 2, or 3
	private static int computerNumber = generator.nextInt(3) + 1;

	// User's menu choice
	private static int userChoice;

	// Stores the number of games that have been played
	private static int numberOfGames = 0;

	// Stores the number of wins from player 1
	private static int numberOfPlayer1Wins = 0;

	// Stores the number of wins from player 2
	private static int numberOfPlayer2Wins = 0;

	// Player's choice of rock, paper, or scissors (when playing against the
	// computer)
	private static String choice;

	// Player 1's choice of rock, paper, or scissors
	private static String choice1;

	// player 2's choice of rock, paper, or scissors
	private static String choice2;

	public static void main(String[] args) {
		// The method to display the welcome message has been called
		welcomeMessage();

			// The method to ask each user for their names has been called
			names();

			// The method to display the default number of games played and the
			// default number of wins has been called
			defaultGameStats(player1Name, player2Name);

			// Determines when it is player 1's turn to play
			boolean player1Turn = true;

			// For loop that runs 3 times
			for (int i = 0; i < 3; i++) {

				// As long as it is player 1's turn, then this loop will run
				do {
					// The method to display which player's turn it is has been
					// called
					playerTurn(player1Name);

					// The method which prompts the player to input either rock,
					// paper, scissors has been called
					choice1 = player1Choice("Rock, Paper, or Scissors? ");

					player1Turn = false;

				} while (player1Turn == true);

				// As long as it is player 2's turn, then this loop will run
				do {
					// The method to display which player's turn it is has been
					// called
					playerTurn(player2Name);

					// The method which prompts the player to input either rock,
					// paper, scissors has been called
					choice2 = player2Choice("Rock, Paper, or Scissors? ");

					player1Turn = true;

				} while (player1Turn == false);

				// The method which runs through the game mechanics of rock,
				// paper,
				// scissors has been called
				gameplay();
			}
		
		// The method which displays the closing message has been called
		closingMessage();
		System.exit(0);

	}

	/**
	 * This method displays the welcome message at the beginning of the program
	 */
	public static void welcomeMessage() {
		System.out.println("Rock Paper Scissors Game");
		System.out.println("--------------------------");
		System.out.println();

		System.out.println("Press Enter to start.");
		input.nextLine();
	}

	/**
	 * This method allows the user to choose to play against a friend or against
	 * the computer
	 * 
	 * @param userInput:
	 *            takes in the user's input
	 * @param prompt:
	 *            Asks the user which number they'd like to choose
	 * @param min:
	 *            Minimum number that they can input (1)
	 * @param max:
	 *            Maximum number that they can input (2)
	 * @return menuChoice: the user's choice of 1 or 2
	 */
	public static int menu(Scanner userInput, String prompt, int min, int max) {
		// A variable storing the user's input
		int menuChoice;

		// Stores the value if the user inputs a string or character(s)
		String invalidChoice;

		System.out.println("You have the choice to:");
		System.out.println(" 1) Play against a friend");
		System.out.println(" 2) Play against the computer");

		System.out.print(prompt);
		while (true) {

			// If the user does not put in an integer, then it returns and error
			// message and asks for the user
			// to input an answer again until a valid number is put in.
			if (!input.hasNextInt()) {
				invalidChoice = input.nextLine();
				System.out.println("Error: expected a number between " + min
						+ " and " + max + " but found: " + invalidChoice);
				System.out.print(prompt);
			} else {
				menuChoice = input.nextInt();
				input.nextLine();
				System.out.println();

				// If the user inputs a number outside the bounds, then a
				// statement is printed, asking the user
				// to enter a number between the specified minimum and maximum
				// parameters until one is put in.
				if (menuChoice < min || menuChoice > max) {
					System.out.println("Please enter a number between " + min
							+ " and " + max + ".");
					System.out.print(prompt);
				} else {
					break;
				}
			}
		}

		return menuChoice;
	}

	/**
	 * This method asks each player to input their name
	 */
	public static void names() {
		System.out.print("Player 1, what is your name? ");
		player1Name = input.nextLine();
		System.out.print("Player 2, what is your name? ");
		player2Name = input.nextLine();
		System.out.println();
	}

	/**
	 * This method displays which player's turn it is
	 * 
	 * @param playerName:
	 *            this parameter takes in either player 1's name or player 2's
	 *            name
	 */
	public static void playerTurn(String playerName) {
		System.out.print(playerName + ", "
				+ "it is your turn. Press Enter to continue.");
		input.nextLine();
	}

	/**
	 * This method displays the default number of games played and wins for each
	 * player
	 */
	public static void defaultGameStats(String name1, String name2) {
		System.out.println("Current number of games played: 0/3");
		System.out.println(name1 + " has won 0/3 games");
		System.out.println(name2 + " has won 0/3 games");
		System.out.println();
	}

	/**
	 * This method prompts player 1 to input either rock, paper, or scissors and
	 * returns their response
	 * 
	 * @param prompt:
	 *            "Rock, Paper, or Scissors?"
	 * @return player1Choice: The player's input of rock, paper, or scissors
	 */
	public static String player1Choice(String prompt) {
		// Prints out the prompt
		System.out.print(prompt);

		// Stores player 1's input
		String player1Input = input.nextLine();

		System.out.println();

		// As long as player 1 does not input rock, paper, or scissors, this
		// loop will print an error message until they do so
		while (!(player1Input.equalsIgnoreCase("rock")
				|| player1Input.equalsIgnoreCase("paper")
				|| player1Input.equalsIgnoreCase("scissors"))) {
			System.out.println(
					"Invalid input: please choose either rock, paper, or scissors");
			System.out.print(prompt);
			player1Input = input.nextLine();

			// If player 1 does input a valid choice, then their answer will be
			// returned
			if (player1Input.equalsIgnoreCase("rock")
					|| player1Input.equalsIgnoreCase("paper")
					|| player1Input.equalsIgnoreCase("scissors")) {
				System.out.println();
				break;
			}
		}
		return player1Input;
	}

	/**
	 * This method prompts player 1 to input either rock, paper, or scissors and
	 * returns their response
	 * 
	 * @param prompt:
	 *            "Rock, Paper, or Scissors?"
	 * @return player2Choice: The player's input of rock, paper, or scissors
	 */
	public static String player2Choice(String prompt) {
		// Prints out the prompt
		System.out.print(prompt);

		// Stores player 2's input
		String player2Input = input.nextLine();

		System.out.println();

		// As long as player 2 does not input rock, paper, or scissors, this
		// loop will print an error message until they do so
		while (!(player2Input.equalsIgnoreCase("rock")
				|| player2Input.equalsIgnoreCase("paper")
				|| player2Input.equalsIgnoreCase("scissors"))) {
			System.out.println(
					"Invalid input: please choose either rock, paper, or scissors");
			System.out.print(prompt);
			player2Input = input.nextLine();

			// If player 1 does input a valid choice, then their answer will be
			// returned
			if (player2Input.equalsIgnoreCase("rock")
					|| player2Input.equalsIgnoreCase("paper")
					|| player2Input.equalsIgnoreCase("scissors")) {
				System.out.println();
				break;
			}
		}
		return player2Input;
	}

	/**
	 * This method runs through all of the possible outcomes of the rock, paper,
	 * scissors game
	 */
	public static void gameplay() {

		// If player 1's choice and player 2's choice are both equal, then
		// neither player wins the game
		if (choice1.equalsIgnoreCase(choice2)) {
			System.out.println("Draw. Neither " + player1Name + " nor "
					+ player2Name + " wins this game");
			// The number of games played is incremented
			numberOfGames++;

			// The method which displays the game's current number of games
			// played and wins for each player is called
			gameStats(numberOfGames, numberOfPlayer1Wins, numberOfPlayer2Wins);
		}
		// If player 1 chooses "rock" and player 2 chooses "paper," then player
		// 2 will win the game
		else if (choice1.equalsIgnoreCase("rock")
				&& choice2.equalsIgnoreCase("paper")) {
			System.out.println(
					"Paper covers rock. " + player2Name + " wins this game");

			numberOfGames++;

			// The number of player 2's wins is incremented
			numberOfPlayer2Wins++;

			gameStats(numberOfGames, numberOfPlayer1Wins, numberOfPlayer2Wins);
		}
		// If player 1 chooses "rock" and player 2 chooses "scissors," then
		// player 1 will win the game
		else if (choice1.equalsIgnoreCase("rock")
				&& choice2.equalsIgnoreCase("scissors")) {
			System.out.println("Rock crushes scissors. " + player1Name
					+ " wins this game");

			numberOfGames++;

			// The number of player 1's wins is incremented
			numberOfPlayer1Wins++;

			gameStats(numberOfGames, numberOfPlayer1Wins, numberOfPlayer2Wins);
		}
		// If player 1 chooses "paper" and player 2 chooses "rock," then player
		// 1 will win the game
		else if (choice1.equalsIgnoreCase("paper")
				&& choice2.equalsIgnoreCase("rock")) {
			System.out.println(
					"Paper covers rock. " + player1Name + " wins this game");

			numberOfGames++;

			numberOfPlayer1Wins++;

			gameStats(numberOfGames, numberOfPlayer1Wins, numberOfPlayer2Wins);
		}
		// If player 1 chooses "paper" and player 2 chooses "scissors," then
		// player 2 will win the game
		else if (choice1.equalsIgnoreCase("paper")
				&& choice2.equalsIgnoreCase("scissors")) {
			System.out.println(
					"Scissors cuts paper. " + player2Name + " wins this game");

			numberOfGames++;

			numberOfPlayer2Wins++;

			gameStats(numberOfGames, numberOfPlayer1Wins, numberOfPlayer2Wins);
		}
		// If player 1 chooses "scissors" and player 2 chooses "rock," then
		// player 2 will win the game
		else if (choice1.equalsIgnoreCase("scissors")
				&& choice2.equalsIgnoreCase("rock")) {
			System.out.println("Rock crushes scissors. " + player2Name
					+ " wins this game");

			numberOfGames++;

			numberOfPlayer2Wins++;

			gameStats(numberOfGames, numberOfPlayer1Wins, numberOfPlayer2Wins);
		}
		// If player 1 chooses "scissors" and player 2 chooses "paper," then
		// player 1 will win the game
		else if (choice1.equalsIgnoreCase("scissors")
				&& choice2.equalsIgnoreCase("paper")) {
			System.out.println(
					"Scissors cuts paper. " + player1Name + " wins this game");

			numberOfGames++;

			numberOfPlayer1Wins++;

			gameStats(numberOfGames, numberOfPlayer1Wins, numberOfPlayer2Wins);
		}
	}

	/**
	 * This method displays and updates the number of games played and the
	 * number of wins for each player
	 * 
	 * @param gamesPlayed
	 * @param player1Wins
	 * @param player2Wins
	 */
	public static void gameStats(int gamesPlayed, int player1Wins,
			int player2Wins) {
		System.out.println("Current number of games played: " + numberOfGames);

		System.out.println(
				player1Name + " has won " + numberOfPlayer1Wins + "/3 games");

		System.out.println(
				player2Name + " has won " + numberOfPlayer2Wins + "/3 games");
		System.out.println();

		// This gives the players a choice to continue or quit the game
		System.out.println("If you would like to continue, press Enter.");
		System.out.println("If you would like to quit, press q to quit.");

		// If the user enters "q" to quit, then the closing message will be
		// displayed and the program will end
		if (input.nextLine().equalsIgnoreCase("q")) {
			closingMessage();
			System.exit(0);
		}
	}

	/**
	 * This method displays the closing message at the end of the program
	 */
	public static void closingMessage() {
		System.out.println("Thanks for playing the Rock Paper Scissors Game!");
	}
}
