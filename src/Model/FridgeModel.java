package Model;

public class FridgeModel extends AbstractModel {
	private static FridgeModel instance;

    public static FridgeModel getInstance(){
        if(null==instance){
            instance = new FridgeModel();
        }
        return instance;
    }

    @Override
    public int getConsigneTemperature() { return this.consigneTemperature; }
    @Override
    public void setConsigneTemperature(int consigneTemperature) {
        this.consigneTemperature = consigneTemperature;
        setChanged();
        notifyObservers();

    }

	@Override
	public int getInternalTemperature() { return this.internalTemperature; }
    @Override
	public void setInternalTemperature(int internalTemperature) {
        this.internalTemperature = internalTemperature;
        setChanged();
        notifyObservers();
	}

    @Override
	public int getExternalTemperature() { return this.externalTemperature; }
    @Override
	public void setExternalTemperature(int externalTemperature) {
        this.externalTemperature = externalTemperature;
        setChanged();
        notifyObservers();
	}

    @Override
	public int getHygrometry() { return this.hygrometry;}
    @Override
	public void setHygrometry(int hygrometry) {
        this.hygrometry = hygrometry;
        setChanged();
        notifyObservers();
	}

    @Override
    public boolean getStateDoor() { return stateDoor;}
    @Override
	public void setStateDoor(boolean stateDoor) {
	    this.stateDoor = stateDoor;
	    setChanged();
	    notifyObservers();
	}


}