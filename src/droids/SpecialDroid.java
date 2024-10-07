package droids;

import HelperClasses.TextMessages;

public class SpecialDroid extends Droid{

    private final String[] defaultSkin = {
            "                     / \\__",
            " /\\                 (    @\\___",
            "( (                 /         O",
            " \\ \\               /   (_____/",
            " /  \\_____________/_____/",
            " \\   \\  " + TextMessages.BLUEHighIntensity + "PES"
            + TextMessages.YELLOWHighIntensity + " PATRON" + TextMessages.RESET + " /   )",
            " (    \\~~~~~~~~~~~/    )",
            " (   ______________   /",
            " /  /   /  /   /  /\\  |",
            " \\  )_ (  (   (  (  \\ |_",
            "  \\__\") \\__\")  \\__\") \\_\")"};

    public SpecialDroid(String name, int hp, int damage){
        super("Special droid",name, hp, damage);
    }

    @Override
    public String[] getDefaultSkin() {
        return defaultSkin;
    }
}
