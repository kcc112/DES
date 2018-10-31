import javax.swing.text.JTextComponent;
import java.util.Arrays;

public class Main {
    public static void main(String args[]){

           Des cipher = new Des();
            String message = "Kamil";
            String key = "aaaaaaaa";

            byte[] keyB = key.getBytes();  //tablica do której zostaną zapisane bity

            System.out.println("String na bity: " + Arrays.toString(keyB));



            /*System.out.print("Orginalna wiadomość"+ " " + message + "\n");
            System.out.print("Orginalna klucz" + " " + key + "\n");

            String messageCheanged = cipher.cheangeToBin(message);
            System.out.print("String binarnie" + " " + messageCheanged + "\n");*/

            //String keyCheanged = cipher.cheangeToBinKey(key);
            //System.out.print("Klucz binarnie" + " " + keyCheanged + "\n");

           // keyB = cipher.bytePermutFunction(keyB,cipher.PC1);

            System.out.println("String na bity po permutacji: " + Arrays.toString(keyB));

            //keyCheanged = cipher.stringPermutationFunc(keyCheanged,cipher.PC1);
            //System.out.print("Klucz binarnie po permutacji" + " " + keyCheanged + "\n");
            //System.out.print(cipher.PC1[0]+ "\n");

            //int wynik = cipher.extractBit(keyB,55);
            //System.out.print(wynik);

            byte[][] subKeys = new byte[16][];

            subKeys = cipher.generateByteSubKey(keyB);

            for(int i = 0; i<16; i++){

                for(int j = 0; j < 6; j++ ) {

                    System.out.print(subKeys[i][j] + " ");
                }
                System.out.print("\n");
            }

                        //cipher.stringSubKey(key);


            String[] xD = cipher.stringSubKey(key);

           for(int j = 0; j < 16; j++ ) {

                System.out.println(xD[j]);
            }



           /* String test = cipher.dividedStringByHalfRight("1212121212121212121256565656565767676767673434343432727272", 0);
                System.out.println(test);
                System.out.println(test.length());




            String test2 = cipher.stringKeyShifter(test,3);
                System.out.println(test2);
                System.out.println(test2.length());

                String test3 = cipher.cheangeToBinKey("a");
                System.out.println(test3);
                System.out.println(test3.length());

        String test4 =cipher.stringPermutationFunc(test3, cipher.PC1);
        System.out.println(test4);
        System.out.println(test4.length());*/

        //String a= "a";
       // String b = "b";

       // System.out.println(a+b);

        /*String byteKey = cipher.cheangeToBinKey(key);
        String keyAfterPerm = cipher.stringPermutationFunc(byteKey, cipher.PC1);
        String subKeys[] = new String[16];
        String subKey;

        String L = keyAfterPerm.substring(0,28);;
        String R = keyAfterPerm.substring(28,56);;

        System.out.println(L);
        System.out.println(R);

        System.out.println(keyAfterPerm);
        System.out.println((L+R).length());*/


        //  String killme;
       // String rR = R;


       //for(int i =0; i<16; i++){

          // killme = cipher.stringKeyShifter(L , 1);


           // rR = cipher.stringKeyShifter(rR , 1);

          // System.out.println(killme);



           // subKey = L + R;

            //subKeys[i] = subKey;
       // }



    }
}