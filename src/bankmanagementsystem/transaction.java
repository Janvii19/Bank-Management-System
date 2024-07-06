
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class transaction extends JFrame implements ActionListener {
    String pinno;
    JButton deposit,withdraw,fastcash,ministatement,pinchange,balanceenquiry,exit;
transaction(String pinno){
    this.pinno = pinno;
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);
    
    JLabel text = new JLabel("Please Select your Transaction");
    text.setBounds(215,300,700,35);
    text.setForeground(Color.white);
    text.setFont(new Font("System", Font.BOLD,16));
    image.add(text);
    
    deposit = new JButton("deposit");
    deposit.setBounds(170,415,150,30);
   deposit.addActionListener(this);
    image.add(deposit);
    
    withdraw = new JButton("Withdraw");
   withdraw.setBounds(355,415,150,30);
   withdraw.addActionListener(this);
    image.add(withdraw);
   
    fastcash = new JButton("Fastcash");
   fastcash.setBounds(170,450,150,30);
   fastcash.addActionListener(this);
    image.add(fastcash);
  
    ministatement = new JButton("Ministatement");
    ministatement.setBounds(355,450,150,30);
   ministatement.addActionListener(this);
    image.add(ministatement);
   
    pinchange = new JButton("Pinchange");
    pinchange.setBounds(170,485,150,30);
    pinchange.addActionListener(this);
    image.add(pinchange);
     
    balanceenquiry = new JButton("Balanceenquiry");
    balanceenquiry.setBounds(355,485,150,30);
    balanceenquiry.addActionListener(this);
    image.add(balanceenquiry);
    
 exit = new JButton("Exit");
 exit.setBounds(355,520,150,30);
 exit.setBackground(new Color(136,230,19));
 exit.addActionListener(this);
 image.add(exit);
    
    setSize(900,900);
    setLocation(300,0);
    setVisible(true);
}
public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == exit){
        System.exit(0);
    }else if(ae.getSource() == deposit){
        setVisible(false);
        new deposit(pinno).setVisible(true);
    }else if(ae.getSource() == withdraw){
        setVisible(false);
        new withdraw(pinno).setVisible(true);
    }else if(ae.getSource() == fastcash){
        setVisible(false);
        new fastcash(pinno).setVisible(true);
    }else if(ae.getSource() == ministatement){
        setVisible(false);
        new ministatement(pinno).setVisible(true);
    }else if(ae.getSource() == pinchange){
        setVisible(false);
        new pinchange(pinno).setVisible(true);
    }else if(ae.getSource() ==  balanceenquiry){
        setVisible(false);
        new balanceenquiry(pinno).setVisible(true);
    }
}


   
  public static void main(String[] args) {
   new transaction("");
    }
    
}
