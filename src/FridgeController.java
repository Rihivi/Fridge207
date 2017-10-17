import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public class FridgeController implements ActionListener, KeyListener, SerialPortEventListener {

    private FridgeInformations fi;
    private FridgeView fv;


    private SerialPort serialPort;
    /** The port we're normally going to use. */
    private static final String PORT_NAMES[] = {
            "COM3", // Windows
    };
    /**
     * A BufferedReader which will be fed by a InputStreamReader
     * converting the bytes into characters
     * making the displayed results codepage independent
     */
    private BufferedReader input;
    /** The output stream to the port */
    private OutputStream output;
    /** Milliseconds to block while waiting for port open */
    private static final int TIME_OUT = 2000;
    /** Default bits per second for COM port. */
    private static final int DATA_RATE = 9600;

    public FridgeController() {
        fi = FridgeInformations.getInstance();
        fv = new FridgeView(fi);

        fv.valider.addActionListener(this);
        fv.plus.addActionListener(this);
        fv.moins.addActionListener(this);
        fv.choixConsigne.addKeyListener(this);
        fv.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fv.valider) {
            String test = fv.choixConsigne.getText();
            if (test.equals("")) {
                JOptionPane d = new JOptionPane();
                d.showMessageDialog(fv.c, "Il n'y a pas de consigne",
                        "Erreur", JOptionPane.WARNING_MESSAGE);
            } else {
                if (estUnEntier(test)) {
                    int nouvelleConsigne = Integer.parseInt(test);
                    System.out.println(nouvelleConsigne);
                    //fv.consigne.setText("Consigne : " + nouvelleConsigne + "°C");
                    fi.setValeurConsigne(nouvelleConsigne);
                } else {
                    JOptionPane d = new JOptionPane();
                    d.showMessageDialog(fv.c, "Ceci n'est pas un entier",
                            "Erreur", JOptionPane.WARNING_MESSAGE);

                }

            }
        }

        if (e.getSource() == fv.plus){
            fi.setValeurConsigne(fi.getValeurConsigne()+1);
        }

        if (e.getSource() == fv.moins){
            fi.setValeurConsigne(fi.getValeurConsigne()-1);
        }
    }

    public boolean estUnEntier(String chaine) {
        try {
            Integer.parseInt(chaine);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("test");
            String test = fv.choixConsigne.getText();
            if (test.equals("")) {
                JOptionPane d = new JOptionPane();
                d.showMessageDialog(fv.c, "Il n'y a pas de consigne",
                        "Erreur", JOptionPane.WARNING_MESSAGE);
            } else {
                if (estUnEntier(test)) {
                    int nouvelleConsigne = Integer.parseInt(test);
                    System.out.println(nouvelleConsigne);
                    //fv.consigne.setText("Consigne : " + nouvelleConsigne + "°C");
                    fi.setValeurConsigne(nouvelleConsigne);
                } else {
                    JOptionPane d = new JOptionPane();
                    d.showMessageDialog(fv.c, "Ceci n'est pas un entier",
                            "Erreur", JOptionPane.WARNING_MESSAGE);

                }
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



    public void initialize() {
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        //First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }

        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener( this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * This should be called when you stop using the port.
     * This will prevent port locking on platforms like Linux.
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    /**
     * Handle an event on the serial port. Read the data and print it.
     */
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        System.out.println("seriEvent");

        //TODO : Add info to interface here !!!
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine=input.readLine();



                System.out.println("Update info");
                System.out.println(inputLine);

                List<String> items = Arrays.asList(inputLine.split("\\s*,\\s*"));

                fi.setValeurHygrometrie(Float.valueOf(items.get(0)));
                fi.setValeurTemperatureExterieur(Float.valueOf(items.get(1)));
                fi.setValeurTemperatureInterieur(Float.valueOf(items.get(2)));

            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }



}
