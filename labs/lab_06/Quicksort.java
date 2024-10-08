import java.util.Random;

public class Quicksort {

    /* Propriedades das Classes */
    public int array[];

    // Construtor
    public Quicksort(int[] array) {
        this.array = array;
    }

    /* Auxiliar - Troca */
    public void swap(int i, int j) {
        int aux = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = aux;
    }

    /* Seleção do Tipo de Pivô */
    public int TypeQuickSort(int option, int left, int right) {
        int pivot = 0;
        switch (option) {
            case 1:
                pivot = QuicksortFirstPivot(left);
                break;
            case 2:
                pivot = QuicksortLastPivot(right);
                break;
            case 3:
                pivot = QuicksortRandom(left, right);
                break;
            case 4:
                pivot = QuicksortMedianOfThree(left, right);
                break;
            default:
                break;
        }
        return pivot;
    }

    /* Quicksort Genérico */
    public void QuicksortAlgorithm(int left, int right, int opc) {
        int i = left, j = right;
        // Escolhe o pivo toda vez que inicia o Quicksort
        int pivot = TypeQuickSort(opc, left, right);

        while (i <= j) {
            while (this.array[i] < pivot) {
                i++;
            }
            while (this.array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        if (left < j) {
            QuicksortAlgorithm(left, j, opc);
        }
        if (i < right) {
            QuicksortAlgorithm(i, right, opc);
        }
    }

    /* Primeiro elemento */
    public int QuicksortFirstPivot(int left) {
        return this.array[left];
    }

    /* Último elemento */
    public int QuicksortLastPivot(int right) {
        return this.array[right];
    }

    public int QuicksortRandom(int left, int right) {
        Random random = new Random(System.currentTimeMillis());
        int pivotIndex = random.nextInt(right - left + 1) + left; // Gera um índice entre left e right
        return this.array[pivotIndex]; // Retorna o valor do pivô
    }

    /* MedianOfThree */
    public int QuicksortMedianOfThree(int left, int right) {
        int median[] = new int[3];
        median[0] = this.array[(left + right) / 2];
        median[1] = this.array[left];
        median[2] = this.array[right];

        int pivot = median[0];
        if ((median[1] < median[0]) && (median[1] > median[2]) || (median[1] > median[0]) && (median[1] < median[2])) {
            pivot = median[1];
        } else if ((median[2] < median[0]) && (median[2] > median[1])
                || (median[2] > median[0]) && (median[2] < median[1])) {
            pivot = median[2];
        }

        return pivot;
    }

    // Aleatório
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }
        
        return array;
    }

    // Ordenado
    public static int[] generateOrderedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    // Quase ordenado
    public static int[] generateNearlySortedArray(int size) {
        int[] array = generateOrderedArray(size);
        Random rand = new Random();
        
        int shuffleCount = size / 10;
        for (int i = 0; i < shuffleCount; i++) {
            int index1 = rand.nextInt(size);
            int index2 = rand.nextInt(size);
            
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
        return array;
    }

    public static void runTests(Quicksort qs, int[] array) {
        for (int i = 1; i <= 4; i++) {
            long startTime = System.nanoTime();
            qs.QuicksortAlgorithm(0, array.length - 1, i);
            long endTime = System.nanoTime();
            
            long duration = endTime - startTime;
            System.out.println("Opção: " + i + " | Tempo: " + duration + " nanoseconds");
        }
    }

    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 10000};
        
        // Testando de acordo com os tamanho
        for (int size : sizes) {
            int[] arrayRandom = generateRandomArray(size);       // Aleatório
            int[] arraySorted = generateOrderedArray(size);       // Ordenado
            int[] arrayNearlySorted = generateNearlySortedArray(size);  // Quase ordenado
            
            Quicksort qsRandom = new Quicksort(arrayRandom);
            Quicksort qsSorted = new Quicksort(arraySorted);
            Quicksort qsNearlySorted = new Quicksort(arrayNearlySorted);

            System.out.println("Tamanho: " + size);
            
            // Testa as 4 opções 
            // Random
            System.out.println("Random array:");
            runTests(qsRandom, arrayRandom);
            
            // Ordenado
            System.out.println("Sorted array:");
            runTests(qsSorted, arraySorted);

            // Parcialmente ordenado
            System.out.println("Nearly Sorted array:");
            runTests(qsNearlySorted, arrayNearlySorted);
        }
    }
}