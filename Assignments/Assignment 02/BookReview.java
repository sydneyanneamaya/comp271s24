import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.io.InputStream;

/*
NO IMPORT STATEMENTS. NO CALLS TO SYSTEM.anything, except for 
System.out.println or print or printf as needed.
 */ 
public class BookReview {

    /**
     * Establishes a Scanner on a weblink. If the connection can not be made,
     * the method returns a null. That's how we can tell something went wrong
     * and decide what to do next.
     * @param link String with link to website with text to scan
     * @return Scanner connected to the website or null if connection cannot be made
     */
    public static Scanner connectToBook(String link) {
        Scanner bookScanner;
        try {
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            InputStream stream = connection.getInputStream();
            bookScanner = new Scanner(stream);
        } catch (Exception e) {
            bookScanner = null;
        }
        return bookScanner;
    } // method connecttoBook

    /**
     * use a while loop to traverse through book
     * if a word is unique add to array
     * and make the array bigger to account
     * for the new word
     * count length of array and return int
     * @param args
     */

    public static void main(String[] args) {
        // https://gutenberg.org/cache/epub/98/pg98.txt is a link
        // to the text of "Tale of Two Cities" from Project Gutenberg
        String book = "https://gutenberg.org/cache/epub/98/pg98.txt";
        Scanner bookScanner;
        bookScanner = connectToBook(book);
        DynamicArray words = new DynamicArray();
        String nextWord = " ";
        while(bookScanner.hasNext()){
            nextWord = bookScanner.next();
            ifUnique(nextWord, words);
        }
        int count = words.length();
        System.out.println("The number of unique words is: " + count);
    }

    public static void ifUnique(String string, DynamicArray myArray){
       boolean myBoolean = myArray.addUnique(string);
       if (myBoolean == true){
        myArray.add(string);
       }
    }


} // method main

// class BookReview
