package manipulaArq;

import java.io.*;
import java.util.ArrayList;

import dominio.Vendedor;

public class ManipuladorBin extends ManipuladorArq {
    public String outputPath;

    public ManipuladorBin(String inputFile, String outputPath) {
        super(inputFile);
        this.outputPath = outputPath;
    }

    public void serealizaBin() {
        try {
            File arq = new File(this.outputPath + "/VendedoresVendas.bin");
            FileOutputStream newArq = new FileOutputStream(arq);
            ObjectOutputStream obj = new ObjectOutputStream(newArq);
            obj.writeObject(this.vendedores);
            obj.close();
            System.out.println("Arquivo gravado com sucesso!");
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }

    public  void desserealizaBin() {
        try {
            File arq = new File(this.outputPath + "/VendedoresVendas.bin");
            if (arq.exists()) {
                FileInputStream inputArq = new FileInputStream(arq);
                ObjectInputStream objArq = new ObjectInputStream(inputArq);
                this.vendedores = (ArrayList<Vendedor>) objArq.readObject();

            } else {
                System.out.println("Arquivo não existe!");
            }
        } catch (IOException | ClassNotFoundException error) {
            System.out.println(error.getMessage());
        }
    }
}
