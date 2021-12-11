package EX2;
import java.time.LocalDate;

public class Citerne {

    private static int id=0;
    private int capacite;
    private LocalDate dateMiseService;
    public enum Liquide {
        Eau(10),
        Vin(15),
        Huile(9);

        private final int temperature; // in degrees
        Liquide(int temperature) {
            this.temperature=temperature;
        }

        private int getTemperature(){
            return temperature;
        }
    }

    public Citerne(int id, int capacite, Liquide liquide, LocalDate dateMiseService){
        id++;
        this.id=id;
        try{
            if(capacite>0)
                this.capacite=capacite;
        }
        catch(Exception e){
            System.err.println("Erreur dans la saisie de l'argument la capacité doit être positive");
        }
        
        this.dateMiseService=dateMiseService;
    }
}
