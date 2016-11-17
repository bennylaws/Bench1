import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
public class DBI42Bench1 {

	public static void main(String[] args) {

		Connection conni = null;
		Statement stmt = null;
		
		String createDb[] = {
			
			// str0
			"DROP DATABASE IF EXISTS bank;",
			// str1
			"CREATE DATABASE bank;",
			// str2
			"USE bank;",
			// str3
			"create table branches"
			+"(    branchid   int not null,"
			+"branchname char(20) not null,"
			+"balance    int not null,"
			+"address    char(72) not null, "
			+"primary key (branchid)          );",
			// str4
			"create table accounts"
			+"(    accid    int not null,"
			+"name     char(20) not null,"
			+"balance  int not null,"
			+"branchid int not null,"
			+"address  char(68) not null,"
			+"primary key (accid),"
			+"foreign key (branchid) references branches(branchid));",
			// str5
			"create table tellers"
			+"(    tellerid   int not null,"
			+"tellername char(20) not null,"
			+"balance    int not null,"
			+"branchid   int not null,"
			+"address    char(68) not null,"
			+"primary key (tellerid),"
			+"foreign key (branchid) references branches (branchid));",
			// str6
			"create table history"
			+"(    accid       int not null,"
			+"tellerid    int not null,"
			+"delta       int not null,"
			+"branchid    int not null,"
			+"accbalance  int not null,"
			+"cmmnt       char(30) not null,"
			+"foreign key (accid) references accounts(accid),"
			+"foreign key (tellerid) references tellers(tellerid),"
			+"foreign key (branchid) references branches (branchid));"
		};
		
//		System.out.println("Versuche Treiber zu laden");
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (Exception e) {
//			System.err.println("etwas ist schief gelaufen :(");
//			System.err.println(e);
//			System.exit(-1);
//		}
//
//		System.out.println("Treiber geladen");
		
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
		
		try {
		    for (String str : createDb) {
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