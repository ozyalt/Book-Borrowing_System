//********************************//
//Name: Abdulaziz Mohammed Altamimi
//Section Number: IT 
//Assignment Title: Assignment 2
//ID : 1940715
//Date: 3/8/2010
//********************************//
package it_1940715_p2_borrowing_system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class IT_1940715_P2_Borrowing_System {

    private static String uniqueCode = "BR";
    private static int uniqueNumber = 1000;

    // Main // 
    public static void main(String[] args) throws FileNotFoundException {

        String temp;
        File file = new File("input.txt");
        if (!file.exists()) {
            System.out.println("File Not availble");
            System.exit(0);
        }

        File fileo = new File("output.txt");
        PrintWriter writer = new PrintWriter(fileo);
        Scanner SC = new Scanner(file);
        Book[] NumberOfBooks = new Book[SC.nextInt()];
        int counterb = NumberOfBooks.length;
        Member[] NumberOfM = new Member[SC.nextInt()];
        int counterm = NumberOfM.length;
        Borrowing[] NumberOfBooksAllowed = new Borrowing[SC.nextInt()*NumberOfM.length];

        // Start of text //
        writer.println("###########################################");
        writer.println("***** Welcome to Library Borrowing System *****");

        while (true) {
            temp = SC.next();
            if (temp.equals("Add_Book")) {
                inputBook(SC, NumberOfBooks, writer);

            } else if (temp.equals("Add_Member")) {

                inputMember(SC, NumberOfM, writer);
            } else if (temp.equals("Borrow")) {
                borrowingBook(writer, SC, NumberOfBooks, NumberOfM, NumberOfBooksAllowed);
            } else if (temp.equals("Search_Borrowing")) {
                borrowingdetails(SC, writer, NumberOfBooksAllowed);
            } else if (temp.equals("Book_Status")) {
                bookStatus(writer, NumberOfBooks, SC);
            } else if (temp.equals("Quit")) {
                writer.println("###########################################");
                writer.println("Thank you for using the books booking System, Good Bye!");
                writer.println("");
                writer.println("###########################################");
                writer.flush();
                writer.close();
                SC.close();
                System.exit(0);
            }

        }
    }

    // input Book Method //
    public static void inputBook(Scanner SC, Book[] books, PrintWriter writer) {
        writer.println("###########################################");
        String bookNo = SC.next();
        String title = SC.next();
        String author = SC.next();
        int remCopies = SC.nextInt();
        int numCopies = remCopies;

        if (Book.getCurrBookindex() < books.length) {
            Book test = new Book(bookNo, title, author, remCopies, numCopies);
            books[Book.getCurrBookindex()] = test;
            Book.incCurrBookindex();

            writer.println("Book " + test.getBookNo() + " Successfully Added ");

        } else {
            writer.println("Book " + bookNo + " Was not Added\n " + "You exceed the maximum number of Books");

        }

    }

    // input Member Method //
    public static void inputMember(Scanner SC, Member[] members, PrintWriter writer) {
        writer.println("###########################################");
        String name = SC.next();
        int id = SC.nextInt();
        String type = SC.next();
        if (Member.getCurrMemberindex() < members.length) {
            Member test = new Member(name, id, type);
            members[Member.getCurrMemberindex()] = test;
            Member.incCurrMemberindex();

            writer.println("Member " + name + " Successfully Added ");

        } else {

            writer.println("Member " + name + " Was not Added\n" + "You exceed the maximum number of Members ");

        }

    }

    // Borrowing Book Method //
    public static void borrowingBook(PrintWriter writer, Scanner SC, Book[] books, Member[] members, Borrowing[] borrowing) {
        writer.println("###########################################");
        int id = SC.nextInt();
        int numbookallowed = SC.nextInt();
        String[] Allowed = new String[numbookallowed];
        int[] indexBook = new int[numbookallowed];
        Book[] borrowed = new Book[numbookallowed];
        int memid = 0;
        for (int i = 0; i < numbookallowed; i++) {
            Allowed[i] = SC.next();
        }
        boolean found = false;
        boolean bookFound = false;
        // ----------------------------------------------------
        for (int i = 0; i < Member.getCurrMemberindex(); i++) {
            if (members[i].getId() == id) {
                memid = i;
                found = true;
            }
        }
        if (found == false) {
            writer.println("Member " + id + " was not registered in the System");
            return;
        }
        //-----------------------------------------------------------------
        if (numbookallowed > 3) {
            writer.println("---The required plus the previous borrowed books is exceeded the maximum of Allowed");
            return;
        }
        //------------------------------------------------------------------
        for (int i = 0; i < Allowed.length; i++) {
            for (int j = 0; j < Book.getCurrBookindex(); j++) {
                if (books[j].getBookNo().equals(Allowed[i])) {
                    indexBook[i] = j;
                    bookFound = true;
                }
            }
            if (bookFound == false) {
                writer.println("“No Record found with the Book Code " + Allowed[i]);
                return;
            }
        }
        //------------------------------------------
        for (int i = 0; i < indexBook.length; i++) {
            if (books[indexBook[i]].getRemCopies() == 0) {
                writer.println("Book " + books[indexBook[i]].getBookNo() + " Was not Added\n"
                        + " You exceed the maximum number of Books");
                return;
            }
        }

        /// iiiii
        for (int i = 0; i < indexBook.length; i++) {
            books[indexBook[i]].setRemCopies(books[indexBook[i]].getRemCopies() - 1);

        }
        String borrwNo = uniqueCode + uniqueNumber;
        for (int i = 0; i < indexBook.length; i++) {
            borrowed[i] = books[indexBook[i]];
        }
        Member mem = members[memid];
        Borrowing bb = new Borrowing(borrwNo, new Date(), borrowed, mem, numbookallowed);
        borrowing[Borrowing.getCurrBorrowing()] = bb;
        Borrowing.incCurrBorrowing();
        uniqueNumber++;
        writer.println("Member with Id   " + id + " Successfully Borrowed  " + numbookallowed + " Books");

    }

    // Borrwing Details Metohd  //
    public static void borrowingdetails(Scanner SC, PrintWriter writer, Borrowing[] borrowing) {
        writer.println("###########################################");
        String temp = SC.next();
        boolean book = false;
        int dex = 0;
        for (int i = 0; i < Borrowing.getCurrBorrowing(); i++) {
            if (borrowing[i].getBrowNo().equals(temp)) {
                book = true;
                dex = i;
            }
        }
        if (book == false) {
            writer.println(" No Record found with the BR " + temp);
            return;
        }
        
        writer.println("Borrowing Information for  BR#  " + temp);
        writer.println("Member Name: "+borrowing[dex].getMember().getName());
        writer.println("borrowing Date : "+borrowing[dex].getBorrowingData());
        writer.println("Number of borrowing Books"+ borrowing[dex].getNumBooksBorrowing());
        writer.println("Books List :");
        for (int i = 0; i < borrowing[dex].getAllBooks().length; i++) {
            writer.print("Title " + borrowing[dex].getAllBooks()[i].getTitle() +" ");
            writer.print("Author: " +borrowing[dex].getAllBooks()[i].getAuthor() + " ");
            writer.print("# of Copies: " + borrowing[dex].getAllBooks()[i].getRemCopies() + " ");
            writer.println("# of Remaning Copies: " + borrowing[dex].getAllBooks()[i].getRemCopies() + "\n");
            
        }
        

    }
    
    // Book Status Method //
    public static void bookStatus(PrintWriter writer, Book[] books, Scanner SC) {
        String temp = SC.next();
        boolean dexter = false;
        writer.println("#####################################");
        for (int i = 0; i < Book.getCurrBookindex(); i++) {
            if (books[i].getBookNo().equals(temp)) {
                writer.println("Information for Book " + books[i].getBookNo());
                writer.println("Title:" + books[i].getTitle());
                writer.println("Author: " + books[i].getAuthor());
                writer.println("Number of Copies" + books[i].getNumCopies());
                writer.println("Number of Remainig Copies" + books[i].getRemCopies());
                writer.println();
                writer.println();
                dexter = true;

            }
        }
        if(dexter == false){
            writer.println("No Record found with the Book Code "+temp);
        }
    }

}
