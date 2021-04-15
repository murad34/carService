

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.sql.Statement;

import com.toedter.calendar.JDateChooser;

public class Swing {

    public void swing() {

        JFrame frame = new JFrame("    Car  Service");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 570);
        frame.setLayout(null);


        JLabel l1 = new JLabel(" NEW CAR  ! ");
        l1.setBounds(140, 10, 250, 60);

        JLabel l2 = new JLabel("Model of a car  : ");
        l2.setBounds(20, 70, 200, 50);

        JTextField tf2 = new JTextField(25);
        tf2.setBounds(150, 80, 130, 30);


        JLabel l3 = new JLabel("Date of receiving  : ");
        l3.setBounds(20, 130, 200, 50);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(150, 140, 130, 30);


        JLabel l5 = new JLabel("Date of giving  : ");
        l5.setBounds(20, 190, 150, 50);

        JDateChooser dateChooser2 = new JDateChooser();
        dateChooser2.setBounds(150, 200, 130, 30);


        JLabel l7 = new JLabel("Services  : ");
        l7.setBounds(30, 270, 200, 120);

        JCheckBox r1 = new JCheckBox("Washing (20)");
        r1.setBounds(120, 270, 100, 20);
        frame.add(r1);

        JCheckBox r2 = new JCheckBox("Cleaning the inside (40)");
        r2.setBounds(120, 290, 200, 20);
        frame.add(r2);

        JCheckBox r3 = new JCheckBox("Change of oil (30)");
        r3.setBounds(120, 310, 200, 20);
        frame.add(r3);

        JCheckBox r4 = new JCheckBox("Change of brakes (60)");
        r4.setBounds(120, 330, 200, 20);
        frame.add(r4);

        JCheckBox r5 = new JCheckBox("Change of motor (100)");
        r5.setBounds(120, 350, 200, 20);
        frame.add(r5);

        JCheckBox r6 = new JCheckBox("Change of wheels (80)");
        r6.setBounds(120, 370, 200, 20);
        frame.add(r6);

        JCheckBox r7 = new JCheckBox("Change of carcass (150)");
        r7.setBounds(120, 390, 200, 20);
        frame.add(r7);


        JButton b = new JButton("Send to database ");
        b.setBounds(70, 430, 200, 50);
        frame.add(b);


        b.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String modelofcar = tf2.getText();
                String dateofreceiving = new String(String.valueOf(dateChooser.getDate()));
                String dateofgiving = new String(String.valueOf(dateChooser2.getDate()));

                Statement statement;
                Connect_with_DB connectDB = new Connect_with_DB();

                try{
                    String sql="insert into maintable(modelofcar,dateofreceiving,dateofgiving) values('"+modelofcar+"','"+dateofreceiving+"','"+dateofgiving+"')";
                    statement=connectDB.connecting().createStatement();
                    statement.executeUpdate(sql);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                try{
                    String sql="insert into tableofservices(washing,cleaningtheinside,changeofoil,changeofbrakes,changeofmotor,changeofwheels,changeofcarcass) " +
                            "values('"+ r1.isSelected() +"','"+ r2.isSelected() +"','"+ r3.isSelected() +"','"+ r4.isSelected() +"','"+ r5.isSelected() +"','"+ r6.isSelected() +"','"+ r7.isSelected() +"')";

                    statement=connectDB.connecting().createStatement();
                    statement.executeUpdate(sql);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }



//                if (r1.isSelected()) {
//                    try{
//                        String sql="insert into tableofservices(washing) values('+')";
//                        statement=connectDB.connecting().createStatement();
//                        statement.executeUpdate(sql);
//                    } catch (SQLException throwables) {
//                        throwables.printStackTrace();
//                    }
//                }
//                if (r2.isSelected()) {
//                    try{
//                        String sql="insert into tableofservices(cleaningtheinside) values('+')";
//                        statement=connectDB.connecting().createStatement();
//                        statement.executeUpdate(sql);
//                    } catch (SQLException throwables) {
//                        throwables.printStackTrace();
//                    }                }
//                if (r3.isSelected()) {
//                    try{
//                        String sql="insert into tableofservices(changeofoil) values('+')";
//                        statement=connectDB.connecting().createStatement();
//                        statement.executeUpdate(sql);
//                    } catch (SQLException throwables) {
//                        throwables.printStackTrace();
//                    }                }
//                if (r4.isSelected()) {
//                    try{
//                        String sql="insert into tableofservices(changeofbrakes) values('+')";
//                        statement=connectDB.connecting().createStatement();
//                        statement.executeUpdate(sql);
//                    } catch (SQLException throwables) {
//                        throwables.printStackTrace();
//                    }                }
//                if (r5.isSelected()) {
//                    try{
//                        String sql="insert into tableofservices(changeofmotor) values('+')";
//                        statement=connectDB.connecting().createStatement();
//                        statement.executeUpdate(sql);
//                    } catch (SQLException throwables) {
//                        throwables.printStackTrace();
//                    }                }
//                if (r6.isSelected()) {
//                    try{
//                        String sql="insert into tableofservices(changeofwheels) values('+')";
//                        statement=connectDB.connecting().createStatement();
//                        statement.executeUpdate(sql);
//                    } catch (SQLException throwables) {
//                        throwables.printStackTrace();
//                    }                }
//                if (r7.isSelected()) {
//                    try{
//                        String sql="insert into tableofservices(changeofcarcass) values('+')";
//                        statement=connectDB.connecting().createStatement();
//                        statement.executeUpdate(sql);
//                    } catch (SQLException throwables) {
//                        throwables.printStackTrace();
//                    }                }


            }
        });

        frame.add(dateChooser);
        frame.add(dateChooser2);
        frame.add(tf2);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l5);
        frame.add(l7);
        frame.add(r1);
        frame.add(r2);
        frame.add(r3);
        frame.add(r4);
        frame.add(r5);
        frame.add(r6);
        frame.add(r7);
        frame.add(b);

        frame.setVisible(true);

    }
}
