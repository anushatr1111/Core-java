import java.util.*;
public class SearchanElementinaMatrix {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the rows:");
        int rows=sc.nextInt();
        System.out.println("Enter the columns:");
        int cols=sc.nextInt();
        int[][] matrix= new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.println("Enter the element at row "+i+" and column "+j+":");
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter the target number:");
        int target=sc.nextInt();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==target){
                    System.out.println("Found at row "+i+" , Column"+j);
                }
            }
        }sc.close();
    }
}
