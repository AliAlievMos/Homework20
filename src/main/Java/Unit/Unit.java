package Unit;

import Item.Armor;
import Item.Boots;
import Item.Weapon;

public abstract class   Unit {
    public  Weapon weapon;
    public Boots boots;
    public Armor armor;
    public int hp;
    public String name;
    public int damage;
    public int run;
    public int weightAll;

    public Unit(int hp, String name, int damage, int run){
        this.hp = hp;
        this.name = name;
        this.damage = damage;
        this.run = run;
        this.weapon = null;
        this.boots = null;
        this.armor = null;



    }
    public void attack(Unit target) {
        damage = chkAttack(target, this);

        if (target.hp <= 0) {
            System.out.println("Он мертв! С ним уже не подерешься!");
        } else {
            if (damage > 0) {
                target.hp -= damage;
                System.out.println(name + " наносит " + damage + " урона!");
                if (target.hp <= 0) {
                    System.out.println(target.name + " мертв!");

                }
            } else {
                System.out.println(name + " не пробил броню " + target.name);
            }

        }
    }
    public Integer chkRun(Unit unit){
        unit.run = (unit.run + unit.boots.run) - chkWeightAll(this);
        run = unit.run;
        return run;

    }public Integer chkWeightAll(Unit unit){
        unit.weightAll = unit.weapon.weight;
        weightAll = unit.weightAll;
        return weightAll;
    }
    public Integer chkAttack(Unit target,Unit self){
        int prearmor = 0;
        if (target.armor != null) prearmor = target.armor.armor;
        if (this.weapon != null) damage = weapon.damage;
        damage = damage - prearmor;
        return damage;
    }

    public void info(){
        System.out.println("Юнит: " + this.name);
        System.out.println("Оружие: " + this.weapon.name);
        System.out.println("Доспехи: " + this.armor.name);
        System.out.println("Ботинки: " + this.boots.name);

        System.out.println("Общие характеристики:");
        System.out.println("Здоровье: " + this.hp);
        System.out.println("Броня: " + this.armor.armor);
        System.out.println("Скорость: " + chkRun(this));
        System.out.println("Урон: " + this.weapon.damage);
    }



}
