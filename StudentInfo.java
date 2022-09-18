import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class StudentInfo extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17;
	JTabbedPane tabs;
	JPanel p1, p2, p3;
	Container c;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	JButton b1, b2, b3;
	JRadioButton rb1, rb2;
	ButtonGroup bg;
	JCheckBox c1, c2, c3, c4, c5, c6, c7, c8;
	JTextArea ta,ta1;
	JComboBox cb;
	JPasswordField pf;

	String fname = null, lname = null, name = null, reg_no = null, email = null, gender = null, branch = null,
			skills = "", address = null, file_name = null;
	
	boolean login;
	
	List<JCheckBox> check_boxes = new ArrayList<JCheckBox>();

	public StudentInfo() {

		setTitle("STUDENT INFO");
		c = getContentPane();

		tabs = new JTabbedPane();
		tabs.setBounds(10, 10, 1000, 1000);

		p1 = new JPanel();
		p1.setBackground(Color.cyan);
		p1.setLayout(null);

		l1 = new JLabel("FIRST NAME");
		l1.setBounds(20, 20, 100, 50);
		tf1 = new JTextField();
		tf1.setBounds(100, 20, 200, 50);
		tf1.setFont(new Font("Monaco", Font.PLAIN, 15));
		l2 = new JLabel("LAST NAME");
		l2.setBounds(20, 100, 100, 50);
		tf2 = new JTextField();
		tf2.setBounds(100, 100, 200, 50);
		tf2.setFont(new Font("Monaco", Font.PLAIN, 15));
		l3 = new JLabel("REGD NO.");
		l3.setBounds(20, 170, 100, 50);
		tf3 = new JTextField();
		tf3.setBounds(100, 170, 200, 50);
		tf3.setFont(new Font("Monaco", Font.PLAIN, 15));
		l4 = new JLabel("EMAIL");
		l4.setBounds(20, 250, 100, 50);
		tf4 = new JTextField();
		tf4.setBounds(100, 250, 200, 50);
		tf4.setFont(new Font("Monaco", Font.PLAIN, 15));
		p1.add(l1);
		p1.add(tf1);
		p1.add(l2);
		p1.add(tf2);
		p1.add(l3);
		p1.add(tf3);
		p1.add(l4);
		p1.add(tf4);
		l5 = new JLabel("GENDER");
		l5.setBounds(20, 300, 100, 50);
		p1.add(l5);

		bg = new ButtonGroup();
		rb1 = new JRadioButton("Male");
		rb1.setBounds(20, 350, 100, 50);
		rb2 = new JRadioButton("Female");
		rb2.setBounds(20, 390, 100, 50);

		p1.add(rb2);
		p1.add(rb1);

		bg.add(rb2);
		bg.add(rb1);

		l6 = new JLabel("BRANCH");
		l6.setBounds(20, 450, 100, 50);
		p1.add(l6);
		String dept[] = {"select", "CSE", "ECE", "EEE", "MECH", "CSIT", "CSSE" };
		cb = new JComboBox<String>(dept);
		cb.setBounds(20, 500, 100, 50);
		p1.add(cb);

		cb.addActionListener(this);

		l7 = new JLabel("SKILLS");
		l7.setBounds(200, 300, 100, 50);
		p1.add(l7);
		c1 = new JCheckBox("C");
		check_boxes.add(c1);
		c1.setBounds(200, 350, 100, 30);
		c2 = new JCheckBox("C++");
		check_boxes.add(c2);
		c2.setBounds(200, 380, 100, 30);
		c3 = new JCheckBox("Python");
		check_boxes.add(c3);
		c3.setBounds(200, 410, 100, 30);
		c4 = new JCheckBox("Java");
		check_boxes.add(c4);
		c4.setBounds(200, 440, 100, 30);
		c5 = new JCheckBox("HTML");
		check_boxes.add(c5);
		c5.setBounds(200, 470, 100, 30);
		c6 = new JCheckBox("CSS");
		check_boxes.add(c6);
		c6.setBounds(200, 500, 100, 30);
		c7 = new JCheckBox("JavaScript");
		check_boxes.add(c7);
		c7.setBounds(200, 530, 100, 30);
		c8 = new JCheckBox("SQL");
		check_boxes.add(c8);
		c8.setBounds(200, 560, 100, 30);

		p1.add(c1);
		p1.add(c2);
		p1.add(c3);
		p1.add(c4);
		p1.add(c5);
		p1.add(c6);
		p1.add(c7);
		p1.add(c8);

		l8 = new JLabel("ADDRESS");
		l8.setBounds(400, 20, 100, 50);
		p1.add(l8);
		ta = new JTextArea();
		ta.setBounds(400, 70, 200, 200);
		ta.setFont(new Font("Monaco", Font.PLAIN, 15));
		p1.add(ta);

		b1 = new JButton("REGISTER");
		b1.setBounds(450, 300, 100, 50);
		p1.add(b1);
		b1.addActionListener(this);

		l9 = new JLabel();
		l9.setBounds(400, 350, 500, 50);
		p1.add(l9);

		p2 = new JPanel();
		p2.setBackground(Color.CYAN);
		p2.setLayout(null);

		l10 = new JLabel("LOGIN WITH YOUR DETAILS");
		l10.setBounds(300, 30, 500, 50);

		p2.add(l10);
		l11 = new JLabel("REGD NO.");
		l11.setBounds(50, 100, 200, 50);
		p2.add(l11);
		tf5 = new JTextField();
		tf5.setBounds(150, 100, 300, 50);
		tf5.setFont(new Font("Monaco", Font.PLAIN, 15));
		p2.add(tf5);
		l12 = new JLabel("EMAIL");
		l12.setBounds(50, 150, 200, 50);
		p2.add(l12);
		tf6 = new JTextField();
		tf6.setBounds(150, 160, 300, 50);
		tf6.setFont(new Font("Monaco", Font.PLAIN, 15));
		p2.add(tf6);
		l13 = new JLabel("PASSWORD");
		l13.setBounds(50, 220, 200, 50);
		p2.add(l13);
		pf = new JPasswordField();
		pf.setBounds(150, 220, 300, 50);
		p2.add(pf);

		b2 = new JButton("login");
		b2.setBounds(300, 300, 100, 50);
		p2.add(b2);
		l14 = new JLabel();
		l14.setBounds(200, 350, 500, 50);
		p2.add(l14);

		b2.addActionListener(this);

		p3 = new JPanel();
		p3.setBackground(Color.CYAN);
		p3.setLayout(null);
		l15 = new JLabel("SEARCH THE STUDENT");
		l15.setBounds(300, 30, 500, 50);
		p3.add(l15);
		l16 = new JLabel("ENTER REGD NO.");
		l16.setBounds(50, 100, 500, 50);
		p3.add(l16);
		tf7 = new JTextField();
		tf7.setBounds(50, 150, 300, 50);
		tf7.setFont(new Font("Monaco", Font.PLAIN, 15));
		p3.add(tf7);
		b3 = new JButton("search");
		b3.setBounds(300, 250, 100, 50);
		p3.add(b3);

		b3.addActionListener(this);
		l17 = new JLabel();
		l17.setBounds(200, 300, 500, 50);
		p3.add(l17);
		
		ta1 = new JTextArea();
		ta1.setBounds(200,350, 500, 250);
		ta1.setFont(new Font("Monaco", Font.PLAIN, 15));
		p3.add(ta1);
		
		tabs.add("Register", p1);
		tabs.add("login", p2);
		tabs.add("search", p3);
		c.add(tabs);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == cb) {
			branch = (String) cb.getItemAt(cb.getSelectedIndex());
		}

		if (e.getSource() == b1) {
			fname = tf1.getText();
			lname = tf2.getText();
			name = fname + " " + lname;
			reg_no = tf3.getText();
			email = tf4.getText();
			gender = rb1.isSelected() ? "male" : "female";
			address = ta.getText();

			file_name = "D:\\students\\" + reg_no + ".txt";

			for (JCheckBox i : check_boxes) {
				if (i.isSelected()) {
					skills += i.getText() + ",";
				}
			}
			if (fname.equals("") || lname.equals("") || reg_no.equals("") || email.equals("") || gender.equals("")
					|| branch.equals("") || address.equals("")) {
				l9.setText("All The Above Fields Are Required");
			} else {
				try {
					File file = new File(file_name);
					if (file.createNewFile()) {
						l9.setText("Registered Successfully");
						FileWriter writer = new FileWriter(file);
						writer.write(" Name :" + name + "\n");
						writer.write(" Registration number :" + reg_no + "\n");
						writer.write(" Email :" + email + "\n");
						writer.write(" Gender :" + gender + "\n");
						writer.write(" Branch :" + branch + "\n");
						writer.write(" Skills :" + skills + "\n");
						writer.write(" Address :" + address + "\n");
						Random rand = new Random();
						int password = rand.nextInt(10000);
						String pass = String.valueOf(password);
						writer.write(pass);
						writer.close();
					} else {
						l9.setText("User Already Exist");
					}
				} catch (IOException e1) {
					l9.setText("Error! Try Again");
				}
			}
		}
		if (e.getSource() == b2) {
			String user_reg,line,pass = null;
			user_reg = tf5.getText();
			String file_check = "D:\\students\\" + user_reg + ".txt";
			try {
				FileReader fr = new FileReader(file_check);
				BufferedReader br=new BufferedReader(fr);
				while((line=br.readLine())!=null) {
						pass=line;
				}
				pf.setText(pass);
				login=true;
				l14.setText("Login success");
				fr.close();
				br.close();
			} catch (FileNotFoundException e1) {
				l14.setText("Invalid Registration Number! try again");
			} catch (IOException e1) {
				l14.setText("Error! try again");
			}
			
			
		}
		if(e.getSource()==b3) {
			if(login) {
				String user_reg,line,details="";
				user_reg = tf7.getText();
				String file_check = "D:\\students\\" + user_reg + ".txt";
				try {
					FileReader fr1 = new FileReader(file_check);
					BufferedReader br1=new BufferedReader(fr1);
					l17.setText("Student Details are");
					while((line=br1.readLine())!=null) {
						details+=line+"\n";
					}
					ta1.setText(details);
					fr1.close();
					br1.close();
				} catch (FileNotFoundException e1) {
					l17.setText("Student not found");
				} catch (IOException e1) {
					l17.setText("Error! try again");
				}
			}else {
				l17.setText("Login to continue");
			}
		}
	}

}
