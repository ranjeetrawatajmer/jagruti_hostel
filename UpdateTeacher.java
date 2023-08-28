import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class updatTeacher extends JFrame {
    updatTeacher() {

        setLayout(null);

        JLabel updateTeacher = new JLabel("UPDATE TEACHER ");
        updateTeacher.setBounds(790, 130, 150, 60);
        this.add(updateTeacher);

        JLabel id = new JLabel("Id");
        id.setBounds(640, 210, 100, 30);
        this.add(id);

        JTextField idTextField = new JTextField();
        idTextField.setBounds(660, 210, 150, 30);
        this.add(idTextField);


        JButton search = new JButton("Search");
        search.setBounds(900, 210, 150, 30);
        this.add(search);

        JLabel firstNameLabel = new JLabel("firstName");
        firstNameLabel.setBounds(600, 300, 100, 30);
        this.add(firstNameLabel);

        JTextField firstNameJTextField = new JTextField();
        firstNameJTextField.setBounds(660, 300, 150, 30);
        this.add(firstNameJTextField);

        JLabel lastNameLabel = new JLabel("lastName");
        lastNameLabel.setBounds(830, 300, 100, 30);
        this.add(lastNameLabel);

        JTextField lastNameJTextField = new JTextField();
        lastNameJTextField.setBounds(900, 300, 150, 30);
        this.add(lastNameJTextField);

        JLabel emailJLabel = new JLabel("Email");
        emailJLabel.setBounds(610, 450, 100, 30);
        this.add(emailJLabel);

        JTextField emailJTextField = new JTextField();
        emailJTextField.setBounds(660, 460, 140, 30);
        this.add(emailJTextField);

        JLabel passwordJLabel = new JLabel("Password:");
        passwordJLabel.setBounds(590, 370, 100, 30);
        this.add(passwordJLabel);

        JTextField passwordTextField = new JTextField();
        passwordTextField.setBounds(660, 370, 150, 30);
        this.add(passwordTextField);

        JLabel mobileNoJLabel = new JLabel("MobileNo:");
        mobileNoJLabel.setBounds(830, 370, 100, 30);
        this.add(mobileNoJLabel);

        JTextField mobileNoTextField = new JTextField();
        mobileNoTextField.setBounds(900, 370, 150, 30);
        this.add(mobileNoTextField);
        
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(810, 450, 100, 30);
        this.add(cancel);
        
        JButton save = new JButton("Save");
        save.setBounds(950, 450, 100, 30);
        this.add(save);

        setSize(700, 650);
        setVisible(true);
        setTitle("UPDATE TEACHER");

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/jagruti_hostel";
                String username = "root";
                String password = "";
                try {
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query1 = "select * from `addteacher` where id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query1);
                    preparedStatement.setString(1, idTextField.getText());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        idTextField.setText(resultSet.getString("Id"));
                        firstNameJTextField.setText(resultSet.getString("firstName"));
                        lastNameJTextField.setText(resultSet.getString("lastName"));
                        emailJTextField.setText(resultSet.getString("Email"));
                        passwordTextField.setText(resultSet.getString("password"));
                        mobileNoTextField.setText(resultSet.getString("mobileNo"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Data not Found");
                    }
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: Unable to Search");
                }
            }
        });

        // Update Button Query
save.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String url = "jdbc:mysql://localhost:3306/jagruti_hostel";
            String username = "root";
            String password = "";
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                String query2 = "update addteacher set firstName=?,lastName=?,Email=?,mobileNo=?,Password=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query2);
               // preparedStatement.setString(1, idTextField.getText());
                preparedStatement.setString(1, firstNameJTextField.getText()); 
                preparedStatement.setString(2, lastNameJTextField.getText());
                preparedStatement.setString(3, emailJTextField.getText());
                preparedStatement.setString(4, passwordTextField.getText());
                preparedStatement.setString(5, mobileNoTextField.getText());

                int updateData = preparedStatement.executeUpdate();
                if (updateData > 0) {
                    JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Data Not Updated!");
                }
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    });


        // CancleButton Qwery
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cancel) {
                    System.exit(0);
                }
            }
        });
        // End CancleButton Qwery
    }

    public static void main(String[] args) {
        updatTeacher ob = new updatTeacher();
    }
}
