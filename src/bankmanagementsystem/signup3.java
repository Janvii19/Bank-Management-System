package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class signup3 extends JFrame implements ActionListener {
  String formno;
  JRadioButton r1,r2,r3,r4;
  JCheckBox c1,c2,c3,c4,c5,c6,c7;
  JButton submit , cancel;
signup3(String formno){
    this.formno =formno;
    setLayout(null);
     JLabel i1 = new JLabel("Page 3: Account Details");
     i1.setBounds(280,40,400,40);
     i1.setFont(new Font("Raleway",Font.BOLD,22));
     add(i1);
    
     
     JLabel type= new JLabel(" Account Type");
     type.setBounds(100,140,200,40);
     type.setFont(new Font("Raleway",Font.BOLD,22));
     add(type);
    
     r1 = new JRadioButton("Saving Account");
     r1.setFont(new Font("Raleway",Font.BOLD,16));
     r1.setBackground(Color.white);
     r1.setBounds(100,190,200,20);
     add(r1);
    
     r2 = new JRadioButton("Fixed Deposit Account");
     r2.setFont(new Font("Raleway",Font.BOLD,16));
     r2.setBackground(Color.white);
     r2.setBounds(350,190,250,20);
     add(r2);
    
     r3 = new JRadioButton("Current Account");
     r3.setFont(new Font("Raleway",Font.BOLD,16));
     r3.setBackground(Color.white);
     r3.setBounds(100,230,200,20);
     add(r3);
     
     r4 = new JRadioButton("Recurring Deposit Account");
     r4.setFont(new Font("Raleway",Font.BOLD,16));
     r4.setBackground(Color.white);
     r4.setBounds(350,230,250,20);
     add(r4);
     
     ButtonGroup group = new ButtonGroup();
     group.add(r1);
     group.add(r2);
     group.add(r3);
     group.add(r4); 
    
    JLabel card = new JLabel("Card Number:");
    card.setFont(new Font("Raleway",Font.BOLD,22));
    card.setBounds(100,300,200,40);
    add(card);
     
   JLabel number = new JLabel("XXXX-XXXXX-XXXX-4184");
   number.setFont(new Font("Raleway",Font.BOLD,22));
   number.setBounds(300,300,300,40);
   add(number);
    
   JLabel carddetail = new JLabel("(Your 16 Digit Card Number)");
    carddetail.setFont(new Font("Raleway",Font.BOLD,12));
    carddetail.setBounds(100,320,300,40);
    add(carddetail);
    
    JLabel pin = new JLabel("Pin:");
    pin.setFont(new Font("Raleway",Font.BOLD,22));
    pin.setBounds(100,370,200,40);
    add(pin);
    JLabel pindetail = new JLabel("(Your 4 Digit Password)");
    pindetail.setFont(new Font("Raleway",Font.BOLD,12));
    pindetail.setBounds(100,390,300,40);
    add(pindetail);
    
    
   JLabel pno = new JLabel("XXXX");
   pno.setFont(new Font("Raleway",Font.BOLD,22));
   pno.setBounds(300,370,300,40);
   add(pno);
   
   JLabel service= new JLabel(" Services Required");
    service.setBounds(100,450,200,40);
    service.setFont(new Font("Raleway",Font.BOLD,22));
     add(service);
   
     c1 = new JCheckBox("ATM CARD");
     c1.setFont(new Font("Raleway",Font.BOLD,16));
     c1.setBackground(Color.white);
     c1.setBounds(100,500,200,30);
     add(c1);
      c2 = new JCheckBox("Mobile Banking");
     c2.setFont(new Font("Raleway",Font.BOLD,16));
     c2.setBackground(Color.white);
     c2.setBounds(100,550,200,30);
     add(c2); 
     c3 = new JCheckBox("Cheque Book");
     c3.setFont(new Font("Raleway",Font.BOLD,16));
     c3.setBackground(Color.white);
     c3.setBounds(100,600,200,30);
     add(c3);
     c4 = new JCheckBox(" Internet Banking");
     c4.setFont(new Font("Raleway",Font.BOLD,16));
     c4.setBackground(Color.white);
     c4.setBounds(350,500,200,30);
     add(c4);
    
     c5 = new JCheckBox("Email & SMS Alerts");
     c5.setFont(new Font("Raleway",Font.BOLD,16));
     c5.setBackground(Color.white);
     c5.setBounds(350,550,250,30);
     add(c5);
     c6 = new JCheckBox("E-Statement");
     c6.setFont(new Font("Raleway",Font.BOLD,16));
     c6.setBackground(Color.white);
     c6.setBounds(350,600,200,30);
     add(c6);
     c7 = new JCheckBox("I Herby declare that the above entered details are correct to the best of by knowledge");
     c7.setFont(new Font("Raleway",Font.BOLD,12));
     c7.setBackground(Color.white);
     c7.setBounds(100,670,600,30);
     add(c7);
         
   submit = new JButton("Submit");
   submit.setBackground(Color.orange);
   submit.setForeground(Color.BLACK);
   submit.setBounds(250,720,100,30);
   submit.addActionListener(this);
   add(submit);
    
  cancel = new JButton("Cancel");
  cancel.setBackground(Color.orange);
  cancel.setForeground(Color.BLACK);
  cancel.setBounds(420,720,100,30);
  cancel.addActionListener(this);
  add(cancel);
     
    setSize(850,820);
    setVisible(true);
    setLocation(350,0);
    getContentPane().setBackground(Color.white);
}
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==submit){
    String accounttype = null;
    if(r1.isSelected()){
        accounttype = "Savings Account";
    }else if(r2.isSelected()){
        accounttype = "Fixed Deposit Account";
    }else if(r3.isSelected()){
        accounttype = "Current Account";
    }else if(r4.isSelected()){
        accounttype = "Recurring Deposit Account";
    }
    Random random = new Random();
    String cardnumber =""+ Math.abs((random.nextLong()%90000000L)+ 5040936000000000L);
    String pinnumber =""+ Math.abs((random.nextLong()%9000L)+ 1000L);
     
    String facility ="";
     if(c1.isSelected()){
         facility = facility +"ATM Card";
     } else if(c2.isSelected()){
         facility = facility +"Mobile Banking";
     }else if(c3.isSelected()){
         facility = facility +"Cheque Book";
     }else if(c4.isSelected()){
         facility = facility +"Internet";
     }else if(c5.isSelected()){
         facility = facility +"Email & SMS Alert";
     }else if(c6.isSelected()){
         facility = facility +"E-Statement";
     }
    
     try{
        
             Conn conn = new Conn();
             String query1 = "insert into signup3 values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
             conn.s.executeUpdate(query1);
              String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
              conn.s.executeUpdate(query2);
              JOptionPane.showMessageDialog(null,"Card Number"+cardnumber+"\npin"+pinnumber);
            setVisible(false);
            new deposit(pinnumber).setVisible(true);
     }catch(Exception e){
         System.out.println(e);
     }
} else if(ae.getSource()== cancel){
    System.exit(0);
}
}
    
    public static void main(String[] args) {
        new signup3("");
    }
    
}
