package net.ddns.fquintana.PrinterLib.Printers;

import net.ddns.fquintana.PrinterLib.Commands.ICommand;

import javax.print.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class POSPrinter {

    private ArrayList<ICommand> Commands;

    public POSPrinter() {
        Commands = new ArrayList<>();
    }

    public void addCommand(ICommand command) {
        Commands.add(command);
    }

    public byte[] getBytes() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (ICommand command: Commands) {
            outputStream.write(command.getBytes());
        }
        return outputStream.toByteArray();
    }

    public void print() throws IOException, PrintException {
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

        //DEFAULT PRINTER
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();

        DocPrintJob job = service.createPrintJob();

        Doc doc = new SimpleDoc(getBytes(), flavor, null);
        job.print(doc, null);

        Commands.clear();
    }
}
