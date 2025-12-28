package HotelBack;

public class Room 
{
	private String RoomNumber;
	private String RoomType;
	private String NightlyPrice;
	private String RoomStatus;

	//*************************************************

	public Room()
	{
		this.RoomNumber="";
		this.RoomType="";
		this.NightlyPrice="";
		this.RoomStatus="";
	}
	
	public Room(Room A)
	{
		this.RoomNumber=A.RoomNumber;
		this.RoomType=A.RoomType;
		this.NightlyPrice=A.NightlyPrice;
		this.RoomStatus=A.RoomStatus;
	}

	//*************************************************

	public void setRoomNumber(String roomNumber) 
	{
		this.RoomNumber = roomNumber;
	}

	public void setRoomType(String roomType) 
	{
		this.RoomType = roomType;
	}
	
	public void setNightlyPrice(String nightlyPrice) 
	{
		this.NightlyPrice = nightlyPrice;
	}

	public void setRoomStatus(String roomStatus) 
	{
		this.RoomStatus = roomStatus;
	}
	
	//*************************************************
	
	public String getRoomNumber() 
	{
		return this.RoomNumber;
	}
	
	public String getRoomType() 
	{
		return this.RoomType;
	}
	
	public String getNightlyPrice() 
	{
		return this.NightlyPrice;
	}

	public String getRoomStatus() 
	{
		return this.RoomStatus;
	}
}
