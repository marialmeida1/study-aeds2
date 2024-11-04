public class Stack {
    private Cel top;

    public Stack() {
        top = null;
    }

    public void insert(int x){
        Cel tmp = new Cel(x); // Cria uma célula temp para setar valores
        tmp.prox = top;
        top = tmp;
        tmp = null; // Esvazia valores temporários
    }

    public int remove() throws Exception{
        if(top == null){
            throw new Exception("Erro ao remover!");
        }

        int aws = top.el;
        Cel tmp = top;
        top = top.prox;
        tmp.prox = null;
        tmp = null;
        return aws;
    }

    public void show() {
        for(Cel i = top; i != null; i = i.prox){
            System.out.println(i.el + " ");
        }
    }

}
