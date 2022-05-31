import Item.Weapon;
import Unit.Fabrics.*;
import Unit.SwordsMan;
import java.sql.SQLException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//      домашка по подключению игры к бд

//        SwordsMan Artur = new SwordsMan(50, "Артур",20,6 );
//        Weapon escalibur = new Weapon("Эксалибур", 7, 30);
//        escalibur.equipItem(Artur);
//        Save.SaveToDB (Artur);
//        (Save.LoadUnitSwordsman(4)).attack(Save.LoadUnitSwordsman(1));

//        beans 20 Homework (создание юнитов полностью работает на бинах)

        new ConfigApp();



    }
}

