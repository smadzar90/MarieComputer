/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mariecomputer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author stipanmadzar
 */
public class TestMarieComputer {

    /**
     * @param args the command line arguments
     */
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<String> memoryAddress = new ArrayList<String>();
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        MarieComputer marie = new MarieComputer();
        System.out.println("\nMARIE'S COMPUTER\n");
        int addressCount = 0;
        boolean instructionValue = true;

        File myObj = new File("instructionSet.txt");
        Scanner myReader = new Scanner(myObj);
        System.out.println("File found!");
            
        while (myReader.hasNextLine()) {
          
            String input = myReader.nextLine();
            instructionValue = marie.checkInstructionCorrectness(input);
            if(!instructionValue) {
                break;
            }
            if(addressCount > 1000) {
                break;
            }
            memoryAddress.add(input); 
            addressCount++;   
            
        }
        myReader.close();
            
        if(memoryAddress.size() > 1000) {
            System.out.println("\n-------------------------------");
            System.out.println("Input size to large. Try Again!\n");
        }
        else if(instructionValue == false) {
            System.out.println("\n------------------------------------------");
            System.out.println("Instruction value not correct. Try Again!\n");
        }
        else {
            while(memoryAddress.size() < 1000) {
                memoryAddress.add("0000");
            }
            marie.executeMarie(addressCount);
        } 
    
    }
          
}
  



