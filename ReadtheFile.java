import java.io.*;
public class ReadtheFile{
    public static void main(String[] args){
        try{
            BufferedReader reader =new BufferedReader(new FileReader("student.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        reader.close();
        }catch(IOException e){
            System.out.println("error :"+e);
            e.printStackTrace();
                
        }
    }
}