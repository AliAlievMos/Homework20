package Unit.Fabrics;

import Unit.Unit;

public class Application {
    private static UnitFactory factory;
    private Unit unit;

    public Application(UnitFactory factory){
        this.factory = factory;
    }


    public void create() {
        factory.factoring();
    }
}
