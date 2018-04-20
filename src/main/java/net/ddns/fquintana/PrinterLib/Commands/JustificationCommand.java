package net.ddns.fquintana.PrinterLib.Commands;

public enum JustificationCommand implements ICommand{
    LEFT(0x00), RIGHT(0x02), CENTER(0x01);

    private final int ESC = 0x1B;
    private final int MODE = 'a';

    private final int value;
    JustificationCommand(int value) {
        this.value = value;
    }

    @Override
    public byte[] getBytes() {
        return new byte[] {ESC, MODE, (byte) value};
    }
}
