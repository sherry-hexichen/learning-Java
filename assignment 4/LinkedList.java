/*
* [LinkedList Class]
*
* COMP 1020 SECTION [A03]
* INSTRUCTOR: [Amir Memar]
* NAME: [Xichen HE]
* ASSIGNMENT: [Assignment 4]
* QUESTION: [question 1 and 2]
*
* PuRPOSE: 
*     A4Q1Test: Store each word in text file as a whole linked list.
*               When printing it out, make sure each line is same length
*             and make the text become aligned in both left and right sides.
*   
*     A4Q2Test: Use the same text file to create an alphabetical list
*             by selecting the unique words from the text file 
*             and insert them into a linked list by alphabetical order. 
*/

import java.util.Scanner;
import java.io.*;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    private Node alphaFirst;
    private int alphaSize;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;

        alphaFirst = null;
        alphaSize = 0;
    }//default constructor

    public LinkedList(String filename) {
        try {
            Scanner read = new Scanner(new File(filename));
            while (read.hasNext()) {
                append(read.next()); //add next word to the end of linked list
                insertAlpha(last); //insert the current word to alpha linked list
            }
        }//try 
        catch (IOException io) {
            System.out.println(io.getMessage());
        }//catch
    }//constructor 2
    
    public int size() {
        Node next = first;
        while (next != null) {
            size++;
            next = next.getLink();
        }
        return size;
    }//size method: return the size of the whole linked list

    public void append(String words) {
        last = new Node(words);
        Node next = first;
        if (first == null) {
            first = last;
        } //empty linked list, add the new node 
        else {
            while (next.getLink() != null) {
                next = next.getLink();
            }//while
            next.setLink(last);
        }//append the new node to the end of current linked list
    }//append method: adding a new node(word) to the end of the existing linked list

    public String format(int width) {
        String output = "";//whole result for return
        String current = "";//current line
        Node next = first; //linked list pointer
        int length = 0; //character length per line
        int lineNo = 0; //num of current line
        current = first.getData();
        length = current.length();
        while (next != last) {
            next = next.getLink();
            length += next.getData().length() + 1;//data length plus at least one space
            if (length <= width) {
                current += " " + next.getData();
            } //current length less than width, keep adding more words 
            else {
                lineNo++; //start from a new line
                current = addSpace(current, width, lineNo);//add extra space to current line
                output += current + "\n"; //add current line with modified space to the output
                current = next.getData(); //reset current line
                length = current.length(); //reset current line length
            }
        }//while
        output += current + "\n";
        return output;
    }//format method

    private String addSpace(String sample, int width, int lineNumber) {
        int empty = 0;//number of space between words
        int extra = width - sample.length();//number of extra spaces to fill up the line
        String[] sampleList = sample.split(" ");
        String result = "";//output result
        for (int i = 0; i < sample.length(); i++) {
            if (sample.charAt(i) == ' ') {
                empty++;
            }
        }//for loop: count the empty room that can used to add extra space in the line
        //extra%empty: from Left to Right or R to L, the first (extra%empty) empty add 1 space
        //extra/empty: every empty spot add (extra/empty) spaces
        for (int i = 0; i < sampleList.length; i++) {
            if (lineNumber % 2 != 0) {
                if (i < extra % empty) {
                    result += sampleList[i] + giveSpace(2) + giveSpace(extra / empty);
                } 
                else {
                    result += sampleList[i] + giveSpace(1) + giveSpace(extra / empty);
                }
            }//odd num line, add extra from left to right 
            else if (empty - i <= extra % empty) {
                result += sampleList[i] + giveSpace(2) + giveSpace(extra / empty);
            } 
            else {
                result += sampleList[i] + giveSpace(1) + giveSpace(extra / empty);
            }//even num line, add extra from right to left
        }//for loop
        return result;
    }//private method addSpace: add extra space to current line

    private String giveSpace(int num) {
        String space = "";
        for (int i = 1; i <= num; i++) {
            space += " ";
        }
        return space;
    }//private method giveSpace: give number of spaces as a whole String

    public int sizeAlpha() {
        Node next = alphaFirst;
        while (next != null) {
            alphaSize++;
            next = next.getAlphaLink();
        }
        return alphaSize;
    }//return the size of the alpha order linked list

    public String toAlphaString() {
        String alphaList = "";
        Node next = alphaFirst;
        while (next != null) {
            alphaList += next.getData() + " ";
            next = next.getAlphaLink();
        }
        return alphaList;
    } //toAlphaString method: return the alphabetical list as a whole String

    public String toAlpha(String word) {
        String alphaWord = "";
        alphaWord = (word.replaceAll("[^\\p{Alpha}-']", "")).toLowerCase();
        return alphaWord;
    } /*toAlpha(String) mehod: remove any special character in the parameter 
                             and change it to lower case */

    public void insertAlpha(Node keyNode) {
        Node newNode = new Node(toAlpha(keyNode.getData()));//new Node contains new word
        if (alphaFirst == null) {
            alphaFirst = newNode;
        } //empty alpha list, add to the front
        else if (newNode.getData().compareTo(toAlpha(alphaFirst.getData())) < 0) {
            //insert into the very first position
            newNode.setAlphaLink(alphaFirst);
            alphaFirst = newNode;
        } //new node belongs to the very first one, add to the front
        else {
            Node after = alphaFirst.getAlphaLink();
            Node before = alphaFirst;
            while (after != null) {
                if (newNode.getData().compareTo(toAlpha(after.getData())) < 0) {
                    break;
                }//proper spot found, break while loop
                //else new node spot not found yet, go to next node to check
                before = after;
                after = after.getAlphaLink();
            }//while
            
            /*before insert the keyNode(new node), 
             * go through whole alpha list to see if keyNode data is already there*/
            Node n = alphaFirst;
            boolean contain = false;
            while (n != null) {
                if (newNode.getData().compareTo(toAlpha(n.getData())) == 0) {
                    contain = true;
                    break; 
                }//as long as one Node gives same data as keyNode, break the loop
                //else go to next node to check
                n = n.getAlphaLink();
            }//while
            // if keyword is not found in list
            if(!contain) {
                //insert between before & after
                newNode.setAlphaLink(before.getAlphaLink());
                before.setAlphaLink(newNode);
            }/*if keyNode data is not in the list, 
             * insert it into the proper spot that found before*/
        } //go through whole alpha linked list to found spot and insert new node
    }/*public method insertAlpha(Node): insert the key node in the param to
     *the alphabetical linked list in order when current data is not in list yet*/
}//LinkedList class

/*[Node Class]*/
class Node {
    private String data; 
    private Node link; //pointer for question 1
    private Node alphaLink; //pointer for question 2

    public Node(String word) {
        data = word;
        link = null;
        alphaLink = null;
    }//constructor
 
    //accessors
    public Node getLink() {
        return link;
    }

    public String getData() {
        return data;
    }

    public Node getAlphaLink() {
        return alphaLink;
    }
 
    //mutators
    public void setLink(Node newLink) {
        this.link = newLink;
    }

    public void setData(String newWord) {
        data = newWord;
    }

    public void setAlphaLink(Node newAlphaLink) {
        this.alphaLink = newAlphaLink;
    }
}//Node class
