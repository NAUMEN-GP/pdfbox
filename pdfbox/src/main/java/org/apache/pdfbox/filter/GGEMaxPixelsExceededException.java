package org.apache.pdfbox.filter;

public class GGEMaxPixelsExceededException extends RuntimeException {

    private final int width;
    private final int heignt;

    public GGEMaxPixelsExceededException(String msg, int width, int heignt) {
        super(msg);
        this.width = width;
        this.heignt = heignt;
    }

    public int getWidth() {
        return width;
    }

    public int getHeignt() {
        return heignt;
    }
}