import java.util.Random;

public class aleatorio_0104 {
    

    public static void main(String[] args) {
        Random gerador = new Random();
        gerador.setSeed(4);
        System.out.println((char)('a' + Math.abs(gerador.nextInt()) % 26));
    }
}
