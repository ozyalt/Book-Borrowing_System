//********************************//
//Name: Abdulaziz Mohammed Altamimi
//Section Number: IT 
//Assignment Title: Assignment 2
//ID : 1940715
//Date: 10/7/2019
//********************************//

package it_1940715_p2_borrowing_system;

import java.util.Date;


public class Borrowing {
    private String browNo;
    private Date borrowingDate;
    private Book[] books;
    private Member member;
    private int numBooksBorrowing;
    public static int currBorrowing = 0 ;
    

public Borrowing(){

  }
  public Borrowing(String browNo,Date borrowingDate,Book[] books,Member member,int numBooksBorrowing){
      this.browNo = browNo;
      this.borrowingDate = borrowingDate;
      this.books = books;
      this.member = member;
      this.numBooksBorrowing = numBooksBorrowing;
  }
  public int getNumBooksBorrowing(){
      return numBooksBorrowing;
  }
   public void setNumBooksBorrowing(int numBooksBorrowing){
       this.numBooksBorrowing=numBooksBorrowing;
   }
    public void setBrowNo(String browNo){
        this.browNo=browNo;
    }
    public void setBorrowingData(Date borrowingDate ){
        this.borrowingDate=borrowingDate;
    }
    public void setBooks(Book book,int index){
        this.books=books;
    }
    public void setMember(Member member){
        this.member=member;
    }
    public static void incCurrBorrowing(){
        currBorrowing++;
    }
    public String getBrowNo(){
        return browNo;
    }
    public Date getBorrowingData(){
        return borrowingDate;
    }
    public Book[] getAllBooks(){
        return books;
    }
    public int getBooks(int index){
        return index;
    }
    public Member getMember(){
        return member;
    }
    public static int getCurrBorrowing(){
        return currBorrowing;
    }

    void setBorrowingData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setBorrowingDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}