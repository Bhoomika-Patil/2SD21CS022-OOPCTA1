package com.completed;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class DetainedException extends Throwable {

	public DetainedException(String title) {
		// TODO Auto-generated constructor stub
		super(title);
	}

	public String toString() {
		return "Student is detained from writing SEE ";
	}
}

class InvalidMarksIA extends Throwable {
	public InvalidMarksIA(String title) {
		// TODO Auto-generated constructor stub
		super(title);
	}

	public String toString() {
		return "IA marks Should be between 0 and 20";
	}
}

class InvalidMarksCTA extends Throwable {

	public InvalidMarksCTA(String title) {
		// TODO Auto-generated constructor stub
		super(title);
	}

	public String toString() {
		return "CTA marks Should be between 0 and 10";
	}
}

class InvalidMarksSEE extends Throwable {

	public InvalidMarksSEE(String title) {
		// TODO Auto-generated constructor stub
		super(title);
	}

	public String toString() {
		return "SEE marks Should be between 0 and 100";
	}
}

class Frame13 extends JFrame implements ActionListener {
	Container contentPane;
	JButton b;
	JPanel p;
	int ia1, ia2, ia3, cta;
	double see;
	JLabel l, l1, l2, l3, lcta, lsee, lexception, ltotal, lgrade;
	JTextField t1, t2, t3, tcta, tsee;

	Frame13(String title) {
		super(title);

		contentPane = this.getContentPane();
		b = new JButton("                              Calculate                                ");
		p = new JPanel();
		l1 = new JLabel("Enter ia 1 marks");
		l2 = new JLabel("Enter ia 2 marks");
		l3 = new JLabel("Enter ia 3 marks");
		lcta = new JLabel("Enter ia cta marks");
		lsee = new JLabel("Enter ia see marks");
		ltotal = new JLabel();
		lgrade = new JLabel();
		lexception = new JLabel();
		l = new JLabel("                          Grade Calculator");
        
		t1 = new JTextField(15);
		t2 = new JTextField(15);
		t3 = new JTextField(15);
		tcta = new JTextField(15);
		tsee = new JTextField(15);

		b.addActionListener(this);
		p.add(l1);
		p.add(t1);
		p.add(l2);
		p.add(t2);
		p.add(l3);
		p.add(t3);
		p.add(lcta);
		p.add(tcta);
		p.add(lsee);
		p.add(tsee);
		p.add(b);
		add(p);
		p.add(ltotal);
		p.add(lgrade);
		p.add(lexception);
		add(p);
		
	
        b.setBackground(Color.LIGHT_GRAY);
		contentPane.add(p, BorderLayout.CENTER);
		contentPane.add(l, BorderLayout.NORTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (e.getSource() == b) {
			if (t1.getText().isEmpty() || t1.getText().equalsIgnoreCase("ab")) {
				ia1 = 0;
			} else {
				ia1 = Integer.parseInt(t1.getText());
			}
			if (t2.getText().isEmpty() || t2.getText().equalsIgnoreCase("ab")) {
				ia2 = 0;
			} else {
				ia2 = Integer.parseInt(t2.getText());
			}
			if (t3.getText().isEmpty() || t3.getText().equalsIgnoreCase("ab")) {
				ia3 = 0;
			} else {
				ia3 = Integer.parseInt(t3.getText());
			}
			if (tcta.getText().isEmpty() || tcta.getText().equalsIgnoreCase("ab")) {
				cta = 0;
			} else {
				cta = Integer.parseInt(tcta.getText());
			}
			if (tsee.getText().isEmpty() || tsee.getText().equalsIgnoreCase("ab")) {
				see = 0.0;
			} else {
				see = Double.parseDouble(tsee.getText());
			}

			try {
				if (ia1 < 0 || ia1 > 20 || ia2 < 0 || ia2 > 20 || ia3 < 0 || ia3 > 20) {
					throw new InvalidMarksIA("IA marks Should be between 0 and 20");
				}
			} catch (InvalidMarksIA imia) {
				lexception.setText("Error: " + imia);
				return;
			} catch (NumberFormatException nfe) {
				lexception.setText("error:Enter the input in integers");
				return;
			}

			try {
				if (cta < 0 || cta > 10) {
					throw new InvalidMarksCTA("CTA marks Should be between 0 and 10");
				}
			} catch (InvalidMarksCTA imcta) {
				lexception.setText("Error: " + imcta);
				return;
			} catch (NumberFormatException nfe) {
				lexception.setText("error:Enter the input in integers");
				return;
			}

			try {
				if (see < 0 || see > 100) {
					throw new InvalidMarksSEE("SEE marks Should be between 0 and 100");
				}
			} catch (InvalidMarksSEE imsee) {
				lexception.setText("Error: " + imsee);
				return;
			} catch (NumberFormatException nfe) {
				lexception.setText("error:Enter the input in integers");
			}

			if (see == 38 || see == 39) {
				see = 40.0;
			}
			see = Math.ceil(see / 2);
			int cie;
			if (ia2 >= ia1 && ia3 >= ia1) {
				cie = ia2 + ia3 + cta;
			} else if (ia1 >= ia2 && ia3 >= ia2) {
				cie = ia1 + ia3 + cta;
			} else {
				cie = ia1 + ia2 + cta;
			}
			try {
				if (cie < 20) {
					throw new DetainedException("Student is detained ");
				}
			} catch (DetainedException de) {
				lexception.setText(""+ de);
			}

			String grade;
			cie += see;
			if (cie <= 100 && cie >= 90) {
				grade = "S";
			} else if (cie < 90 && cie >= 80) {
				grade = "A";
			} else if (cie < 80 && cie >= 70) {
				grade = "B";
			} else if (cie < 70 && cie >= 60) {
				grade = "C";
			} else if (cie < 60 && cie >= 50) {
				grade = "D";
			}

			else if (cie < 50 && cie >= 40) {
				grade = "E";
			} else {
				grade = "F";
			}

			ltotal.setText("Total Marks: " + cie + "                ");

			lgrade.setText("Grade: " + grade);
		}

	}

}

public class CTAVersion15Done {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new Frame13("GRADE CALCULATOR");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setBounds(200, 200, 350, 400);
		f.setResizable(true);
		f.setVisible(true);
	}

}

