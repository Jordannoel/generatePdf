import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font.FontFamily;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FicheProduit {

    private Document document;
    private Produit produit;
    private String nom;

    public FicheProduit(Document document, Produit produit, String nom) {
        this.document = document;
        this.produit = produit;
        this.nom = nom;
    }

    public void generer() {
        try {

            PdfWriter writer = PdfWriter.getInstance(this.document, new FileOutputStream(this.nom));
            this.document.open();
            PdfContentByte canvas = writer.getDirectContent();

            Font fontCode = new Font(FontFamily.TIMES_ROMAN, 15);
            Phrase Code = new Phrase("Code: " + produit.getCode() + "\n", fontCode);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, Code, 36, 800, 0);

            Font fontCategorie = new Font(FontFamily.TIMES_ROMAN, 19);
            Phrase Categorie = new Phrase("Catégorie : " + produit.getCategorie() + "\n", fontCategorie);
            ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, Categorie, 500, 750, 0);

            Font fontNom = new Font(FontFamily.TIMES_ROMAN, 33, Font.NORMAL);
            Phrase Nom = new Phrase(produit.getNom() + "\n", fontNom);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, Nom, 36, 741, 0);

            Font fontDescriptionLibelle = new Font(FontFamily.TIMES_ROMAN, 14);
            Phrase DescriptionLibelle = new Phrase("Description : ", fontDescriptionLibelle);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, DescriptionLibelle, 36, 715, 0);

            Font fontDescription = new Font(FontFamily.TIMES_ROMAN, 19);
            Phrase Description = new Paragraph(produit.getDescription() + "\n", fontDescription);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, Description, 50, 665, 0);

            Font fontMontantHT = new Font(FontFamily.TIMES_ROMAN, 19, Font.BOLD);
            float montantHT = produit.getPrix();
            Phrase VarMontantHT = new Phrase(montantHT + "€\n", fontMontantHT);
            ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, VarMontantHT, 559, 160, 0);

            Phrase MontantHTLibelle = new Phrase("Montant HT : ", fontMontantHT);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, MontantHTLibelle, 340, 160, 0);

            Font fontTVA = new Font(FontFamily.TIMES_ROMAN, 19, Font.BOLD);
            float montantTVA = produit.getPrix() / 5;
            Phrase TVA = new Phrase(montantTVA + "€\n", fontTVA);
            ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, TVA, 559, 140, 0);

            Phrase TVALibelle = new Phrase("TVA : ", fontTVA);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, TVALibelle, 340, 140, 0);

            Font fontmontantTTC = new Font(FontFamily.TIMES_ROMAN, 19, Font.BOLD);
            float montantTTC = produit.getPrix() + produit.getPrix() / 5;
            Phrase VarmontantTTC = new Phrase(montantTTC + "€", fontmontantTTC);
            ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, VarmontantTTC, 559, 120, 0);

            Phrase VarmontantTTCLibelle = new Phrase("Montant TTC : ", fontmontantTTC);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, VarmontantTTCLibelle, 340, 120, 0);

            Rectangle rect = new Rectangle(36, 200, 559, 700);
            rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(2);
            canvas.rectangle(rect);
            this.document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}