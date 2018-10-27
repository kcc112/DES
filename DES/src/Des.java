import java.util.Arrays;

public class Des {

    public long binMessage;

    public String cheangeToBin(String message) {


        while (message.length() % 8 != 0) { //Dopuki nie bedzie mozna podzielić tekstu na minimum 8 znaków dpoisuj zank null
            message += "\u0000";
        }

        int blockNumber = message.length()/8;   //Ilość bloków textu każdy blok zawiera 8 znaków
        String[] tableMessageBin = new String[blockNumber];  //Tablice do , której zostanie zapisany text jako reprezętacja binarna
        byte[] byteTable = message.getBytes();  //tablica do której zostaną zapisane bity

        String messageBin;
        for(int i = 0; i < blockNumber; i++){

            String textBlock = message.substring(i*8 , i*8+8); //Podzielenie message na bloki po 8 znaków

            binMessage = 0;

            for(int j = 0; j < 8; j++){

                binMessage += textBlock.charAt(j);  //Zwpisuje w Long wartość bloku textu

                if(j < 7) {
                    binMessage <<= 8;   //Przesuwa o 8 bitów w lewo
                }
            }

            messageBin = Long.toBinaryString(binMessage);   //Po zapisaniu wartości binarnej w postaci stringa  zostanie ucięty pierwszy bajt jakim jest 0 dlatego trzeba dodać ten znak
            while (messageBin.length() % 64 != 0){
                messageBin = "0" + messageBin;
            }

            tableMessageBin[i] = messageBin;

        }

        messageBin = Long.toBinaryString(binMessage);   //Zapisuje wartość binMessage w stringu

        System.out.print("Wartość Long" + " " + binMessage +"\n");

        int test = messageBin.length();

        System.out.print("Długość tekstu" + " " + test +"\n");

        System.out.print("Bity zapisane w tabel:");

        System.out.print(Arrays.toString(tableMessageBin));

        System.out.print("\n");

        System.out.println("String na bity: " + Arrays.toString(byteTable));

        System.out.println("Długość tablicy bitów: " + byteTable.length);


        return messageBin;
    }

    public String cheangeToBinKey(String key){

        while (key.length() % 8 != 0) {
            key += "\u0000";
        }

        long binKey = 0;

        for(int i = 0; i < key.length(); i++) {

            binKey += key.charAt(i);
            if (i < 7) {
                binKey <<= 8;
            }
        }

        key = Long.toBinaryString(binKey);
        while(key.length()%64 != 0){
                key = "0" + key;
            }


        return key;
    }


    public  byte[][] generateSubKey(byte[] key){

        byte[][] subKey = new byte[16][];

        return subKey;
    }
}