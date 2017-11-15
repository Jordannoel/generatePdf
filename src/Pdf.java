import com.itextpdf.text.Document;

public abstract class Pdf {

    protected Document document;
    protected Produit produit;
    protected String nom;

    public Pdf(Document document, Produit produit, String nom) {
        this.document = document;
        this.produit = produit;
        this.nom = nom;
    }
}
