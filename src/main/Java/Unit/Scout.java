package Unit;

import Item.Armor;
import Item.Boots;
import Item.Weapon;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Scout extends Unit{

    public Scout(int hp, String name, int damage, int run) {
        super(hp, name, damage, run);

    }

    public void scouting(){
        run = chkRun(this);
        if (run > Math.random()* 30){
            System.out.println("Разведка удалась!");
        }
        else {
            System.out.println("Разведка не удалась!");

        }
    }


    public static Unit create() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Weapon weaponForScout = context.getBean("WeaponBean", Weapon.class);
        Boots bootsForScout = context.getBean("BootsBean", Boots.class);
        Armor armorForScout = context.getBean("ArmorBean", Armor.class);
        Scout scout = context.getBean("ScoutBean", Scout.class);
        weaponForScout.equipItem(scout);
        bootsForScout.equipItem(scout);
        armorForScout.equipItem(scout);
        System.out.println(" СОЗДАН ПЕРСОНАЖ!" + scout.name);
        scout.info();
        context.close();
        return scout;

    }
}
