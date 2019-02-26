import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AccountFrame extends JFrame
{

	public AccountFrame()
	{
		
	 setTitle("Bank Account");
	 setBounds(100,100,600,400);
	 setLayout(null);
	 
	 JLabel name = new JLabel("Name: ");
	 name.setBounds(100, 10, 50, 50);
	 add(name);
	 
	 JTextField nameAns = new JTextField();
	 nameAns.setBounds(200,20,100,30);
	 add(nameAns);
	
	 JLabel init = new JLabel("Initial Balance: ");
	 init.setBounds(100, 150, 100, 100);
	 add(init);
	 
	 JTextField bal = new JTextField();
	 bal.setBounds(200,190,100,30);
	 add(bal);
	 
	 JLabel accType = new JLabel("Account Type: ");
	 accType.setBounds(100,70,100,100);
	 add(accType);
	 
	 String[] choice = {"", "Checking", "Savings"};
	 JComboBox choose = new JComboBox(choice);
	 choose.setBounds(200,95,100,50);
	 add(choose);
	 
	 ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	 JButton addAcc = new JButton("Create Account");
	 addAcc.setBounds(100,250,150,50);
	 add(addAcc);
	
	 addAcc.addActionListener(new ActionListener()
			 {	
		 		public void actionPerformed(ActionEvent e)
		 		{
				  if(choose.getSelectedItem().equals ("Checking"))
				  {
					  CheckingAccount account = new CheckingAccount(nameAns.getText(),Integer.parseInt(bal.getText()),0,0,0);
					  accounts.add(account);
				  }
				  else if(choose.getSelectedItem().equals("Savings"))
				  {
					  SavingsAccount account = new SavingsAccount(nameAns.getText(), Integer.parseInt(bal.getText()),0,0,0);
				  }
				  
		 		}
			 
	});
	 JButton printAcc = new JButton("Print Accounts");
	 printAcc.setBounds(350,250,150,50);
	 add(printAcc);
	 printAcc.addActionListener(new ActionListener()
			 {
				 public void actionPerformed(ActionEvent e)
				 {
					for(BankAccount a : accounts)
					{
						System.out.println(a);
					}
				 }
			 }
			 
			 
			 );
	 

	}

	public static void main(String[] args)
	{	
		AccountFrame frame = new AccountFrame();
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
