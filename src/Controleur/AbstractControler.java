package Controleur;
import Model.AbstractModel;

import java.util.Observable;


public abstract class AbstractControler extends Observable {
	protected AbstractModel model;

	public AbstractControler() {}

	public abstract void consigneDoor();

	public abstract void toggleDoor();

	public abstract int updateTemperature(int newTemperature);
}