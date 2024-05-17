package de.fmauz.pdf.extractor;

import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 *
 * @author fmauz
 */
public class PdfExtractorTest {

    @Test
    public void testDocumentParse() throws FileNotFoundException {
        File f = new File("src/test/resources/gi-proc-112-022.txt");
        if (f.exists()) {
            f.delete();
        }

        PdfExtractor.main(new String[]{"src/test/resources/gi-proc-112-022.pdf"});
    }
}
