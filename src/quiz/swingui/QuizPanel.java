package quiz.swingui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import quiz.data.Answer;
import quiz.data.Question;

@SuppressWarnings("serial")
public class QuizPanel extends JPanel {
	private JLabel questionLabel;
	private JRadioButton[] buttons;
	private Question question;

	public QuizPanel(Question question) {
		this.question = question;
		
		questionLabel = new JLabel(question.getValue());

		// setup radio buttons
		List<Answer> answers = question.getAnswers();
		buttons = new JRadioButton[answers.size()];
		ButtonGroup group = new ButtonGroup();
		RadioButtonListener listener = new RadioButtonListener();
		
		for (int i = 0; i < answers.size(); i++) {
			buttons[i] = new JRadioButton(answers.get(i).getValue());
			// add the radio button to the group to make sure
			// only one button is selected at a time
			group.add(buttons[i]);
			// add a listener to each radio button to capture the 
			// selected value
			buttons[i].addActionListener(listener);
		}
		
		// put everything in a column
		this.setLayout(new GridLayout(0, 1));

		this.add(questionLabel);
		// add the radio buttons to this JPanel
		for (int i = 0; i < buttons.length; i++) {
			this.add(buttons[i]);
		}
		
		this.setBorder(BorderFactory.createEtchedBorder());
	}

	class RadioButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JRadioButton jRadioButton = (JRadioButton)e.getSource();
			question.setGivenAnswer(jRadioButton.getText());
		}
	}
}
