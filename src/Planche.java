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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Planche extends Pdf{

    public Planche(Document document, Produit produit, String nom) {
        super(document, produit, nom);
    }

    public void generer() {
        try {
            generateQrCode();
            PdfWriter.getInstance(this.document, new FileOutputStream(this.nom));
            document.open();
            Image img;
            try{
                img = Image.getInstance("Qr code " + this.produit.getNom() + ".jpg");
                img.setAbsolutePosition(20f, 10f);
                document.add(img);
                //here




            } catch (IOException ie){
                ie.printStackTrace();
            }
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void generateQrCode() {
        int size = 400;
        BitMatrix bitMatrix;
        try {
            bitMatrix = new QRCodeWriter().encode(this.produit.getCode(), BarcodeFormat.QR_CODE, size, size);
            createImage("Qr code " + produit.getNom() +".jpg", "jpg", bitMatrix);
        } catch (WriterException we) {
            we.printStackTrace();
        }
    }

    public void createImage(String outputFileName, String imageFormat, BitMatrix bitMatrix) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(outputFileName));
            MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, fileOutputStream);
            fileOutputStream.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
