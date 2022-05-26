package Unit;

import Item.Armor;
import Item.Boots;
import Item.Weapon;

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
        int random1 = (int) Math.random()*5;
        int random2 = (int) (5 + Math.random()*10);
        int random3 = (int) (10 + Math.random()*15);

        Weapon weaponForScout = new Weapon("Легкий кинжал", random1, random1);
        Boots bootsForScout = new Boots("Быстрейшие сапоги", random1, random3);
        Armor armorForScout = new Armor("Легкие доспехи", random1, random1);
        Scout scout = new Scout(random3, "Разведчик", random1, random3);
        weaponForScout.equipItem(scout);
        bootsForScout.equipItem(scout);
        armorForScout.equipItem(scout);
        System.out.println(" СОЗДАН ПЕРСОНАЖ!" + scout.name);
        scout.info();
        return scout;

    }
}
