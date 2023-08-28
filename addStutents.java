import java.awt.Button;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;

class addStutents extends JFrame {
  addStutents() {

    JLabel AddStudent = new JLabel("ADD STUDENTS ");
    AddStudent.setBounds(790, 130, 150, 60);
    this.add(AddStudent);

    setLayout(null);
    JLabel firstName = new JLabel("FirstName");
    firstName.setBounds(600, 210, 100, 30);
    this.add(firstName);

    JTextField firstNameTextField = new JTextField();
    firstNameTextField.setBounds(660, 210, 150, 30);
    this.add(firstNameTextField);

    JLabel LastName = new JLabel("LastName");
    LastName.setBounds(830, 210, 100, 30);
    this.add(LastName);

    JTextField lastNameTextField = new JTextField();
    lastNameTextField.setBounds(900, 210, 150, 30);
    this.add(lastNameTextField);

    JLabel email = new JLabel("Email");
    email.setBounds(615, 300, 100, 30);
    this.add(email);

    JTextField emailTextField = new JTextField();
    emailTextField.setBounds(660, 300, 150, 30);
    this.add(emailTextField);

    JLabel password = new JLabel("Password");
    password.setBounds(830, 300, 100, 30);
    this.add(password);

    JTextField passwordTextField = new JTextField();
    passwordTextField.setBounds(900, 300, 150, 30);
    this.add(passwordTextField);

    JLabel phone = new JLabel("PhoneNo:");
    phone.setBounds(600, 370, 100, 30);
    this.add(phone);

    JTextField phoneTextField = new JTextField();
    phoneTextField.setBounds(660, 370, 150, 30);
    this.add(phoneTextField);

    JButton Cancel = new JButton("Cancel");
    Cancel.setBounds(810, 450, 100, 30);
    this.add(Cancel);

    JButton save = new JButton("Save");
    save.setBounds(950, 450, 100, 30);
    this.add(save);

    setSize(700, 650);
    setVisible(true);
    setTitle("Add Students");

    save.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String url = "jdbc:mysql://localhost:3306/jagruti_hostel";
        String username = "root";
        String password = "";
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection connection = DriverManager.getConnection(url, username, password);
          java.sql.Statement statement = connection.createStatement();
          String query1 = "INSERT INTO `jagruti_hostel`.`student`"
              + "(firstName,LastName,email,password,phone)"
              + "values ('" + firstNameTextField.getText() + "','" + lastNameTextField.getText() + "','"
              + emailTextField.getText() + "','"
              + Integer.parseInt(passwordTextField.getText()) + "','"
              + Integer.parseInt(phoneTextField.getText()) + "')";
          int i = statement.executeUpdate(query1);
          if (i > 0) {
            JOptionPane.showMessageDialog(null, "student Added SuccessFully............");
            // frame.dispose();
          } else {
            System.out.println("not inserted");
          }
          connection.close();
        } catch (ClassNotFoundException c) {
          System.out.println(c);
        } catch (SQLException SQLException) {
          System.out.println(SQLException.getMessage());
        }

      }
    });
    // CancleButton Qwery
    Cancel.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Cancel) {
          System.exit(0);
        }
      }
    });
    // End CancleButton Qwery

  }

  public static void main(String[] args) {
    addStutents ob = new addStutents();
  }
}
