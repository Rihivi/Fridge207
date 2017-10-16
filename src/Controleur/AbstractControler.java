package Controleur;
import Model.AbstractModel;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public abstract class AbstractControler{
	protected AbstractModel model;

	public AbstractControler() {}

	public abstract void consigneDoor();

	public abstract void toggleDoor();

	public abstract void updateTemperature();
}