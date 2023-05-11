
# MARIE'S COMPUTER

The program simulates Marie's Computer that takes the set of instructions through the input from the file. Input that is greater than 1000, and if the instructions are not properly stated, Marie's simulator will generate an error. If intruction set is runnable, the Marie's Computer will execute the instructions correctly unless program enters instruction with the upcode 0, which will cause crash. 
<br><br>

## How To Use

To enter the Marie's assembly code inside the program, user will have to use instructionSet.txt file and input his code there. All the instructions need to contain 4 digits with leading zeros if needed. After the correct assembly code is entered in the file, user can run the program in IDE or command line, which will execute the instructions of Marie's computer. 
<br><br>

## Instruction Set

Every instruction must be numerical and contain 4 digits. If the decimal number instead of instruction wants to be entered in instruction, user will need to add leading zeros (Ex: 23 would be 0023). First digit is used for the upcode which shows which operation needs to be executed, and rest of the digit is used for the address. Address contains leading zeros as well, if needed. There is maximum of 1000 addresses inside the computer. 

Address count: 000, 001, 002,..., 020, 021, 022, 023 and so on till the 999.
<br><br>

```

Upcode: 

0 -> Used for decimal number 
1 -> Load contents of address inside AC
2 -> Store the contents of AC at address
3 -> Add the contents of address to AC
4 -> Subtract the contents of address to AC
5 -> Input a value from the keyboard into AC
6 -> Output the value in AC to the display
7 -> Terminate program
8 -> Skip next instruction on condition
9 -> Load the value of address into PC

```


## Requirements

1. Instructions must be 4 digits long and numerical 
2. Number of instructions cannot exceed 1000
3. Program not allowed to enter instruction with upcode 0
4. Numbers generated cannot exceed 9999

## How to run

> **TODO**. javac -d . TestMarieComputer.java <br/>
> **TODO**. java com.mycompany.mariecomputer.TestMarieComputer <br/>

## Author 

Stipan Madzar


