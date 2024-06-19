/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Ykimmel
 */
public class Members {
    private String name;
    private String memberdetails;
    private boolean ispremuim= false;
    private boolean isreg = true;
    private boolean ismemberdue;
    private double moneyspent;
    
    
    
    // Constructor to initialize member details
    public Members(String n,String m,boolean r,boolean isp,Double s){
        this.name = n;
        this.memberdetails=m;
        this.isreg=r;
        this.ispremuim =isp;
        this.moneyspent=s;
    }
      // Empty constructor
    public Members(){
        
    }
     // Getter method for isPremium
     public boolean getP(){
       return ispremuim;
   }
     // Getter method for isMemberDue
     public boolean getDue(){
       return ismemberdue;
   }
     // Getter method for isRegular
      public boolean getR(){
       return isreg;
   }
     // Getter method for name 
     public String getN(){
         return name;
     }
     
     // Getter method for memberDetails
     public String getD(){
         return memberdetails;
     }
     
      // Getter method for moneySpent
     public Double getSpent(){
         return moneyspent;
     }
     
     // Setter method for isRegular 
     public void setR(boolean check){
         isreg=check;
     }
     // Setter method for isMemberDue
    public void setmembershipdue( boolean check){
        ismemberdue= check;
    }
       
    // Setter method for isPremium   
    public void setMembership(boolean check){
        ispremuim= check;
    }
    
    // Setter method for name     
    public void setName( String check){
        name= check;
    }
    
     // Setter method for memberDetails      
     public void setmemberD( String check){
        memberdetails= check;
    }
             
     // Method to add money spent        
     public void addmoney(double num){
        moneyspent+=num;
    }
               
     // Method to remove money spent           
    public void removemoney(double num){ 
        moneyspent-=num;
              }
              

    @Override
    public String toString() {
        return "Members{" + "name=" + name + ", memberdetails=" + memberdetails + ", ispremuim=" + ispremuim + ", ismemberdue=" + ismemberdue + ", moneyspent=" + moneyspent + '}';
    }
               
       
       
       
    
    
}
