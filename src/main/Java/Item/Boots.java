package Item;

import Unit.Unit;

public class Boots extends Item{
    public int run;
    public Boots(String name, int weight, int run) {
        super(name, weight);
        this.run = run;
    }

    @Override
    public void equipItem(Unit unit) {
        System.out.println(unit.name +" экиперует " + this.name);
        unit.boots = this;

    }
}
