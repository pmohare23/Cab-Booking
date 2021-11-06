
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

import com.Queries;

public class View extends JFrame
{
JPanel jp;
JButton b1;
	
JScrollPane jsc;
JTable table;

String heading[]={"Car","Name","Source","Destination","No. of Seats","Trip Id"};
Object data[][]=null;

public View()
{
super("View All Employees");

b1 = new JButton("Back");
jp=new JPanel();

jp.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 35));

jp.add(b1);
add(jp);

setSize(500,250);
setResizable(false);
Queries q = new Queries();
data = q.selectAsArray();
table = new JTable(data,heading);
jsc=(JScrollPane) new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


for(int i=0;i<data.length;i++)
for(int j=0;j<data[0].length;j++)

table.setValueAt(data[i][j],i,j);
add(jsc);
setLocation(290,200);
setVisible(true);

addWindowListener(new WindowAdapter() {
public void windowClosing(WindowEvent we){
new Home();
dispose();
}
});

b1.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		dispose();
		new Home();
	}
});
}
}

 






