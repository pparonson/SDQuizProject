package quiz.swingui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import quiz.data.Quiz;
import quiz.data.QuizInMemory;


@SuppressWarnings("serial")
public class QuizGUI extends JFrame {
	
	private Quiz quiz;
	private int currentCard = 0;
	private JPanel cards;
	private JButton nextButton;
	private JButton previousButton;
	private JButton doneButton;
	
	public QuizGUI() {
		quiz = new QuizInMemory();
		// Uncomment the following to use the DB version instead
//		quiz = new QuizDB();
		
		this.setTitle(quiz.getQuizName());

		cards = new JPanel(new CardLayout());
		for (int i = 0; i < quiz.getNumberOfQuestions(); i++) {
			cards.add(new QuizPanel(quiz.getQuestions().get(i)));
		}
		this.add(cards, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		previousButton = new JButton("Previous");
		previousButton.addActionListener(new PreviousButtonListener());
		buttonPanel.add(previousButton);

		nextButton = new JButton("Next");
		nextButton.addActionListener(new NextButtonListener());
		buttonPanel.add(nextButton);
		
		doneButton = new JButton("Done");
		doneButton.addActionListener(new DoneButtonListener());
		buttonPanel.add(doneButton);
		enableButtons();

		this.add(buttonPanel, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	class NextButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					CardLayout cl = (CardLayout) cards.getLayout();
					cl.next(cards);
					currentCard++;
					enableButtons();
				}
			});
		}
	}
	
	class PreviousButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					CardLayout cl = (CardLayout) cards.getLayout();
					cl.previous(cards);
					currentCard--;
					enableButtons();
				}
			});
		}
	}
	
	class DoneButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// After the quiz print a report with results
			// to the console
			System.out.println(quiz.getResults());
			dispose();
		}
	}

	private void enableButtons() {
		nextButton.setEnabled(true);
		previousButton.setEnabled(true);
		
		if (isDisplayingFirstCard()) {
			previousButton.setEnabled(false);
		}
		
		if (isDisplayingLastCard()) {
			nextButton.setEnabled(false);
		}
	}

	private boolean isDisplayingFirstCard() {
		return currentCard == 0;
	}

	private boolean isDisplayingLastCard() {
		return currentCard == quiz.getNumberOfQuestions() - 1;
	}
	
	public static void main(String[] args) {
		new QuizGUI();
	}
}
