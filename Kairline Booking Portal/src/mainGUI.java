import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class mainGUI implements ActionListener
{
	JFrame mainframe=new JFrame();
	JLabel title=new JLabel("Kairlines Booking Portal");
	JButton bookButton=new JButton("BOOK A FLIGHT");
	ImageIcon ico=new ImageIcon("Resources/planeicon.png");
	JLabel version=new JLabel("version 1.0");
	public mainGUI()
	{
		title.setFont(new Font("Arial",Font.BOLD,40));
		title.setForeground(Color.WHITE);
		title.setBounds(250, 50, 500, 100);
		
		bookButton.setBounds(100,200,750,500);
		bookButton.setBorder(BorderFactory.createBevelBorder(1));
		bookButton.setBackground(Color.GREEN);
		bookButton.setForeground(Color.RED);
		bookButton.setFont(new Font("Times New Roman",Font.ITALIC,50));
		bookButton.setFocusable(false);
		bookButton.setIcon(ico);
		bookButton.addActionListener(this);
		bookButton.setVerticalTextPosition(SwingConstants.NORTH);
		bookButton.setHorizontalTextPosition(SwingConstants.CENTER);
		
		version.setBounds(900,10,100,30);
		version.setForeground(Color.WHITE);
		version.setFont(new Font("Arial",Font.BOLD,15));
		
		mainframe.setPreferredSize(new Dimension(1000,750));
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setTitle("book_a_kairline.com");
		mainframe.setLayout(null);
		mainframe.pack();
		mainframe.add(title);
		mainframe.add(version);
		mainframe.add(bookButton);
		mainframe.getContentPane().setBackground(Color.BLACK);
		mainframe.setVisible(true);
	}
	public static void main(String[] args)
	{
		new mainGUI();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bookButton)
		{
			new PlaneInfoPaymentGUI();
			mainframe.dispose();
		}
	}
}
