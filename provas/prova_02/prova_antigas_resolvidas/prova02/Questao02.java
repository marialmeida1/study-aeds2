class No {
    public String palavra;
    public No esq, dir;

    public No(String palavra){
        this.palavra = palavra;
        this.esq = null;
        this.dir = null;
    }
}

class NoPrincipal {
    public char letra;
    public No raiz;
    public NoPrincipal esq, dir;

    public NoPrincipal(char letra) {
        this.letra = letra;
        this.esq = null;
        this.dir = null;
        this.raiz = null;
    }
}

class Arvore {
    public NoPrincipal raiz;

    public int contarPalavras(String palavra) {

        char busca = palavra.charAt(0); // Procura a letra a ser encontrada
        int tamanho = palavra.length(); // Tamanho da string e valor a procurado

        NoPrincipal no_busca = pesquisa(busca);
        return caminhamentoContador(no_busca.raiz, tamanho);
    }

    // Faz uma pesquisa na árvore principal
    public NoPrincipal pesquisa(char letra){
        return pesquisa(this.raiz, letra);
    }

    // Método recursivo que encontra qual No possui a letra que está sendo buscada
    private NoPrincipal pesquisa(NoPrincipal no, char letra){
        NoPrincipal resp = null;
        if(no == null){
            resp = null;
        } else if(no.letra < letra){
            no = pesquisa(no.esq, letra);
        } else if(no.letra > letra){
            no = pesquisa(no.dir, letra);
        } else {
            resp = no;
        }
        return resp;
    }

    private int caminhamentoContador(No no, int tamanho){
        int resp = 0;
        if(no != null){

            if(no.palavra.length() == tamanho){
                resp++;
            }
            resp = caminhamentoContador(no.esq, tamanho) + caminhamentoContador(no.dir, tamanho);
        }   
        return resp;
    }
}