package bench1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class DBI42Bench1 {

	public static void main(String[] args) {

		// Statement-Strings aus Klasse Statements laden
		Statements strings = new Statements();
		
		Connection conni = null;
		Statement stmt = null;
		
/*		System.out.println("Versuche Treiber zu laden");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.err.println("etwas ist schief gelaufen :(");
			System.err.println(e);
			System.exit(-1);
		}

		System.out.println("Treiber geladen");
*/		
		//Verbindung herstellen
		try {
//			conni = DriverManager.getConnection(
//					"jdbc:mysql://192.168.122.46", "dbi", "dbi_pass");
		    conni = DriverManager.getConnection(
				"jdbc:mysql://java-co.de:65535", "bench", "atb");
			stmt = conni.createStatement();
		} 
		
		catch (SQLException e) {
			String err = e.getMessage();
			System.out.println("etwas ist schief gelaufen :(");
			System.out.println(err);
			System.exit(-1);
		}

		System.out.println("Sehr verbunden");
		
		// in Schleife alle Einzel-Strings aus strings.xxxxxx ausfuehren
		try {
		    for (String str : strings.createDb) {
			System.out.println(str);
			stmt.executeUpdate(str);
		    }
		}
		catch (Exception e) {
			System.out.println("Error...");
			System.out.println(e);
		}
				
		//Verbindung beenden, Programm verlassen
		try{
			conni.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}