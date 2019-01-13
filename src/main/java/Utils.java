import java.util.Random;

public class Utils {

   public static String errorMessage = "Обязательное поле";
   public static String pass = "Qwert1993";

    public static String getRandomEmail() {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * symbols.length());
            salt.append(symbols.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr+"@gmail.com";

    }
    public static String getRandomName() {
        String symbols = "АБВГДЕЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * symbols.length());
            salt.append(symbols.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

}
