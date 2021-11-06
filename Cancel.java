
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.Queries;

public class Cancel extends JFrame{
    
	JPanel jp;
	TextField t1;
	JLabel l1;
	JButton b1,b2;
	
	
	public Cancel() 
	{
		 super("Book a cab");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(400,135);
		 setLocation(150, 100);
		 
		 l1 = new JLabel("Trip Id:");
		 t1 = new TextField(10);
		 b1 = new JButton("Cancel Trip");
		 b2 = new JButton("Back");
		 jp=new JPanel();
		 jp.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 35));
		 
		 jp.add(l1);
		 jp.add(t1);
		 jp.add(b1);jp.add(b2);
		 add(jp);
		 
		 // event handling
		 
		 b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 Queries q = new Queries();
				 q.delete(Integer.parseInt(t1.getText()));
				 t1.setText("");
			}
		});
		
		 b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					dispose();
					new Home();
				}
			});

		 setVisible(true);
	}
	
}

