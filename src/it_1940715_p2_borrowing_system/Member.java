//********************************//
//Name: Abdulaziz Mohammed Altamimi
//Section Number: IT 
//Assignment Title: Assignment 2
//ID : 1940715
//Date: 10/7/2019
//********************************//

package it_1940715_p2_borrowing_system;

public class Member {
    private String name;
    private int id;
    private String type;
    private static int currMemberindex = 0;

   public Member(){
        this.type=null;
        this.name=null;
        this.id=0;
   }
    public Member(String type, int id,String name){
        this.type=type;
        this.id=id;
        this.name=name;
        
    }
    public void setName(String name){
        this.name=name;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setType(String type){
        this.type=type;
    }
    public static void incCurrMemberindex(){
        currMemberindex++;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public String getType(){
        return type;
    }
    public static int getCurrMemberindex(){
        return currMemberindex;
    }
}
