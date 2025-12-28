package HotelBack;

public class RoomManager 
{	
	public boolean RoomNumberTest(String S)
	{
		int RoomNumberAscii;
		if (S.equals(""))
			return false;
		for (int x=0; x<S.length(); x++)
		{
			RoomNumberAscii = (int)(S.charAt(x));
			if (RoomNumberAscii<48 || RoomNumberAscii>57)
				return false;
		}
		return true;
	}
	
	public boolean RoomTypeTest(String S)
	{
		if (S.equals("VIP"))
			return true;
		else if (S.equals("Suite"))
			return true;
		else if (S.equals("Normal"))
			return true;
		return false;
	}
	
	public boolean NightlyPriceTest(String S)
	{
		int NightlyPriceAscii;
		if (S.equals(""))
			return false;
		for (int x=0; x<S.length(); x++)
		{
			NightlyPriceAscii = (int)(S.charAt(x));
			if (NightlyPriceAscii<48 || NightlyPriceAscii>57)
				return false;
		}
		
		return true;
	}
	
	public boolean RoomStatusTest(String S)
	{
		if (S.equals("Vacant"))
			return true;
		else if(S.equals("Reserved"))
			return true;
		else if(S.equals("Under Maintenance"))
			return true;
		
		return false;
	}
	
	public int AddRoom(Room A)//-2:مشکل در ورودی ها
	//0:ارور فضای ناکافی
	//1:همه چی ردیفه
	//-3= مشکل  در انجام عملیات
	{
		boolean RoomNumberflag=RoomNumberTest(A.getRoomNumber());
		
		boolean RoomTypeflag=RoomTypeTest(A.getRoomType());
		
		boolean NightlyPriceflag=NightlyPriceTest(A.getNightlyPrice());
		
		boolean RoomStatusflag=RoomStatusTest(A.getRoomStatus());
		
		int Return=1;
		if (RoomNumberflag==true && RoomTypeflag==true && NightlyPriceflag==true
				&& RoomStatusflag==true)
		{
			String RoomInformation=MakingDataString(A.getRoomNumber(), A.getRoomType(),
					A.getNightlyPrice(), A.getRoomStatus());
			
			FileManager RoomsFile= new FileManager("rooms.txt");
			Return= RoomsFile.Add(RoomInformation);
		}
		else
			Return= -2;
		
		return Return;
		
	}
	
	public int Search (String Search, int C, String SearchInforMation[])
	{
		FileManager RoomsFile= new FileManager("Rooms.txt");
		int CReturn=RoomsFile.Search (Search, C, SearchInforMation);
		return CReturn;
	}
	
	public void Delete(int C)
	{
		FileManager RoomsFile= new FileManager("Rooms.txt");
		RoomsFile.Delete(C);
	}
	
	public int Edit(int CRow ,int C, String Update) //0=> مشکل در ویرایش
	//-1=> مشکل در اطلاعات وارد شده برای ویرایش
	//1=> همه چی اوکیه
	{
		boolean flag=true;
		boolean Return=true;
		if(C==1)
			flag=RoomNumberTest(Update);
		else if(C==2)
			flag= RoomTypeTest(Update);
		else if(C==3)
			flag= NightlyPriceTest(Update);
		else if(C==4)
			flag= RoomStatusTest(Update);
		if (flag==true)
		{
			FileManager RoomsFile= new FileManager("rooms.txt");
			System.out.println("CROWROOMMANAGER= " + CRow);
			Return=RoomsFile.Update(CRow-1 , C, Update);
			if(Return==false)
				return 0;
		}
		else
			return -1;
		
		return 1;
	}
	private String MakingDataString (String RoomNumber, String RoomType,
			String NightlyPrice, String RoomStatus)
	{
		String Return=RoomNumber+"&"+RoomType+"&"+NightlyPrice+"&"+RoomStatus;
		
		return Return;
	}
}// END OF CLASS
