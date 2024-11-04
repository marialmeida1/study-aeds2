class Cel {
    public int el;
    public Cel prox;

    public Cel(){
        this(0);
    }

    public Cel(int el){
        this.el = el;
        this.prox = null;
    }
}