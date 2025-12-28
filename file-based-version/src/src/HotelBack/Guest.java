package HotelBack;

public class Guest 
{
	private String CodeMelli;
	private String FLName;
	private String ShShenasname;
	private String DateOfBirth;
	private String PhoneNumber;
	private String DateOfRegistration;
	//*************************************************************
	
	public Guest()
	{
		this.CodeMelli="";
		this.FLName="";
		this.ShShenasname="";
		this.DateOfBirth="";
		this.PhoneNumber="";
		this.DateOfRegistration="";
	}
	
	public Guest(Guest A)
	{
		this.CodeMelli=A.GetCodeMelli();
		this.FLName=A.GetFLName();
		this.ShShenasname=A.GetShShenasname();
		this.DateOfBirth=A.GetDateOfBirth();
		this.PhoneNumber=A.GetPhoneNumber();
		this.DateOfRegistration=A.GetDateOfRegistration();
	}
	
	//*************************************************************
	
	public void SetCodeMelli(String CodeMelli)
	{
		this.CodeMelli=CodeMelli;
	}

	public void SetFLName(String FLName)
	{
		this.FLName=FLName;
	}

	public void SetShShenasname(String ShShenasname)
	{
		this.ShShenasname=ShShenasname;
	}

	public void SetDateOfBirth(String DateOfBirth)
	{
		this.DateOfBirth=DateOfBirth;
	}

	public void SetPhoneNumber(String PhoneNumber)
	{
		this.PhoneNumber=PhoneNumber;
	}

	public void SetDateOfRegistration(String DateOfRegistration)
	{
		this.DateOfRegistration=DateOfRegistration;
	}

	//********************************************************************************************************

	public String GetCodeMelli()
	{
		return this.CodeMelli;
	}

	public String GetFLName()
	{
		return this.FLName;
	}

	public String GetShShenasname()
	{
		return this.ShShenasname;
	}
	
	public String GetDateOfBirth()
	{
		return this.DateOfBirth;
	}

	public String GetPhoneNumber()
	{
		return this.PhoneNumber;
	}

	public String GetDateOfRegistration()
	{
		return this.DateOfRegistration;
	}

}
