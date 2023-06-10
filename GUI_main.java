package GUI_PACKAGE;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class GUI_main {
	//global variable - can be access from anywhere within the class without having to instanciate it
	public static JFrame frame;
	public static JPanel panelCenter;
	public static JPanel panelNorth;
	public static JButton button1;

	public static void main(String[] args) {
		initializeFrame();












	}
	public static void initializeFrame() {
		/*
		 * anything you do to the frame has to be done before the frame is visible
		 */
		frame = new JFrame();
		//the size of the frame
		frame.setSize(800,800);

		//the location of where the screen is displayed
		Point locPoint  = new Point(200,200);
		frame.setLocation(locPoint);
		//a title at the top of the frame
		frame.setTitle("GUI Demo");
		/*set color of the frame - there are build in colors such as blue,black,red ect.
		 * but you can also build your own color
		 * to do this first you have to access the content pane then you can set its color
		 */
		//frame.getContentPane().setBackground(new Color(146, 192, 213 )); //China blue
		//frame.getContentPane().setBackground(new Color(46, 94, 133)); //dark-ish blue
		//frame.getContentPane().setBackground(Color.red);
		//when you close from the frame it does not stop the code but this will make it
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//we will create an instance of the tic-tac two panel
		panelCenter = new TicTacToe_Panel();

//		initializePanels();


		frame.add(panelCenter,BorderLayout.CENTER);
		//this will set it
//		frame.add(panelNorth,BorderLayout.NORTH);
		frame.setVisible(true);

	}
	public static void initializePanels() {

		/*since you can have more than one frame I want some of them visible and
		 * others non-visible
		 */
		panelCenter = new JPanel();
		//adding a grid layout to the center panel - think rows and columns
		//if you put 0,0 in the attributes that means you would have an unlimited amount of rows and columns
		panelCenter.setLayout(new GridLayout(0,3));
		//we now will fill out our grid
		panelCenter.setBackground(Color.red);
		initializeButtons();


		//we will add our button to the center panel
		panelCenter.add(button1);
		JTextField nameField = new JTextField();
		panelCenter.add(nameField);
		//slider - from a minimum number to a maximum number
		JSlider slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMinimum(0);
		slider.setMaximum(200);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(10);
		//label will tell us the current value of the slider
		JLabel sliderLabel = new JLabel();
		sliderLabel.setFont(new Font("Serif",Font.BOLD,42));
		//sliderLabel.setText("Value : " + slider.getValue());
		//we will need to override this method
		ChangeListener cl = new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				int val = slider.getValue();
				sliderLabel.setText("Value : " + val);
				
				
			}
			
		};
		slider.addChangeListener(cl);
		panelCenter.add(slider);
		panelCenter.add(sliderLabel);
		
		
		
		
		
		panelNorth = new JPanel();
		//we set the color of the north panel to be blue - we still have not added it yet
		panelNorth.setBackground(Color.blue);
		//this is not a container this is a component
		JLabel label1 = new JLabel("North Label");
		//setting a font to the text as well as other attributes such as size of the text and plain text bold text ect.
		//we added the code but we have not implemented it into the panel
		label1.setFont(new Font("Times New Roman",Font.PLAIN,72));
		//Changing the color of the text.
		label1.setForeground(Color.white);
		panelNorth.add(label1);

	}
	public static void initializeButtons() {
		button1 = new JButton("Unclicked");
		button1.setSize(100,100);
		button1.addActionListener(buttonListener());


	}
	public static ActionListener buttonListener() {
		//ActionListener is a class and within the class we will create a method called actionPreformed
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(button1.getText().compareTo("Clicked") == 0){//0 means that the button is clicked
					//if the button is clicked set it to be Unclicked
					button1.setText("Unclicked");	
				}else {
					button1.setText("Clicked");
				}
			}


		};
		return listener;

	}

}
