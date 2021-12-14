package EX2;
import java.time.LocalDate;
import EX2.Citerne.Liquide;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Citerne> citernes=new ArrayList<Citerne>();

        LocalDate dateMiseService1=LocalDate.of(2021,12,11);
        LocalDate dateMiseService2=LocalDate.of(2021,8,5);
        LocalDate dateMiseService3=LocalDate.of(2021,1,31);

        Liquide Vin = Liquide.Vin;
        Liquide Eau = Liquide.Eau;
        Liquide Huile = Liquide.Huile;

        Citerne c1 = new Citerne(13, 9.5, Eau, dateMiseService1);
        Citerne c2 = new Citerne(13, 9.5, Eau, dateMiseService1);
        Citerne c3 = new Citerne(13, 9, Eau, dateMiseService1);

        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));

        // citernes.add(new Citerne(13, 9.5, Eau, dateMiseService1));
        // citernes.add(new Citerne(8, 6.2, Vin, dateMiseService2));
        // citernes.add(new Citerne(15, 10, Huile, dateMiseService3));
        // citernes.add(new Citerne(0, -10, null, dateMiseService3));
        // citernes.forEach(citerne -> System.out.println(citerne));

    }
}