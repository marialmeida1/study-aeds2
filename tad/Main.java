class Main {


    public static int menu() {
        int opc;
        System.out.println("=========================");
        System.out.println("           MENU");
        System.out.println("=========================");
        System.out.println(" 1 - Inserir");
        System.out.println(" 2 - Remover");
        System.out.println(" 3 - Mostrar");
        System.out.println(" 0 - Sair");
        System.out.println("=========================");
        opc = MyIO.readInt();
        System.out.println("=========================");
        return opc;
    }

    public static void main(String[] args) throws Exception {


       int opc = menu();

        do {
            
            switch (opc) {
                case 1:
                    System.out.println("=========================");
                    System.out.println("         MANEIRAS");
                    System.out.println("=========================");
                    System.out.println(" 1 - Inserir");
                    System.out.println(" 2 - Remover");
                    System.out.println(" 3 - Mostrar");
                    System.out.println(" 0 - Sair");
                    System.out.println("=========================");
                    break;
            
                default:
                    break;
            }

        }while(opc != 0 && (opc <= 3 || opc >= 1));

       System.out.println("========== LISTA =============");
       List list = new List();
       int x1, x2, x3;
 
       list.insertStart(1);
       list.insertStart(7);
       list.insertEnd(2);
       list.insertEnd(3);
       list.insert(4, 3);
       list.insert(5, 2);

       // 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
       // 7 | 1 | 5 | 2 | 4 | 3 | 0 | 0 | 0 | 0 |
 
       System.out.print("Inserções: ");
       list.show();

       // 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
       // 7 | 1 | 5 | 2 | 4 | 3 | 0 | 0 | 0 | 0 |
       // 1 | 5 | 2 | 4 | 3 | 0 | 0 | 0 | 0 | 0 |
       // 1 | 5 | 4 | 3 | 0 | 0 | 0 | 0 | 0 | 0 |
 
       x1 = list.removeStart();
       x2 = list.removeEnd();
       x3 = list.remove(2);
 
       System.out.println("Objetos Removidos: (" + x1 + ", " + x2 + ", " + x3 + "):");
       System.out.print("Remoções: ");
       list.show();
    }
 }