package com.UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.Numerical.Bisection;
import com.Numerical.Secant;

public class UiSecant
{
	private JFrame frame;
	private JPanel panel;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JLabel l1,l2,l3;
	private JButton b1;
	private JLabel func;
	private JButton close;
	public UiSecant()
	{
		frame=new JFrame("Secant");
		panel=new JPanel();
		func=new JLabel("f(x) = x^4 - 7x^2 -10 ");
		txt1=new JTextField();
		txt1.setBackground(Color.cyan);
		l1=new JLabel("Guess 1st value: ");
		l2=new JLabel("Guess 2nd value: ");
		l3=new JLabel("How many steps: ");
		txt2=new JTextField();
		txt2.setBackground(Color.cyan);
		txt3=new JTextField();
		txt3.setBackground(Color.cyan);
		b1=new JButton("press");
		close=new JButton("Close");
	}
	public void Gen()
	{
		frame.setSize(600,200);
		frame.add(panel);
		panel.add(func);
		panel.add(l1);
		panel.add(txt1);
		panel.add(l2);
		panel.add(txt2);
		panel.add(l3);
		panel.add(txt3);
		panel.add(b1);
		panel.add(close);
		frame.setVisible(true);
		panel.setLayout(null);
		func.setBounds(func.getX(), func.getY(), 400, 20);
		l1.setBounds(func.getX()+10, func.getY()+20, 100, 20);
		txt1.setBounds(l1.getX()+l1.getWidth()+10, l1.getY(), 100, 25);
		l2.setBounds(l1.getX(), txt1.getY()+30, 100, 20);
		txt2.setBounds(l2.getX()+l2.getWidth()+10, l2.getY(), 100, 25);
		l3.setBounds(l2.getX(), l2.getY()+l2.getHeight()+10, 100, 20);
		txt3.setBounds(l3.getX()+l3.getWidth()+10, l3.getY(), 100, 25);
		b1.setBounds(l3.getX(), l3.getY()+l3.getHeight()+10, 100, 25);
		close.setBounds(b1.getX()+b1.getWidth()+10, b1.getY(), 100, 25);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		b1.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				String G1=txt1.getText();
				String G2=txt2.getText();
				String G3=txt3.getText();
				try 
				{
					double g1=new Double(G1);
					double g2=new Double(G2);
					int g3=new Integer(G3);
					Secant Se=new Secant();
					String ans=Se.Gen(g1,g2,g3);
					Show S=new Show(ans, "Secant");
				} 
				catch (NumberFormatException e) 
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Oie Mia thik vabe Input Den\n");
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
				}
			}
		});
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		txt1.addMouseListener(new Action(txt1));
		txt2.addMouseListener(new Action(txt2));
		txt3.addMouseListener(new Action(txt3));
	}
}