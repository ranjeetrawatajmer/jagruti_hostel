import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;
class DeleteTeacher extends JFrame
{
    DeleteTeacher(){ 

        JLabel updateTeacher=new JLabel("DELETE TEACHER ");
       updateTeacher.setBounds(790, 130, 150, 60);
       this.add(updateTeacher);
      
       setLayout(null);
       JLabel id=new JLabel("ID");
       id.setBounds(640, 210, 100, 30);
       this.add(id);

       JButton search=new JButton("Search");
       search.setBounds(900, 210, 150, 30);
       this.add(search);

  
       JTextField idTextField=new JTextField();
       idTextField.setBounds(660, 210, 150, 30);
       this.add(idTextField);

       JLabel firstName=new JLabel("firstName");
       firstName.setBounds(600, 300, 100, 30);
       this.add(firstName);

      JTextField firstNameTextField=new JTextField();
      firstNameTextField.setBounds(660, 300, 150, 30);
       this.add(firstNameTextField);

        JLabel emailJLabel=new JLabel("Email");
       emailJLabel.setBounds(830, 300, 100, 30);
       this.add(emailJLabel);

       JTextField emailJTextField=new JTextField();
       emailJTextField.setBounds(900, 300, 150, 30);
       this.add(emailJTextField);

       JButton cancel=new JButton("Cancel");
       cancel.setBounds(760, 400, 100, 30);
       this.add(cancel);

       JButton Delete=new JButton("Delete");
       Delete.setBounds(900, 400, 100, 30);
       this.add(Delete);


       setSize(700, 650);
       setVisible(true);
       setTitle("DELETE TEACHER");


        
         search.addActionListener((ActionListener) new ActionListener() {
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
                
                firstNameTextField.setText(resultSet.getString("Firstname"));
                emailJTextField.setText(resultSet.getString("email"));
            } else {
                JOptionPane.showMessageDialog(null, "Data not Found");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: Unable to Search");
        }
    }
});

Delete.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String url = "jdbc:mysql://localhost:3306/jagruti_hostel";
        String username = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query2 = "delete from addteacher where Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query2);
            preparedStatement.setString(1, idTextField.getText());
            int updateData = preparedStatement.executeUpdate();

            if (updateData > 0) {
                JOptionPane.showMessageDialog(null, "Data Deleted Successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Something Went Wrong: Data Not Deleted!");
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: Unable to Update Data");
        }
    }
});

cancel.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            System.exit(0);
           // deleteWorkerFrame.dispose();
        }
    }
});
    }
    public static void main(String[] args) {
        DeleteTeacher ob=new DeleteTeacher();
    }
    
}
