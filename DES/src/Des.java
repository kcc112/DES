import java.util.Arrays;

public class Des {

    public static byte[] PC1 = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51,
            43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22,
            14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4};

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


    /*public  byte[][] generateSubKey(byte[] key){

        byte[][] subKeys = new byte[16][];
        byte[] permKey = permutF(key, PC1);

        return subKey;
    }*/


    //Funkcja stringPermutationFunc pzryjmuje string i przeprowadza permutacje zgodnie z przesłana
    //tabelą zwraca string po permutacji
    public static String stringPermutationFunc(String text , byte[] table){

        String textPermutated = "";

        for(int i = 0; i < table.length; i++){

            textPermutated += text.charAt(table[i] -1); // -1 bo tablice zaczynają sie od 0
        }

        return textPermutated;
    }

    public static byte[] bytePermutFunction(byte[] input, byte[] table) {
        int nrBytes = (table.length - 1) / 8 + 1;
        byte[] output = new byte[nrBytes];
        for (int i = 0; i < table.length; i++) {
            int value = extractBit(input, table[i] - 1);
            setBit(output, i, value);
        }
        return output;

    }
    private static int extractBit(byte[] data, int position) {
        int bytePosition = position/ 8;
        int bitPosition = position % 8;
        byte temp = data[bytePosition];
        int bit = temp >> (8 - (bitPosition + 1)) & 0x0001;
        return bit;
    }

    private static void setBit(byte[] table, int position, int val) {
        int bytePosition = position / 8;
        int bitPosition = position % 8;
        byte temp = table[bytePosition];
        temp = (byte) (((0xFF7F >> bitPosition) & temp) & 0x00FF);
        byte newByte = (byte) ((val << (8 - (bitPosition + 1))) | temp);
        table[bytePosition] = newByte;
    }

}