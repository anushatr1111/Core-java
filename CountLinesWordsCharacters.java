import java.io.*;
public class CountLinesWordsCharacters{
    public static void main(String[] args){
        try{
            BufferedReader reader =new BufferedReader(new FileReader("notes.txt"));
            String line;
            int line_count=0;
            int word_count=0;
            int char_count=0;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                line_count++;
                String[] words=line.split(" ");
                word_count+=words.length;
                char_count+=line.length();
            }

            reader.close();
            System.out.println("Line count: " + line_count);
            System.out.println("Word count: " + word_count);
            System.out.println("Character count: " + char_count);
        }catch(IOException e){
            System.out.println("error :"+e);
            e.printStackTrace();
                
        }
    }
}