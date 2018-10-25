public class Main {
    public static void main(String args[]){

        Des cipher = new Des();
        String message = "Kamil";

        System.out.print(message + "\n");

        String messageCheanged = cipher.cheangeToBin(message + "\n");

        System.out.print("String binarnie" + " " + messageCheanged + "\n");
    }
}