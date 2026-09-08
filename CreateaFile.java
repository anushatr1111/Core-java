import java.io.*;
public class CreateaFile{
    public static void main(String[] args){
        File file= new File("Student.txt");
        try{
            if(file.createNewFile()){
                System.out.println("File created successfully ");
            }else{
                System.out.println("file is already created");
            }
        }catch(IOException e){
            System.out.println("error :"+e);
            e.printStackTrace();
                
        }
    }
}