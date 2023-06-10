package GUI_PACKAGE;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import javax.swing.JPanel;

public class TicTacToe_Panel extends JPanel {
	private JButton[][] buttons;
	private ActionListener bListener;
	private int counter = 0;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	/*
	 * Because we have the initializePanel method  and initializeButton we 
	 * can create the constructor
	 */
	
	public TicTacToe_Panel() {
		initializePanel();
		initializeButtons();
	}


	//helper method - when the  game is over we want to disable all the buttons
	private void disableButtons() {
		for(int i = 0; i < 3; i ++) {
			for(int j = 0; j < 3; j ++) {
				this.buttons[i][j].setEnabled(false);//this will disable all the buttons


			}

		}
	}
	//helper method
	private void initializePanel() {
		/*
		 * number 0 means that i will have unlimited number of rows
		 * and 3 represents the number of columns 
		 * the two 10 after it is the pixel space in between the rows and columns
		 */
		this.setLayout(new GridLayout(0,3,10,10));
		this.label1 = new JLabel();
		this.label1.setFont(new Font("Tahoma", Font.BOLD,70));
		this.add(label1);
		this.label2 = new JLabel();
		this.label2.setFont(new Font("Tahoma", Font.BOLD,70));
		this.add(label2);
		this.label3 = new JLabel();
		this.label3.setFont(new Font("Tahoma", Font.BOLD,70));
		this.add(label3);
	}
	public void checkWin(){
		int hWin=0,vWin=0,d1Win = 0, d2Win = 0;
		for(int i = 0;i < 3;i++){
			for(int j = 0,k = 2;j < 3;j++,k--){
				hWin += this.buttons[i][j].getText().charAt(0);
				vWin += this.buttons[j][i].getText().charAt(0);
				d1Win += this.buttons[j][j].getText().charAt(0);
				d2Win += this.buttons[j][k].getText().charAt(0);
			}
			if(hWin == 264 || vWin == 264 || d1Win == 264 ||
					d2Win == 264){
				this.label1.setText("");
				this.label2.setText("X wins");
				this.label3.setText("");
				disableButtons();
				break;
			}
			else if (hWin == 237 || vWin == 237 || d1Win == 237 ||
					d2Win == 237){
				this.label1.setText("");
				this.label2.setText("O wins");
				this.label3.setText("");
				disableButtons();
				break;
			}
			/*
			 *we reset every variable to 0 so the next time this for-loop 
			 *is ran it would have been started from 0.
			 */
			hWin = 0;
			vWin = 0;
			d1Win = 0;
			d2Win = 0;
		}
	}
	//helper method - initialize the button
	private void initializeButtons() {
		//we are going to create a new button that is 3 by 3
		this.buttons = new JButton[3][3];
		//an Action Listener - its waiting for an input to happen like a button press
		this.bListener = new ActionListener() {

			//what will happen when someone clicks a button
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * the if counter statement has to do with who's turn it is 
				 * the output will either be 0 or 1
				 */
				if(counter % 2 == 0) { 
					//setting up an action listener - which button is pressed
					/*since we know what button is pressed we 
					 * want to cast it as a button
					 */
					((JButton)e.getSource()).setText("O");
					
				}else {
					((JButton)e.getSource()).setText("X");
				}
				((JButton)e.getSource()).setEnabled(false);
				counter++;
				checkWin();
			}

		};
		/*
		 * wiring up the buttons - we have created the button and know what we will
		 * do with the buttons but now we want to assign them a task(s)
		 */
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				/*
				 * once we initialize the array as a button
				 * each attribute of the array is now a button
				 * therefore we can add all the function of a button onto it
				 */
				this.buttons[i][j] = new JButton(" ");
				this.buttons[i][j].setFont(new Font("Tahoma",Font.BOLD,42));
				this.buttons[i][j].addActionListener(bListener);
				//we now have to add it to the panel in sequence
				this.add(this.buttons[i][j]);
			}
		}
	}





}
