import java.util.*;

public class Encryptor {
    private final Scanner scanner;
    private final ArrayList<Character> charList;
    private ArrayList<Character> shuffledCharList;
    private char character;
    private boolean isRunning;

    Encryptor() {
        scanner = new Scanner(System.in);
        charList = new ArrayList<>();
        shuffledCharList = new ArrayList<>();
        character = ' ';
        isRunning = true;
    }

    public void start() {
        generateNewKey(false);
        askOperationType();
    }

    private void askOperationType() {
        while(isRunning) {
            System.out.println("\n********************************************");
            System.out.println("What do you want to do?");
            System.out.println("(N)ewKey|(G)etKey|(E)ncrypt|(D)ecrypt|(Q)uit");

            char response;
            try {
                response = Character.toUpperCase(scanner.nextLine().charAt(0));
            } catch (Exception e) {
                response = '@';
            }

            switch(response) {
                case 'N':
                    generateNewKey();
                    break;
                case 'G':
                    getKey();
                    break;
                case 'E':
                    encrypt();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'Q':
                    quit();
                    break;
                default:
                    System.out.println("Not a valid option. :(");
            }
        }
    }

    private void generateNewKey() {
        generateNewKey(true);
    }

    private void generateNewKey(boolean printMessage) {
        character = ' ';
        charList.clear();
        shuffledCharList.clear();

        for (int i = 32; i < 127; i++) {
            charList.add(character);
            character++;
        }

        shuffledCharList = new ArrayList<>(charList);
        Collections.shuffle(shuffledCharList);

        if (printMessage) {
            System.out.println("* A new key has been generated *");
        }
    }

    private void getKey() {
        String listString = "";
        for (Character charItem : shuffledCharList) {
            listString += charItem.toString();
        }

        System.out.println("Key: " + listString);
        listString = null;
        System.out.println();
    }

    private void encrypt() {
        processMessage("encrypt", charList, shuffledCharList);
    }

    private void decrypt() {
        processMessage("decrypt", shuffledCharList, charList);
    }

    private void processMessage(String processType, ArrayList<Character> charListFrom, ArrayList<Character> charListTo) {
        if (!Objects.equals(processType, "encrypt") && !Objects.equals(processType, "decrypt")) {
            System.out.println("Nothing to do.");
            return;
        }

        System.out.println("Enter a message to be " + processType + "ed: ");
        char[] messageLetters = scanner.nextLine().toCharArray();

        for (int i = 0; i < messageLetters.length; i++) {
            for (int j = 0; j < charListFrom.size(); j++) {
                if (messageLetters[i] == charListFrom.get(j)) {
                    messageLetters[i] = charListTo.get(j);
                    break;
                }
            }
        }

        System.out.println("Message " + processType + "ed: ");
        String message = "";
        for (char charItem : messageLetters) {
            message += charItem;
        }
        System.out.println(message);

        messageLetters = null;
        message = null;
    }

    private void quit() {
        System.out.println("Exiting...");
        isRunning = false;
    }
}
