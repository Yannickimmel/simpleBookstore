
import java.util.ArrayList;




/**
 *
 * @author Ykimmel
 */
public class Memberlist {
    //List to store members
  private ArrayList<Members> members;
     
 // constructor to initialize the list
 public Memberlist() {
        members = new ArrayList<>();
    }

    // Method to add a member to the list
    public void addMember(Members member) {
        members.add(member);
    }

    // Method to find a member by name
    public Members findM(String name) {
        for (Members member : members) {
            if (member.getN().equals(name)) {
                return member;
            }
        }
        return null; // Member not found
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return members.isEmpty();
    }
     

        
     
     

     
     
     
     
     
      public void  printmembers(){
        for(Members member : members){
         System.out.println( "Name:" + member.getN() + " Info:" + member.getD() + " Membership:" +  member.getP() + " Fees:" + member.getDue());
    }
    }

    
     
     
}
