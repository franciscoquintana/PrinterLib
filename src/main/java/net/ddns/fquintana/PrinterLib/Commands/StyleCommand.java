package net.ddns.fquintana.PrinterLib.Commands;

import java.util.ArrayList;

public class StyleCommand implements ICommand {
    private final int ESC = 0x1B;
    private final int MODE = '!';

    private ArrayList<StyleType> styleTypes;

    public StyleCommand() {
        styleTypes = new ArrayList<>();
    }

    public StyleCommand(StyleType... types) {
        this();
        for (StyleType type: types) {
            addStyleType(type);
        }
    }

    public void setStyleTypes(ArrayList<StyleType> styleTypes) {
        this.styleTypes = styleTypes;
    }

    public void addStyleType(StyleType styleType) {
        this.styleTypes.add(styleType);
    }

    public void removeStyleType(StyleType styleType) {
        this.styleTypes.remove(styleType);
    }


    public byte[] getBytes() {
        int code = StyleType.FONT_A.getValue();
        if (styleTypes.size() != 0)
            for (int i = 0; i < styleTypes.size(); i++) {
                code += styleTypes.get(i).getValue();
            }
        return new byte[] {ESC, MODE, (byte) code};
    }
}
