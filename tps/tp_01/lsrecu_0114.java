import java.util.Random;

public class lsrecu_0114 {
    
    public static void main(String[] args) {
        lsrecu_0114 fnc = new lsrecu_0114();

        String str = "";
        while (true) {
            str = MyIO.readLine("");
            if (str.equals("FIM")) {
                break;
            }

            fnc.replace(str);
        }
    }
}
