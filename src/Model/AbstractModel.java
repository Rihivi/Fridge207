package Model;
import java.util.Observable;

public abstract class AbstractModel extends Observable {

	protected int consigneTemperature; //valeurConsigne
	protected int internalTemperature; //valeurTemperatureInterieur
	protected int externalTemperature; //valeurTemperatureExterieur
	protected int hygrometry; // valeurHygrometrie
	protected boolean stateDoor;

	public abstract int getConsigneTemperature();
	public abstract void setConsigneTemperature(int consigneTemperature);

	public abstract int getInternalTemperature();
	public abstract void setInternalTemperature(int internalTemperature);

	public abstract int getExternalTemperature();
	public abstract void setExternalTemperature(int externalTemperature);

	public abstract int getHygrometry();
	public abstract void setHygrometry(int hygrometry);

	public abstract boolean getStateDoor();
	public abstract void setStateDoor(boolean stateDoor);

}