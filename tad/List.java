public class List {

    private int array[];
    private int n;

    public List() {
        array = new int[10];
    }

    public List(int x) {
        array = new int[x];
    }

    // Mostra a lista
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.println(array[i] + " | ");
        }
        System.out.println("");
    }

    // Insere em uma posição da lista
    public void insert(int el, int p) throws Exception {
        if(n >= array.length || p < 0 || p > n){
            throw new Exception("Error");
        }

        for (int i = n; i > p; i--) {
            array[i] = array[i - 1];
        }

        array[p] = el;
        n++;
    }

    // Insere no início
    public void insertStart(int el) throws Exception {
        if(n >= array.length){
            throw new Exception("Error");
        }

        for (int i = n; i > 0; i--) {
            array[i] = array[i-1];
        }

        array[0] = el;
        n++;
    }

    // Insere no fim do array
    public void insertEnd(int el) throws Exception {
        if(n >= array.length){
            throw new Exception("Error");
        }

        array[n] = el;
        n++;
    }
    
    // Remove em qualquer posição
    public int remove(int p) throws Exception {
        if(n == 0 || p < 0 || p > n) {
            throw new Exception("Error");
        }

        int resp = array[p];
        n--;

        for (int i = p; i < n; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    // Remove no início
    public int removeStart() throws Exception {
        if(n == 0) {
            throw new Exception("Error");
        }
        
        int resp = array[0];
        n--;

        for (int i = 0; i < n; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    // Remove no fim
    public int removeEnd() throws Exception {
        if(n == 0){
            throw new Exception("Error");
        }

        return array[--n];
    }
}
