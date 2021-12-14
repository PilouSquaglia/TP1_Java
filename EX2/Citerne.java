package EX2;
import java.time.LocalDate;

public class Citerne {

    private static int nbCiterne=0;
    private String id="";
    private int capacite;
    private LocalDate dateMiseService;
    private double volume;
    private Liquide liquide;

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

    public Citerne(int capacite, double volume, Liquide liquide, LocalDate dateMiseService){
        nbCiterne++;
        id+=nbCiterne;
        try{
            if(capacite>0)
                this.capacite=capacite;
        }
        catch(IllegalArgumentException e){
            System.err.println("Erreur dans la saisie de l'argument, la capacité doit être positive");
        }

        try{
            if(volume>0)
                this.volume=volume;
        }
        catch(IllegalArgumentException e){
            System.err.println("Erreur dans la saisie de l'argument, le volume doit être positive");
        }

        this.dateMiseService=dateMiseService;

        try{
            if(liquide==Liquide.Vin || liquide==Liquide.Eau || liquide==Liquide.Huile)
                this.liquide=liquide;
        }
        catch(IllegalArgumentException e){
            System.err.println("Erreur dans la saisie de l'argument, le liquide est soit de l'eau, du vin ou de l'huile");
        }

    }

    public boolean plusAncienne(Citerne c2){
        return this.dateMiseService.isBefore(c2.dateMiseService);
    }

    @Override
    public String toString() {
        return "Citerne n°"+id+", "+liquide+", capacité : "+capacite+" m³, mise en service : "+dateMiseService+", volume occupé : "+volume+" m³";
    }

    public void nettoyage(){
        this.liquide=null;
    }

    public void ajouterLiquide(double addquantite){
        double quantite_final;
        if(addquantite>0 && addquantite<1)
            quantite_final=volume+capacite*(addquantite);
        else{
            quantite_final=this.volume;
        }
        try{
            if(quantite_final<=capacite && this.liquide!=null)
                this.volume=quantite_final;
        }
        catch(IllegalArgumentException e){
            System.err.println("Erreur dans la saisie de l'argument, le volume occupé est supérieur à la capacité de la cuve, ou bien la cuve n'a pas encore de type de liquide assigné");
        }
    }

    public void ajouterLiquide(int addquantite){
        double quantite_final;
        if(addquantite>0)
            quantite_final=volume+addquantite;
        else{
            quantite_final=this.volume;
        }
        try{
            if(quantite_final<=capacite && this.liquide!=null)
                this.volume=quantite_final;
        }
        catch(IllegalArgumentException e){
            System.err.println("Erreur dans la saisie de l'argument, le volume occupé est supérieur à la capacité de la cuve, ou bien la cuve n'a pas encore de type de liquide assigné");
        }
    }

    public void enleverLiquide(double suppquantite){
        double quantite_final;
        if(suppquantite>0 && suppquantite<1)
            quantite_final=volume-capacite*(suppquantite);
        else{
            quantite_final=this.volume;
        }
        try{
            if(quantite_final>=0 && this.liquide!=null)
                this.volume=quantite_final;
        }
        catch(IllegalArgumentException e){
            System.err.println("Erreur dans la saisie de l'argument, le volume occupé demandé est inférieur à 0 il manque "+ Math.abs(quantite_final) +", ou bien la cuve n'a pas encore de type de liquide assigné");
            this.volume=0;
        }
    }

    public void enleverLiquide(int suppquantite){
        double quantite_final;
        if(suppquantite>0)
            quantite_final=volume-suppquantite;
        else{
            quantite_final=this.volume;
        }
        try{
            if(quantite_final>=0 && this.liquide!=null)
                this.volume=quantite_final;
        }
        catch(IllegalArgumentException e){
            System.err.println("Erreur dans la saisie de l'argument, le volume occupé demandé est inférieur à 0 il manque "+ Math.abs(quantite_final) +", ou bien la cuve n'a pas encore de type de liquide assigné");
            this.volume=0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Citerne
        && ((Citerne)obj).capacite == this.capacite
        && ((Citerne)obj).dateMiseService.equals(this.dateMiseService)
        && ((Citerne)obj).liquide == this.liquide
        && ((Citerne)obj).volume == this.volume;
    }

}
