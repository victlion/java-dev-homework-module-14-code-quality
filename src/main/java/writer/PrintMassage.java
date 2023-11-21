package writer;

public class PrintMassage {
    private final String WIN = "You won the game!\nCreated by Shreyas Saha. Thanks for playing!";
    private final String LOST = "You lost the game!\nCreated by Shreyas Saha. Thanks for playing!";
    private final String DRAW = "It's a draw!\nCreated by Shreyas Saha. Thanks for playing!";
    private final String ENTER_NUMBER = "Enter box number to select. Enjoy!\n";
    private final String ENTER_ANOTHER = "That one is already in use. Enter another.";
    private final String INVALID_INPUT = "That one is already in use. Enter another.";

    public void printBox(char[] box) {
        System.out.println("\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    public void printWinnerStatus(byte statusNumber) {
        switch (statusNumber) {
            case 1:
                System.out.println(WIN);
                break;
            case 2:
                System.out.println(LOST);
                break;
            case 3:
                System.out.println(DRAW);
                break;
        }
    }

    public void printStartMsg() {
        System.out.println(ENTER_NUMBER);
    }

    public void printEnterAnotherMsg() {
        System.out.println(ENTER_ANOTHER);
    }

    public void printInvalidInputMsg() {
        System.out.println(INVALID_INPUT);
    }
}
