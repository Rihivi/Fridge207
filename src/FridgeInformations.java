

import java.util.Observable;

public class FridgeInformations extends Observable {

    private float valeurConsigne;
    private float valeurTemperatureInterieur;
    private float valeurTemperatureExterieur;
    private float valeurHygrometrie;
    private static FridgeInformations instance;

    private FridgeInformations(float valeurConsigne, float valeurTemperatureExterieur, float valeurTemperatureInterieur, float valeurHygrometrie){
        this.valeurConsigne = valeurConsigne;
        this.valeurTemperatureExterieur = valeurTemperatureExterieur;
        this.valeurTemperatureInterieur = valeurTemperatureInterieur;
        this.valeurHygrometrie = valeurHygrometrie;
    }

    public static FridgeInformations getInstance(){
        if(null==instance){
            instance = new FridgeInformations(0,0,0,0);
        }
        return instance;
    }



    public void setValeurConsigne(float consigne) {
        this.valeurConsigne = consigne;
        setChanged();
        notifyObservers();
    }

    public float getValeurConsigne() {
        return this.valeurConsigne;
    }

    public void setValeurTemperatureInterieur(float temperature) {
        this.valeurTemperatureInterieur = temperature;
        setChanged();
        notifyObservers();
    }

    public float getValeurTemperatureInterieur() {
        return this.valeurTemperatureInterieur;
    }

    public void setValeurTemperatureExterieur(float temperature) {
        this.valeurTemperatureExterieur = temperature;
        setChanged();
        notifyObservers();
    }

    public float getValeurTemperatureExterieur() {
        return this.valeurTemperatureExterieur;
    }

    public void setValeurHygrometrie(float hygrometrie) {
        this.valeurHygrometrie = hygrometrie;
        setChanged();
        notifyObservers();
    }

    public float getValeurHygrometrie() {
        return this.valeurHygrometrie;
    }





}
