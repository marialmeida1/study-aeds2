import java.util.Scanner;

public class lab_0202 {


    public void espelho(int num1, int num2) {

        String str = "";

        for(int i = num1; i <= num2; i++){
            str += i;
        }

        StringBuilder sb = new StringBuilder(str);
        String inverse = sb.reverse().toString();

        System.out.print(str);
        System.out.print(inverse);
        
        System.out.println();
    }

    public static void main(String[] args) {

        lab_0202 lab = new lab_0202();

        int i = 0;
        int temp = 0;
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String num = sc.next();

            int n1 = Integer.parseInt(num);

            if (i % 2 == 0) {
                temp = sc.nextInt();
                i++;
            } 
            
            if (i % 2 != 0)  {
                lab.espelho(n1, temp);
                i++;
            }
        }
        sc.close();
    }
}