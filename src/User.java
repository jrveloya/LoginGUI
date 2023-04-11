package practice;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.RandomAccessFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class User {
	private String firstName;
	private String lastName;
	private String email;
	private String userID;
	private String password;
	private int ln;
	
	public User() {
		
	}
	public User(String email, String password, String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userID = generateID();
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	 // A utility function to check
    // whether a password is valid or not
    public  void isValid(String password)
        throws InvalidPasswordException
    {
  
        // for checking if password length
        // is between 8 and 15
        if (!((password.length() >= 8)
              && (password.length() <= 15))) {
            throw new InvalidPasswordException(1);
        }
  
        // to check space
        if (password.contains(" ")) {
            throw new InvalidPasswordException(2);
        }
        if (true) {
            int count = 0;
  
            // check digits from 0 to 9
            for (int i = 0; i <= 9; i++) {
  
                // to convert int to string
                String str1 = Integer.toString(i);
  
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                throw new InvalidPasswordException(3);
            }
        }
  
        // for special characters
        if (!(password.contains("@") || password.contains("#")
              || password.contains("!") || password.contains("~")
              || password.contains("$") || password.contains("%")
              || password.contains("^") || password.contains("&")
              || password.contains("*") || password.contains("(")
              || password.contains(")") || password.contains("-")
              || password.contains("+") || password.contains("/")
              || password.contains(":") || password.contains(".")
              || password.contains(", ") || password.contains("<")
              || password.contains(">") || password.contains("?")
              || password.contains("|"))) {
            throw new InvalidPasswordException(4);
        }
  
        if (true) {
            int count = 0;
  
            // checking capital letters
            for (int i = 65; i <= 90; i++) {
  
                // type casting
                char c = (char)i;
  
                String str1 = Character.toString(c);
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                throw new InvalidPasswordException(5);
            }
        }
  
        if (true) {
            int count = 0;
  
            // checking small letters
            for (int i = 90; i <= 122; i++) {
  
                // type casting
                char c = (char)i;
                String str1 = Character.toString(c);
  
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                throw new InvalidPasswordException(6);
            }
        }
  
        // The password is valid
    }
   
    public String generateID() {
		Random r = new Random();
		String randomNumberID = String.format("%04d", r.nextInt(1001));
		ArrayList<String> ID = new ArrayList<String>();
		ID.add(firstName.substring(0,1));
		ID.add(lastName.substring(0,1));
		ID.add("-");
		ID.add(randomNumberID);
		userID = String.join("", ID);
		return userID;
	}
    public void addData(String email, String password) {
    	countLines();
    	try {
			RandomAccessFile raf = new RandomAccessFile("C:\\Users\\jvelo\\eclipse-workspace\\GUIPractice\\src\\practice\\res\\users.txt", "rw");
			for(int i = 0; i < ln; i++) {
				raf.readLine();
			}
			if(ln > 0) {
				raf.writeBytes("\r\n");
	            raf.writeBytes("\r\n");
			}
			raf.writeBytes("Email: " + this.email+ "\r\n");
			raf.writeBytes("Password: " + this.password+ "\r\n");
			raf.writeBytes("User ID: " + this.userID+ "\r\n");
			raf.writeBytes("First Name: " + this.firstName+ "\r\n");
			raf.writeBytes("lastName: " + this.lastName);
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    void countLines() {
    	try {
    		ln=0;
            RandomAccessFile raf = new RandomAccessFile("C:\\Users\\jvelo\\eclipse-workspace\\GUIPractice\\src\\practice\\res\\users.txt", "rw");
            for(int i=0;raf.readLine()!=null;i++){
                ln++;
            }
    	}catch (FileNotFoundException e) {
    		
    	}catch (IOException e1) {
    		
    	}
    }
}

class InvalidPasswordException extends Exception {
	  
    int passwordConditionViolated = 0;
  
    public InvalidPasswordException(int conditionViolated)
    {
        super("Invalid Password: ");
        passwordConditionViolated = conditionViolated;
    }
  
    public String printMessage()
    {
        // Call constructor of parent Exception
        // according to the condition violated
        switch (passwordConditionViolated) {
  
        // Password length should be
        // between 8 to 15 characters
        case 1:
        	
            return ("Password length should be"
                    + " between 8 to 15 characters");
  
        // Password should not contain any space
        case 2:
            return ("Password should not"
                    + " contain any space");
  
        // Password should contain// at least one digit(0-9)
        case 3:
            return ("Password should contain"
                    + " at least one digit(0-9)");
  
        // Password should contain at least
        // one special character ( @, #, %, &, !, $ )
        case 4:
            return ("Password should contain at "
                    + "least one special character");
  
        // Password should contain at least
        // one uppercase letter(A-Z)
        case 5:
            return ("Password should contain at"
                    + " least one uppercase letter(A-Z)");
  
        // Password should contain at least
        // one lowercase letter(a-z)
        case 6:
            return ("Password should contain at"
                    + " least one lowercase letter(a-z)");
        }
  
        return ("");
    }
}
  
