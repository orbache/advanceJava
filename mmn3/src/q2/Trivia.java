/**
 * Create: Evyatar Orbach
 * Date: 07/12/2018
 * Brief: mmn 13 qu 2
 */
package q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * This class create trivia game and manage it
 * @author Evyatar Orbach
 *
 */
public class Trivia {
	public static final String[] choise = {"yes","no"};
	final public static String TRIVIA_PATH = "src/q2/trivia.txt";
	private ArrayList<Question> questions;
	private Scanner input;
	private int score;
	private boolean play;
	private int questionCounter;
	
	/**
	 * Trivia get file of trivia, the first line is the question, second - the answer and the other three are the other options and so on
	 */
	Trivia() {
		try {
			input = new Scanner(new File(TRIVIA_PATH));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
		
		String question;
		ArrayList<String> options;
		this.questions = new ArrayList<Question>();
		
		while(input.hasNext()) {
			options = new ArrayList<>();
			question = input.nextLine();
			for(int line=0;line<4;line++) {
				options.add(input.nextLine());
			}
			this.questions.add(new Question(question, options.get(0), options));
		}
		input.close();
	}
	
	/**
	 * check if it ok to continue playing
	 * @return true if yes or false if not
	 */
	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

	/**
	 * shuffle the trivia questions
	 */
	public void shuffle() {
		Collections.shuffle(questions);
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	/**
	 * at the end of game it will show you the final score and ask for replay
	 * @return false for replay or true to end it
	 */
	public boolean endGame() {
		JOptionPane.showMessageDialog(null, "Your Score is "+this.score, "Exit", JOptionPane.INFORMATION_MESSAGE);
		int playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play again?","Message",JOptionPane.YES_NO_OPTION);
		if(playAgain == 0) {
			startGame();
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * starting all variables for new game
	 */
	public void startGame() {
		this.shuffle();
		this.score =0;
		this.questionCounter =0;
		this.setPlay(true);
	}

	/**
	 * get the next question if there is
	 * @return Question
	 */
	public Question getQ() {
		if(questionCounter >= questions.size()) {
			return null;
		}
		questionCounter++;
		return this.questions.get(questionCounter-1);
	}

	/**
	 * to make sure will leave the program when the file is close
	 */
	@Override
	protected void finalize() throws Throwable {
		input.close();
	}
}
