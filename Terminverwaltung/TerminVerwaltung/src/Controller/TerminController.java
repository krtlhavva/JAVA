package Controller;

import Model.Termin;

import java.sql.*;
import java.util.Scanner;

public class TerminController {

    private String datum;
    private String uhrzeit;
    private  String termin;
    private  String beschreibung;
    static Scanner scanner = new Scanner(System.in);

    public static void selectTermin(){

        try{
           Connection connection= MySQL.getConnection();
           Statement statement= connection.createStatement();
            ResultSet rs= statement.executeQuery("Select * from termin");
            while (rs.next()){
                int id = rs.getInt("id");
                String datum= rs.getString("datum");
                String uhrzeit= rs.getString("uhrzeit");
                String termin= rs.getString("termin");
                String beschreibung= rs.getString("beschreibung");
                new Termin(id,datum,uhrzeit,termin,beschreibung);
            }
            System.out.println("------------------------------------------");
            System.out.println("Terminliste:");
            System.out.println("------------------------------------------");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void insertTermin(String datum, String uhrzeit, String termin, String beschreibung){


        try(Connection connection = MySQL.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO termin (datum,uhrzeit,termin,beschreibung)"+
                            "VALUES(?, ?, ?,?)",Statement.RETURN_GENERATED_KEYS)){
            System.out.print("Geben Sie Datum in Format (JJJJ-MM-TT) ein: ");
            datum=scanner.nextLine();
            System.out.print("Geben Sie Uhrzeit in Format (SS:MM) ein: ");
            uhrzeit=scanner.nextLine();
            System.out.print("Geben Sie Termin ein: ");
            termin=scanner.nextLine();
            System.out.print("Geben Sie Beschreibung ein: ");
            beschreibung=scanner.nextLine();
            statement.setString(1,datum);
            statement.setString(2,uhrzeit);
            statement.setString(3,termin);
            statement.setString(4,beschreibung);
            statement.executeUpdate();

            System.out.println("Ihr Termin wurde erfolgreich erzeugt!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
