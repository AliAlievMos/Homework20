package Unit;

import Item.Armor;
import Item.Boots;
import Item.Weapon;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Weapon weaponForThrower = context.getBean("WeaponBean", Weapon.class);
        Boots bootsForThrower = context.getBean("BootsBean", Boots.class);
        Armor armorForThrower = context.getBean("ArmorBean", Armor.class);
        Thrower thrower = context.getBean("ThrowerBean", Thrower.class);
        weaponForThrower.equipItem(thrower);
        bootsForThrower.equipItem(thrower);
        armorForThrower.equipItem(thrower);
        System.out.println(" СОЗДАН ПЕРСОНАЖ!" + thrower.name);
        thrower.info();
        context.close();
        return thrower;
    }
}
