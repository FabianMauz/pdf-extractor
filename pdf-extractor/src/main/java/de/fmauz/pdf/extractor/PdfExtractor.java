/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package de.fmauz.pdf.extractor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;
import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;

/**
 *
 * @author fmauz
 */
public class PdfExtractor {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            File initialFile = new File(args[0]);
            InputStream inputStream = new FileInputStream(initialFile);

            Pattern lineEndPattern = Pattern.compile("[-\\s]$");
            Tika tika = new Tika();

            BufferedReader rd = new BufferedReader(tika.parse(inputStream, new Metadata()));
            String line = rd.readLine();
            while (line != null) {
                line = lineEndPattern.matcher(line).matches() ? line : line + " ";
                line = rd.readLine();
                if (line != null && !line.endsWith(" ")) {
                    line += " ";
                }
                stringBuilder.append(line);
            }

            String outputFileName = initialFile.getName().split("\\.")[0] + ".txt";

            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outputFileName, true), "UTF-8"));
            pw.write(stringBuilder.toString());

            pw.close();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println(ste.toString());
            }

        }

    }

    public static void checkParameter(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter as argument the filename which must be in the same folder.");
        }
    }
}
