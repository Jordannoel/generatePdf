import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Planche extends Pdf{

    public Planche(Document document, Produit produit, String nom) {
        super(document, produit, nom);
    }

    public void generer() throws IOException, WriterException, DocumentException{
            generateQrCode();
            PdfWriter.getInstance(this.document, new FileOutputStream(this.nom));
            document.open();
            Image img;
            img = Image.getInstance("Qr code " + this.produit.getNom() + ".jpg");
            img.setAbsolutePosition(20f, 10f);
            document.add(img);
            document.close();
    }

    public void generateQrCode() throws IOException, WriterException{
        int size = 80;
        BitMatrix bitMatrix;
        bitMatrix = new QRCodeWriter().encode(this.produit.getCode(), BarcodeFormat.QR_CODE, size, size);
        createImage("Qr code " + produit.getNom() +".jpg", "jpg", bitMatrix);
    }

    public void createImage(String outputFileName, String imageFormat, BitMatrix bitMatrix) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(new File(outputFileName));
        MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, fileOutputStream);
        fileOutputStream.close();
    }
}
