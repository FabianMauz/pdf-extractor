package de.fmauz.pdf.extractor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author fmauz
 */
public class PdfFolderExtractor {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        String baseFolder = new File(".").getCanonicalPath() + "/";

        File f = new File(baseFolder);
        for (String fileName : f.list()) {
            if (fileName.endsWith("pdf")) {
                PdfExtractor.main(new String[]{baseFolder + fileName});
            }
        }
    }
}
