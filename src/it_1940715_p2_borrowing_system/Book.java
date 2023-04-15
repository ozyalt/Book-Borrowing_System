//********************************//
//Name: Abdulaziz Mohammed Altamimi
//Section Number: IT 
//Assignment Title: Assignment 2
//ID : 1940715
//Date: 10/7/2019
//********************************//

package it_1940715_p2_borrowing_system;


public class Book {
        private String bookNo;
    private String title;
    private String author;
    private int numCopies;
    private int remCopies;
    private static int currBookindex = 0;

    public Book(){

    }
    public Book(String bookNo,String title, String author,int remCopies,int numCopies){
        this.bookNo=bookNo;
        this.title=title;
        this.author=author;
        this.remCopies=remCopies;
        this.numCopies=numCopies;
        
    }

    
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author=author;
    }
     public void setBookNo(String bookNo){
         this.bookNo=bookNo;
     }
      public void setTitle(String title){
          this.title=title;
      }
       public void setNumCopies(int numCopies){
           this.numCopies=numCopies;
       }
       public void setRemCopies(int remCopies){
           this.remCopies=remCopies;
       }
       public static void incCurrBookindex(){
           currBookindex++;
       }
       public String getBookNo(){
           return bookNo;
       }
       public String getTitle(){
           return title;
       }
       public int getNumCopies(){
           return numCopies;
       }
       public int getRemCopies(){
           return remCopies;
       }
       public static int getCurrBookindex(){
           return currBookindex;
       }
}