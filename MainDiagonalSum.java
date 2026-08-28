import java.util.*;
public class MainDiagonalSum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the rows:");
        int rows=sc.nextInt();
        System.out.println("Enter the cols:");
        int cols=sc.nextInt();
        int[][] matrix=new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Enter the element at row " + i + " col " + j);
                matrix[i][j] = sc.nextInt();
            }
        }
        int sum=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==j){
                    sum+=matrix[i][j];
                }
            }
        }
        System.out.println(sum);
        sc.close();
    }
}
