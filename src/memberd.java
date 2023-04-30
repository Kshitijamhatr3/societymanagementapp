
public class memberd {
    private int rno;
    private String fname;
    private String lname;
    private long mno;
    private int areasqft;
    private String email;
    
    public memberd(int ID,String FirstName,String LastName,long MobileNo,String Email,int Areasqft)
    {
       this.rno=ID;
       this.fname=FirstName;
       this.lname=LastName;
       this.mno=MobileNo;
       this.areasqft=Areasqft;
       this.email=Email;
       
    }
    public int getId(){
        return rno;
    }
    public String getFirstName(){
        return fname;
    }
    public String getLastName(){
        return lname;
    }
    public long getMobileNo(){
        return mno;
    }
     public String getEmail(){
        return email;
    }
    public int getAreasqft(){
        return areasqft;
    }
    
   
}
