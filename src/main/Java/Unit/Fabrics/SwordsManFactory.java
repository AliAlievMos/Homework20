package Unit.Fabrics;


import Unit.SwordsMan;
import Unit.Unit;

public class SwordsManFactory implements UnitFactory {

    public Unit factoring() {


        return SwordsMan.create();
    }
}
