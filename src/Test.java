
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;

public class Test {

    public void test() {

        JFrame frame = new JFrame("   Car Service");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 700);
        frame.setLayout(null);


        JLabel newcar = new JLabel(" NEW CAR  ! ");
        newcar.setBounds(140, 0, 250, 60);
        frame.add(newcar);

        JLabel nameofowner = new JLabel("Name and surname  : ");
        nameofowner.setBounds(20, 38, 200, 40);
        frame.add(nameofowner);

        JTextField nameofownertextfield = new JTextField(25);
        nameofownertextfield.setBounds(150, 45, 130, 30);
        frame.add(nameofownertextfield);

        JLabel numberofowner = new JLabel("Number of owner  : ");
        numberofowner.setBounds(20, 78, 200, 40);
        frame.add(numberofowner);

        JTextField numberofowenrtextfield = new JTextField(25);
        numberofowenrtextfield.setBounds(150, 85, 130, 30);
        frame.add(numberofowenrtextfield);

        JLabel modelofcar = new JLabel("Model of a car  : ");
        modelofcar.setBounds(20, 118, 200, 40);
        frame.add(modelofcar);

        JTextField modelofcartextfield = new JTextField(25);
        modelofcartextfield.setBounds(150, 125, 130, 30);
        frame.add(modelofcartextfield);

        JLabel numberofcar = new JLabel("Number of car  : ");
        numberofcar.setBounds(20, 158, 200, 40);
        frame.add(numberofcar);

        JTextField numberofcartextfield = new JTextField(25);
        numberofcartextfield.setBounds(150, 165, 130, 30);
        frame.add(numberofcartextfield);

        JLabel dateofreceiving = new JLabel("Date of receiving  : ");
        dateofreceiving.setBounds(20, 198, 200, 40);
        frame.add(dateofreceiving);

        JDateChooser dateofreceivingchooser = new JDateChooser();
        dateofreceivingchooser.setBounds(150, 205, 130, 30);
        frame.add(dateofreceivingchooser);

        JLabel dateofgiving = new JLabel("Date of giving  : ");
        dateofgiving.setBounds(20, 238, 150, 40);
        frame.add(dateofgiving);

        JDateChooser dateofgivingchooser = new JDateChooser();
        dateofgivingchooser.setBounds(150, 245, 130, 30);
        frame.add(dateofgivingchooser);

        JLabel services = new JLabel("Services  : ");
        services.setBounds(30, 355, 200, 40);
        frame.add(services);

        JCheckBox checkbox1 = new JCheckBox("Washing (20)");
        checkbox1.setBounds(120, 295, 100, 20);
        frame.add(checkbox1);

        JCheckBox checkbox2 = new JCheckBox("Cleaning the inside (40)");
        checkbox2.setBounds(120, 315, 200, 20);
        frame.add(checkbox2);

        JCheckBox checkbox3 = new JCheckBox("Change of oil (30)");
        checkbox3.setBounds(120, 335, 200, 20);
        frame.add(checkbox3);

        JCheckBox checkbox4 = new JCheckBox("Change of brakes (60)");
        checkbox4.setBounds(120, 355, 200, 20);
        frame.add(checkbox4);

        JCheckBox checkbox5 = new JCheckBox("Change of motor (100)");
        checkbox5.setBounds(120, 375, 200, 20);
        frame.add(checkbox5);

        JCheckBox checkbox6 = new JCheckBox("Change of wheels (80)");
        checkbox6.setBounds(120, 395, 200, 20);
        frame.add(checkbox6);

        JCheckBox checkbox7 = new JCheckBox("Change of carcass (150)");
        checkbox7.setBounds(120, 415, 200, 20);
        frame.add(checkbox7);


        JButton sendbutton = new JButton("Send Data to Database ");
        sendbutton.setBounds(70, 455, 200, 40);
        frame.add(sendbutton);


        sendbutton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String modelofcarstring = modelofcartextfield.getText();
                String dateofreceivingstring = new String(String.valueOf(dateofreceivingchooser.getDate()));
                String dateofgivingstring = new String(String.valueOf(dateofgivingchooser.getDate()));

                Statement statement;
                Connect_with_DB connectDB = new Connect_with_DB();

                try{
                    String sql="insert into maintable(modelofcar,dateofreceiving,dateofgiving) values('"+modelofcarstring+"','"+dateofreceivingstring+"','"+dateofgivingstring+"')";
                    statement=connectDB.connecting().createStatement();
                    statement.executeUpdate(sql);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                try{
                    String sql="insert into tableofservices(washing,cleaningtheinside,changeofoil,changeofbrakes,changeofmotor,changeofwheels,changeofcarcass) " +
                            "values('"+ checkbox1.isSelected() +"','"+ checkbox2.isSelected() +"','"+ checkbox3.isSelected() +"'," +
                            "'"+ checkbox4.isSelected() +"','"+ checkbox5.isSelected() +"','"+ checkbox6.isSelected() +"','"+ checkbox7.isSelected() +"')";

                    statement=connectDB.connecting().createStatement();
                    statement.executeUpdate(sql);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });

        // SECOND PART - SERVICE !

        JLabel service = new JLabel(" SERVICE ! ");
        service.setBounds(720, 0, 250, 80);
        frame.add(service);

        JLabel id = new JLabel(" ID ");
        id.setBounds(660, 70, 50, 50);
        frame.add(id);

        JTextField idtextfield = new JTextField(25);
        idtextfield.setBounds(700, 80, 130, 30);
        frame.add(idtextfield);

        JButton getbutton = new JButton("Get Data from Database");
        getbutton.setBounds(650,130,200,40);
        frame.add(getbutton);


        JLabel NAMEOFOWNER = new JLabel("Name and surname  : ");
        NAMEOFOWNER.setBounds(630, 170, 200, 40);
        frame.add(NAMEOFOWNER);

        JLabel NUMBEROFOWNER = new JLabel("Number of owner  : ");
        NUMBEROFOWNER.setBounds(630, 210, 200, 40);
        frame.add(NUMBEROFOWNER);

        JLabel MODELOFCAR = new JLabel("Model of a car  : ");
        MODELOFCAR.setBounds(630, 250, 200, 40);
        frame.add(MODELOFCAR);

        JLabel NUMBEROFCAR = new JLabel("Number of car  : ");
        NUMBEROFCAR.setBounds(630, 290, 200, 40);
        frame.add(NUMBEROFCAR);

        JLabel DATEOFRECEIVING = new JLabel("Date of receiving  : ");
        DATEOFRECEIVING.setBounds(630, 330, 200, 40);
        frame.add(DATEOFRECEIVING);

        JLabel DATEOFGIVING = new JLabel("Date of giving  : ");
        DATEOFGIVING.setBounds(630, 370, 150, 40);
        frame.add(DATEOFGIVING);

        JLabel SERVICES = new JLabel("Services  : ");
        SERVICES.setBounds(630, 450, 200, 120);
        frame.add(SERVICES);

        JLabel label1 = new JLabel("Washing (20)");
        label1.setBounds(730, 410, 100, 40);
        frame.add(label1);

        JLabel label2 = new JLabel("Cleaning the inside (40)");
        label2.setBounds(730, 440, 170, 40);
        frame.add(label2);

        JLabel label3 = new JLabel("Change of oil (30)");
        label3.setBounds(730, 470, 170, 40);
        frame.add(label3);

        JLabel label4 = new JLabel("Change of brakes (60)");
        label4.setBounds(730, 500, 170, 40);
        frame.add(label4);

        JLabel label5 = new JLabel("Change of motor (100)");
        label5.setBounds(730, 530, 170, 40);
        frame.add(label5);

        JLabel label6 = new JLabel("Change of wheels (80)");
        label6.setBounds(730, 560, 170, 40);
        frame.add(label6);

        JLabel label7 = new JLabel("Change of carcass (150)");
        label7.setBounds(730, 590, 170, 40);
        frame.add(label7);

        JLabel totalprice = new JLabel("Total price :");
        totalprice.setBounds(630,650,100,40);
        frame.add(totalprice);


        getbutton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Statement statement ;
                Connect_with_DB connectDB = new Connect_with_DB();
                ResultSet rs;

                try{

                    String sql="select * from maintable where id="+idtextfield.getText()+"";
                    statement=connectDB.connecting().createStatement();
                    rs=statement.executeQuery(sql);

                    while(rs.next()){

                        JTextField nameofowner_rs = new JTextField(rs.getString("modelofcar"));
                        nameofowner_rs.setBounds(745, 190, 130, 30);
                        frame.add(nameofowner_rs);

                        JTextField numberofowner_rs = new JTextField(rs.getString("modelofcar"));
                        numberofowner_rs.setBounds(745, 190, 130, 30);
                        frame.add(numberofowner_rs);

                        JTextField modelofcar_rs = new JTextField(rs.getString("modelofcar"));
                        modelofcar_rs.setBounds(745, 190, 130, 30);
                        frame.add(modelofcar_rs);

                        JTextField numberofcar_rs = new JTextField(rs.getString("modelofcar"));
                        numberofcar_rs.setBounds(745, 190, 130, 30);
                        frame.add(numberofcar_rs);

                        DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
                        JTextField textField = new JTextField();
                        textField.setBounds(745,250,130,30);
                        textField.setText(dateformat.format(rs.getDate("dateofreceiving")));
                        frame.add(textField);

                        DateFormat dateformat2 = new SimpleDateFormat("dd-MM-yyyy");
                        JTextField textField2 = new JTextField();
                        textField2.setBounds(745,310,130,30);
                        textField2.setText(dateformat2.format(rs.getDate("dateofgiving")));
                        frame.add(textField2);

                    }
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                try{
                    String sql="select * from tableofservices where id="+idtextfield.getText()+"";
                    statement=connectDB.connecting().createStatement();
                    rs=statement.executeQuery(sql);

                    while(rs.next()){

                        JTextField a1 = new JTextField(rs.getString("washing"));
                        a1.setBounds(915,364,50,30);
                        frame.add(a1);

                        JTextField a2 = new JTextField(rs.getString("cleaningtheinside"));
                        a2.setBounds(915,394,50,30);
                        frame.add(a2);

                        JTextField a3 = new JTextField(rs.getString("changeofoil"));
                        a3.setBounds(915,424,50,30);
                        frame.add(a3);

                        JTextField a4 = new JTextField(rs.getString("changeofbrakes"));
                        a4.setBounds(915,454,50,30);
                        frame.add(a4);

                        JTextField a5 = new JTextField(rs.getString("changeofmotor"));
                        a5.setBounds(915,484,50,30);
                        frame.add(a5);

                        JTextField a6 = new JTextField(rs.getString("changeofwheels"));
                        a6.setBounds(915,514,50,30);
                        frame.add(a6);

                        JTextField a7 = new JTextField(rs.getString("changeofcarcass"));
                        a7.setBounds(915,544,50,30);
                        frame.add(a7);

                    }
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });

        frame.setVisible(true);

    }
}
