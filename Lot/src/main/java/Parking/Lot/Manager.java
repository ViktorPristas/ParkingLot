package Parking.Lot;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Manager {
	
	public JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate returnTemplate() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("kopr");
		dataSource.setPassword("koprprojekt2");
		dataSource.setDatabaseName("parking");
		jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}

}
