package main;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import util.DirReader;

import java.io.*;
import java.util.ArrayList;
import org.apache.commons.io.FilenameUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import util.PDFManipulation;

import javax.swing.*;


public class main {
    public static void main(String[] args) throws IOException, DocumentException {


        String dir = "C:\\Users\\IMPRESSÃO\\Desktop\\Jtest\\teste\\";
        File directory = new File("C:\\Users\\IMPRESSÃO\\Desktop\\Jtest");
        String sDir = "C:\\Users\\IMPRESSÃO\\Desktop\\Jtest\\";
        int paperWidth = 110;

        double convert = paperWidth * 3120.6772 / 110;

        FilenameUtils fnu = new FilenameUtils();

        ArrayList<String> files = DirReader.listFilesForFolder(directory);
        if (files.contains("Thumbs.db")){
            files.remove(files.indexOf("Thumbs.db"));
        }

            BufferedWriter writer;
            for(int i=0;i<files.size();i++) {
                System.out.println(sDir + files.get(i));
                PdfReader reader = new PdfReader(sDir + files.get(i));
                Rectangle mediabox = reader.getPageSizeWithRotation(reader.getPageN(1));
                System.out.println(reader.getPageSizeWithRotation(reader.getPageNRelease(1)));
                if (mediabox.getWidth() > convert){
                    System.out.println("A largura do PDF " + files.get(i) + " está maior do que a largura suportada pelo papel da impressora!");
                    writer = new BufferedWriter(new FileWriter(dir + (files.get(i))));
                    System.out.println(fnu.removeExtension(files.get(i)));
                    writer.write("");
                    writer.close();
                }
            }



            // MÉTODO PARA RODAR PDF
            // PDFManipulation.rotatePDF(directory + "\\" + files.get(i), directory + "\\" + "r" + files.get(i));

        System.out.println("Arquivos: " + files);
        System.out.println("Quantidade de arquivos: " + files.size());
    }
}
