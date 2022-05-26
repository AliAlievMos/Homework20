package Unit.Fabrics;



import java.util.Scanner;

public class ConfigApp {
    public ConfigApp() {
        System.out.println("Кого создать? Разведчик/Мечник/Метатель");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext("Разведчик") == true) {
            UnitFactory factory = new ScoutFactory();
            Application app =new Application(factory);
            app.create();


        }
         else if (sc.hasNext("Метатель") == true){
            UnitFactory factory = new ThrowerFactory();
            Application app =new Application(factory);
            app.create();


        }
        else if (sc.hasNext("Мечник") == true){
            UnitFactory factory = new SwordsManFactory();
            Application app =new Application(factory);
            app.create();
        }

    }
}
