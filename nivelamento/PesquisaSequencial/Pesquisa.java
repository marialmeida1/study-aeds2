import java.util.Random;

class Pesquisa {

   public boolean sequencial(int array[], int x){

      for(int i=0; i<array.length; i++){
         if(array[i] == x){
            return true;
         }
      }

      return false;
   }

   public void print_array(int array[]){
      for (int i = 0; i < array.length; i++) {
         MyIO.println(i + "º: " + array[i]);
      }
   }

   public static void main(String[] args) {
      
      Pesquisa pesquisa = new Pesquisa();


      int[] array = new int[10];
      Random random = new Random();
      for (int i = 0; i < array.length; i++) {
         array[i] = random.nextInt(100);
      }
      
      boolean resposta =  pesquisa.sequencial(array, 10);
      pesquisa.print_array(array);
      MyIO.println("A reposta e " + resposta);
   }
}