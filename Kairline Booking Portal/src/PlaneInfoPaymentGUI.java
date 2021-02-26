import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlaneInfoPaymentGUI implements ActionListener
{
	char bookingidchar=(char)(((int)(Math.random()*25)+65));
	int bookingidnum=(((int)(Math.random()*90))+10);
	JFrame mainframe=new JFrame();
	JLabel note1=new JLabel("It is only possible to book one way tickets currently.Only major cities in INDIA are connected by Kairlines. You can book a flight maximum 2 days in advance.");
	JLabel note2=new JLabel("It is only possible to book for maximum 5 adults and 3 children at a time.The breakdown of the amount shown is always hidden.Error means one or more items are invalid.");
	JLabel note3=new JLabel("Every passenger will get the same meal.Express Check-In is available for all passengers if chosen. Only one wheel chair can be provided.Call 9384674135 for any queries.");
	JLabel note4=new JLabel("Payment with credit card or debit card is not yet available.");
	JLabel version=new JLabel("version 1.0");
	JLabel pricelabel=new JLabel();
	JLabel payeename=new JLabel("Payee Name: Kairav Pathak");
	JLabel ifsccode=new JLabel("IFSC Code: KAIN00567");
	JLabel accnum=new JLabel("Account Number:143220161205");
	JLabel thankyou=new JLabel("THANK YOU");
	JButton confirmButton=new JButton("Confirm");
	JButton cardconfButton=new JButton("Confirm");
	JButton contButton=new JButton("Continue");
	JCheckBox wcbox=new JCheckBox("Wheelchair");
	JCheckBox exbox=new JCheckBox("Express Check-In");
	ImageIcon pic=new ImageIcon("Resources/banner.png");
	JButton bannerbutton=new JButton();
	JLabel cardnuminput=new JLabel();
	JLabel cardnuminputlabel=new JLabel("Enter card number:");
	JLabel exmonthinput=new JLabel();
	JLabel exmonthinputlabel=new JLabel("Enter month of expiry:");
	JLabel exyearinput=new JLabel();
	JLabel exyearinputlabel=new JLabel("Enter year of expiry:");
	JLabel cardnameinput=new JLabel();
	JLabel cardnameinputlabel=new JLabel("Enter name on card:");
	JLabel cvvinput=new JLabel();
	JLabel cvvinputlabel=new JLabel("Enter CVV:");
	JLabel bookingidlabel=new JLabel("Your booking ID: "+bookingidchar+""+bookingidnum);
	JComboBox depacb;
	JComboBox arricb;
	JComboBox timecb;
	JComboBox adultcb;
	JComboBox childcb;
	JComboBox datecb;
	JComboBox mealcb;
	JTextField tf=new JTextField();
	
	JFrame frame=new JFrame();
	JLabel label1=new JLabel("Choose Mode Of Payment");
	JLabel emiprice=new JLabel();
	JLabel cardnuminstr=new JLabel("*Enter only 16 digits in format:xxxxxxxxxxxxxxxx");
	JLabel exmonthinstr=new JLabel("*Enter only 2 digits in format:0x or 1x");
	JLabel exyearinstr=new JLabel("*Enter only 2 digits in format:xx");
	JLabel cvvinstr=new JLabel("*Enter only 3 digits in format:xxx");
	JComboBox mopcb;
	JComboBox emichoosecb;
	JButton emiconfButton= new JButton("Confirm");
	JButton confButton=new JButton("Confirm");
	double price;
	int flag=1;
	int numctr=0,wsctr=0;
	public PlaneInfoPaymentGUI()
	{
		String[] arriarray= {"Choose Arrival Location","Chennai","Delhi","Mumbai","Kolkata","Hyderabad","Bangalore","Ahmedabad"};
		arricb=new JComboBox(arriarray);
		arricb.setBounds(700, 200, 200, 25);
		
		String[] depaarray= {"Choose Departure Location","Chennai","Delhi","Mumbai","Kolkata","Hyderabad","Bangalore","Ahmedabad"};
		depacb=new JComboBox(depaarray);
		depacb.setBounds(100, 200, 200, 25);
		
		String[] timearray= {"Choose Time","7 a.m.","10 a.m.","12 noon","3 p.m.","6 p.m.","9 p.m.","12 midnight","2 a.m."};
		timecb=new JComboBox(timearray);
		timecb.setBounds(400, 200, 200, 25);
		
		String[] adultarray= {"Choose No of Adults","0","1","2","3","4","5"};
		adultcb=new JComboBox(adultarray);
		adultcb.setBounds(100,100,200,25);
		
		String[] childarray= {"Choose No of Children(Age<6)","0","1","2","3"};
		childcb=new JComboBox(childarray);
		childcb.setBounds(700, 100, 200, 25);
		
		String[] datearray= {"Choose Date","Tomorrow","Day After Tomorrow"};
		datecb=new JComboBox(datearray);
		datecb.setBounds(400, 100, 200, 25);
		
		String[] mealarray= {"Choose Meal","No Meal","Indian Veg Meal","Indian Non-Veg Meal","Fruit Platter","Italian Veg Meal","Italian Non-Veg Meal","Jain Meal"};
		mealcb=new JComboBox(mealarray);
		mealcb.setBounds(400, 0, 200, 25);
		
		bannerbutton.setBounds(225, 360, 550, 300);
		bannerbutton.setBackground(Color.BLACK);
		bannerbutton.setIcon(pic);
		bannerbutton.setFocusable(false);
		
		version.setBounds(900,10,100,30);
		version.setForeground(Color.WHITE);
		version.setFont(new Font("Arial",Font.BOLD,15));
		
		confirmButton.setBounds(400, 250, 200, 100);
		confirmButton.setBorder(BorderFactory.createBevelBorder(1));
		confirmButton.setForeground(Color.green);
		confirmButton.setBackground(Color.red);
		confirmButton.setFont(new Font("Times New Roman",Font.BOLD,25));
		confirmButton.setFocusable(false);
		confirmButton.addActionListener(this);
		confirmButton.setVerticalTextPosition(SwingConstants.NORTH);
		confirmButton.setHorizontalTextPosition(SwingConstants.CENTER);
		
		contButton.setBounds(400, 350, 200, 100);
		contButton.setBorder(BorderFactory.createBevelBorder(1));
		contButton.setForeground(Color.green);
		contButton.setBackground(Color.red);
		contButton.setFont(new Font("Times New Roman",Font.BOLD,25));
		contButton.setFocusable(false);
		contButton.addActionListener(this);
		contButton.setVerticalTextPosition(SwingConstants.NORTH);
		contButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contButton.setVisible(false);
		
		pricelabel.setBounds(425, 200, 200, 100);
		pricelabel.setFont(new Font("Arial",Font.PLAIN,30));
		pricelabel.setForeground(Color.green);
		
		note1.setBounds(25, 680, 1000,15);
		note1.setFont(new Font("Arial",Font.PLAIN,12));
		note1.setForeground(Color.WHITE);
		
		note2.setBounds(25, 700, 1000, 15);
		note2.setFont(new Font("Arial",Font.PLAIN,12));
		note2.setForeground(Color.WHITE);
		
		note3.setBounds(25, 720, 1000,15);
		note3.setFont(new Font("Arial",Font.PLAIN,12));
		note3.setForeground(Color.WHITE);
		
		note4.setBounds(25, 720, 1000, 15);
		note4.setFont(new Font("Arial",Font.PLAIN,12));
		note4.setForeground(Color.WHITE);
		
		exbox.setBounds(100, 0, 200, 25);
		exbox.setFont(new Font("Arial",Font.ITALIC,20));
		exbox.setFocusable(false);
		
		wcbox.setBounds(700, 0, 200, 25);
		wcbox.setFont(new Font("Arial",Font.ITALIC,20));
		wcbox.setFocusable(false);
		
		mainframe.setPreferredSize(new Dimension(1000,775));
		mainframe.setTitle("book_a_kairline.com/choose_details/chooser");
		mainframe.setLayout(null);
		mainframe.add(depacb);
		mainframe.add(arricb);
		mainframe.add(timecb);
		mainframe.add(adultcb);
		mainframe.add(childcb);
		mainframe.add(datecb);
		mainframe.add(mealcb);
		mainframe.add(confirmButton);
		mainframe.add(bannerbutton);
		mainframe.add(contButton);
		mainframe.add(note1);
		mainframe.add(note2);
		mainframe.add(note3);
		mainframe.add(pricelabel);
		mainframe.add(exbox);
		mainframe.add(wcbox);
		mainframe.pack();
		mainframe.getContentPane().setBackground(Color.BLACK);
		mainframe.setVisible(true);
		
		
		String[] moparray= {"Choose","Net Banking","EMI"};
		mopcb=new JComboBox(moparray);
		mopcb.setBounds(400, 125, 200, 25);
		
		String[] emiarray= {"Choose term","3 months","6 months","9 months","12 months"};
		emichoosecb=new JComboBox(emiarray);
		emichoosecb.setBounds(400, 125, 200, 25);
		emichoosecb.setVisible(false);
		
		label1.setBounds(300, 25, 400, 100);
		label1.setFont(new Font("Arial",Font.BOLD,30));
		label1.setForeground(Color.WHITE);
		
		confButton.setBounds(450, 200, 100, 50);
		confButton.setBorder(BorderFactory.createBevelBorder(1));
		confButton.setForeground(Color.green);
		confButton.setBackground(Color.red);
		confButton.setFont(new Font("Times New Roman",Font.BOLD,25));
		confButton.setFocusable(false);
		confButton.addActionListener(this);
		confButton.setVerticalTextPosition(SwingConstants.NORTH);
		confButton.setHorizontalTextPosition(SwingConstants.CENTER);
		
		emiconfButton.setBounds(450, 200, 100, 50);
		emiconfButton.setBorder(BorderFactory.createBevelBorder(1));
		emiconfButton.setForeground(Color.green);
		emiconfButton.setBackground(Color.red);
		emiconfButton.setFont(new Font("Times New Roman",Font.BOLD,25));
		emiconfButton.setFocusable(false);
		emiconfButton.addActionListener(this);
		emiconfButton.setVerticalTextPosition(SwingConstants.NORTH);
		emiconfButton.setHorizontalTextPosition(SwingConstants.CENTER);
		emiconfButton.setVisible(false);
		
		emiprice.setBounds(200, 300, 600, 100);
		emiprice.setFont(new Font("Arial",Font.BOLD,30));
		emiprice.setForeground(Color.WHITE);
		emiprice.setVisible(false);
		
		payeename.setBounds(200, 400, 600, 100);
		payeename.setFont(new Font("Arial",Font.BOLD,30));
		payeename.setForeground(Color.WHITE);
		payeename.setVisible(false);
		
		accnum.setBounds(200, 510, 600, 100);
		accnum.setFont(new Font("Arial",Font.BOLD,30));
		accnum.setForeground(Color.WHITE);
		accnum.setVisible(false);
		
		ifsccode.setBounds(200, 620, 600, 100);
		ifsccode.setFont(new Font("Arial",Font.BOLD,30));
		ifsccode.setForeground(Color.WHITE);
		ifsccode.setVisible(false);
		
		thankyou.setBounds(200, 25, 600, 200);
		thankyou.setFont(new Font("Arial",Font.BOLD,75));
		thankyou.setForeground(Color.WHITE);
		thankyou.setVisible(false);
		
		bookingidlabel.setBounds(200, 230, 600, 70);
		bookingidlabel.setFont(new Font("Arial",Font.BOLD,30));
		bookingidlabel.setForeground(Color.WHITE);
		bookingidlabel.setVisible(false);
		
		frame.setPreferredSize(new Dimension(1000,825));
		frame.setTitle("book_a_kairline.com/payment_chooser/doing");
		frame.setLayout(null);
		frame.add(label1);
		frame.add(accnum);
		frame.add(ifsccode);
		frame.add(thankyou);
		frame.add(payeename);
		frame.add(bookingidlabel);
		frame.add(note4);
		frame.add(mopcb);
		frame.add(emichoosecb);
		frame.add(version);
		frame.add(emiconfButton);
		frame.add(emiprice);
		frame.add(confButton);
		frame.pack();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(false);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==confirmButton)
		{
			mainframe.setTitle("book_a_kairline.com/choose_details/chose");
			String departure=(String) depacb.getSelectedItem();
			String arrival=(String) arricb.getSelectedItem();
			String time=(String) timecb.getSelectedItem();
			String adults=(String) adultcb.getSelectedItem();
			String children=(String) childcb.getSelectedItem();
			String date=(String) datecb.getSelectedItem();
			String meal=(String) mealcb.getSelectedItem();
			boolean wcstate= wcbox.isSelected();
			boolean exstate=exbox.isSelected();
			switch(departure)
			{
			case "Choose Departure Location":
				flag=0;
				break;
			}
			switch(arrival)
			{
			case "Chennai":
				price+=3000.0;
				break;
			case "Delhi":
				price+=3500.0;
				break;
			case "Mumbai":
				price+=3500.0;
				break;
			case "Kolkata":
				price+=3000.0;
				break;
			case "Bangalore":
				price+=3000.0;
				break;
			case "Hyderabad":
				price+=3000.0;
				break;
			case "Ahmedabad":
				price+=2500.0;
				break;
			default:
				flag=0;
				break;
			}
			switch(time)
			{
			case "7 a.m.":
				price+=250.0;
				break;
			case "10 a.m.":
				price+=500.0;
				break;
			case "12 noon":
				price+=500.0;
				break;
			case "3 p.m.":
				price+=500.0;
				break;
			case "6 p.m.":
				price+=1000.0;
				break;
			case "9 p.m.":
				price+=1000.0;
				break;
			case "12 midnight":
				price+=250.0;
				break;
			case "2 a.m.":
				price+=125.0;
				break;
			default:
				flag=0;
				break;
			}
			switch(date)
			{
			case "Tomorrow":
				price+=500.0;
				break;
			case "Day After Tomorrow":
				price+=250.0;
				break;
			default:
				flag=0;
				break;
			}
			switch(meal)
			{
			case "No Meal":
				break;
			case "Indian Veg Meal":
			case "Indian Non-Veg Meal":
			case "Jain Meal":
				price+=500.0;
				break;
			case "Italian Veg Meal":
			case "Italian Non-Veg Meal":
				price+=750.0;
				break;
			case "Fruit Platter":
				price+=625.0;
				break;
			default:
				flag=0;
				break;
			}
			switch(adults)
			{
			case "0":
			case "1":
				break;
			case "2":
				price*=2;
				break;
			case "3":
				price*=3;
				break;
			case "4":
				price*=4;
				break;
			case "5":
				price*=5;
				break;
			default:
				flag=0;
				break;
			}
			switch(children)
			{
			case "0":
                break;
			case "1":
				price+=1000.0;
				break;
			case "2":
				price+=1750.0;
				break;
			case "3":
				price+=2500.0;
				break;
			default:
				flag=0;
				break;
			}
			if(wcstate==true)
				price+=500.0;
			if(exstate==true)
				price+=500.0;
			if(adults=="0" && children=="0")
				flag=0;
			if(departure.equals(arrival))
				flag=0;
			if(flag==0)
				pricelabel.setText("ERROR");
			else
			{
				price+=250.0;
				price*=1.18;
			    contButton.setVisible(true);
				pricelabel.setText("Price: "+(int)price);
			}
			confirmButton.setVisible(false);
			arricb.setVisible(false);
			depacb.setVisible(false);
			timecb.setVisible(false);
			adultcb.setVisible(false);
			childcb.setVisible(false);
			datecb.setVisible(false);
			mealcb.setVisible(false);
			exbox.setVisible(false);
			wcbox.setVisible(false);
			bannerbutton.setVisible(false);
		}
		else if(e.getSource()==contButton)
		{
			frame.setVisible(true);
			mainframe.dispose();
		}
		else if(e.getSource()==confButton)
		{
			mopcb.setVisible(false);
			confButton.setVisible(false);
			String mop=(String) mopcb.getSelectedItem();
			switch(mop)
			{
			case "Net Banking":
				label1.setVisible(false);
				emiprice.setText("The amount to be payed: "+(int)price);
				emiprice.setVisible(true);
				payeename.setVisible(true);
				accnum.setVisible(true);
				note4.setVisible(false);
				ifsccode.setVisible(true);
				thankyou.setVisible(true);
				frame.setTitle("book_a_kairline.com/payment_chooser/done");
				bookingidlabel.setVisible(true);
				break;
			case "EMI":
				label1.setVisible(false);
				emichoosecb.setVisible(true);
				emiconfButton.setVisible(true);
				note4.setVisible(false);
				break;
			default:
				label1.setText("Error");
				break;
			}
		}
		else if(e.getSource()==emiconfButton)
		{
			emichoosecb.setVisible(false);
			emiconfButton.setVisible(false);
			String emiterm=(String)emichoosecb.getSelectedItem();
			frame.setTitle("book_a_kairline.com/payment_chooser/done");
			switch(emiterm)
			{
			case "3 months":
				price*=1.07;
				emiprice.setText("The installment per month is: "+(int)(price/3));
				emiprice.setVisible(true);
				payeename.setVisible(true);
				accnum.setVisible(true);
				ifsccode.setVisible(true);
				thankyou.setVisible(true);
				bookingidlabel.setVisible(true);
				break;
			case "6 months":
				price*=1.07;
				emiprice.setText("The installment per month is: "+(int)(price/6));
				emiprice.setVisible(true);
				payeename.setVisible(true);
				accnum.setVisible(true);
				ifsccode.setVisible(true);
				thankyou.setVisible(true);
				bookingidlabel.setVisible(true);
				break;	
			case "9 months":
				price*=1.09;
				emiprice.setText("The installment per month is: "+(int)(price/9));
				emiprice.setVisible(true);
				payeename.setVisible(true);
				accnum.setVisible(true);
				ifsccode.setVisible(true);
				thankyou.setVisible(true);
				bookingidlabel.setVisible(true);
				break;
			case "12 months":
				price*=1.11;
				emiprice.setText("The installment per month is: "+(int)(price/12));
				emiprice.setVisible(true);
				payeename.setVisible(true);
				accnum.setVisible(true);
				ifsccode.setVisible(true);
				thankyou.setVisible(true);
				bookingidlabel.setVisible(true);
				break;
			default:
				emiprice.setText("Error");
				emiprice.setVisible(true);
				break;	
			}
		}
	}
}