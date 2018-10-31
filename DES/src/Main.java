import javax.swing.text.JTextComponent;
import java.util.Arrays;

public class Main {
    public static void main(String args[]){

        Des cipher = new Des();
        String message = "Kamilaaa";
        String key = "aaaaaaaa";



        String[] test = cipher.cheangeToBin(message);

        //cipher.encrypt(message , key);


    }
}