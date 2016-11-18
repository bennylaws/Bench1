package bench1;

import java.sql.SQLException;
import java.sql.Statement;

public class Fill {

	static void fill(Statement stmt, int n)throws SQLException {
		
		
		//Schleife um die BRANCHES-Relation zu füllen
		for(int i=0;i<n;i++){
			
			stmt.executeUpdate(Statements.branches1 + (i+1) + Statements.branches2);
		
		}
		// Schleife um die TELLERS-Relation zu füllen
		for(int i=0;i<n*10;i++){
	
			stmt.executeUpdate(Statements.tellers1 + (i+1) + Statements.tellers2
					+ (int) (1+(Math.random()*n))  + Statements.tellers3);
		}
//		// Schleife um die ACCOUNTS-Relation zu füllen
		for(int i=0;i<n*100000;i++){
			
			stmt.executeUpdate(Statements.accounts1 + (i+1) + Statements.accounts2
					+ (int) (1+(Math.random()*n))  + Statements.accounts3);

		}
	}
}
