/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mariecomputer;


import static com.mycompany.mariecomputer.TestMarieComputer.memoryAddress;
import static com.mycompany.mariecomputer.TestMarieComputer.scan;

/**
 *
 * @author stipanmadzar
 */
public class MarieComputer {
    
    public static String ac = "0000";
    public static String pc = "000";
    public static String ir = "0000";
    public static String mar = "000";
    public static String mbr = "0000";
   
    public void executeMarie(int addressCount) {
        
           System.out.println("\n------>PROGRAM RESULTS<-----\n");
           
           for(int i = 0; i < addressCount; ++i) {
           
           if(memoryAddress.get(i).charAt(0) == '0') {
               System.out.println("---------------------------------------------------");
               System.out.println("Error! Program entered instruction with upcode \"0\".\n");
               break;
           }
           
           mar = pc;
           int address = Integer.parseInt(removeLeadingZeros(mar));
           ir = memoryAddress.get(address);
           address++;
           pc = addLeadingZeros(address);
           mar = ir.substring(1);
           int marAddress =  Integer.parseInt(removeLeadingZeros(mar));
           mbr = memoryAddress.get(marAddress);  
           
           String instructionNumber = ir.substring(0, 1);
           String fullAddress = ir;
           int address2 = Integer.parseInt(removeLeadingZeros(ir.substring(1)));
           
           if("1".equals(instructionNumber)) {
               ac = memoryAddress.get(address2);
           }
           else if("2".equals(instructionNumber)) {
             memoryAddress.set(address2, ac);
           }
           else if("3".equals(instructionNumber)) {
               int acInteger = Integer.parseInt(removeLeadingZeros(ac));
               int sum = acInteger + Integer.parseInt(removeLeadingZeros(memoryAddress.get(address2)));
               if(sum > 9999) {
                   System.out.println("---------------------------------------");
                   System.out.println("Error! Number generated exceeds 4 bits.\n");
                   break;
               }
               ac = addLeadingZerosAC(sum);
           }
           else if("4".equals(instructionNumber)) {
               int acInteger = Integer.parseInt(removeLeadingZeros(ac));
               int subtraction = acInteger - Integer.parseInt(removeLeadingZeros(memoryAddress.get(address2)));
               if(subtraction > 9999) {
                   System.out.println("---------------------------------------");
                   System.out.println("Error! Number generated exceeds 4 bits.\n");
                   break;
               }
               ac = addLeadingZerosAC(subtraction);
           }
           else if("5".equals(instructionNumber)) {
               System.out.print("Input decimal number: ");
               int inputValue = scan.nextInt();
               if(inputValue > 9999) {
                   System.out.println("-------------------------------------");
                   System.out.println("Error! Number inputed exceeds 4 bits.\n");
                   break;
               }
               ac = addLeadingZerosAC(inputValue);
           }
           else if("6".equals(instructionNumber)) {
               System.out.println("AC = " + removeLeadingZeros(ac));
           }
           else if("7".equals(instructionNumber)) {
               System.out.println("Program halted!\n");
               break;
           }
           else if("8".equals(instructionNumber)) {
               
               if("8000".equals(fullAddress)) {
                   if(Integer.parseInt(removeLeadingZeros(ac)) < 0) {
                       i++; 
                       int pcInt = Integer.parseInt(removeLeadingZeros(pc));
                       pcInt++;
                       pc = addLeadingZeros(pcInt);
                   }
               }
               else if("8100".equals(fullAddress)) {
                   if(Integer.parseInt(removeLeadingZeros(ac)) == 0) {
                       i++; 
                       int pcInt = Integer.parseInt(removeLeadingZeros(pc));
                       pcInt++;
                       pc = addLeadingZeros(pcInt);
                   }
               }
               else if("8200".equals(fullAddress)) {
                   if(Integer.parseInt(removeLeadingZeros(ac)) > 0) {
                       i++;
                       int pcInt = Integer.parseInt(removeLeadingZeros(pc));
                       pcInt++;
                       pc = addLeadingZeros(pcInt);
                      
                   }
               }
           }           
           else if("9".equals(instructionNumber)) {
               i = address2 - 1;
               pc = addLeadingZeros(address2);
           }
        }
    }
    
    public String removeLeadingZeros(String number) {

        while(number.length() > 1) {
            
            if(number.charAt(0) == '0') {
                number = number.substring(1);
            }
            else {
                break;
            }  
        }  
       return number; 
    }
    
    public String addLeadingZeros(int number) {
        
        String number2 = Integer.toString(number);
        while(number2.length() < 3) {
            
            number2 = "0" + number2;
        }
        return number2;
    }
    
    public String addLeadingZerosAC(int number) {
        
        String number2 = Integer.toString(number);
        while(number2.length() < 4) {
            
            number2 = "0" + number2;
        }
        return number2;
    }
    
    public boolean checkInstructionCorrectness(String instruction) {
        boolean check = true;
                
        if(instruction.length() != 4 || !instruction.matches("[0-9]+") ) {
                check = false;
        }
        else if(instruction.charAt(0) == '5') {
            if(!"000".equals(instruction.substring(1))) {
                return false;
            }
        }
        else if(instruction.charAt(0) == '6') {
            if(!"000".equals(instruction.substring(1))) {
                return false;
            }
        }
        else if(instruction.charAt(0) == '7') {
            if(!"000".equals(instruction.substring(1))) {
                return false;
            }
        }
        else if(instruction.charAt(0) == '8') {
            if(!"000".equals(instruction.substring(1)) && !"100".equals(instruction.substring(1))
            &&!"200".equals(instruction.substring(1))) {
                return false;
            }  
        }
        return check;
    }   
}
