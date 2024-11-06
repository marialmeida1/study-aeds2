import java.util.Scanner;

class Cel {
    public String el;
    public Cel prox;

    public Cel() {
        this("");
    }

    public Cel(String el) {
        this.el = el;
        this.prox = null;
    }
}

class Queue {

    public Cel first;
    public Cel last;

    public Queue() {
        first = new Cel("");
        last = first;
    }

    public void enqueue(String el) {
        last.prox = new Cel(el);
        last = last.prox;
    }

    public String dequeue() {
        if (first == last) {
            System.out.println("Erro");
        }

        Cel tmp = first;
        first = tmp.prox;
        String resp = first.el;
        tmp.prox = null;
        tmp = null;
        return resp;
    }

    public void show() {
        for (Cel i = first; i != null; i = i.prox) {
            System.out.print(i.el + " ");
        }
    }
}

public class FlyingControl {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String ln = new String();

        // Orientação
        int p = 0;

        // Filas de Orientação
        Queue norte = new Queue();
        Queue sul = new Queue();
        Queue leste = new Queue();
        Queue oeste = new Queue();

        ln = input.nextLine();

        while (!ln.equals("0")) {

            if (ln.equals("-1") || ln.equals("-2") || ln.equals("-3") || ln.equals("-4")) {
                p = Integer.parseInt(ln);
            } else {
                switch (p) {
                    case -1:
                        oeste.enqueue(ln);
                        break;
                    case -2:
                        sul.enqueue(ln);
                        break;
                    case -3:
                        norte.enqueue(ln);
                        break;
                    case -4:
                        leste.enqueue(ln);
                        break;
                    default:
                        System.out.println("Erro!");
                        break;
                }
            }

            ln = input.nextLine();
        }

        // Saiu do loop
        // Agora irá ordenar
        Queue fluxo = new Queue();

        // Ponteiros para seguir
        Cel i_norte = norte.first;
        Cel i_sul = sul.first;
        Cel i_leste = leste.first;
        Cel i_oeste = oeste.first;

        while (i_norte != null || i_sul != null || i_leste != null || i_oeste != null) {
            if (i_oeste != null) {
                fluxo.enqueue(i_oeste.el);
                i_oeste = i_oeste.prox;
            }

            if (i_norte != null) {
                fluxo.enqueue(i_norte.el);
                i_norte = i_norte.prox;
            }

            if (i_sul != null) {
                fluxo.enqueue(i_sul.el);
                i_sul = i_sul.prox;
            }

            if (i_leste != null) {
                fluxo.enqueue(i_leste.el);
                i_leste = i_leste.prox;
            }
        }

        fluxo.show();
    }

}
