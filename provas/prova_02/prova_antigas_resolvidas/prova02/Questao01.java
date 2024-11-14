class Celula {
    public int el;
    public Celula prox;

    public Celula(int el) {
        this.el = el;
        this.prox = null;
    }
}

class CelulaLista {
    public Celula topo;
    public CelulaLista prox;

    public CelulaLista() {
        topo = null;
        prox = null;
    }
}

class Lista {
    public CelulaLista inicio, fim;

    public Lista() {
        inicio = new CelulaLista();
    }

    public CelulaLista maiorPilha() {
        CelulaLista resp = null;
        int maior = 0;
        int cont = 0;

        for(CelulaLista i = inicio; i != null; i = i.pro){


        }

        return resp;
    }
}
