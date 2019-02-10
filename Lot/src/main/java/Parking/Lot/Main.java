package Parking.Lot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Main {

	public static void main(String[] args) {
		Manager manager = new Manager();
		JdbcTemplate jdbcTemplate = manager.returnTemplate();
		
		MysqlTicketDao mtd = new MysqlTicketDao(jdbcTemplate);
		int number = mtd.getFreePlaces(2);
		System.out.println(number);
		mtd.enter(2, "KE999KE");
		//mtd.enter(0, "KE222KE");
		//mtd.leave("KE222KE");
		//System.out.println(mtd.dayDetail("2019-02-04"));
		
	}
	

}
