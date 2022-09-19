import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class DictHasher {


    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        int lines = 0;
        int contador = 0;
        try {
            Path path = Paths.get("C:\\Users\\bs0076\\IdeaProjects\\untitled\\kaonashi14M.txt");
            lines = (int) Files.lines(path).count();


        } catch (IOException f) {
            f.printStackTrace();
        }
        String[] strings = new String[lines];
        try {
            File file = new File("C:\\Users\\bs0076\\IdeaProjects\\untitled\\kaonashi14M.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                strings[contador] = data;
                contador++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("kaonashiHasheado.txt");
            for (String string : strings) {
                myWriter.write(string + ":" + new BigInteger(1, messageDigest.digest(string.getBytes(StandardCharsets.UTF_8))).toString(16) + "\n");
            }


            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

