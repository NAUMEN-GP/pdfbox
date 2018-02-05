package org.apache.pdfbox.rendering;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 *
 */
public class GGERenderTest {

    public static void main(String[] args) throws Exception {

        for (int j = 0; j < 1; j++) {

            long begin = System.currentTimeMillis();
            //File f = new File("/Users/akorobejnikov/Projects/gge/els-dev/mroot/conf/ТОМ 3.2.2 (Переустройство 0,4кВ).pdf");
            File f = new File("/Volumes/storage/update_dev/mroot/c3333f5723063361496150359632.pdf");


            PDDocument doc = PDDocument.load(FileUtils.readFileToByteArray(f));

            for (int i = 0; i < doc.getNumberOfPages(); i++) {

                PDFRenderer pdfRenderer = new PDFRenderer(doc);
                pdfRenderer.setMaxSecondsToRender(10);



                BufferedImage bim = pdfRenderer.renderImageWithDPI(i, 72f, ImageType.RGB);
                System.out.println(pdfRenderer.isMaxSecondsToRenderExceed());

                ImageIO.write(bim, "png", new File("/Volumes/storage/gge-files/previewtest/" + i + ".png"));
            }
            System.out.println(System.currentTimeMillis() - begin);
        }
    }

}
