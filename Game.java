import javax.swing.JOptionPane;
//Class Game runs the course of the game
public class Game {
	public static void main(String[] args) {
		boolean gameOn = true;
		String message_received = "";
		Logic game = new Logic();
		String guesses_made = "";
		
		while(gameOn == true) {				
			String guess = JOptionPane.showInputDialog("Please enter your guess: ");	//asks for the input

			//add the new message with the last guesses			
			JOptionPane.showMessageDialog(null, (message_received = game.check_guess(guess)) +"\nPrevious guesses: "+ guesses_made);
			if(message_received.startsWith("Your"))										//save previous guesses only if they were valid
				guesses_made = guesses_made +"\n"+ message_received;
			
//if starts with "Very" that means user won, ask for new game or shut down
			if(message_received.startsWith("Very") == true) {
				guess = JOptionPane.showInputDialog("Play again? enter Yes if you want");
				if(guess.contains("Yes")) {
					game = new Logic();												//if useres want a new game, make a new Game object
					guesses_made = "";
				}
				else {
					JOptionPane.showMessageDialog(null, "Thanks for playing :)");
					gameOn = false;														//false - to leave while loop
				}
			}
		}
	}
}