import java.util.Arrays;

public class Des {

    public static byte[] PC1 = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51,
            43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22,
            14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4};

    private static byte[] PC2 = { 14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10,
            23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55,
            30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29,
            32 };

    private static byte[] keyShifts = { 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2,
            2, 1 };


    public String[] cheangeToBin(String message) {

        while (message.length() % 8 != 0) {
            message += "\u0000";
        }

        int blockNumber = message.length()/8;
        String[] tableMessageBin = new String[blockNumber];

        String messageBin;

        for(int i = 0; i < blockNumber; i++){

            String textBlock = message.substring(i*8 , i*8+8);

            long binMessage = 0;

            for(int j = 0; j < 8; j++){

                binMessage += textBlock.charAt(j);

                if(j < 7) {
                    binMessage <<= 8;
                }
            }

            messageBin = Long.toBinaryString(binMessage);
            while (messageBin.length() % 64 != 0){
                messageBin = "0" + messageBin;
            }

            tableMessageBin[i] = messageBin;

        }

        return tableMessageBin;
    }

    private static String cheangeToBinKey(String key){

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



    //Funkcja stringPermutationFunc pzryjmuje string i przeprowadza permutacje zgodnie z przesłana
    //tabelą zwraca string po permutacji
    private String stringPermutationFunc(String text , byte[] table){

        String textPermutated = "";

        for(int i = 0; i < table.length; i++){

            textPermutated += text.charAt(table[i] -1); // -1 bo tablice zaczynają sie od 0
        }
        return textPermutated;
    }

    public String[] stringSubKey(String key){

        String byteKey = cheangeToBinKey(key);
        String keyAfterPerm = stringPermutationFunc(byteKey, PC1);
        String[] subKeys = new String[16];
        String subKey;

        String L = keyAfterPerm.substring(0,28);;
        String R = keyAfterPerm.substring(28,56);;

        for(int i =1; i<17; i++){

            L = stringKeyShifter(L , i);
            R = stringKeyShifter(R , i);

           subKey = L + R;

           subKeys[i-1] = stringPermutationFunc(subKey, PC2 );
        }

        return subKeys;
    }


    private String stringKeyShifter(String half ,int value){

        String healper;
        String newText = "";

        if(value == 1 || value == 2 || value == 9 || value == 16 ){

            healper = half.substring(0,1);

            for(int i = 1; i<28; i++){

                newText += half.substring(i,i+1);
            }

            newText +=healper;
        }
        else{
            healper = half.substring(0,1)+half.substring(1,2);

            for(int i=0; i<26; i++) {

                newText += half.substring(i+2,i+3);
            }

            newText +=healper;
        }
        return newText;
    }



    ///////////////////////////DES using only []byte/////////////////////////////////////////


    public  byte[][] generateByteSubKey(byte[] key){

        byte[][] subKeys = new byte[16][];
        byte[] keyAfterPerm = bytePermutFunction(key, PC1);

        byte[]L = dividedByHalf(keyAfterPerm,0,28);
        byte[]R = dividedByHalf(keyAfterPerm, 28, 28);

        for(int i=0; i<16; i++){
            L = shiftKey(L , 28, keyShifts[i]);
            R = shiftKey(R , 28, keyShifts[i]);

            byte[] gluedKey = glueLefrRight(L,28, R,28);
            subKeys[i] = bytePermutFunction(gluedKey, PC2);
        }
        return subKeys;
    }


    //Funkcja przyjmuje text zapisany w tablicy byte oraz tablice permutacji
    //zwraca tablice byte po permutacij
    private static byte[] bytePermutFunction(byte[] input, byte[] table) {
        int nrBytes = (table.length - 1) / 8 + 1;
        byte[] output = new byte[nrBytes];
        for (int i = 0; i < table.length; i++) {
            int value = extractBit(input, table[i] - 1);
            setBit(output, i, value);
        }
        return output;
    }

    //Wyciąga bit znajdujacy się na kąkretnej pozycji w tablicy byte
    private static int extractBit(byte[] table, int position) {
        int bytePosition = position/ 8;
        int bitPosition = position % 8;
        byte temp = table[bytePosition];
        int bit = (temp >> (8 - (bitPosition + 1))) & 0x0001;
        return bit;
    }

    //Ustawia bit na odpowiednim miejscu w tablicy byte
    private static void setBit(byte[] table, int position, int val) {
        int bytePosition = position / 8;
        int bitPosition = position % 8;
        byte temp = table[bytePosition];
        temp = (byte) (((0xFF7F >> bitPosition) & temp) & 0x00FF);
        byte newByte = (byte) ((val << (8 - (bitPosition + 1))) | temp);
        table[bytePosition] = newByte;
    }

    //Dostaje tablice byte wyciąga bity z danej pozycji do połowy tableli i ustawia je w output zwarca połowe
    //tabeli byte , która została przysłana
    private static byte[] dividedByHalf(byte[] input, int position, int halfTableLength) {
        int numOfBytes = (halfTableLength - 1) / 8 + 1;
        byte[] output = new byte[numOfBytes];
        for (int i = 0; i < halfTableLength; i++) {
            int value = extractBit(input,position + i);
            setBit(output, i, value);
        }
        return output;
    }

    //Przyjmuje połowę klucza z danej iteracji jej długość oraz o ile bitów zostało wykonane przesunięcie.
    //Stworzy klucz po odpowiednipm rzesunieci bitu o 2 albo 1 zależnie od iteracji
    private static byte[] shiftKey(byte[] input, int length, int shift) {
        int nrBytes = (length - 1) / 8 + 1;
        byte[] output = new byte[nrBytes];
        for (int i = 0; i < length; i++) {
            int value = extractBit(input, (i + shift) % length);
            setBit(output, i, value);
        }
        return output;
    }

    //Funkcja skleja lewa i prawą stronę podzielonego byte[]
    private static byte[] glueLefrRight(byte[] L, int lengthL, byte[] R, int lengthR) {
        int numOfBytes = (lengthL + lengthR - 1) / 8 + 1;
        byte[] output = new byte[numOfBytes];
        int j = 0;
        for (int i = 0; i < lengthL; i++) {
            int value = extractBit(L, i);
            setBit(output, j, value);
            j++;
        }
        for (int i = 0; i < lengthR; i++) {
            int value = extractBit(R, i);
            setBit(output, j, value);
            j++;
        }
        return output;
    }

}