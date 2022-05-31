package Unit;

import Item.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwordsMan extends Unit {
    public SwordsMan(int hp, String name, int damage, int run) {
        super(hp, name, damage, run);
    }


    public static Unit create() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");



        Weapon weaponForSwordsMan = context.getBean("WeaponBean", Weapon.class);
        Boots bootsForSwordsMan = context.getBean("BootsBean", Boots.class);
        Armor armorForSwordsMan = context.getBean("ArmorBean", Armor.class);
        SwordsMan swordsMan = context.getBean("SwordsManBean", SwordsMan.class);
        weaponForSwordsMan.equipItem(swordsMan);
        bootsForSwordsMan.equipItem(swordsMan);
        armorForSwordsMan.equipItem(swordsMan);
        System.out.println(" СОЗДАН ПЕРСОНАЖ!" + swordsMan.name);
        swordsMan.info();
        context.close();
        return swordsMan;
    }
}
