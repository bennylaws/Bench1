package bench1;

public class Statements {
	
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
}