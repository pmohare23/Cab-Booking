
import java.awt.*;
import javax.swing.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.*;

public class Bookcab extends JFrame {	
    JPanel p1,p2,p3;
    JLabel name,src,dest,seats,trip_id;
    JRadioButton rb1,rb2,rb3;
    ButtonGroup bg1;
    JComboBox<Integer> nos;
    JTextField tf1,tf2,tf3,tf4;
    JButton sub,reset,back;
    Container con;
    String carType;
    
    
    public Bookcab(){
    super("Book a cab");
	con = getContentPane();
	con.setLayout(new BoxLayout(con,BoxLayout.Y_AXIS)); 
	setSize(420,280);
        setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	p1.setBorder(BorderFactory.createTitledBorder("Cabs"));
	trip_id = new JLabel("Id No. :");
	tf4= new JTextField(10);
	rb1 = new JRadioButton("Mini",true);
	rb2 = new JRadioButton("Sedan");
	rb3 = new JRadioButton("Prime");
	bg1= new ButtonGroup();
	bg1.add(rb1);
	bg1.add(rb2);
	bg1.add(rb3);
	p1.add(trip_id);
	p1.add(tf4);
	p1.add(rb1);
	p1.add(rb2);
	p1.add(rb3);
	con.add(p1);
	   
	p2 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
	p2.setBorder(BorderFactory.createTitledBorder("Details"));
	Integer[] s = { 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 }; 
	
	name = new JLabel("Name :");
	tf1= new JTextField(15);
    seats= new JLabel("No. of seats :");
    nos= new JComboBox<Integer>(s);
	src = new JLabel("Source :");
	tf2= new JTextField(10);
	dest = new JLabel("Destination :");
	tf3= new JTextField(10);
	
	p2.add(name);
	p2.add(tf1);
    p2.add(seats);
	p2.add(nos);
	p2.add(src);
	p2.add(tf2);
	p2.add(dest);
	p2.add(tf3);
	con.add(p2);   
           
        sub = new JButton("Submit");
        reset = new JButton("Reset");
        back= new JButton("Back");
        p3 = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
        p3.add(sub);
        p3.add(reset);
        p3.add(back);
        con.add(p3);
        
        // event handling
        
        rb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				carType=rb1.getActionCommand();
				
			}
		});
        
        rb2.addActionListener(new ActionListener() {
			
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    			
    				carType=rb2.getActionCommand();
    				
    			}
    		});
        rb3.addActionListener(new ActionListener() {
			
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    			
    				carType=rb3.getActionCommand();
    				
    			}
    		});
        
        sub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(tf1.getText().equals("")){
                    JOptionPane.showMessageDialog(con,"Please Enter Name");
                    tf1.requestFocus();
                }
                else if(tf2.getText().equals("")){
                    JOptionPane.showMessageDialog(con,"Please Enter Source");
                    tf2.requestFocus();
                }
                else if(tf3.getText().equals("")){
                    JOptionPane.showMessageDialog(con,"Please Enter Destination");
                    tf3.requestFocus();
                }
                else{
                    Queries q = new Queries();
                    System.out.println(carType);
                    q.insert(carType, tf1.getText(), tf2.getText(),tf3.getText(),(Integer)nos.getSelectedItem(),Integer.parseInt(tf4.getText()));
                    
                    JOptionPane.showMessageDialog(con,"Cab Booked Successfully !");
                    Home h= new Home();
                    dispose();
                }
            }
        });
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Bookcab e = new Bookcab();
                dispose();
            }
        });
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Home h= new Home();
                dispose();
            }
        });
        setLocationRelativeTo(null);
	    setVisible(true);
    }
}
