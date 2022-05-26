package Unit.Fabrics;


import Unit.Thrower;
import Unit.Unit;

public class ThrowerFactory implements UnitFactory {
    public Unit factoring() {


        return Thrower.create();
    }


}
