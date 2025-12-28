package HotelBack;

import com.github.mfathi91.time.PersianDate;

public class GuestManager //از یو آی اطلاعات رو بگیره و اعتبار ستجی کنه و بعدش بده برای ذخیره به فایل منیجر
{
	private boolean CodeMelliTest (String S)
	{
		int CodeMelliAscii;
		if(S.length()!=10 || S.equals(""))
			return false;
		for (int x=0; x<S.length(); x++)
		{
			CodeMelliAscii = (int)(S.charAt(x));
			if (CodeMelliAscii<48 || CodeMelliAscii>57)
				return false;
		}

		boolean flag=false;
		for (int i = 1; i < S.length(); i++) 
			if (S.charAt(i) != S.charAt(0)) 
				flag=true;
		if (flag==false)
			return false;

		int Sum=0;
		for (int x=0; x<9; x++)
		{
			Sum+=(10-x)*(((int)(S.charAt(x)))-48);
		}

		int R=Sum%11;
		if (R<2 && (((int)(S.charAt(9)))-48)!=R)
			return false;
		else if (R>=2 && (((int)(S.charAt(9)))-48)!=(11-R))
			return false;

		return true;
	}

	private boolean FLNameTest (String S)
	{
		if (S.equals(""))
			return false;
		for (int x=0; x<S.length(); x++)
		{
			int FLName=(int)(S.charAt(x));
			if ((FLName<65 || (FLName>90 && FLName<97)) || FLName>122)
				return false;
		}
		return true;
	}

	private boolean ShShenasnameTest (String S)
	{
		int ShShenasnameAscii;
		if(S.length()!=10 || S.equals(""))
			return false;
		for (int x=0; x<S.length(); x++)
		{
			ShShenasnameAscii = (int)(S.charAt(x));
			if (ShShenasnameAscii<48 || ShShenasnameAscii>57)
				return false;
		}

		return true;
	}

	private boolean DateOfBirthTest (String S) 
	{
		if(S.equals(""))
			return false;

		String year="";
		for(int x=0; x<=3; x++)
		{
			year+=S.charAt(x);
			int Ascii=(int) (S.charAt(x));
			if(Ascii<48 || Ascii>57)
				return false;
		}
		if(S.charAt(4)!='/' || S.charAt(7)!='/')
			return false;

		for(int x=5; x<=6; x++)
		{
			int Ascii=(int) (S.charAt(x));
			if(Ascii<48 || Ascii>57)
				return false;
		}

		for(int x=8; x<=9; x++)
		{
			int Ascii=(int) (S.charAt(x));
			if(Ascii<48 || Ascii>57)
				return false;
		}

		PersianDate Date=PersianDate.now();

		if(Date.getYear()-Integer.parseInt(year)>=120)
			return false;

		return true;
	}

	private boolean PhoneNumberTest (String S)
	{
		int PhoneNumberAscii;
		if(S.equals("") || S.charAt(0)!='0' || S.charAt(1)!='9' || S.length()!=11)
			return false;
		for (int x=2; x<S.length(); x++)
		{
			PhoneNumberAscii = (int)(S.charAt(x));
			if (PhoneNumberAscii<48 || PhoneNumberAscii>57)
				return false;
		}
		return true;
	}

	private boolean DateOfRegistrationTest (String S)
	{
		if(S.equals(""))
			return false;
		
		for(int x=0; x<=3; x++)
		{
			int Ascii=(int) (S.charAt(x));
			if(Ascii<48 || Ascii>57)
				return false;
		}
		if(S.charAt(4)!='/' || S.charAt(7)!='/')
			return false;

		for(int x=5; x<=6; x++)
		{
			int Ascii=(int) (S.charAt(x));
			if(Ascii<48 || Ascii>57)
				return false;
		}

		for(int x=8; x<=9; x++)
		{
			int Ascii=(int) (S.charAt(x));
			if(Ascii<48 || Ascii>57)
				return false;
		}
		
		return true;
	}

	public int GuestAdd (Guest A)//-2:مشکل در ورودی ها
	//0:ارور فضای ناکافی
	//1:همه چی ردیفه
	//-3= مشکل  در انجام عملیات
	{
		boolean CodeMelliflag=CodeMelliTest(A.GetCodeMelli());

		boolean FLNameflag=FLNameTest(A.GetFLName());

		boolean ShShenasnameflag=ShShenasnameTest(A.GetShShenasname());

		boolean DateOfBirthflag=DateOfBirthTest(A.GetDateOfBirth());

		boolean PhoneNumberflag=PhoneNumberTest(A.GetPhoneNumber());

		boolean DateOfRegistrationflag=DateOfRegistrationTest(A.GetDateOfRegistration());

		int Return=1;

		if (CodeMelliflag==true && FLNameflag==true && ShShenasnameflag==true
				&& DateOfBirthflag==true && PhoneNumberflag==true 
				&& DateOfRegistrationflag== true)
		{
			String GuestInformation=MakingDataString(A.GetCodeMelli(), A.GetFLName(),
					A.GetShShenasname(), A.GetDateOfBirth(), A.GetPhoneNumber(),
					A.GetDateOfRegistration());
			FileManager GuestsFile= new FileManager("guests.txt");
			Return=GuestsFile.Add(GuestInformation);
		}
		else
			Return= -2;
		System.out.println("CodeMelliflag= "+ CodeMelliflag);
		System.out.println("FLNameflag= "+ FLNameflag);
		System.out.println("ShShenasnameflag= "+ ShShenasnameflag);
		System.out.println("DateOfBirthflag= "+ DateOfBirthflag);
		System.out.println("PhoneNumberflag= "+ PhoneNumberflag);
		System.out.println("DateOfRegistrationflag= "+ DateOfRegistrationflag);
		System.out.println("13");


		return Return;

	}//End of Add

	public int Search (String Search, int C, String SearchInforMation[])
	{
		FileManager GuestsFile= new FileManager("guests.txt");
		int CReturn=GuestsFile.Search (Search, C, SearchInforMation);
		return CReturn;
	}

	public void Delete(int C)
	{
		FileManager GuestsFile= new FileManager("guests.txt");
		GuestsFile.Delete(C);
	}

	public int Edit(int CRow ,int C, String Update) //0=> مشکل در ویرایش
	//-1=> مشکل در اطلاعات وارد شده برای ویرایش
	//1=> همه چی اوکیه
	{
		boolean flag=true;
		boolean Return=true;
		if(C==1)
			flag=CodeMelliTest(Update);
		else if(C==2)
			flag= FLNameTest(Update);
		else if(C==3)
			flag= ShShenasnameTest(Update);
		else if(C==4)
			flag= DateOfBirthTest(Update);
		else if(C==5)
			flag= PhoneNumberTest(Update);
		else if(C==6)
			flag= DateOfRegistrationTest(Update);
		if (flag==true)
		{
			FileManager GuestsFile= new FileManager("guests.txt");
			Return=GuestsFile.Update(CRow-1 , C, Update);
			if(Return==false)
				return 0;
		}
		else
			return -1;

		return 1;
	}

	private String MakingDataString (String CodeMelli, String FLName,
			String ShShenasname, String DateOfBirth, String PhoneNumber,
			String DateOfRegistration)
	{
		String Return=CodeMelli+"&"+FLName+"&"+ShShenasname+"&"+DateOfBirth+
				"&"+PhoneNumber+"&"+DateOfRegistration;

		return Return;
	}
}
