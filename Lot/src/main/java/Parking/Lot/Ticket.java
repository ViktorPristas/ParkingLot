package Parking.Lot;

import java.sql.Date;

public class Ticket {

	private int ticketID;
	private Date entry;
	private Date leaving;
	private int parkHouseID;
	private String spz;

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public Date getEntry() {
		return entry;
	}

	public void setEntry(Date entry) {
		this.entry = entry;
	}

	public Date getLeaving() {
		return leaving;
	}

	public void setLeaving(Date leaving) {
		this.leaving = leaving;
	}

	public int getParkHouseID() {
		return parkHouseID;
	}

	public void setParkHouseID(int parkHouseID) {
		this.parkHouseID = parkHouseID;
	}

	public String getSpz() {
		return spz;
	}

	public void setSpz(String spz) {
		this.spz = spz;
	}

}
