public class List {

    private Cel first;
    private Cel last;

    public List() {
        first = new Cel();
        last = first;
    }

    // INSERÇÕES
    // Inserir Início
    public void insertStart(int x) {
        Cel tmp = new Cel(x);
        tmp.prox = first.prox;
        first.prox = tmp;
        if (first == last) {
            last = tmp;
        }
        tmp = null;
    }

    // Inserir Fim
    public void insertEnd(int x) {
        Cel tmp = new Cel(x);
        last.prox = tmp;
        last = tmp;
    }

    // Inserir qualquer posição
    public void insert(int x, int pos) throws Exception {
        int size = size();

        if (pos < 0 || pos > size) {
            throw new Exception("Erro ao inserir posicao (" + pos + " / size = " + size + ") invalida!");
        } else if (pos == 0) {
            insertStart(x);
        } else if (pos == size) {
            insertEnd(x);
        } else {
            Cel i = first;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            Cel tmp = new Cel(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;
        }
    }

    // REMOÇÃO
    // Remoção Início
    public int removeStart() throws Exception {
        if (first == last) {
            throw new Exception("Erro ao remover (vazia)!");
        }

        Cel tmp = first;
        first = first.prox;
        int resp = first.el;
        tmp.prox = null;
        tmp = null;
        return resp;
    }

    // Remoção Final
    public int removeEnd() throws Exception {
        if (first == last) {
            throw new Exception("Erro ao remover (vazio)!");
        }

        Cel i;
        for (i = first; i.prox != last; i = i.prox)
            ;

        int resp = last.el;
        last = i;
        i = last.prox = null;
        return resp;
    }

    // Remoção em qualquer posição
    public int remove(int pos) throws Exception {
        int resp;
        if (first == last) {
            throw new Exception("Erro ao remover (vazio)!");
        }

        int size = size();

        if (pos < 0 || pos > size) {
            throw new Exception("Erro ao inserir posicao (" + pos + " / size = " + size + ") invalida!");
        } else if (pos == 0) {
            resp = removeStart();
        } else if (pos == size) {
            resp = removeEnd();
        } else {

            Cel i = first;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            Cel tmp = i.prox;
            resp = tmp.el;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;
        }
        return resp;
    }

    public void show() {

        for (Cel i = first.prox; i != null; i = i.prox) {
            System.out.print(i.el + " ");
        }
        System.out.println();
    }

    public int size() {
        int size = 0;
        for (Cel i = first; i != last; i = i.prox, size++)
            ;
        return size;
    }
}
