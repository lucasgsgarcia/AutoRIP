package util;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class PDFManipulation {

    public static void rotatePDF(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        int n = reader.getNumberOfPages();
        PdfDictionary page;
        PdfNumber rotate;
        for (int p = 1; p <= n; p++) {
            page = reader.getPageN(p);
            rotate = page.getAsNumber(PdfName.ROTATE);
            if (rotate == null) {
                page.put(PdfName.ROTATE, new PdfNumber(90));
            }
            else {
                page.put(PdfName.ROTATE, new PdfNumber((rotate.intValue() + 90) % 360));
            }
        }
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        stamper.close();
        reader.close();
    }
}
