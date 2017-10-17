package Controleur;

import Model.FridgeModel;
import Vue.FridgeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

public class FridgeControler extends AbstractControler implements ActionListener, KeyListener {

    private FridgeModel model;
    private FridgeView view;

	public FridgeControler() {

        model = FridgeModel.getInstance();
        view = new FridgeView(this);
        model.addObserver(view);

        view.validate.addActionListener(this);
       // view.ButtonMore.addActionListener(this);
       // view.ButtonLess.addActionListener(this);
        view.componentUpdateTemperature.addKeyListener(this);
        view.setVisible(true);
	}

    @Override
    public void consigneDoor() {
    }

    @Override
    public void toggleDoor() {
    }

    public int getExtTemperature(){return model.getExternalTemperature();}

    public int getConsigneTemperature(){return  model.getConsigneTemperature();}

    @Override
    public int updateTemperature(int newTemperature) {


        return model.getConsigneTemperature();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.validate) {
            String test = view.componentUpdateTemperature.getText();
            if (test.equals("")) {
                JOptionPane d = new JOptionPane();
                d.showMessageDialog(view.container, "Il n'y a pas de consigne",
                        "Erreur", JOptionPane.WARNING_MESSAGE);
            } else {
                if (estUnEntier(test)) {
                    int nouvelleConsigne = Integer.parseInt(test);
                    System.out.println(nouvelleConsigne);
                    //fv.consigne.setText("Consigne : " + nouvelleConsigne + "°C");
                    model.setConsigneTemperature(nouvelleConsigne);
                } else {
                    JOptionPane d = new JOptionPane();
                    d.showMessageDialog(view.container, "Ceci n'est pas un entier",
                            "Erreur", JOptionPane.WARNING_MESSAGE);

                }

            }
        }

       /* if (e.getSource() == view.ButtonMore){
            model.setConsigneTemperature(model.getConsigneTemperature()+1);
        }

        if (e.getSource() == view.ButtonLess){
            model.setConsigneTemperature(model.getConsigneTemperature()-1);
        }*/

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("test");
            String test = view.componentUpdateTemperature.getText();
            if (test.equals("")) {
                JOptionPane d = new JOptionPane();
                d.showMessageDialog(view.container, "Il n'y a pas de consigne",
                        "Erreur", JOptionPane.WARNING_MESSAGE);
            } else {
                if (estUnEntier(test)) {
                    int nouvelleConsigne = Integer.parseInt(test);
                    System.out.println(nouvelleConsigne);
                    //fv.consigne.setText("Consigne : " + nouvelleConsigne + "°C");
                    model.setConsigneTemperature(nouvelleConsigne);
                    System.out.println(model.getConsigneTemperature());
                } else {
                    JOptionPane d = new JOptionPane();
                    d.showMessageDialog(view.container, "Ceci n'est pas un entier",
                            "Erreur", JOptionPane.WARNING_MESSAGE);

                }
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }




    public boolean estUnEntier(String chaine) {
        try {
            Integer.parseInt(chaine);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}