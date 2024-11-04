public class Queue {


    private Cel first;
    private Cel last;

    public Queue() {
        first = new Cel();
        last = first;   
    }

    // Inserir no fim
    public void enqueue(int x){
        Cel tmp = new Cel(x);
        last.prox = tmp;
        last = tmp;
    }

    // Remover no início | NÓ CABEÇA
    public int dequeue() throws Exception{

        if(first == last){
			throw new Exception("Erro ao remover!");
        }

        Cel tmp = first;
        first = tmp.prox;
        int aws = first.el;
        tmp.prox = null;
        tmp = null;
        return aws;
    }

    public void show() {
        for(Cel i = first.prox; i != null; i = i.prox) {
			System.out.print(i.el + " ");
		}
    }

}
