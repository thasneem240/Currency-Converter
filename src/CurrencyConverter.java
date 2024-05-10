/********************************************
 * Author: A.S.M.Thasneem 					*
 * Index Number: DSE/21/120					*
 * Title: Currency Converter				*
 * ******************************************/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CurrencyConverter {

	private JFrame frmCurrencyConverter;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverter window = new CurrencyConverter();
					window.frmCurrencyConverter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CurrencyConverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCurrencyConverter = new JFrame();
		frmCurrencyConverter.setResizable(false);
		frmCurrencyConverter.setTitle("Currency Converter");
		frmCurrencyConverter.setBounds(100, 100, 450, 300);
		frmCurrencyConverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCurrencyConverter.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(148, 0, 211));
		panel.setBounds(0, 0, 434, 157);
		frmCurrencyConverter.getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"US Dollar(USD)"}));
		comboBox.setBounds(27, 23, 150, 24);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"SriLankan Rupee(SLR)", "Indian Rupee(INR)", "Aus Dollar(AUD)", "Saudi Riyal", "Russian Ruble"}));
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_1.setBounds(230, 23, 183, 24);
		panel.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(27, 100, 150, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(230, 100, 183, 30);
		panel.add(textField_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 255));
		panel_1.setBounds(0, 157, 434, 104);
		frmCurrencyConverter.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("CLEAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(49, 22, 97, 55);
		panel_1.add(btnNewButton);
		
		JButton btnConvert = new JButton("CONVERT");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double result = 0,amount;
				
				// Check the text field is empty or not 
				
				if( !textField.getText().isEmpty()) 
				{
					try 
					{
						amount = Double.parseDouble(textField.getText());
						
						if(comboBox.getSelectedItem().toString() == "US Dollar(USD)" ) 
						{
							if(comboBox_1.getSelectedItem().toString() == "SriLankan Rupee(SLR)" ) 
							{
								result = amount * 357.33;
							}
							else 
							{
								if(comboBox_1.getSelectedItem().toString() == "Indian Rupee(INR)" ) 
								{
									result = amount * 77.37;
								}
								else
								{
									if(comboBox_1.getSelectedItem().toString() == "Aus Dollar(AUD)" ) 
									{
										result = amount * 1.43;
									}
									else 
									{
										if(comboBox_1.getSelectedItem().toString() == "Saudi Riyal" ) 
										{
											result = amount * 3.75;
										}
										else 
										{
											if(comboBox_1.getSelectedItem().toString() == "Russian Ruble" ) 
											{
												result = amount * 68.25;
											}
										}
									}
								}
							}
						}
						
						double roundResult = Math.round(result*1000)/1000.0; // Round to 3 decimal places;
						
						textField_1.setText(String.valueOf(roundResult));
					}
					catch(NumberFormatException e1)
					{
						JOptionPane.showMessageDialog(null, "Invalid Number format","ERROR",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnConvert.setForeground(new Color(255, 0, 0));
		btnConvert.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConvert.setBackground(new Color(0, 255, 0));
		btnConvert.setBounds(275, 22, 118, 55);
		panel_1.add(btnConvert);
	}
}
