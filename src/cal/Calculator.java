package cal;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
public class Calculator {

	private JFrame frame;
	private JTextField textField;
	private  boolean pointPressed = false;
	private  String operation = "";
	private  Double result = 0.0;
	private  Double number = 0.0;
	private boolean firstZero = true;
    Pattern r = Pattern.compile("^[0]+$");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}
	
	public void setNumber(JButton button,JTextField myTextField ) {
		String number = textField.getText() + button.getText().toString();
		myTextField.setText(number);
	}
	public void setSign(JButton button,JTextField myTextField) {
		if(myTextField.getText().length() > 1)
		System.out.println(myTextField.getText());
		result= Double.parseDouble(myTextField.getText());
		pointPressed = false;
		System.out.println(result);
		operation = "";
		operation = button.getText();
		System.out.println(operation);
		myTextField.setText("");
	}
	

	public void setResult(JTextField myTextField) {
		number = Double.parseDouble(myTextField.getText());
		switch(operation) {
		case "+":
		{
			result +=number;
			break;
		}
		case "-" : {
			result -= number;
			break;
		}
		case "*" :{
			result *= number;
			break;
		}
		case "/":{
			result /= number;
			break;
		}
		case "%":{
			result = (number/100.0) * result;
		}
		default : break;
		}
		myTextField.setText(result.toString());
		
	}
	public void checkZero(JButton button,JTextField myTextField)
	{
		try {
		if(Pattern.matches("^[0]+$", textField.getText()))
		{
			textField.setText("0");
		}
		}catch(Exception e) {}

	}
	public void checkZeroPositionOne(JButton button,JTextField myTextField) {
		if(Pattern.matches("^[0]+$",myTextField.getText().substring(0,myTextField.getText().length()-1)))
		{
			myTextField.setText(button.getText());
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Image icon = Toolkit.getDefaultToolkit().getImage("calculator.png"); 
		frame = new JFrame();
		frame.setBounds(100, 100, 364, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 333, 44);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		frame.setIconImage(icon);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pointPressed = false;
				firstZero = true;
				try {
				textField.setText(textField.getText().substring(0,textField.getText().length()-1));
				}
				catch(Exception e) {
					 JOptionPane.showMessageDialog(frame,"Can't remove any more characters!");
				}
			}
		});
		btnNewButton.setBounds(10, 80, 48, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumber(btnNewButton_1,textField);
				checkZeroPositionOne(btnNewButton_1,textField);
			}
		});
		btnNewButton_1.setBounds(10, 130, 48, 44);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("4");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumber(btnNewButton_2,textField);
				checkZeroPositionOne(btnNewButton_2,textField);
			}
		});
		btnNewButton_2.setBounds(10, 180, 48, 44);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("7");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumber(btnNewButton_2_1,textField);
				checkZeroPositionOne(btnNewButton_2_1,textField);
			}
		});
		btnNewButton_2_1.setBounds(10, 230, 48, 44);
		frame.getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("C");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				number = 0.0;
				result = 0.0;
				operation = "";
				pointPressed = false;
				firstZero = true;
			}
		});
		btnNewButton_2_2.setBounds(100, 80, 48, 44);
		frame.getContentPane().add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("2");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumber(btnNewButton_2_3,textField);
				checkZeroPositionOne(btnNewButton_2_3,textField);
			}
		});
		btnNewButton_2_3.setBounds(100, 130, 48, 44);
		frame.getContentPane().add(btnNewButton_2_3);
		
		JButton btnNewButton_2_4 = new JButton("5");
		btnNewButton_2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumber(btnNewButton_2_4,textField);
				checkZeroPositionOne(btnNewButton_2_4,textField);
			}
		});
		btnNewButton_2_4.setBounds(100, 180, 48, 44);
		frame.getContentPane().add(btnNewButton_2_4);
		
		JButton btnNewButton_2_5 = new JButton("8");
		btnNewButton_2_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumber(btnNewButton_2_5,textField);
				checkZeroPositionOne(btnNewButton_2_5,textField);
			}
		});
		btnNewButton_2_5.setBounds(100, 230, 48, 44);
		frame.getContentPane().add(btnNewButton_2_5);
		
		JButton btnNewButton_2_6 = new JButton("00");
		btnNewButton_2_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumber(btnNewButton_2_6,textField);
				checkZero(btnNewButton_2_6, textField);
			}
		});
		btnNewButton_2_6.setBounds(190, 80, 48, 44);
		frame.getContentPane().add(btnNewButton_2_6);
		
		JButton btnNewButton_2_3_1 = new JButton("3");
		btnNewButton_2_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumber(btnNewButton_2_3_1,textField);
				checkZeroPositionOne(btnNewButton_2_3_1,textField);
			}
		});
		btnNewButton_2_3_1.setBounds(190, 130, 48, 44);
		frame.getContentPane().add(btnNewButton_2_3_1);
		
		JButton btnNewButton_2_3_2 = new JButton("6");
		btnNewButton_2_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumber(btnNewButton_2_3_2,textField);
				checkZeroPositionOne(btnNewButton_2_3_2,textField);
			}
		});
		btnNewButton_2_3_2.setBounds(190, 180, 48, 44);
		frame.getContentPane().add(btnNewButton_2_3_2);
		
		JButton btnNewButton_2_3_3 = new JButton("9");
		btnNewButton_2_3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumber(btnNewButton_2_3_3,textField);
				checkZeroPositionOne(btnNewButton_2_3_3,textField);
			}
		});
		btnNewButton_2_3_3.setBounds(190, 230, 48, 44);
		frame.getContentPane().add(btnNewButton_2_3_3);
		
		JButton btnNewButton_2_3_4 = new JButton("+");
		btnNewButton_2_3_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSign(btnNewButton_2_3_4,textField);
			}
		});
		btnNewButton_2_3_4.setBounds(280, 80, 48, 44);
		frame.getContentPane().add(btnNewButton_2_3_4);
		
		JButton btnNewButton_2_3_4_1 = new JButton("-");
		btnNewButton_2_3_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSign(btnNewButton_2_3_4_1,textField);
			}
		});
		btnNewButton_2_3_4_1.setBounds(280, 130, 48, 44);
		frame.getContentPane().add(btnNewButton_2_3_4_1);
		
		JButton btnNewButton_2_3_4_2 = new JButton("*");
		btnNewButton_2_3_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSign(btnNewButton_2_3_4_2,textField);
			}
		});
		btnNewButton_2_3_4_2.setBounds(280, 180, 48, 44);
		frame.getContentPane().add(btnNewButton_2_3_4_2);
		
		JButton btnNewButton_2_3_4_3 = new JButton("/");
		btnNewButton_2_3_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSign(btnNewButton_2_3_4_3,textField);
			}
		});
		btnNewButton_2_3_4_3.setBounds(280, 230, 48, 44);
		frame.getContentPane().add(btnNewButton_2_3_4_3);
		
		JButton btnNewButton_2_3_4_4 = new JButton("0");
		btnNewButton_2_3_4_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumber(btnNewButton_2_3_4_4,textField);
				checkZero(btnNewButton_2_3_4_4, textField);
			}
		});
		btnNewButton_2_3_4_4.setBounds(10, 285, 48, 44);
		frame.getContentPane().add(btnNewButton_2_3_4_4);
		
		JButton btnNewButton_2_3_4_5 = new JButton(".");
		btnNewButton_2_3_4_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pointPressed == false) {
				setNumber(btnNewButton_2_3_4_5,textField);
				pointPressed = true;
			}
				}
		});
		btnNewButton_2_3_4_5.setBounds(100, 285, 48, 44);
		frame.getContentPane().add(btnNewButton_2_3_4_5);
		
		JButton btnNewButton_2_3_4_6 = new JButton("=");
		btnNewButton_2_3_4_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pointPressed = false;
				setResult(textField);
			}
		});
		btnNewButton_2_3_4_6.setBounds(190, 285, 48, 44);
		frame.getContentPane().add(btnNewButton_2_3_4_6);
		
		JButton btnNewButton_2_3_4_7 = new JButton("%");
		btnNewButton_2_3_4_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSign(btnNewButton_2_3_4_7,textField);
			}
		});
		btnNewButton_2_3_4_7.setBounds(268, 285, 60, 44);
		frame.getContentPane().add(btnNewButton_2_3_4_7);
	}
}
