import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException{

        Des cipher = new Des();
        ReadWriteFileToString file = new ReadWriteFileToString();
        RandomKeyGenerator keyGen = new RandomKeyGenerator();

        String plainText = "Wół go pyta: Panie chrząszczu, po co pan tak brzęczy w gąszczu?";
        String key = "ąbwc";
        String cipherText = cipher.encrypt(plainText, key);
        String decryptedText = cipher.decript(cipherText, key);
        System.out.println("Orginalnt text: " + plainText);
        System.out.println("Klucz: " + key);
        System.out.println("Zaszyfrowany text szesnastkowo: " + cipherText);
        System.out.println("Odszyfrowany text: " + decryptedText);


        String fileText = file.readFile("d:/Projekty/DES/DES/plikiTextowe/plainText.txt");
        String cipherTextFile = cipher.encrypt(fileText, key);
        file.writeFile(cipherTextFile,"d:/Projekty/DES/DES/plikiTextowe/cipherText.txt");
        String fileCipherText = file.readFile("d:/Projekty/DES/DES/plikiTextowe/cipherText.txt");
        String fileDecryptedText = cipher.decript(fileCipherText, key);
        file.writeFile(fileDecryptedText,"d:/Projekty/DES/DES/plikiTextowe/encryptedText.txt");

        String genKey = keyGen.generateKey(8);
        System.out.println(genKey);
    }
}

