package Unit;

import Item.Armor;
import Item.Boots;
import Item.Weapon;

public class Thrower extends Unit {

    public Thrower(int hp, String name, int damage, int run) {
        super(hp, name, damage, run);

    }
    public void attack(Unit target){
        run = chkRun(target);
        if (damage > target.run){
            target.hp = 0;
            System.out.println("Попал!" + target.name + " мертв!");
        }
        else {
            target.attack(this);
        }

    }


    public static Unit create() {
        int random1 = (int) Math.random()*5;
        int random2 = (int) (5 + Math.random()*10);
        int random3 = (int) (10 + Math.random()*15);

        Weapon weaponForThrower = new Weapon("Метательное копье", random2,random2);
        Boots bootsForThrower = new Boots("Средние сапоги", random2, random2);
        Armor armorForThrower = new Armor("Легкие доспехи", random2, random2);
        Thrower thrower = new Thrower(random2, "Метатель", random2, random2);
        weaponForThrower.equipItem(thrower);
        bootsForThrower.equipItem(thrower);
        armorForThrower.equipItem(thrower);
        System.out.println(" СОЗДАН ПЕРСОНАЖ!" + thrower.name);
        thrower.info();

        return thrower;
    }
}
