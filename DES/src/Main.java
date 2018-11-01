public class Main {
    public static void main(String args[]){

        Des cipher = new Des();
        String plainText = "Turning the binary set into an integer";
        String key = "123";
        String cipherText = cipher.encrypt(plainText, key);
        String decryptedText = cipher.decript(cipherText, key);
        System.out.println("Orginalnt text: " + plainText);
        System.out.println("Klucz: " + key);
        System.out.println("Zaszyfrowany text szesnastkowo: " + cipherText);
        System.out.println("Odszyfrowany text: " + decryptedText);
    }
}