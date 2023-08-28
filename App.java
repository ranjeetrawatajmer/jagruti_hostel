import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.Color;
import java.awt.event.*;
import java.sql.*;

 class AddStudent {
   public static void main(String[] args) {
    JFrame frame=new JFrame("JAGRUTI HOSTAL");
    frame.setVisible(true);
    frame.setBounds(100, 100, 1000, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBackground(ColorUIResource.GREEN);
    
    JMenuBar menu=new JMenuBar();
    menu.setLocation(100,20);

    JMenu studentmenu=new JMenu("AAD_STUDENT");
    studentmenu.setBackground(Color.blue);
    JMenuItem AddStudent=new JMenuItem("ADD STUDENT");
    JMenuItem UpdateStudent=new JMenuItem("UPDATE STUDENT");
    JMenuItem DeleteStudent=new JMenuItem("DELETE STUDENT");
    JMenuItem ViewStudent=new JMenuItem("VIEW STUDENT");

    studentmenu.add(AddStudent);
    studentmenu.add(UpdateStudent);
    studentmenu.add(DeleteStudent);
    studentmenu.add(ViewStudent);

    AddStudent.setBackground(Color.lightGray);
    UpdateStudent.setBackground(Color.lightGray);
    DeleteStudent.setBackground(Color.lightGray);
    ViewStudent.setBackground(Color.lightGray);

     
    JMenu teachermenu=new JMenu("ADD_TEACHER");
    teachermenu.setBackground(Color.BLACK);
    JMenuItem AddTeacher=new JMenuItem("ADD TEACHER");
    JMenuItem UpdateTeacher=new JMenuItem("UPDATE TEACHER");
    JMenuItem DeleteTeacher=new JMenuItem("DELETE TEACHER");
    JMenuItem ViewTeacher=new JMenuItem("VIEW TEACHER");

    teachermenu.add(AddTeacher);
    teachermenu.add(UpdateTeacher);
    teachermenu.add(DeleteTeacher);
    teachermenu.add(ViewTeacher);

    AddTeacher.setBackground(Color.lightGray);
    UpdateTeacher.setBackground(Color.lightGray);
    DeleteTeacher.setBackground(Color.lightGray);
    ViewTeacher.setBackground(Color.lightGray);

    menu.add(studentmenu);
    menu.add(teachermenu);
    frame.setJMenuBar(menu);
    
    AddStudent.addActionListener (new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            new addStutents();
        }
    });

    UpdateStudent.addActionListener (new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            new updatStudent();
        }
    });

    DeleteStudent.addActionListener (new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            new DeleteStudent();
        }
    });

    AddTeacher.addActionListener (new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            new AddTeacher();
        }
    });

    UpdateTeacher.addActionListener (new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            new updatTeacher();
        }
    });

    DeleteTeacher.addActionListener (new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            new DeleteTeacher();
        }
    });
}
    
}
