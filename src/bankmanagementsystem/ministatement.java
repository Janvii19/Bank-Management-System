package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
public class ministatement extends JFrame {
String pinno;    
ministatement(String pinno){
    this.pinno = pinno;
    setTitle("Mini Statement");
    setLayout(null);
     JLabel mini = new JLabel();
     mini.setBounds(20,140,400,200);
     add(mini);
     
    JLabel bank = new JLabel("JANVI BANK");
     bank.setBounds(150,20,100,20);
     add(bank);
    
    JLabel card = new JLabel();
     card.setBounds(20,80,300,20);
     add(card);
    
    JLabel balance = new JLabel();
     balance.setBounds(20,400,300,20);
     add(balance);
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select*from login where pinnumber = '"+pinno+"'");
        while(rs.next()){
            card.setText("CARD NUMBER: "+ rs.getString("cardnumber").substring(0,4)+"XXXXXXXXXXXX");
        }
    }catch(Exception e){
        System.out.println(e);
    }
    
    try{
        Conn c = new Conn();
        int bal =0;
        ResultSet rs = c.s.executeQuery("select*from bank where pinno = '"+pinno+"'");
        while(rs.next()){
            mini.setText(mini.getText()+ "<html>" + rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("number")+"<br><br>");
            if(rs.getString("type").equals("deposit")){
                bal+= Integer.parseInt(rs.getString("number"));
            }else{
                bal -= Integer.parseInt(rs.getString("number"));
            }
            balance.setText("YOUR CUURENT ACCOUNT BALACNE Is RS:"+bal);
        }
    }catch(Exception e){
        System.out.println(e);
    }
    
    
    
    setSize(400,600);
    setLocation(20,20);
    setVisible(true);
}
   
    public static void main(String[] args) {
     new ministatement("");
     
    }
    
}
