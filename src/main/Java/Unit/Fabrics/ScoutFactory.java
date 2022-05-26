package Unit.Fabrics;


import Unit.Scout;
import Unit.Unit;

public class ScoutFactory implements UnitFactory {

    public Unit factoring() {


        return Scout.create();
    }
}
