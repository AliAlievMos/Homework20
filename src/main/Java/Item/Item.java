package Item;

import Unit.Unit;

public abstract class Item {
    public String name;
    public int weight;

    public Item(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public abstract void equipItem(Unit unit);
}
