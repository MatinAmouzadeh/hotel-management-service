package HotelBack;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class FileManager 
{
	private File file;
	private String FileName;
	private int CRow;
	private String DataArray[];

	//**********************************************************

	public FileManager (String FileName)
	{
		this.CRow=0;
		this.file=new File (FileName);
		try {
			this.file.createNewFile();
		} catch (IOException e) {
			//مشکل در فایل
		}
		this.FileName=FileName;
		this.DataArray=new String[1000];
	}
	//**********************************************************	

	public void SetFileName(String S)
	{
		this.FileName=S;
	}

	//**********************************************************

	public int GetCRow()
	{
		return this.CRow;
	}

	public String[] GetDataArray()
	{
		return this.DataArray;
	}

	public File Getfile()
	{
		return this.file;
	}

	public String GetFileName()
	{
		return this.FileName;
	}
	//**********************************************************

	public int Add (String Information)//-1:تکراری بودن
	//0:ارور فضای ناکافی
	//1:همه چی ردیفه
	//-3= مشکل  در انجام عملیات
	{
		System.out.println("0");
		this.CRow=FileToArray(this.DataArray);
		if (CRow==1000)
			return 0;//ارور فضای ذخیره سازی بده

		else 
		{
			System.out.println("1");
			int Place=SearchToArray(DataArray, CRow, Information);


			if (Place==-1)
			{
				return -1;//ارور تکراری بودن کدملی
			}
			else if (Place==-2)
			{
				return -3;
			}
			else
			{
				for (int x=CRow-1; x>=Place; x--)
				{
					DataArray[x+1]=DataArray[x];
				}
				CRow++;
				DataArray[Place] = Information;
				System.out.println("3");
				ArrayToFile(DataArray);
				return 1;
			}

		}
	}

	public boolean Update(int CRow, int C, String Update) 
	{
		try{
			FileToArray(this.DataArray);

			for (int x=0; x<this.DataArray.length; x++)
				System.out.println(x + "="+ this.DataArray[x]);

			if (this.CRow==-1)
				return false;

			System.out.println("CROWInput File Manager= " + CRow);
			System.out.println("CROW= " + this.CRow);

			int K = 1;
			int a = -1;
			System.out.println("CRowERROR= "+ CRow);
			int b = DataArray[CRow].length();

			for (int y = 0; y < DataArray[CRow].length(); y++) 
			{
				if (DataArray[CRow].charAt(y) == '&') 
				{
					K++;
					if (K == C) 
					{
						a = y;        
					} 
					else if (K==C+1) 
					{
						b = y;
						break;
					}
				}
			}

			String Return = "";
			if (a!=-1)
				Return = DataArray[CRow].substring(0, a+1); 

			Return += Update;

			if (b < DataArray[CRow].length())
				Return += DataArray[CRow].substring(b);

			this.DataArray[CRow] = Return;
			ArrayToFile(this.DataArray);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public void Delete(int C)
	{
		this.CRow=FileToArray(this.DataArray);
		for(int x=C; x<this.CRow; x++)
		{
			this.DataArray[x-1]=this.DataArray[x];
		}
		this.CRow--;
		ArrayToFile(this.DataArray);
	}
	//"User not found."
	public int Search (String Search, int C, String SearchInforMation[])
	{
		int Place[]= new int[1000];
		int CPlace= LocationSearch(Search, C, Place);
		if (CPlace==0)
			return 0;
		for(int x=0; x<CPlace; x++)
		{
			SearchInforMation[x]= (Place[x]+":"+this.DataArray[Place[x]-1]);
			// بررسی اینکه شماره خط معتبر باشه
		}
		return CPlace;
	}

	private int LocationSearch(String Search , int C, int A[])//مکانش به صورت شماره خط در فایل بازگردانده میشود
	//به ترتیب بخش های یک خط اطلاعات فایلی از چپ به راست
	{
		this.CRow = FileToArray(this.DataArray);

		int cA=0;
		for (int x = 0; x < CRow; x++) {
			int K = 0; // شمارنده ستون‌ها
			String S = ""; // اینجا مقدار ستون مورد نظر قرار می‌گیره

			for (int y = 0; y < DataArray[x].length(); y++) 
			{
				char ch = DataArray[x].charAt(y);

				if (ch == '&') 
				{
					K++;
					continue;
				}

				if (K == C - 1) 
				{
					S += ch;
				}
				else if (K >= C) 
				{
					break; // از ستون مورد نظر رد شدیم
				}
			}

			if (S.equals(Search)) 
			{
				A[cA++]=x + 1; // شماره خط فایل
			}
		}
		return cA;
	}

	private int FileToArray(String DataArray[])
	{
		int Row=0;
		try {
			Scanner FileScanner= new Scanner(this.file);
			while(FileScanner.hasNextLine())
			{
				DataArray[Row++]=FileScanner.nextLine();
			}
		}catch (Exception e) {
			return -1;
		}

		this.CRow = Row;

		return Row;
	}


	private void ArrayToFile(String DataArray[])
	{
		try (PrintWriter FM1 = new PrintWriter(this.file)) //فایل رو با وجود ارور نیز سیو میکنه
		{
			for(int x=0; x<this.CRow; x++)
			{
				FM1.write(DataArray[x]+"\n");
			}
			FM1.close();
		}
		catch (IOException e) {
			System.out.println("3");
		}
	}

	private int SearchToArray(String DataArray[], int CRow, String Information) //-2= وارد if و else if نشده
	//-1= تکراری بودن کد ملی یا شماره رزرو
	{
		System.out.println("2");
		String InformationS=""; 
		for (int y=0; Information.charAt(y)!='&'; y++)
		{
			InformationS+=Information.charAt(y);
		}
		try {
			long InformationCodeMelli=Long.parseLong(InformationS);

			long Array[]= new long[CRow];
			String CodeMelliS="";
			for(int x=0; x<CRow; x++)
			{
				for (int y=0; DataArray[x].charAt(y)!='&'; y++)
				{
					CodeMelliS+=DataArray[x].charAt(y);
				}
				Array[x]=Long.parseLong(CodeMelliS);
				CodeMelliS="";
			}
			if(CRow==0 || Array[0]>InformationCodeMelli)
				return 0;

			else if(Array[CRow/2]>InformationCodeMelli)
				for(int x=0; x<CRow/2; x++)
				{
					if (Array[x]==InformationCodeMelli)
						return -1;

					else if (Array[x]<InformationCodeMelli && InformationCodeMelli<Array[x+1])
						return x+1;
				}

			else if(Array[CRow/2]<InformationCodeMelli)
			{
				for(int x=CRow/2; x<CRow-1; x++)
				{
					if (Array[x]==InformationCodeMelli)
						return -1;

					else if (Array[x]<InformationCodeMelli && InformationCodeMelli<Array[x+1])
						return x+1;
				}

				if (Array[CRow-1]<InformationCodeMelli)
					return CRow;

			}
			else
				return -1;

		}catch (Exception e) {
			BigInteger InformationInteger= new BigInteger(InformationS);

			BigInteger Array[]= new BigInteger[CRow];
			String ReservationS="";
			for(int x=0; x<CRow; x++)
			{
				for (int y=0; DataArray[x].charAt(y)!='&'; y++)
				{
					ReservationS+=DataArray[x].charAt(y);
				}
				BigInteger ReservationInteger= new BigInteger(ReservationS);
				Array[x]=ReservationInteger;
				ReservationS="";
			}
			if(CRow==0 || InformationInteger.compareTo(Array[0])==-1)
				return 0;

			else if(InformationInteger.compareTo(Array[CRow/2])==-1)
				for(int x=0; x<CRow/2; x++)
				{
					if (InformationInteger.compareTo(Array[0])==0)
						return -1;

					else if (InformationInteger.compareTo(Array[x])==1 && InformationInteger.compareTo(Array[x+1])==-1)
						return x+1;
				}

			else if(InformationInteger.compareTo(Array[CRow/2])==1)
			{
				for(int x=CRow/2; x<CRow-1; x++)
				{
					if (InformationInteger.compareTo(Array[x])==0)
						return -1;

					else if (InformationInteger.compareTo(Array[x])==1 && InformationInteger.compareTo(Array[x+1])==-1)
						return x+1;
				}

				if (InformationInteger.compareTo(Array[CRow-1])==1)
					return CRow;

			}
			else
				return -1;
		}

		return -2;
	}
}
