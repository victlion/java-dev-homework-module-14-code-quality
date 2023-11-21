package logic;

import writer.PrintMassage;

import java.util.Scanner;

public class Core {
    PrintMassage printMassage = new PrintMassage();
    private char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private byte count;
    private boolean boxEmpty = false;
    private byte winnerStatus = 0;

    @SuppressWarnings("java:S2189")
    public void startApp() {
        boolean boxAvailable;
        printMassage.printStartMsg();

        while (true) {
            printMassage.printBox(box);
            if (!boxEmpty) {
                clearBox();
                boxEmpty = true;
            }
            printMassage.printWinnerStatus(winnerStatus);
            validateInputPlayer();
            if (isWinnerX()) {
                restartGame((byte) 1);
                continue;
            }
            boxAvailable = isBoxAvailable();
            if (!boxAvailable) {
                restartGame((byte) 3);
                continue;
            }
            stapComputer();
            if (isWinnerY()) {
                restartGame((byte) 2);
            }
        }
    }

    private void validateInputPlayer() {
        int inputValuePlayer = 0;
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                inputValuePlayer = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException ex) {
            }
            if (inputValuePlayer > 0 && inputValuePlayer < 10) {
                if (box[inputValuePlayer - 1] == 'X' || box[inputValuePlayer - 1] == 'O')
                    printMassage.printEnterAnotherMsg();
                else {
                    box[inputValuePlayer - 1] = 'X';
                    break;
                }
            } else
                printMassage.printInvalidInputMsg();
        }
    }

    private void clearBox() {
        for (count = 0; count < 9; count++) {
            box[count] = ' ';
        }
    }

    @SuppressWarnings("java:S3776")
    private boolean isWinnerX() {
        return ((box[0] == 'X' && box[1] == 'X' && box[2] == 'X') || (box[3] == 'X' && box[4] == 'X' && box[5] == 'X')
                || (box[6] == 'X' && box[7] == 'X' && box[8] == 'X') ||
                (box[0] == 'X' && box[3] == 'X' && box[6] == 'X') || (box[1] == 'X' && box[4] == 'X' && box[7] == 'X')
                || (box[2] == 'X' && box[5] == 'X' && box[8] == 'X') ||
                (box[0] == 'X' && box[4] == 'X' && box[8] == 'X') || (box[2] == 'X' && box[4] == 'X' && box[6] == 'X'));
    }

    @SuppressWarnings("java:S3776")
    private boolean isWinnerY() {
        return ((box[0] == 'O' && box[1] == 'O' && box[2] == 'O') || (box[3] == 'O' && box[4] == 'O' && box[5] == 'O')
                || (box[6] == 'O' && box[7] == 'O' && box[8] == 'O') ||
                (box[0] == 'O' && box[3] == 'O' && box[6] == 'O') || (box[1] == 'O' && box[4] == 'O' && box[7] == 'O')
                || (box[2] == 'O' && box[5] == 'O' && box[8] == 'O') ||
                (box[0] == 'O' && box[4] == 'O' && box[8] == 'O') || (box[2] == 'O' && box[4] == 'O' && box[6] == 'O'));
    }

    private boolean isBoxAvailable() {
        for (count = 0; count < 9; count++) {
            if (box[count] != 'X' && box[count] != 'O') {
                return true;
            }
        }
        return false;
    }

    private void stapComputer() {
        while (true) {
            byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    private void restartGame(byte status) {
        boxEmpty = false;
        printMassage.printWinnerStatus(status);
    }
}