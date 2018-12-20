/**
 * Create: Evyatar Orbach
 * Date: 07/12/2018
 * Brief: mmn 13 qu 2
 */
package q2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * this class create question and manage it
 * @author Evyatar Orbach
 */
public class Question {
	private ArrayList<String> options;
	private String theAnswer;
	private String question;

	/**
	 * copy constructor
	 * @param question
	 */
	public Question(Question question) {
		this.question = question.getQuestion();
		this.theAnswer = question.getTheAnswer();
		this.options = question.getOptions();
	}
	
	/**
	 * constructor
	 * @param question
	 * @param theAnswer - the correct answer
	 * @param options - all the options to choose including the correct one
	 */
	public Question(String question, String theAnswer, ArrayList<String> options) {
		this.question = question;
		this.theAnswer = theAnswer;
		this.options = options;
	}
	
	/**
	 * shuffle the options of the question
	 */
	public void shuffle() {
		Collections.shuffle(this.options);
	}

	public ArrayList<String> getOptions() {
		return options;
	}

	public String getTheAnswer() {
		return theAnswer;
	}

	public String getQuestion() {
		return question;
	}

	@Override
	public String toString() {
		String triviaQuestion = question;
		for(int i=0;i<options.size();i++) {
			triviaQuestion += "\n" + options.get(i);
		}
		return triviaQuestion;
	}
	
}

