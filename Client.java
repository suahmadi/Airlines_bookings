import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author Sultan Alahmadi
 *
 * 11/18/2019
 */



public final class Client {




    static String response;
    static int ports;
    static String host;
    static String request;

    static Airline delta = new Delta();
    public static void main(String[] args) {
        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        Socket socket;
        int port;
        int first;
        BufferedWriter socketWriter = null;
        BufferedReader socketReader = null;
        String hostname;
        String portString;

        String response;


        try {
             host = JOptionPane.showInputDialog(null,"host?","Purdue Airport",JOptionPane.QUESTION_MESSAGE);
            ports = Integer.parseInt(JOptionPane.showInputDialog(null,"Port?","Purdue Airport",JOptionPane.QUESTION_MESSAGE));
            socket = new Socket(host, ports);

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            }
            Icon icon = new ImageIcon("logo.png");
            Icon icon1 = new ImageIcon("logo1.png");
            {
                UIManager.put("OptionPane.cancelButtonText", "Quit");
                UIManager.put("OptionPane.okButtonText", "Book a flight");
                first = JOptionPane.showConfirmDialog(null, "Welcome to our Airport\nTicket Management System!", "Purdue Airport", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon1);
                UIManager.put("OptionPane.cancelButtonText","Cancel");
                UIManager.put("OptionPane.okButtonText","Ok");


            }

            if (first == 0) {
                createWindow();
            }
            port = ports;


                    socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                    socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    if (request != null) {
                        socketWriter.write(Client.getRequest());
                    }
            socketWriter.newLine();
            socketWriter.flush();
            response = socketReader.readLine();
            System.out.println(response);

            socketReader.close();
            socketWriter.close();
            System.out.println();



                    System.out.println();

                } //end if
        catch (IOException e) {
            e.printStackTrace();

     //end if
        } finally {
            try {
                userInputReader.close();

                if (socketWriter != null) {
                    socketWriter.close();
                } //end if

                if (socketReader != null) {
                    socketReader.close();
                } //end if
            } catch (IOException e) {
                e.printStackTrace();
            } //end try catch
        } //end try catch finally
    } //main

    private static void createWindow() {
        //Create and set up the window.
        JFrame frame = new JFrame("Purdue Airport");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel textLabel = new JLabel("Welcome to Purdue Airport\n" +
                "we offer flights through United Airlines, Aer linguas, Delta Airlines",SwingConstants.CENTER);
        JButton button = new JButton("Book", null);
        String[] country ={"Select an Airline","Delta Airlines","United Airlines","Aer linguas Airline"};
        JLabel airlinelabel = new JLabel("Airline:");
        airlinelabel.setFont(new Font("Serif", Font.PLAIN, 14));
        JComboBox cb=new JComboBox(country);
        cb.setBounds(125,35,100,20);

        frame.getContentPane().add(cb, BorderLayout.PAGE_START);


        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cb.getItemAt(cb.getSelectedIndex());
                if (cb.getItemAt(cb.getSelectedIndex()) == "Delta Airlines") {
                    textLabel.setText("Delta Airlines is the one of the best airlines");
                } else if (cb.getItemAt(cb.getSelectedIndex()) == "United Airlines"){
                    textLabel.setText("United Airlines is the USA national airline");

                } else if (cb.getItemAt(cb.getSelectedIndex()) == "Aer linguas Airline") {
                    textLabel.setText("Aer Linguas is Ireland national airline");

                }
            }

        });
        JFrame booking = new JFrame("Purdue Airport");
        JTextField name = new JTextField("",20);

        JTextField lastname = new JTextField("",20);

        JTextField age = new JTextField("",20);
        JLabel label = new JLabel();
        label.setText("Enter Name :");
        label.setBounds(10, 10, 100, 100);
        booking.getContentPane().setLayout(new FlowLayout());
        JLabel label1 = new JLabel();
        label1.setText("Enter lastname :");
        label1.setBounds(10, 10, 100, 100);
        booking.getContentPane().setLayout(new FlowLayout());
        JLabel label2 = new JLabel();
        label2.setText("Enter Age :");
        label2.setBounds(10, 10, 100, 100);
        booking.getContentPane().setLayout(new FlowLayout());
        JButton confirm = new JButton("confirm",null);
        booking.getContentPane().setLayout(new FlowLayout());



        booking.getContentPane().add(label);
        booking.getContentPane().add(name);
        booking.getContentPane().add(label1);
        booking.getContentPane().add(lastname);
        booking.getContentPane().add(label2);
        booking.getContentPane().add(age);
        booking.getContentPane().add(confirm);
        confirm.addActionListener(actionEvent -> {
            String passname = name.getText();
            String passlastname = lastname.getText();
            String passage = age.getText();
            int co = JOptionPane.showConfirmDialog(null,"IS THIS INFORMATION CORRECT ?\n Your name is " + passname + " " + passlastname +"\n" +
                    "and you are " + passage + " old\n" + "You are flying on " + cb.getItemAt(cb.getSelectedIndex()),"Purdue Airport"
                    ,JOptionPane.YES_NO_OPTION);
            if (co == 0) {
                if (cb.getItemAt(cb.getSelectedIndex()).equals("Delta Airline")) {
                    Passenger passenger = new Passenger(passname,passlastname,Integer.parseInt(passage));
                    delta.getPassengers().add(passenger);
                }
                JOptionPane.showMessageDialog(null,"You have been booked","Purdue Airport",JOptionPane.INFORMATION_MESSAGE);
                 setRequest("[ " + passname + "\n" + passlastname + "\n" + passage + "]");

                 JOptionPane.showMessageDialog(null,delta.getPassengers().toString());
//                try {
////                    writeToServer(request);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

            }
            booking.setVisible(false);
        });
        booking.pack();

        booking.setVisible(false);

        frame.setSize(300,300);
        frame.getContentPane().add(textLabel, BorderLayout.CENTER);
        frame.getContentPane().add(button, BorderLayout.AFTER_LAST_LINE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

            AtomicInteger x = new AtomicInteger();

        button.addActionListener(actionEvent -> {
            frame.setVisible(false);
            int y = 3;
            y = (JOptionPane.showConfirmDialog(null, "we need a few more details: click yes to continue",
                    "Purdue Airport",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null));
            if(y == 0) {
                booking.setVisible(true);
            }
        });





        //Display the window.

    }

    public static void writeToServer(String request) throws IOException {
        Socket socket = new Socket(host, ports);

        BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        if (request != null) {
            socketWriter.write(request);
        }


        socketWriter.newLine();
        socketWriter.flush();
        response = socketReader.readLine();
        System.out.println(response);

        socketReader.close();
        socketWriter.close();
        System.out.println();
    }

    public static int getPorts() {
        return ports;
    }

    public static String getHost() {
        return host;
    }
    public static String getRequest(){
        return request;
    }

    public static void setRequest(String request) {
        Client.request = request;
    }


}
