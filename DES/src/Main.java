import javax.swing.text.JTextComponent;
import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        Des cipher = new Des();
       String test = cipher.encrypt("Kamil;;;;","123");
       System.out.println(test);
    }
}