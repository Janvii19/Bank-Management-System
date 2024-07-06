package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signup2 extends JFrame implements ActionListener {
    JTextField  pannoTextField, aadharTextField ;
    JRadioButton eyes,eno,syes,sno;
    JButton next;
    long random;
    
    JComboBox religion,category,income,occupation,education;
signup2(String formno){
   
    setLayout(null);
    JLabel personalDetails = new JLabel("Page 2: Additional Details");
    personalDetails.setFont(new Font("Raleway",Font.BOLD,25));
    personalDetails.setBounds(290,80,400,30);
    add(personalDetails);
    
    JLabel name = new JLabel("Religion:");
    name.setFont(new Font("Raleway",Font.BOLD,20));
    name.setBounds(100,150,400,30);
    add(name);
    String valReligion[] ={"Hindu","Muslim","sikh","Christian","other"};
  religion = new JComboBox(valReligion);
   religion.setBackground(Color.white);
   religion.setBounds(300,150,400,30);
    add(religion);
     
    JLabel fname = new JLabel("Category:");
    fname.setFont(new Font("Raleway",Font.BOLD,20));
    fname.setBounds(100,200,400,30);
    add(fname);
    String valCategory[] ={"General","OBC","ST","SC","other"};
    category = new JComboBox(valCategory);
   category.setBackground(Color.white);
  category.setBounds(300,200,400,30);
  add(category);  
    
    JLabel dob = new JLabel("Income");
    dob.setFont(new Font("Raleway",Font.BOLD,20));
    dob.setBounds(100,250,400,30);
    add(dob);
    
     String valincome[] ={"NULL","<1,50,000","<2,50,000","5,00,000","Upto 10,00,000"};
    income = new JComboBox(valincome);
   income.setBackground(Color.white);
   income.setBounds(300,250,400,30);
    add(income);
   
    
   JLabel email = new JLabel("Education");
    email.setFont(new Font("Raleway",Font.BOLD,20));
    email.setBounds(100,310,400,30);
    add(email);
   JLabel marital = new JLabel("Qualification:");
    marital.setFont(new Font("Raleway",Font.BOLD,20));
    marital.setBounds(100,335,400,30);
    add(marital);
    
    String valeducation[] ={"Non-Graducation","Graduate","Post-Graduate","doctrate","Other"};
   education = new JComboBox(valeducation);
  education.setBackground(Color.white);
   education.setBounds(300,320,400,30);
    add(education);
     
    
    JLabel address = new JLabel("Occupation:");
    address.setFont(new Font("Raleway",Font.BOLD,20));
    address.setBounds(100,385,400,30);
    add(address);
    
    String valoccupation[] ={"Salaried","Self-Empolyed","Bussiness","Retired","Other"};
    occupation = new JComboBox(valoccupation);
  occupation.setBackground(Color.white);
   occupation.setBounds(300,385,400,30);
    add(occupation);
     
    JLabel state = new JLabel("PAN Number:");
    state.setFont(new Font("Raleway",Font.BOLD,20));
    state.setBounds(100,440,400,30);
    add(state);
      pannoTextField = new JTextField();
    pannoTextField.setFont(new Font("Raleway",Font.BOLD,14));
    pannoTextField.setBounds(300,440,400,30);
    add(pannoTextField);
    
    JLabel city = new JLabel("Aadhar Card:");
    city.setFont(new Font("Raleway",Font.BOLD,20));
    city.setBounds(100,500,400,30);
    add(city);
   aadharTextField = new JTextField();
   aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
   aadharTextField.setBounds(300,500,400,30);
    add(aadharTextField);
    
    JLabel pincode = new JLabel("Senior Citizen:");
    pincode.setFont(new Font("Raleway",Font.BOLD,20));
    pincode.setBounds(100,560,400,30);
    add(pincode);
     syes = new JRadioButton("Yes");
    syes.setBackground(Color.white);
    syes.setBounds(300,560,50,30);
    add(syes);
     sno = new JRadioButton("No");
    sno.setBackground(Color.white);
    sno.setBounds(400,560,50,30);
    add(sno);
    ButtonGroup senior = new ButtonGroup();
    senior.add(syes);
    senior.add(sno);
    
     JLabel ex = new JLabel("Existing Account:");
    ex.setFont(new Font("Raleway",Font.BOLD,20));
    ex.setBounds(100,610,400,30);
    add(ex);
    eyes = new JRadioButton("Yes");
    eyes.setBackground(Color.white);
    eyes.setBounds(300,610,50,30);
    add(eyes);
    eno = new JRadioButton("No");
    eno.setBackground(Color.white);
    eno.setBounds(400,610,50,30);
    add(eno);
    ButtonGroup acc = new ButtonGroup();
    acc.add(eyes);
    acc.add(eno);
    
    
    next = new JButton("Next");
    next.setBackground(Color.orange);
    next.setForeground(Color.BLACK);
    next.setBounds(640,650,60,30);
    next.addActionListener(this);
    add(next);
    
     getContentPane().setBackground(Color.WHITE);
    setSize(850,800);
    setLocation(350,10);
    setVisible(true);
   
}
public void actionPerformed(ActionEvent ae){
    String  formno = "" + random;
    String sreligion = (String)religion.getSelectedItem();
    String scategory =(String)category.getSelectedItem();
    String sincome =(String)income.getSelectedItem();
    String seducation =(String)education.getSelectedItem();
    String soccupation=(String)occupation.getSelectedItem();
    String span = pannoTextField.getText();
    String saadhar = aadharTextField.getText();
    String senior = null;
    if(syes.isSelected()){
        senior = "Yes";
    }else if(sno.isSelected()){
        senior = "No";
    }
     
    String acc = null;
    if(eyes.isSelected()){
        acc = "Yes";
    }else if(eno.isSelected()){
        acc  = "No";
    }
   
     
   try{
       
          Conn c = new Conn();
          String query= "insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+senior+"','"+acc+"')";
          c.s.executeUpdate(query);
          
          setVisible(false);
          new signup3(formno).setVisible(true);
       }
   catch(Exception e){
       System.out.println(e);
   }
}
    
    

    
    public static void main(String[] args) {
        new signup2("");
    }
    
}
