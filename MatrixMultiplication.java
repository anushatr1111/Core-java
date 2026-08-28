import java.util.*;
public class MatrixMultiplication {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the rows of first matrix:");
        int rows1=sc.nextInt();
        System.out.println("Enter the cols of first matrix:");
        int cols1=sc.nextInt();
        System.out.println("Enter the rows of second matrix:");
        int rows2=sc.nextInt();
        System.out.println("Enter the cols of second matrix:");
        int cols2=sc.nextInt();
        if(cols1!=rows2){
            System.out.println("Matrix multiplication is not possible");
            return;
        }
        int[][] matrix1=new int[rows1][cols1];
        int[][] matrix2=new int[rows2][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                System.out.println("Enter the element at row " + i + " col " + j + " of first matrix");
                matrix1[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.println("Enter the element at row " + i + " col " + j + " of second matrix");
                matrix2[i][j] = sc.nextInt();
            }
        }
        int[][] result=new int[rows1][cols2];
        for(int i=0;i<rows1;i++){
            for(int j=0;j<cols2;j++){
                for(int k=0;k<cols1;k++){
                    result[i][j]+=matrix1[i][k]*matrix2[k][j];
                }
            }
        }
        System.out.println("Resultant Matrix:");
        for(int i=0;i<rows1;i++){
            for(int j=0;j<cols2;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
