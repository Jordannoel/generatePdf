import com.itextpdf.text.Document;

import java.util.List;

public class GenererFiches {

    public static void main(String args[]) {

        List<Produit> produits = Tools.getProduits("donnees.csv");
        for (Produit produit : produits) {
            Document documentFiche = new Document();
            Document documentProduit = new Document();

            FicheProduit ficheProduit = new FicheProduit(documentFiche, produit, "Fiche " + produit.getNom() + ".pdf");
            ficheProduit.generer();

            Planche planche = new Planche(documentProduit, produit, "Planche " + produit.getNom() + ".pdf");
            planche.generer();
        }
    }
}
