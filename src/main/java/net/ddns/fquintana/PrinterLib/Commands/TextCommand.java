package net.ddns.fquintana.PrinterLib.Commands;

public class TextCommand implements ICommand {

    private String Text;

    public TextCommand(String text) {
        Text = text;
    }

    @Override
    public byte[] getBytes() {
        return Text.getBytes();
    }
}
