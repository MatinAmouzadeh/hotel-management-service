package com.matinsoft.hotel.util;

import java.time.LocalDate;

public class ValidationUtil {

	//No Object
	private ValidationUtil() {

	}

	public static void validateNationalCode(String nationalCode, String country) {
		//***************************IR**************************************
		if(country.equals("IR")) {
			int CodeMelliAscii;

			if(nationalCode.length()!=10)
				throw new IllegalArgumentException("Invalid Iranian national code");

			for (int x=0; x<nationalCode.length(); x++)
			{
				CodeMelliAscii = (int)(nationalCode.charAt(x));
				if (CodeMelliAscii<48 || CodeMelliAscii>57)
					throw new IllegalArgumentException("Invalid Iranian national code");
			}

			boolean flag=false;
			for (int i = 1; i < nationalCode.length(); i++)
				if (nationalCode.charAt(i) != nationalCode.charAt(0))
					flag=true;
			if (flag==false)
				throw new IllegalArgumentException("Invalid Iranian national code");

			int Sum=0;
			for (int x=0; x<9; x++)
			{
				Sum+=(10-x)*(((int)(nationalCode.charAt(x)))-48);
			}

			int R=Sum%11;

			if (R<2 && (((int)(nationalCode.charAt(9)))-48)!=R)
				throw new IllegalArgumentException("Invalid Iranian national code");

			else if (R>=2 && (((int)(nationalCode.charAt(9)))-48)!=(11-R))
				throw new IllegalArgumentException("Invalid Iranian national code");
		}

		//*****************TR************************************************
		else if(country.equals("TR")) {
			if (nationalCode.length()!=11)
				throw new IllegalArgumentException("Invalid Turkish national code");

			boolean flag=true;
			int A[]=null;
			for(int x=0; x<nationalCode.length(); x++) {
				//Just number
				if(nationalCode.charAt(x)<48 || nationalCode.charAt(x)>57)
					throw new IllegalArgumentException("Invalid Turkish national code");
				//CharAt 0!=0
				else if(x==0 && nationalCode.charAt(0)=='0')
					throw new IllegalArgumentException("Invalid Turkish national code");
				else if(flag==true) {
					A=new int[11];
					A[0]=nationalCode.charAt(0)-'0';
					flag=false;
				}
				//Array full
				else if(flag==false) {
					A[x]=nationalCode.charAt(x)-'0';
				}

			}

			int sumOdd= A[0] + A[2] + A[4] + A[6] + A[8];
			int sumEven= A[1] + A[3] + A[5] + A[7];

			int digit10= ((sumOdd*7)-sumEven)%10;
			if (digit10 < 0) digit10 += 10;

			if (digit10 != A[9]) {
				throw new IllegalArgumentException("Invalid Turkish national code");
			}

			int sumFirst10=0;
			for (int i=0; i<10; i++) {
				sumFirst10+=A[i];
			}

			int digit11=sumFirst10%10;
			if (digit11!=A[10]) {
				throw new IllegalArgumentException("Invalid Turkish national code");
			}
		}

		//*****************DE************************************************
		else if(country.equals("DE")) {
			if (nationalCode.length()!=11)
				throw new IllegalArgumentException("Invalid German national code");

			int product=10;

			for(int x=0; x<10; x++) {
				if(nationalCode.charAt(x)<48 || nationalCode.charAt(x)>57)
					throw new IllegalArgumentException("Invalid German tax ID");

				int digit=nationalCode.charAt(x)-'0';
				product=(product+digit)*2%11;
			}

			int checkDigit=(11-product)%10;

			if (checkDigit!=(nationalCode.charAt(10)-'0'))
				throw new IllegalArgumentException("Invalid German tax ID");
		}

		//******************ES**********************************************
		//ready method
		else if (country.equals("ES")) {

			if (nationalCode==null||nationalCode.length()<9)
				throw new IllegalArgumentException("Invalid Spanish national code");

			nationalCode=nationalCode.toUpperCase();

			String letters="TRWAGMYFPDXBNJZSQVHLCKE";

			String numberPart;
			char givenLetter;

			// ---------- NIE ----------
			if (nationalCode.charAt(0)=='X' ||
					nationalCode.charAt(0)=='Y' ||
					nationalCode.charAt(0)=='Z') {

				char firstChar=nationalCode.charAt(0);
				String replaced;

				if (firstChar=='X')
					replaced="0";
				else if (firstChar == 'Y')
					replaced="1";
				else
					replaced="2";

				numberPart=replaced+nationalCode.substring(1, 8);
				givenLetter=nationalCode.charAt(8);
			}
			// ---------- DNI ----------
			else {
				numberPart=nationalCode.substring(0, 8);
				givenLetter=nationalCode.charAt(8);
			}

			// ---------- Numeric check ----------
			for (int i=0; i<numberPart.length(); i++) {
				if (!Character.isDigit(numberPart.charAt(i))) {
					throw new IllegalArgumentException("Invalid Spanish national code");
				}
			}

			int number=Integer.parseInt(numberPart);
			int index=number % 23;
			char expectedLetter=letters.charAt(index);

			if (expectedLetter!=givenLetter) {
				throw new IllegalArgumentException("Invalid Spanish national code");
			}
		}

		//******************BR***********************************************
		else if (country.equals("BR")) {

			if (nationalCode.length()!=11)
				throw new IllegalArgumentException("Invalid Brazilian CPF");

			//Just number
			for (int i=0; i<11; i++) {
				if (!Character.isDigit(nationalCode.charAt(i)))
					throw new IllegalArgumentException("Invalid Brazilian CPF");
			}

			// charAt(x)!= ...&charAt(x-1)&charAt(x+1)&...
			boolean allSame=true;
			for (int i=1; i<11; i++) {
				if (nationalCode.charAt(i)!=nationalCode.charAt(0)) {
					allSame=false;
					break;
				}
			}
			if (allSame)
				throw new IllegalArgumentException("Invalid Brazilian CPF");

			int sum=0;

			// ---------- digit 10 ----------
			for (int i=0; i<9; i++) {
				int digit=nationalCode.charAt(i)-'0';
				sum+=digit*(10-i);
			}

			int r=(sum*10)%11;
			if (r==10)
				r=0;

			if (r!=(nationalCode.charAt(9)-'0'))
				throw new IllegalArgumentException("Invalid Brazilian CPF");

			// ---------- digit 11 ----------
			sum=0;
			for (int i=0; i<10; i++) {
				int digit=nationalCode.charAt(i)-'0';
				sum+=digit*(11-i);
			}

			r=(sum*10)%11;
			if (r==10)
				r=0;

			if (r!=(nationalCode.charAt(10)-'0'))
				throw new IllegalArgumentException("Invalid Brazilian CPF");
		}

		//******************SE***********************************************
		else if (country.equals("SE")) {

			if (nationalCode.length()!=10)
				throw new IllegalArgumentException("Invalid Swedish personal number");

			int sum=0;

			for (int i=0; i<9; i++) {

				char c=nationalCode.charAt(i);
				if (!Character.isDigit(c))
					throw new IllegalArgumentException("Invalid Swedish personal number");

				int digit=c-'0';

				// موقعیت‌های زوج (از صفر)
				if (i%2==0) {
					digit*=2;
					if (digit>9)
						digit-=9;
				}

				sum+=digit;
			}

			int checkDigit=nationalCode.charAt(9)-'0';

			if ((sum+checkDigit)%10!=0)
				throw new IllegalArgumentException("Invalid Swedish personal number");
		}

		//******************UK********************************************
		else if (country.equals("UK")) {
			if (nationalCode.length() != 9)
				throw new IllegalArgumentException("Invalid UK NINO");

			String firstTwo = nationalCode.substring(0, 2);
			String numbers = nationalCode.substring(2, 8);
			char suffix = nationalCode.charAt(8);

			// حروف ممنوع
			String forbiddenLetters = "DFIQUV";
			if (forbiddenLetters.indexOf(firstTwo.charAt(0)) != -1 ||
					forbiddenLetters.indexOf(firstTwo.charAt(1)) != -1) {
				throw new IllegalArgumentException("Invalid UK NINO");
			}

			// ترکیب‌های ممنوع
			String[] invalidPrefixes = {
					"BG", "GB", "KN", "NK", "NT", "TN", "ZZ"};

			for (String p : invalidPrefixes) {
				if (firstTwo.equals(p))
					throw new IllegalArgumentException("Invalid UK NINO");
			}

			// بررسی عددی بودن ۶ رقم
			for (int i = 0; i < numbers.length(); i++) {
				if (!Character.isDigit(numbers.charAt(i)))
					throw new IllegalArgumentException("Invalid UK NINO");
			}

			// بررسی suffix
			if ("ABCD".indexOf(suffix) == -1)
				throw new IllegalArgumentException("Invalid UK NINO");
		}

		//******************IT*********************************************
		else if (country.equals("IT")) {
			if (nationalCode.length()!=16)
				throw new IllegalArgumentException("Invalid Italian national code");

			for (int i=0; i<nationalCode.length(); i++) {
				char c=nationalCode.charAt(i);

				if (!Character.isUpperCase(c) && !Character.isDigit(c)) {
					throw new IllegalArgumentException("Invalid Italian national code");
				}
			}

			// 6 حرف اول
			for (int i=0; i<6; i++) {
				if (!Character.isLetter(nationalCode.charAt(i))) {
					throw new IllegalArgumentException("Invalid Italian national code");
				}
			}

			// جای اعداد مشخص
			int[] digitPositions={6,7,9,10,12,13,14};
			for (int pos:digitPositions) {
				if (!Character.isDigit(nationalCode.charAt(pos))) {
					throw new IllegalArgumentException("Invalid Italian national code");
				}
			}

			// جای حروف مشخص
			int[] letterPositions = {8,11,15};
			for (int pos : letterPositions) {
				if (!Character.isLetter(nationalCode.charAt(pos))) {
					throw new IllegalArgumentException("Invalid Italian national code");
				}
			}
		}

		//*********************ELSE*********************************************
		else {

			int len = nationalCode.length();

			// طول منطقی
			if (len < 6 || len > 20) {
				throw new IllegalArgumentException("Invalid national code format");
			}

			// بررسی تک‌تک کاراکترها
			for (int i = 0; i < len; i++) {

				char c = nationalCode.charAt(i);

				boolean isDigit = (c >= '0' && c <= '9');
				boolean isUpperLetter = (c >= 'A' && c <= 'Z');
				boolean isLowerLetter = (c >= 'a' && c <= 'z');

				if (!isDigit && !isUpperLetter && !isLowerLetter) {
					throw new IllegalArgumentException("Invalid national code format");
				}
			}
		}


	}//END OF METHOD

	public static void validatePhone(String phone) {
		if (phone.length()<7 || phone.length()>15)
			throw new IllegalArgumentException("Invalid phone number length");

		for (int i=0; i<phone.length(); i++) {
			char c=phone.charAt(i);
			if (i==0 && c=='+')
				continue;
			if (c<'0'||c>'9')
				throw new IllegalArgumentException("Invalid phone number format");
		}
	}//END OF METHOD

	public static void validateEmail(String email) {
		if (email == null || email.isBlank())
			return; // ایمیل اختیاری

		if (!email.contains("@") || !email.contains("."))
			throw new IllegalArgumentException("Invalid email format");
	}//END OF METHOD

	public static void validateName(String value, String fieldName) {
		if (value.length()<2 || value.length()>50) {
			throw new IllegalArgumentException(fieldName + " length is invalid");
		}

		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);

			if (!((c >= 'A' && c <= 'Z')||(c >= 'a' && c <= 'z')||c==' ')) {
				throw new IllegalArgumentException(fieldName + " contains invalid characters");
			}

			// جلوگیری از دو فاصله پشت سر هم
			if (c==' ' && i+1<value.length() && value.charAt(i+1)==' ') {
				throw new IllegalArgumentException(fieldName +" contains multiple spaces");
			}
		}

	}//END OF METHOD

	public static void validateCountry(String country) {
		if (country.length()!=2)
			throw new IllegalArgumentException("Invalid country code");

		for (int i=0; i<country.length(); i++) {
			char c=country.charAt(i);

			if (!(c>='A' && c<='Z')) {
				throw new IllegalArgumentException("Invalid country code");
			}
		}
	}//END OF METHOD

	public static void validateDateOfBirth(LocalDate DateOfBirth) {
		if(!DateOfBirth.isBefore(LocalDate.now()))
			throw new IllegalArgumentException("Invalid birth date");
	}

}//END OF CLASS