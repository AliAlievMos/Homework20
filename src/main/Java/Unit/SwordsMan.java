package Unit;

import Item.Armor;
import Item.Boots;
import Item.Weapon;

public class SwordsMan extends Unit {
    public SwordsMan(int hp, String name, int damage, int run) {
        super(hp, name, damage, run);
    }


    public static Unit create() {
        int random1 = (int) Math.random()*5;
        int random2 = (int) (5 + Math.random()*10);
        int random3 = (int) (10 + Math.random()*15);

        Weapon weaponForSwordsMan = new Weapon("Меч", random3,random3);
        Boots bootsForSwordsMan = new Boots("Сапоги", random1, random1);
        Armor armorForSwordsMan = new Armor("Крепчайшие доспехи", random3, random3);
        SwordsMan swordsMan = new SwordsMan(random3, "Мечник", random1, random3);
        weaponForSwordsMan.equipItem(swordsMan);
        bootsForSwordsMan.equipItem(swordsMan);
        armorForSwordsMan.equipItem(swordsMan);
        System.out.println(" СОЗДАН ПЕРСОНАЖ!" + swordsMan.name);
        swordsMan.info();

        return swordsMan;
    }
}
