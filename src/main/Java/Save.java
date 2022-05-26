import Unit.*;

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Save {
    //        Запускается только через терминал "java -cp sqlite-jdbc-3.20.1.jar:. JDBCmy.java"!
    // таблицы работают так: один -- много где один это абстрактный юнит(у котрого общие характеристики NOT NULL,
//    а у никальные для каждого класса могут быть NULL, по этим значением можно определять тип снаряжения или юнита, когда
//    будет доставать из таблицы

    static final String JDBC_DRIVER = "org.sqlite.JDBC";
    static final String DATABASE_URL = "jdbc:sqlite:game.db";
    public final String table = "units";
    public static String action;
    public static int id;

    public static void SaveToDB(Unit unit) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер сохранения");
        id = Integer.parseInt(sc.next());


        Connection connection = null;
        Statement statement = null;

        System.out.println("Registering JDBC driver...");

        Class.forName(JDBC_DRIVER);

        System.out.println("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL);

        System.out.println("Executing statement...");
        statement = connection.createStatement();


        menu(statement, unit);
//        SaveUnit(statement, unit);


        System.out.println("Closing connection and releasing resources...");
        statement.close();
        connection.close();
        sc.close();

    }
    public static void menu(Statement statement, Unit unit) throws SQLException {
        System.out.println("1. Вывети таблицу\n2. Удалить сохранение\n3.Сохранить\n 4. Загрузить");
        Scanner sc = new Scanner(System.in);
        action = sc.next();
        sc.close();
        if (Objects.equals(action, "1")){
            showTable(statement);
        }
        if (Objects.equals(action, "2")){
            deleteSave(statement);
        }
        if (Objects.equals(action, "3")){
            SaveUnit(statement, unit);
        }
    }

    public static SwordsMan LoadUnitSwordsman(int numberOfSave) throws SQLException {

        String sql;
        sql = "SELECT * FROM units Where id=" + "'" + numberOfSave + "'";
        Connection connection = DriverManager.getConnection(DATABASE_URL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int hp = resultSet.getInt("hp");
        int damage = resultSet.getInt("damage");
        int run = resultSet.getInt("run");
        String type_unit = resultSet.getString("type_unit");
        SwordsMan swordsMan = new SwordsMan(hp, name, damage, run);

        return swordsMan;
    }

    public static void SaveUnit(Statement st, Unit unit) throws SQLException {

        String type_unit = null;
        if (Objects.equals(String.valueOf(unit.getClass()), "class Unit.SwordsMan")){
            type_unit = "class Unit.Thrower";
        }
        if (Objects.equals(String.valueOf(unit.getClass()), "class Unit.Thrower")){
            type_unit = "class Unit.Thrower";
        }if (Objects.equals(String.valueOf(unit.getClass()), "class Unit.Scout")){
            type_unit = "class Unit.Thrower";
        }
        String sql1 = null;
        String sql = null;
        String name = unit.name;
        int hp  = unit.hp;
        int damage  = unit.damage;
        int run  = unit.run;
        sql = "INSERT INTO units (id, name, hp, damage, run, type_unit) VALUES ('"+id+"'"+","+"'"+name+"'"+","+"'"+hp+"'"+","
                    +"'"+damage+"'"+","+"'"+run+"'"+","+"'"+type_unit+"')";

        if (unit.weapon != null){
            String WeaponName = unit.weapon.name;
            int WeaponWeight = unit.weapon.weight;
            int WeaponDamage = unit.weapon.damage;
            sql1 = "INSERT INTO weapon (unit_id, name,weight, damage) VALUES ('"+id+"'"+","+"'"+WeaponName+"'"+","+"'"+WeaponWeight+"'"+","
                    +"'"+WeaponDamage+"')";
            try{
                Connection connection = DriverManager.getConnection(DATABASE_URL);
                Statement statement = connection.createStatement();
                statement.executeQuery(sql1);
            }
            catch (java.sql.SQLException e){
                System.out.println(e);
            }
        }
        try{
            st.executeQuery(sql);
        }
        catch (java.sql.SQLException e){
            System.out.println(e);
        }

        st.close();

    }
    public static void deleteSave(Statement st) throws SQLException {

        String sql;

        sql = "DELETE FROM units WHERE id=" + "'"+id+"'";

        try{
            ResultSet resultSet = st.executeQuery(sql);
            resultSet.deleteRow();
        }
        catch (java.sql.SQLException e){
            System.out.println(e);
        }
        st.close();

    }

    public static void showTable(Statement st) throws SQLException {

        String sql;
        sql = "SELECT * FROM units";

        Statement statement = st;
        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database...");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int hp = resultSet.getInt("hp");
                    int damage = resultSet.getInt("damage");
                    int run = resultSet.getInt("run");
                    String type_unit = resultSet.getString("type_unit");
                    System.out.println("Номер сохранения: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Hp: " + hp);
                    System.out.println("Damage: " + damage);
                    System.out.println("Run: " + run);
                    System.out.println("Unit: " + type_unit);
                    System.out.println("\n================\n");
//                    id, name, hp, damage, run, type_unit)
                }
                resultSet.close();

            }
    }