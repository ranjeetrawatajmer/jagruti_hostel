import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class viewTeacher extends JFrame {
    JButton cancel, view;
    JFrame frame = new JFrame("View Teacher");

    viewTeacher() {
        view = new JButton("View");
        view.setBounds(20, 20, 100, 30);

        String url = "jdbc:mysql://localhost:3306/Jagruti_hostel";
        String username = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query1 = "select * from addteacher";
            PreparedStatement preparedStatement = connection.prepareStatement(query1);
            ResultSet resultSet = preparedStatement.executeQuery();

            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Id");
            tableModel.addColumn("FirstName");
            tableModel.addColumn("LastName");
            tableModel.addColumn("Password");
            tableModel.addColumn("MobileNo");

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String Email = resultSet.getString("Email");
                String Password = resultSet.getString("Password");
                String MobileNo = resultSet.getString("MobileNo");
                tableModel.addRow(new Object[] { id, firstName, lastName, Password, MobileNo});
            }

            JTable sideTable = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(sideTable);

            frame.getContentPane().removeAll();
            frame.getContentPane().add(scrollPane);
            frame.revalidate();

            resultSet.close();
            preparedStatement.close();
            connection.close();

            frame.setVisible(true);
            frame.setSize(600, 400);

            System.out.println("Successfully viewed");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            viewTeacher ob = new viewTeacher();
            ob.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        });
    }
}
