package Item;

import Unit.Unit;

public class Armor extends Item {
    public int armor;
    public Armor(String name, int weight, int armor) {
        super(name, weight);
        this.armor = armor;

    }

    @Override
    public void equipItem(Unit unit) {
        System.out.println(unit.name +" экиперует " + this.name);
        unit.armor = this;

    }
}
