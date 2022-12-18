
public class Logic {
	protected final int LENGTH=4;
	protected int guessTimes;
	protected String numToGuess="";
//Class Logic responsible for game logic
public Logic() {
	this.numToGuess=randomNum();
	this.guessTimes=0;
}

//getter of the secret number to guess
	public String getNum() {												
		return numToGuess;}

//getter of the times guessed
	public int getGuesses() {												
		return guessTimes;}
	
private String randomNum() {
	String randomNum = "";
	int rand;
//get random digit, add it to the 'randomNum' string, return the new secret number 
	while(randomNum.length() < LENGTH) {
		rand = (int)(Math.random()*10);
		if (randomNum.contains(""+rand) != true)	//add this digit only if it's not in already
			randomNum += rand;
	}
	return randomNum;
}

public String check_guess(String guess) {
	int bulls = 0;										//"bull pgia"
	int cows = 0;										//"pgia"
	String message ="";	
	
	if(input_check(guess).length() != 0)				//check if the input is 4 different digits 
		return input_check(guess);						//if input not as required, return the right message (generated by input_check method)
	
	this.guessTimes += 1;								//increase guess counter, for each right input made in this game 
	
	for (int i=0; i<LENGTH; i++) {						//check bulls and cow by checking if equal in the same index or the secret contains this digit 
		if(this.getNum().charAt(i) == guess.charAt(i))
			bulls +=1;
		else if( this.getNum().contains(""+guess.charAt(i)) == true)
			cows +=1;
	}

	
	if(bulls == LENGTH)									//save the result of the guess if won
		message = "Very nice! you won. took you "+ this.getGuesses() +" guesses to get it's "+this.getNum()+", not bad.";
	else											 	//save the result of the guess if not won
		message = "Your guess "+ guess +" has "+ bulls +" Bulls, and "+ cows +" Cows"; 
	
	return message;
}

private String input_check(String guess) {
	String message = "";
	
	if(guess.length() != LENGTH)						//check if the guess is 4 digits 
		return message = "Wrong guess, the input must be 4 digits";
	if(guess.matches("\\d+") != true)					//check if the guess is numeric
		return message = "The input must be numeric";
	for(int i=0; i<=guess.length()-1;i++) {				//check if the guess is without the same 2 digits or more, O(1) loop
		for(int j=i+1; j<=guess.length()-1;j++) {
			if(guess.charAt(i) == guess.charAt(j))
				return message = "The input must not have repeated digits"; 
		}
	}
	return message;
}
}