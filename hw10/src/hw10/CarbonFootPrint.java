/*
 Name: Marcus Lim
 Assignment: hw10
 Using Java GUI frameworks, I recreated from hw9 the calculator for figuring out
 someone's carbon footprint.
 */

package hw10;

import javax.swing.*;
import java.awt.event.*;  


class CarbonFootPrint extends JFrame implements ActionListener {
	
	JRadioButton rbCar,rbBuilding,rbBicycle;
	JTextField thermsOfGas,carMileage,carMPG,milesRidden;
	JLabel mileageLabel,mpgLabel,thermsLabel,riddenLabel;
	JButton Select, Calculate;    
		CarbonFootPrint(){      
		rbCar=new JRadioButton("Car");    
		rbCar.setBounds(10,10,50,30);     
		
		rbBuilding=new JRadioButton("Building");    
		rbBuilding.setBounds(95,10,100,30);
		
		rbBicycle=new JRadioButton("Bicycle");    
		rbBicycle.setBounds(210,10,100,30);
		
		carMileage = new JTextField();
		mileageLabel = new JLabel("Enter car mileage");
		carMPG = new JTextField();
		mpgLabel = new JLabel("Enter car MPG");
		carMileage.setBounds(120,50,150,20);
		mileageLabel.setBounds(10,50,150,20);
		carMPG.setBounds(120,70,150,20);
		mpgLabel.setBounds(10,70,150,20);
		mileageLabel.setVisible(false);
		carMileage.setVisible(false);
		mpgLabel.setVisible(false);
		carMPG.setVisible(false);
		
		milesRidden = new JTextField();
		riddenLabel = new JLabel("Enter miles ridden");
		milesRidden.setBounds(120,50,150,20);
		riddenLabel.setBounds(10,50,150,20);
		riddenLabel.setVisible(false);
		milesRidden.setVisible(false);
		
		thermsOfGas = new JTextField();
		thermsLabel = new JLabel("Enter therms of gas used");
		thermsOfGas.setBounds(120,50,150,20);
		thermsLabel.setBounds(5,50,150,20);
		thermsLabel.setVisible(false);
		thermsOfGas.setVisible(false);
		
		ButtonGroup bg=new ButtonGroup();    
		bg.add(rbCar);bg.add(rbBuilding);bg.add(rbBicycle);
		
		Select=new JButton("Select");    
		Select.setBounds(30,200,80,30);    
		Select.addActionListener(this);
		
		Calculate=new JButton("Result");    
		Calculate.setBounds(150,200,80,30);    
		Calculate.addActionListener(this);
		
		
		add(rbCar);add(rbBuilding);add(rbBicycle);add(Select);add(Calculate);
		add(carMileage);add(carMPG);add(mpgLabel);add(mileageLabel);
		add(thermsOfGas);add(thermsLabel);
		add(milesRidden);add(riddenLabel);

		setSize(300,300);    
		setLayout(null);    
		setVisible(true);    
}
	
	public void actionPerformed(ActionEvent e) {    
		if (rbCar.isSelected()) {
			thermsOfGas.setText("");
			milesRidden.setText("");
			
			carMileage.setVisible(true);
			mileageLabel.setVisible(true);
			carMPG.setVisible(true);
			mpgLabel.setVisible(true);
			
			riddenLabel.setVisible(false);
			milesRidden.setVisible(false);
			thermsLabel.setVisible(false);
			thermsOfGas.setVisible(false);
			
			if (!carMileage.getText().equals("") && !carMPG.getText().equals("")) {
				String mileage = carMileage.getText();
				String MPG = carMPG.getText();
				double a = Double.parseDouble(mileage);
				double b = Double.parseDouble(MPG);
				double c = 8887/b*a/1000000;
				String result = String.format("%.4f",c);
				JOptionPane.showMessageDialog(null, "Your car's carbon footprint is " + result + " metric tons of CO2.");
				
				
			}
						
		}   
		
		if(rbBicycle.isSelected()) {
			carMileage.setText("");
			carMPG.setText("");
			thermsOfGas.setText("");
			
			riddenLabel.setVisible(true);
			milesRidden.setVisible(true);
			
			mileageLabel.setVisible(false);
			carMileage.setVisible(false);
			mpgLabel.setVisible(false);
			carMPG.setVisible(false);
			thermsLabel.setVisible(false);
			thermsOfGas.setVisible(false);
			
			if (!milesRidden.getText().equals("")) {
				String ridden = milesRidden.getText();
				double a = Double.parseDouble(ridden);
				double b = 8.046727 * a;
				
				String result = String.format("%.4f", b);
				JOptionPane.showMessageDialog(null, "Your bike's carbon footprint is " + result + " grams of CO2.");
				
			}
			
		}
		
		if(rbBuilding.isSelected()) {
			carMileage.setText("");
			carMPG.setText("");
			milesRidden.setText("");
			
			thermsLabel.setVisible(true);
			thermsOfGas.setVisible(true);
			
			mileageLabel.setVisible(false);
			carMileage.setVisible(false);
			mpgLabel.setVisible(false);
			carMPG.setVisible(false);
			riddenLabel.setVisible(false);
			milesRidden.setVisible(false);
			
			if (!thermsOfGas.getText().equals("")) {
				String therms = thermsOfGas.getText();
				double a = Double.parseDouble(therms);
				double b = 11.7 * a;
				
				String result = String.format("%.4f", b);
				JOptionPane.showMessageDialog(null, "Your building's carbon footprint is " + result + " pounds of CO2.");
				
			}
			
		}
	}  

	public static void main(String args[]){    
	new CarbonFootPrint();    
	}
}   