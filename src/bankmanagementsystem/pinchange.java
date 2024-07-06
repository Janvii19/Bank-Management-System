package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class pinchange extends JFrame implements ActionListener{
    String pinno;
    JPasswordField pin,repin;
    JButton back,change;
pinchange(String pinno){
    this.pinno = pinno;
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
   Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
   ImageIcon i3 = new ImageIcon(i2);
   JLabel image = new JLabel(i3);
   image.setBounds(0,0,900,900);
   add(image);
    
    JLabel text = new JLabel("CHANGE YOUR PIN");
    text.setBounds(250,280,500,35);
    text.setForeground(Color.white);
    text.setFont(new Font("System", Font.BOLD,16));
    image.add(text);
    
     JLabel pintext = new JLabel("New Pin");
    pintext.setBounds(165,320,180,25);
    pintext.setForeground(Color.white);
    pintext.setFont(new Font("System", Font.BOLD,16));
    image.add(pintext);
    pin = new JPasswordField();
    pin.setBounds(330,320,180,25);
    pin.setFont(new Font("System", Font.BOLD,16));
    image.add(pin);
   
     JLabel repintext = new JLabel("New Pin");
    repintext.setBounds(165,360,180,25);
    repintext.setForeground(Color.white);
    repintext.setFont(new Font("System", Font.BOLD,16));
    image.add(repintext);
    repin = new JPasswordField();
    repin.setBounds(330,360,180,25);
    repin.setFont(new Font("System", Font.BOLD,16));
    image.add(repin);
    
   change = new JButton("CHANGE");
   change.setBounds(355,485,150,25);
   change.setBackground(new Color(136,230,19));
   change.addActionListener(this);
   
   image.add(change);
   back = new JButton("BACK");
   back.setBounds(355,520,150,25);
   back.setBackground(new Color(136,230,19));
   back.addActionListener(this);
   image.add(back);
    
    setSize(900,900);
    setLocation(300,0);
    setVisible(true);
}
   
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()== change){
        try{
            String npin = pin.getText();
            String rpin = repin.getText();
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"ENTER PIN DOES NOT MATCH");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE ENTER NEW PIN");
                return;
            } if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE RE-ENTER NEW PIN");
                return;
            }
            Conn c = new Conn();
            String  query1 = "update bank set pinno ='"+rpin+"' where pinno ='"+pinno+"'";
            String  query2 = "update signup3 set pinnumber ='"+rpin+"' where pinnumber ='"+pinno+"'";
             String  query3 = "update login set pinnumber ='"+rpin+"' where pinnumber ='"+pinno+"'";
              c.s.executeUpdate(query1);
              c.s.executeUpdate(query2);
              c.s.executeUpdate(query3);
              JOptionPane.showMessageDialog(null,"PIN CHANGE SUCESSFULLY");
              setVisible(false);
              new transaction(pinno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }else{
           setVisible(false);
              new transaction(pinno).setVisible(true);     
                }
}
    public static void main(String[] args) {
        new pinchange("").setVisible(true);
    }
    
}
