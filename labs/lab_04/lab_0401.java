public class lab_0401 {


    // Por natureza do código seleção ele realiza O(n²) -> pior caso
    // Visto que seu ∑ (n - 1 - i)   | for externo: determina o limite de execução
    //               0<=i<=n-2       | for interno: quantas operações será realizada
    // Encontrando o fórmula fechada temos: n² - n  -> deixamos somente o de maior grau
    //                                      n    2  
    // Ficando assim com O(n²)

    // Dentro do seleção temos dois "if's" que fazem variar o resultado conforme a entrada
    // Entretando, de todo modo, eles não alteram a quantidade de iteração dos loops
    // Sendo "irrelevantes" para a equação final
    // O método de Seleção se trata de uma função quadrática de O(n²)
    public static void selection(int array[], int mod) {
        for (int i = 0; i < (array.length - 1); i++) {
            int smaller = i;
            for (int j = (i + 1); j < array.length; j++) {
                if ((array[smaller] % mod >= array[j] % mod)) {
                    smaller = j;
                }
            }

            if (smaller != i) {
                swap(i, smaller, array);
            }
        }
    }

    // A ordenação de maior grau é a do loop
    // Sendo uma iteração de (n - 1), em modos gerais, o loop realiza uma operação de custo O(n)
    // Dentro de cada loop temos um aumento de custo, pricipalmente quando a condição verdadeira
    // Entretando, para grandes entradas, tal custo será "irrelevante"
    // O método de ordenação se caracteriza como um função linear de O(n)
    public static int[] ordenation(int array[], int mod) {

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] % mod == array[i + 1] % mod) {
                if (array[i] % 2 == 0 && array[i + 1] % 2 != 0) {
                    swap(i, i + 1, array);
                } else if (array[i] % 2 != 0 && array[i + 1] % 2 != 0) {
                    if (array[i] < array[i + 1]) {
                        swap(i, i + 1, array);
                    }
                } else if (array[i] % 2 == 0 && array[i + 1] % 2 == 0) {
                    if (array[i] > array[i + 1]) {
                        swap(i, i + 1, array);
                    }
                }
            }
        }
        return array;
    }

    // Swap se trata de uma função constante
    // Ela realiza basicamente três operações, tendo um custo de f(n) = 3
    // Não possuindo melhor ou pior caso, sua ordem de complexidade é O(1)
    public static void swap(int i, int j, int array[]) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // No main temos algumas chamadas básicas e uma loop
    // O loop domina a ordem de complexidade
    // Tornando o método main uma função linear de f(n) = n
    // Sua ordem de complexidade sempre será de O(n)
    public static void main(String[] args) {

        while (true) {
            int n = 0, m = 0;
            n = MyIO.readInt();
            m = MyIO.readInt();

            if (n == 0 && m == 0) {
                MyIO.println(n + " " + m);
                break;
            }

            int array[] = new int[n];

            for (int i = 0; i < array.length; i++) {
                array[i] = MyIO.readInt();
            }

            if (n == 1) {
                MyIO.println(array[0]);
            } else {
                selection(array, m);
                array = ordenation(array, m);

                MyIO.println(n + " " + m);
                for (int j = 0; j < array.length; j++) {
                    MyIO.println(array[j]);
                }
            }

            // Ou seja, temos no código as seguintes ordens
            // Seleção: O(n²)
            // Ordenação: O(n)
            // Swap: O(1)
            // Main: O(n)

            // Realizando a soma temos: f(n) = n² + n + n + 1  
            // Algebrismo: f(n) = n² + 2n + 1
            // O termo de maior grau sempre será O(n²)
            // Portanto ordem de complexidade será O(n²)
        }
    }

}
