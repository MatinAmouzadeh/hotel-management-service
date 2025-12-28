package HotelBack;

public class Reservation 
{
	private String ReservationID;
	private String GuestCodeMelli;
	private String CompanionsCodeMelli;
	private String RoomNumber;
	private String CheckInDate;
	private String CheckOutDate;
	private String TotalAmount;
	private String ReservationDate;
	
	//*************************************************************
	
	public Reservation()
	{
		ReservationID="";
		GuestCodeMelli="";
		CompanionsCodeMelli="";
		RoomNumber="";
		CheckInDate="";
		CheckOutDate="";
		TotalAmount="";
		ReservationDate="";
	}
	
	public Reservation(Reservation A)
	{
		ReservationID=A.ReservationID;
		GuestCodeMelli=A.GuestCodeMelli;
		CompanionsCodeMelli=A.CompanionsCodeMelli;
		RoomNumber=A.RoomNumber;
		CheckInDate=A.CheckInDate;
		CheckOutDate=A.CheckOutDate;
		TotalAmount=A.TotalAmount;
		ReservationDate=A.ReservationDate;
	}
	
	//*************************************************************
	
	public void SetReservationID(String ReservationID)
	{
		this.ReservationID=ReservationID;
	}
	public void SetGuestCodeMelli(String GuestCodeMelli)
	{
		this.GuestCodeMelli=GuestCodeMelli;
	}
	public void SetCompanionsCodeMelli(String CompanionsCodeMelli)
	{
		this.CompanionsCodeMelli=CompanionsCodeMelli;
	}
	public void SetRoomNumber(String RoomNumber)
	{
		this.RoomNumber=RoomNumber;
	}
	public void SetCheckInDate(String CheckInDate)
	{
		this.CheckInDate=CheckInDate;
	}
	public void SetCheckOutDate(String CheckOutDate)
	{
		this.CheckOutDate=CheckOutDate;
	}
	public void SetTotalAmount(String TotalAmount)
	{
		this.TotalAmount=TotalAmount;
	}
	public void SetreservationDate(String ReservationDate)
	{
		this.ReservationDate=ReservationDate;
	}
	
	//*************************************************************
	
	public String GetReservationID()
	{
		return this.ReservationID;
	}
	
	public String GetGuestCodeMelli()
	{
		return this.GuestCodeMelli;
	}
	
	public String GetCompanionsCodeMelli()
	{
		return this.CompanionsCodeMelli;
	}
	
	public String GetRoomNumber()
	{
		return this.RoomNumber;
	}
	
	public String GetCheckInDate()
	{
		return this.CheckInDate;
	}
	
	public String GetCheckOutDate()
	{
		return this.CheckOutDate;
	}
	
	public String GetTotalAmount()
	{
		return this.TotalAmount;
	}
	
	public String GetReservationDate()
	{
		return this.ReservationDate;
	}
	
}
