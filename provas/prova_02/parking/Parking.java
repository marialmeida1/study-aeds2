import java.util.Scanner;

class Cel {
    int el;
    Cel prox;

    public Cel() {
        this(0);
    }

    public Cel(int el) {
        this.el = el;
        this.prox = null;
    }
}

class Stack {
    Cel top;

    public Stack() {
        top = null;
    }

    // Inserção
    public void insert(int x) {
        Cel tmp = new Cel(x);
        tmp.prox = top;
        top = tmp;
        tmp = null;
    }

    // Remoção
    public int remove() {
        if (top == null) {
            System.out.println("Error");
        }

        int resp = top.el;
        Cel tmp = top;
        top = top.prox;
        tmp.prox = null;
        tmp = null;

        return resp;
    }

    public void show() {
        for (Cel i = top; i != null; i = i.prox) {
            System.out.println(i.el + " ");
        }
    }

    public void clear() {
        top = null;
    }
    
}

public class Parking {

    public static int getBigger(int array[]) {
        int bigger = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > bigger) {
                bigger = array[i];
            }
        }
        return bigger;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Stack cars = new Stack();

        int pos = 0;
        int n = -1;
        int k = -1;
        boolean resp = true;

        do {

            n = input.nextInt();
            k = input.nextInt();
            int start[] = new int[n];
            int end[] = new int[n];


            // Vai repetir de acordo com o n
            for (int i = 0; i < n; i++) {
                // Vai pegar os valores
                start[i] = input.nextInt();
                end[i] = input.nextInt();
            }

            // Vai pegar o maior valor
            // Irá fazer um for que realizará validações
            int bigger = getBigger(start);
            for (int i = 0; i <= bigger; i++) {

                // Inserção
                for (int j = 0; j < start.length; j++) {
                    if (pos <= k) {
                        if (i == start[j]) {
                            cars.insert(end[j]);
                            pos++;
                        }
                    } else {
                        resp = false;
                        break;
                    }
                }

                // Remoção
                for (int j = 0; j < end.length; j++) {
                    if(i == end[j]){
                        if(i == cars.top.el){
                            cars.remove();
                            pos--;
                        } else {
                            resp = false;
                            break;
                        }
                    }
                }
            }

            if(resp){
                System.out.println("Sim");
            } else {
                System.out.println("Não");
            }

            cars.clear();
        } while (n != 0 && k != 0);


    }
}
