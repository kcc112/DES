import java.util.Arrays;

public class Main {
    public static void main(String args[]){

       Des cipher = new Des();
        String message = "Kamil";
        String key = "asctfavt";

        byte[] keyB = key.getBytes();  //tablica do której zostaną zapisane bity

        System.out.println("String na bity: " + Arrays.toString(keyB));



        /*System.out.print("Orginalna wiadomość"+ " " + message + "\n");
        System.out.print("Orginalna klucz" + " " + key + "\n");

        String messageCheanged = cipher.cheangeToBin(message);
        System.out.print("String binarnie" + " " + messageCheanged + "\n");*/

        String keyCheanged = cipher.cheangeToBinKey(key);
        System.out.print("Klucz binarnie" + " " + keyCheanged + "\n");

        keyB = cipher.bytePermutFunction(keyB,cipher.PC1);

        System.out.println("String na bity po permutacji: " + Arrays.toString(keyB));

        keyCheanged = cipher.stringPermutationFunc(keyCheanged,cipher.PC1);
        System.out.print("Klucz binarnie po permutacji" + " " + keyCheanged + "\n");
        System.out.print(cipher.PC1[0]);



    }
}