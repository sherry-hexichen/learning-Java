/*
* [A2Q2 Class]
*
* COMP 1020 SECTION [A03]
* INSTRUCTOR: [Amir Memar]
* NAME: [Xichen HE]
* ASSIGNMENT: [Assignment 2]
* QUESTION: [question 2]
*
* PuRPOSE: A2Q2 Class reads a input file, remove duplicate information from the file and write the rest to a output file:
*           -input: String
*           -output: String
*           -words[]: String
*           -numWords: int
*           -insert(String): void
*           -indexOf(String): int
*           +removeDuplicateLines(): void
*/

import java.io.*; //I/O operations
import java.util.Scanner;

public class A2Q2 {
    //instance variable
    private String[] words;
    private String input = "inputFile";
    private String output = "outputFile";
    private int numWords;//count the number of words in array

    private final int ARRAY_SIZE = 20;
    private final int NOT_FOUND = -1;

    public A2Q2(String in, String out) {
        this.input = in;
        this.output = out;
        words = new String[ARRAY_SIZE];
        numWords = 0;
    }//constructor

    private void insert(String newWord) {
        //check space
        if (numWords == words.length) {
            //too small, double the array size, copy the elements
            String[] tempWords = new String[words.length * 2];
            for (int i = 0; i < words.length; i++) {
                tempWords[i] = words[i];
            }//for loop
            words = tempWords;//change the pointer, "words" is now pointing the new array
        }
        //ordered insertion
        int index = numWords;
        while (index > 0) {
            if (words[index - 1].compareTo(newWord) >= 0) {
                words[index] = words[index - 1];
                index--;
            } //if input parameter is smaller than the last element in the array, move the last element one more position
             
            else { 
                break; //until find the position for the input param, break the loop
            }
        }//while loop
        words[index] = newWord; //insert the newWord into the array
        numWords++;//increment num of words in array
    }//insert method: insert the input parameter into the array and keep the array in ascending order

    private int indexOf(String newWord) {
        int index = NOT_FOUND;//index of the newWord
        //binary search
        int low = 0; //lowest index
        int high = numWords - 1; //highest index
        int mid; //index in the middle
        while (low <= high) {
            mid = (low + high) / 2;
            if (words[mid].equals(newWord)) {
                index = mid;
                break;
            } else if (words[mid].compareTo(newWord) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }//while loop
        return index;
    }//indexOf method: perform a binary search and find the index of the given parameter in the array

    public void removeDuplicateLines() throws IOException {
        Scanner readFile = new Scanner(new File(input));//open input file
        PrintWriter writeFile = new PrintWriter(output);//create output file
        while (readFile.hasNextLine()) {
             insert(readFile.nextLine()); //insert all lines in the input file to the array
        }//while loop
        for(int i=0; i<numWords; i++){
            if(indexOf(words[i]) == i) //if the current word is unique in the array
                writeFile.println(words[i]); //write it to the output file
            else                      //if the current word is NOT unique in the array
                System.out.println(words[i]+" has been seen before!!"); //don't write it the second time
        }
        readFile.close();
        writeFile.close();
    }//removeDuplicateLines method

}//A2Q2 Class
