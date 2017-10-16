package Vue;
import Model.FridgeModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class FridgeView extends JFrame implements Observer {

	private FridgeModel model;

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
	private Label plusOuMoins;

	public TextField componentUpdateTemperature;
	private Font gras;



	public Button validate;
	public Button ButtonMore;
	public Button ButtonLess;
	public Container container;


	public JPanel componentContainer;
	public JPanel componentStateDoor;

	public FridgeView(FridgeModel model) {
		setTitle("Centre de contrôle du frigo");
		setSize(700, 300);
		this.model = model;
		model.addObserver(this);


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

		componentExternalTemperature = new Label("Température extérieure : " + model.getExternalTemperature() + "°C");
		componentInternalTemperature = new Label("Température intérieure : " + model.getInternalTemperature()+ "°C");
		componentConsigne = new Label("Consigne : " + model.getConsigneTemperature() + "°C");
		componentHygrometry = new Label("Hygrométrie :" + model.getHygrometry());
		componentUpdateTemperature = new TextField();
		proposition = new Label("Vous pouvez changer la valeur de la consigne en l'écrivant : ");
		plusOuMoins = new Label("Ou l'augmenter / diminuer de 1 : ");

		validate = new Button("Valider");


		ButtonMore = new Button("+1");


		ButtonLess = new Button("-1");



		stats.add(componentStatTitle);
		stats.add(componentInternalTemperature);
		stats.add(componentExternalTemperature);
		stats.add(componentHygrometry);
		stats.add(componentConsigne);

		componentUpdateWrite.add(proposition);
		componentUpdateWrite.add(componentUpdateTemperature);
		componentConsigne.setPreferredSize(new Dimension(50, 24));
		componentUpdateWrite.add(validate);

		changementPlusMoins.add(plusOuMoins);
		changementPlusMoins.add(ButtonMore);
		changementPlusMoins.add(ButtonLess);

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
		componentConsigne.setText("Consigne : " + model.getConsigneTemperature() + "°C");
		componentInternalTemperature.setText("Température intérieure : " + model.getInternalTemperature() + "°C");
		componentExternalTemperature.setText("Température extérieure : " + model.getExternalTemperature() + "°C");
		componentHygrometry.setText("Hygrométrie :" + model.getHygrometry());

	}
}

//////////////////////////////////////////////////////////////////
/*
import Model.FridgeModel;

import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;


public class FridgeView extends JFrame implements Observer {

	private FridgeModel fi;

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

	public TextField choixConsigne;



	public Button valider;
	public Button plus;
	public Button moins;
	public Container c;


	private Font gras;


	public FridgeView(FridgeModel fi) {
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

		tempExt = new Label("Température extérieure : " + fi.getExternalTemperature() + "°C");
		tempInt = new Label("Température intérieure : " + fi.getInternalTemperature()+ "°C");
		consigne = new Label("Consigne : " + fi.getConsigneTemperature() + "°C");
		hygro = new Label("Hygrométrie :" + fi.getHygrometry());
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
		consigne.setText("Consigne : " + fi.getConsigneTemperature() + "°C");
		tempInt.setText("Température intérieure : " + fi.getInternalTemperature() + "°C");
		tempExt.setText("Température extérieure : " + fi.getExternalTemperature() + "°C");
		hygro.setText("Hygrométrie :" + fi.getHygrometry());

	}
}*/
