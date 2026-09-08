import java.io.*;
public class WriteStudentDetails{
    public static void main(String[] args){
        File file = new File("Student.txt");
        try{
            FileWriter fileWriter=new FileWriter(file);
            fileWriter.write("Name: Aparajitha\n");
            fileWriter.write("Age: 22\n");
            fileWriter.write("Percentage: 98.5\n");
            fileWriter.close();
            System.out.println("Student details written successfully");
        }catch(IOException e){
            System.out.println("error :"+e);
            e.printStackTrace();
                
        }
    }
}
