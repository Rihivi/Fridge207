import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;


public class FridgeView extends JFrame implements Observer {

    private FridgeInformations fi;

    private Panel stats;
    private Panel changementEtat;
    private Panel changementEcrit;
    private Panel changementPlusMoins;

    private Label statTitle;
    private Label tempInt;
    private Label tempExt;
    private Label hygro;
    protected Label consigne;
    private Label proposition;
    private Label plusOuMoins;

    protected TextField choixConsigne;



    protected Button valider;
    protected Button plus;
    protected Button moins;
    protected Container c;


    private Font gras;


    public FridgeView(FridgeInformations fi) {
        setTitle("Centre de contrôle du frigo");
        setSize(700, 300);
        this.fi = fi;
        fi.addObserver(this);


        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        stats = new Panel(new GridLayout(5, 0));
        changementEtat = new Panel(new GridLayout(4, 0));
        changementEcrit = new Panel();
        changementPlusMoins = new Panel();
        statTitle = new Label("Etat du système");
        gras = new Font("Courrier", Font.BOLD, 20);
        statTitle.setFont(gras);
        stats.setBackground(Color.lightGray);

        tempExt = new Label("Température extérieure : " + fi.getValeurTemperatureExterieur() + "°C");
        tempInt = new Label("Température intérieure : " + fi.getValeurTemperatureInterieur()+ "°C");
        consigne = new Label("Consigne : " + fi.getValeurConsigne() + "°C");
        hygro = new Label("Hygrométrie :" + fi.getValeurHygrometrie() + "%");
        choixConsigne = new TextField();
        proposition = new Label("Vous pouvez changer la valeur de la consigne en l'écrivant : ");
        plusOuMoins = new Label("Ou l'augmenter / diminuer de 1 : ");

        valider = new Button("Valider");


        plus = new Button("+1");


        moins = new Button("-1");



        stats.add(statTitle);
        stats.add(tempInt);
        stats.add(tempExt);
        stats.add(hygro);
        stats.add(consigne);

        changementEcrit.add(proposition);
        changementEcrit.add(choixConsigne);
        choixConsigne.setPreferredSize(new Dimension(50, 24));
        changementEcrit.add(valider);

        changementPlusMoins.add(plusOuMoins);
        changementPlusMoins.add(plus);
        changementPlusMoins.add(moins);

        changementEtat.add(changementEcrit);
        changementEtat.add(changementPlusMoins);

        c.add(stats, BorderLayout.WEST);
        c.add(changementEtat, BorderLayout.CENTER);


        setDefaultCloseOperation(3);
    }




    @Override
    public void update(Observable o, Object arg) {
        consigne.setText("Consigne : " + fi.getValeurConsigne() + "°C");
        tempInt.setText("Température intérieure : " + fi.getValeurTemperatureInterieur() + "°C");
        tempExt.setText("Température extérieure : " + fi.getValeurTemperatureExterieur() + "°C");
        hygro.setText("Hygrométrie :" + fi.getValeurHygrometrie() + "%");

    }
}
