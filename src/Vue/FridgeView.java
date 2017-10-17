package Vue;
import Controleur.FridgeControler;
import Model.FridgeModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class FridgeView extends JFrame implements Observer {

	private FridgeControler controler;

	private Panel stats;
	private Panel componentUpdateState;
	private Panel componentUpdateWrite;
	private Panel changementPlusMoins;

	private Label componentStatTitle;
	private Label componentInternalTemperature;
	private Label componentExternalTemperature;
	private Label componentHygrometry;
	protected Label componentConsigne;
	private Label proposition;
	//private Label plusOuMoins;

	public TextField componentUpdateTemperature;
	private Font gras;



	public Button validate;
	//public Button ButtonMore;
	//public Button ButtonLess;
	public Container container;


	public JPanel componentContainer;
	public JPanel componentStateDoor;

	public FridgeView(FridgeControler controler) {
		setTitle("Centre de contrôle du frigo");
		setSize(700, 300);
		this.controler = controler;



		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		stats = new Panel(new GridLayout(5, 0));
		componentUpdateState = new Panel(new GridLayout(4, 0));
		componentUpdateWrite = new Panel();
		changementPlusMoins = new Panel();
		componentStatTitle = new Label("Etat du système");
		gras = new Font("Courrier", Font.BOLD, 20);
		componentStatTitle.setFont(gras);
		stats.setBackground(Color.lightGray);

		componentExternalTemperature = new Label("Température extérieure : " + controler.getExtTemperature() + "°C");
		componentInternalTemperature = new Label("Température intérieure : " /*+ model.getInternalTemperature()*/+ "°C");
		componentConsigne = new Label("Consigne : " + controler.getConsigneTemperature() + "°C");
		componentHygrometry = new Label("Hygrométrie :"/* + model.getHygrometry()*/);
		componentUpdateTemperature = new TextField();
		proposition = new Label("Vous pouvez changer la valeur de la consigne en l'écrivant : ");
		//plusOuMoins = new Label("Ou l'augmenter / diminuer de 1 : ");

		validate = new Button("Valider");


		//ButtonMore = new Button("+1");


		//ButtonLess = new Button("-1");



		stats.add(componentStatTitle);
		stats.add(componentInternalTemperature);
		stats.add(componentExternalTemperature);
		stats.add(componentHygrometry);
		stats.add(componentConsigne);

		componentUpdateWrite.add(proposition);
		componentUpdateWrite.add(componentUpdateTemperature);
		componentConsigne.setPreferredSize(new Dimension(50, 24));
		componentUpdateWrite.add(validate);

		//changementPlusMoins.add(plusOuMoins);
		//changementPlusMoins.add(ButtonMore);
		//changementPlusMoins.add(ButtonLess);

		componentUpdateState.add(componentUpdateWrite);
		componentUpdateState.add(changementPlusMoins);

		c.add(stats, BorderLayout.WEST);
		c.add(componentUpdateState, BorderLayout.CENTER);


		setDefaultCloseOperation(3);
	}


	public void addComponent(int typeComponent) {

	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("TESSSSTTTTTT");
		componentConsigne.setText("Consigne : " + controler.getConsigneTemperature() + "°C");
		//componentInternalTemperature.setText("Température intérieure : " + model.getInternalTemperature() + "°C");
		componentExternalTemperature.setText("Température extérieure : " + controler.getExtTemperature() + "°C");
		//componentHygrometry.setText("Hygrométrie :" + model.getHygrometry());

	}
}
