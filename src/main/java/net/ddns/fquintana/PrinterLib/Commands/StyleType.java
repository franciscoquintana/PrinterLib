package net.ddns.fquintana.PrinterLib.Commands;

public enum StyleType {
    FONT_A(0x00), FONT_B(0x01), EMPHASIZED(0x08), DOUBLE_HEIGHT(0x10), DOUBLE_WIDTH(0x20), UNDERLINE(0x80);

    private int bvalue;
    StyleType(int b) {
        bvalue = b;
    }

    public int getValue() {
        return bvalue;
    }
}
