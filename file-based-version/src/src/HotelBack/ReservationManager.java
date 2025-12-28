package HotelBack;

public class ReservationManager 
{
	public boolean ReservationIDTest(String ReservationID)
	{
		return true;
	}

	public boolean GuestCodeMelliTest(String GuestCodeMelli)
	{
		return true;
	}

	public boolean CompanionsCodeMelliTest(String CompanionsCodeMelli)
	{
		return true;
	}

	public boolean RoomNumberTest(String RoomNumber)
	{
		return true;
	}

	public boolean CheckInDateTest(String CheckInDate)
	{
		return true;
	}

	public boolean CheckOutDateTest(String CheckOutDate)
	{
		return true;
	}

	public boolean TotalAmountTest(String TotalAmount)
	{
		return true;
	}

	public boolean ReservationDateTest(String ReservationDate)
	{
		return true;
	}

	public int ReservationAdd (Reservation A)//-2:مشکل در ورودی ها
	//0:ارور فضای ناکافی
	//1:همه چی ردیفه
	//-3= مشکل  در انجام عملیات
	{
		boolean ReservationIDflag=ReservationIDTest(A.GetReservationID());

		boolean GuestCodeMelliflag=GuestCodeMelliTest(A.GetGuestCodeMelli());

		boolean CompanionsCodeMelliflag=CompanionsCodeMelliTest(A.GetCompanionsCodeMelli());

		boolean RoomNumberflag=RoomNumberTest(A.GetRoomNumber());

		boolean CheckInDateflag=CheckInDateTest(A.GetCheckInDate());

		boolean CheckOutDateflag=CheckOutDateTest(A.GetCheckOutDate());

		boolean TotalAmountflag=TotalAmountTest(A.GetTotalAmount());	

		boolean ReservationDateflag=ReservationDateTest(A.GetReservationDate());

		int Return=1;

		if (ReservationIDflag==true && GuestCodeMelliflag==true && CompanionsCodeMelliflag==true
				&& RoomNumberflag==true && CheckInDateflag==true 
				&& CheckOutDateflag== true && TotalAmountflag== true && ReservationDateflag== true)
		{
			String ReservationInformation=MakingDataString(A.GetReservationID(), A.GetGuestCodeMelli(),
					A.GetCompanionsCodeMelli(), A.GetRoomNumber(), A.GetCheckInDate(),
					A.GetCheckOutDate(),A.GetTotalAmount(),A.GetReservationDate());

			System.out.println(ReservationInformation);
			
			FileManager ReservationsFile= new FileManager("reservations.txt");
			Return=ReservationsFile.Add(ReservationInformation);
		} 
		else
			Return=-2;

		return Return;

	}//End of Add

	public int Search (String Search, int C, String SearchInforMation[])
	{
		FileManager ReservationsFile= new FileManager("reservations.txt");
		int CReturn=ReservationsFile.Search (Search, C, SearchInforMation);
		return CReturn;
	}

	public void Delete(int CRow)
	{
		FileManager ReservationsFile= new FileManager("reservations.txt");
		ReservationsFile.Update(CRow-1, 9, "false");
	}

	public int Edit(int CRow ,int C, String Update)//0=> مشکل در ویرایش
	//-1=> مشکل در اطلاعات وارد شده برای ویرایش
	//1=> همه چی اوکیه
	{
		boolean flag=true;
		boolean Return=true;
		if(C==1)
			flag=ReservationIDTest(Update);
		else if(C==2)
			flag=GuestCodeMelliTest(Update);
		else if(C==3)
			flag=CompanionsCodeMelliTest(Update);
		else if(C==4)
			flag=RoomNumberTest(Update);
		else if(C==5)
			flag=CheckInDateTest(Update);
		else if(C==6)
			flag=CheckOutDateTest(Update);
		else if(C==7)
			flag=TotalAmountTest(Update);
		else if(C==8)
			flag=ReservationDateTest(Update);
		if(flag==true)
		{
		FileManager ReservationsFile= new FileManager("reservations.txt");
		Return=ReservationsFile.Update(CRow-1 , C, Update);
		if(Return==false)
			return 0;
		}
		else
			return -1;
		
		return 1;
	}

	private String MakingDataString (String ReservationID, String GuestCodeMelli,
			String CompanionsCodeMelli, String RoomNumber, String CheckInDate,
			String CheckOutDate,String TotalAmount,String ReservationDate)
	{
		String Return=ReservationID+"&"+GuestCodeMelli+"&"+CompanionsCodeMelli+"&"+RoomNumber+
				"&"+CheckInDate+"&"+CheckOutDate+"&"+TotalAmount+"&"+ReservationDate+"&"+"true";

		return Return;
	}
}
