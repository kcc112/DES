import com.sun.prism.shader.Solid_RadialGradient_REFLECT_AlphaTest_Loader;

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

    private static byte[] IP = { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36,
            28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32,
            24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19,
            11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 };

    private static byte[] E = { 32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8,
            9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21,
            20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32,
            1 };

    private static byte[] P = { 16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5,
            18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4,
            25

    };

    private static byte[][][] sBoxes = {
            { 		{ 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 },
                    { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 },
                    { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 },
                    { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 }
            },
            { 		{ 15, 1, 8, 14, 6, 11, 3, 2, 9, 7, 2, 13, 12, 0, 5, 10 },
                    { 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 },
                    { 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 },
                    { 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 }
            },
            { 		{ 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 },
                    { 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 },
                    { 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 },
                    { 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 }
            },
            { 		{ 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 },
                    { 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 },
                    { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 },
                    { 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 }
            },
            { 		{ 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 },
                    { 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 },
                    { 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 },
                    { 11, 8, 12, 7, 1, 14, 2, 12, 6, 15, 0, 9, 10, 4, 5, 3 }
            },
            { 		{ 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 },
                    { 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 },
                    { 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 },
                    { 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 }

            },
            { 		{ 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 },
                    { 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 },
                    { 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 },
                    { 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 }

            },
            { 		{ 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 },
                    { 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 },
                    { 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 },
                    { 2, 1, 14, 7, 4, 10, 18, 13, 15, 12, 9, 0, 3, 5, 6, 11 }
            } };


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

        /*for(int i = 0; i < blockNumber; i++){
            String permutedMessage = stringPermutationFunc(tableMessageBin[i] , IP );
            String L = permutedMessage.substring(0,32);
            String R = permutedMessage.substring(32,64);

            for( int j = 0; j < 16; j++){


            }

        }*/
        return tableMessageBin;
    }

    /*public String encrypt(String plainText , String key){

        String cipherText ="";
        String[] binText = cheangeToBin(plainText);
        String[] subKeys = stringSubKey(key);
        int blockNumber = binText.length;

        for(int i = 0; i < blockNumber; i++) {
            String permutedMessage = stringPermutationFunc(binText[i], IP);
            String L = permutedMessage.substring(0,32);
            String R = permutedMessage.substring(32,64);

            for (int j = 0; j < 16; j++) {
                String nextL = R;
                String NextR = L +

            }

           // System.out.println(permutedMessage);
           // System.out.println(L.length());
           // System.out.println(R.length());

        }

        return cipherText;
    }*/

    public String functionFaistal(String text , String subKey) {
        String permutedText = stringPermutationFunc(text, E);
        String xoredText = xorFunction(permutedText, subKey);
        String sBoxText = sBoxPermutation(xoredText);
        String outputText = stringPermutationFunc(sBoxText, P);
        return outputText;
    }

    private String sBoxPermutation(String text){

        String outputText = "";
        for(int i = 0; i < 3; i++ ){
            String sixBitText = text.substring(i*6,i*6+6);
            String sixBitTextRow = "0000" + sixBitText.substring(5,6) + sixBitText.substring(0,1);
            String sixBitTextCol = "00" + sixBitText.substring(1,5);
            int arrayRow = Integer.parseInt(sixBitTextRow, 2);
            int arrayCol = Integer.parseInt(sixBitTextCol, 2);
            String fourBitText = Integer.toBinaryString(sBoxes[i][arrayRow][arrayCol]);
            while (fourBitText.length() % 4 != 0) fourBitText = "0" + fourBitText;
            outputText += fourBitText;
        }
        return outputText;
    }

    private String xorFunction(String text , String subKey){

        String xored = "";
        for(int i = 0; i < 48; i++) {

            if(text.charAt(i) == subKey.charAt(i)){
                xored += 0;
            }
            else{
                xored += 1;
            }
        }
        return xored;
    }

    private String cheangeToBinKey(String key){

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