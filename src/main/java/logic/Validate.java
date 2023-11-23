package logic;

import writer.PrintMassage;

import java.util.Scanner;

public class Validate {
    PrintMassage printMassage = new PrintMassage();

    public void validateInputPlayer(char[] box) {
        Scanner scan = new Scanner(System.in);
        int inputValuePlayer;
        String scanResult;
        while (true) {
            try {
                scanResult = scan.nextLine();
                if(scanResult.equalsIgnoreCase("n")){
                    scan.close();
                    System.exit(0);
                }
                inputValuePlayer = Integer.parseInt(scanResult);
            } catch (NumberFormatException ex) {
                inputValuePlayer = 0;
            }
            if (inputValuePlayer > 0 && inputValuePlayer < 10) {
                if (box[inputValuePlayer - 1] == 'X' || box[inputValuePlayer - 1] == 'O') {
                    printMassage.printEnterAnotherMsg();
                } else {
                    box[inputValuePlayer - 1] = 'X';
                    break;
                }
            } else {
                printMassage.printInvalidInputMsg();
            }
        }
    }
}
