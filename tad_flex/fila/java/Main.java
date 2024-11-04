public class Main {
    public static void main(String[] args) throws Exception {
       System.out.println("==== FILA FLEXIVEL ====");
       Queue fila = new Queue();
       int x1, x2, x3;
 
       fila.enqueue(5);
       fila.enqueue(7);
       fila.enqueue(8);
       fila.enqueue(9);
 
       System.out.println("Apos insercoes(5, 7, 8, 9): ");
       fila.show();
 
       x1 = fila.dequeue();
       x2 = fila.dequeue();
 
       System.out.println("Apos remocoes (" + x1 + ", " + x2 + "):");
       fila.show();
 
       fila.enqueue(3);
       fila.enqueue(4);
 
 
       System.out.println("Apos insercoes(3, 4): ");
       fila.show();
 
       x1 = fila.dequeue();
       x2 = fila.dequeue();
       x3 = fila.dequeue();
 
       System.out.println("Apos remocoes (" + x1 + ", " + x2 + ", " + x3 + "):");
       fila.show();
 
       fila.enqueue(4);
       fila.enqueue(5);
 
       System.out.println("Apos insercoes(4, 5): ");
       fila.show();
 
       x1 = fila.dequeue();
       x2 = fila.dequeue();
 
       System.out.println("Apos remocoes (" + x1 + ", " + x2 + "):");
       fila.show();
 
       fila.enqueue(6);
       fila.enqueue(7);
 
       System.out.println("Apos insercoes(6, 7): ");
       fila.show();
 
       x1 = fila.dequeue();
 
       System.out.println("Apos remocao (" + x1 + "): ");
       fila.show();
    }
 }