
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame{
    JPanel jp;
    JButton book,can_book,view;
    JLabel title;
    
    public Home(){
        super("Booking Agency");
        setSize(500,200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jp = new JPanel();
        title = new JLabel("WELCOME TO MY CAB BOOKING !"); 
        title.setFont(new Font("TimesRoman",Font.BOLD,25));
        book = new JButton("Book Cab");
        can_book = new JButton("Cancel Cab");
        view = new JButton("View Bookings");
        
        
        jp.add(title);
        jp.setLayout(new FlowLayout(FlowLayout.CENTER,15,30));
        jp.add(book);
        jp.add(can_book);
        jp.add(view);
        
        add(jp);
     
        setLocationRelativeTo(null);
        setVisible(true);
     
        book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Bookcab a = new Bookcab();
		        dispose();	
            }
	});
        can_book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cancel b = new Cancel();
                dispose();
            }
        });
        view.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                View c = new View();
                dispose();
            }
	});
        
        }
}
