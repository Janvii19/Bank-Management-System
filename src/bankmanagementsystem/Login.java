package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 import java.sql.*;
public class Login extends JFrame implements ActionListener {
JButton signin,clear,signup;
JTextField cardTextField;
JPasswordField pinTextField;
    
    Login(){
    setTitle("AUTOMATED TELLER MACHINE");
    setLayout(null);
    ImageIcon i1 = new ImageIcon( ClassLoader.getSystemResource("icons/logo.jpg"));
    Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel label= new JLabel(i3);
    label.setBounds(70,10,100,100);
    add(label);
     JLabel text = new JLabel("WELCOME TO ATM");
     text.setFont(new Font("Osawrd",Font.BOLD,38));
     text.setBounds(200,40,400,40);
     add(text);
     
     JLabel cardno = new JLabel("Card No:");
     cardno.setFont(new Font("Raleway",Font.BOLD,28));
     cardno.setBounds(120,150,150,40);
     add(cardno);
     cardTextField = new JTextField();
     cardTextField.setBounds(300,150,230,30);
     add(cardTextField);
     
     JLabel pin = new JLabel("Pin:");
     pin.setFont(new Font("Raleway",Font.BOLD,28));
     pin.setBounds(120,220,250,30);
     add(pin);
     
     pinTextField = new JPasswordField();
     pinTextField.setBounds(300,220,230,30);
     add(pinTextField);

      signin = new JButton("SIGN IN");
     signin.setBounds(300,300,100,31);
     signin.setBackground(Color.orange);
     signin.setForeground(Color.black);
     signin.addActionListener(this);
    add(signin);
    
      clear = new JButton("CLEAR");
     clear.setBounds(430,300,100,30);
     clear.setBackground(Color.orange);
     clear.setForeground(Color.black);
     clear.addActionListener(this);
     add(clear);
     
      signup = new JButton("SIGN UP");
     signup.setBounds(300,350,230,30);
     signup.setBackground(Color.orange);
     signup.setForeground(Color.black);
     signup.addActionListener(this);
     add(signup);
    
     getContentPane().setBackground(Color.WHITE);
    setSize(800, 480);
    setVisible(true);
    setLocation(350,200);
}
public void actionPerformed(ActionEvent e){
    if(e.getSource()== clear){
        cardTextField.setText("");
        pinTextField.setText("");
        }else if (e.getSource() == signin ){
            Conn conn = new Conn();
            String cardno = cardTextField.getText();
             String pinno = pinTextField.getText();
             String query = "select*from login where cardnumber = '"+cardno+"' and pinnumber = '"+pinno+"'";
             try{
             ResultSet rs = conn.s.executeQuery(query);
             if(rs.next()){
                 setVisible(false);
                 new transaction(pinno).setVisible(true);
             }else {
                 JOptionPane.showMessageDialog(null,"Incorrect card no. or pin");
             }
             }catch(Exception i){
                 System.out.println(i);
                 
             }
             
        }else if(e.getSource()== signup){
            setVisible(false);
            new signup1().setVisible(true);
        }
    
}
    
    public static void main(String[] args) {
       new Login();
    }
    
}
