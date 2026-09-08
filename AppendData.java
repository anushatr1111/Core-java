import java.io.*;

public class AppendData {
    public static void main(String[] args) {
        File file = new File("employees.txt");
        try {
            // Step 1: Initially write initial employee data
            FileWriter writer = new FileWriter(file, false);
            writer.write("101 - Aparajitha - 45000\n");
            writer.write("102 - Priya - 50000\n");
            writer.close();
            System.out.println("Initial employee data written successfully to employees.txt.");

            // Step 2: Append new employee record using FileWriter with append flag set to true
            FileWriter appendWriter = new FileWriter("employees.txt", true);
            appendWriter.write("103 - Rahul - 35000\n");
            appendWriter.close();
            System.out.println("New employee data appended successfully using FileWriter(filename, true).\n");

            // Step 3: Read and verify the final file content
            System.out.println("Final file content:");
            BufferedReader reader = new BufferedReader(new FileReader("employees.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("error :" + e);
            e.printStackTrace();
        }
    }
}
