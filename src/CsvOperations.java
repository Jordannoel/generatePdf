import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvOperations {

    public static List<Produit> getProduits(String nomFichier) {
        List<String> lignes = CsvOperations.readFile(nomFichier);
        List<Produit> produits = new ArrayList<>();
        for (String ligne : lignes) {
            String[] ligneCoupee = ligne.split(";");
            String code = ligneCoupee[0];
            String nom = ligneCoupee[1];
            String description = ligneCoupee[2];
            String categorie = ligneCoupee[3];
            float prix;
            if (ligneCoupee[4].matches("[0-9]+(,[0-9]+)")) { //si le prix contient une virgule
                String[] prixString = ligneCoupee[4].split(",");
                prix = Float.parseFloat(prixString[0]) + Float.parseFloat(prixString[1]) / 100;
            } else {
                prix = Float.parseFloat(ligneCoupee[4]);
            }
            produits.add(new Produit(code, nom, description, categorie, prix));
        }
        return produits;
    }

    public static List<String> readFile(String nomFichier) {
        File fichier = new File(nomFichier);
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fichier),"ISO-8859-1"));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
            return lines;
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", nomFichier);
            e.printStackTrace();
            return null;
        }
    }
}
