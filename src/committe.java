public class committe {
    private int id;
    private String memberrole;
    private String workassign;
    private String workdn;
    
     public committe(int id,String memberrole1,String workassign1,String workdn1)
    {
       this.id=id;
       this.memberrole=memberrole1;
       this.workassign=workassign1;
       this.workdn=workdn1; 
     
    }
    public int getId(){
        return id;
    }
    public String getMemberrole(){
        return memberrole;
    }
    public String getWorkassign(){
        return workassign;
    }
    public String getWorkdn(){
        return workdn;
    }  
    
    
}

