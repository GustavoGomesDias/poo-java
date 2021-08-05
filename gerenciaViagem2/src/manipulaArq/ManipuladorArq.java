package manipulaArq;

import java.io.*;

public class ManipuladorArq {
    public String inputFile;
    public String outputFile;
    public String path;

    public ManipuladorArq(String inputFile, String outputFile) {
        this.path = System.getProperty("user.dir");
        this.inputFile = inputFile + ".txt";
        this.outputFile = outputFile + ".txt";
    }

    public void leitor() {
        try {
            if (!this.fileExists("input")) {
                System.out.println("Arquivo de entrada não existente!");
                return;
            }
            String linha = "";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.path + "/input/" + this.inputFile));
            linha = bufferedReader.readLine();
            while(linha != null) {
                System.out.println(linha.getClass().getSimpleName() + ": " + linha);
                linha = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch(IOException error) {
            System.out.println("Error message: " + error.getMessage());
        }
    }

    public boolean fileExists(String option) throws IOException {
        File file = new File(this.path + "/" + option +"/" + this.inputFile);
        return file.exists();
    }
}
