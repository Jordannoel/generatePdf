import com.itextpdf.text.Document;
import org.apache.commons.cli.CommandLine;

import java.util.List;

public class GenererFiches {

    public static void main(String args[]) {

//        CommandLine commandLine = CommandLineUtils.;
        String fileName = "";
//        fileName = commandLine.getOptionValue("i");
        List<Produit> produits = CsvOperations.getProduits(fileName == "" ? "donnees.csv" : fileName);
        for (Produit produit : produits) {
            Document documentFiche = new Document();
            Document documentProduit = new Document();

            FicheProduit ficheProduit = new FicheProduit(documentFiche, produit, "Fiche " + produit.getNom() + ".pdf");
            ficheProduit.generer();

            Planche planche = new Planche(documentProduit, produit, "Planche " + produit.getNom() + ".pdf");
            try {
                planche.generer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
