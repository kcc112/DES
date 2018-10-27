public class Main {
    public static void main(String args[]){

        Des cipher = new Des();
        String message = "a";
        String key = "a";

        System.out.print("Orginalna wiadomość"+ " " + message + "\n");
        System.out.print("Orginalna klucz" + " " + key + "\n");

        String messageCheanged = cipher.cheangeToBin(message);
        System.out.print("String binarnie" + " " + messageCheanged + "\n");

        String keyCheanged = cipher.cheangeToBinKey(key);
        System.out.print("Klucz binarnie" + " " + keyCheanged + "\n");

    }
}