package manipulaArq;

import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;

import dominio.*;

public class ManipuladorJSON extends ManipuladorArq {
    public String outputPath;
    public String fileName;

    public ManipuladorJSON(String inputFile, String outputPath, String fileName) {
        super(inputFile);
        this.outputPath = outputPath;
        this.fileName = fileName;
    }

    public void toJSON(ArrayList<Vendedor> vendedorList) {
        try {

            Gson gson = new Gson();
            String json;
            if (this.vendedores.isEmpty() && !vendedorList.isEmpty()) {
                json = gson.toJson(vendedorList);
            } else {
                json = gson.toJson(this.vendedores);
            }
            File file = new File(this.outputPath + "/" + this.fileName);
            FileWriter writer = new FileWriter(file);
            writer.write(json);
            System.out.println("JSON criado com sucesso! Ele está no diretório: " + file.getCanonicalPath());
            writer.close();

        } catch (IOException err) {
            System.out.println("Error to JSON: " + err.getMessage());
        }
    }
}
