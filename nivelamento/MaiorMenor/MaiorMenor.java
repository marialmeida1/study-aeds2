import java.util.Random;

public class MaiorMenor {

    public int maior(int array[]){
        int maior = array[0];

        for(int i=0; i<array.length; i++){
            if(maior < array[i]){
                maior = array[i];
            }
        }

        return maior;
    }

    public int menor(int array[]){
        int menor = array[0];

        for(int i=0; i<array.length; i++){
            if(menor > array[i]){
                menor = array[i];
            }
        }

        return menor;
    }

    public static void main(String[] args) {

        MaiorMenor pesquisa = new MaiorMenor();

        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        int maior_num = pesquisa.maior(array);
        int menor_num = pesquisa.menor(array);
        System.out.println("Maior numero: " + maior_num);
        System.out.println("Menor numero: " + menor_num);
    }
}
