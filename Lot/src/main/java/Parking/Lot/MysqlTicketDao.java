package Parking.Lot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class MysqlTicketDao {
	
	JdbcTemplate jdbcTemplate;
	
	public MysqlTicketDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void enter(int parkHouseID, String spz) {
		if(getFreePlaces(parkHouseID) >= 100) {
			System.err.println("Parkhouse " + parkHouseID + " is full!");
			return;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO Ticket (entry, parkHouseID, spz) VALUES (NOW(), ");
		sb.append(parkHouseID);
		sb.append(", '");
		sb.append(spz);
		sb.append("');");
		String sql = sb.toString();
//		System.out.println(sql);
		jdbcTemplate.update(sql);		
	}
	
	public void leave(String spz) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE Ticket SET leaving = NOW() WHERE leaving = 0 AND spz = '");
		sb.append(spz);
		sb.append("';");
		String sql = sb.toString();
		System.out.println(sql);
		jdbcTemplate.update(sql);
	}
	
	public int dayDetail(String date) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(*) FROM Ticket WHERE DATE(entry) = '");
		sb.append(date);
		sb.append("' OR DATE(leaving) = '");
		sb.append(date);
		sb.append("';");
		String sql = sb.toString();
//		System.out.println(sql);
		return jdbcTemplate.queryForObject(sql,  Integer.class);
	}
	
	public int getFreePlaces(int parkHouseID) {
		String sql = "SELECT COUNT(*) FROM Ticket WHERE leaving = 0 AND parkHouseID = " + parkHouseID + ";";
		return jdbcTemplate.queryForObject(sql,  Integer.class);
	}

}
