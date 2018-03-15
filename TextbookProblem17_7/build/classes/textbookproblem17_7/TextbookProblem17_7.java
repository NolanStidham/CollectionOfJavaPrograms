package textbookproblem17_7;

import java.io.*;
import java.util.ArrayList;

/**
 * Computer Science 2 
 * Nolan Stidham 
 * Assignment Number: 17.7 Date Last Edited: 4/4/17 
 * Reads from a .dat file and outputs based on the contents of that file
 */
public class TextbookProblem17_7 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        double sumOfLoanPayment = 0;
        try {
            try (ObjectOutputStream outputDat
                    = new ObjectOutputStream(new FileOutputStream("object.dat"))) {
                int numOfLoans = (int)(Math.random()*(10));
                
                for (int i = 0; i < numOfLoans; i++) {
                    double interest = Math.random()*10;
                    int years = (int)(Math.random()*(50))+1;
                    double intAmount = Math.random()*1000000;
                    outputDat.writeObject(new Loan(interest, years, intAmount));
                }
                
                outputDat.close();
            }

            try(ObjectInputStream inputDat
                    = new ObjectInputStream(new FileInputStream("object.dat"))){
                int counter = 0;
                ArrayList<Object> loans = new ArrayList<>();
                
                while(true){
                    loans.add(inputDat.readObject());
                    System.out.println("Loan " + (counter + 1) + ": \n" + loans.get(counter));
                    Loan currentLoan = (Loan) loans.get(counter);
                    sumOfLoanPayment = sumOfLoanPayment + currentLoan.getTotalPayment();
                    counter++;
                }
                
            }
            

        } catch (EOFException ex) {
            System.out.println("All loans read");
            System.out.println("Total Loan Payment: " + sumOfLoanPayment);
        }

    }
}
