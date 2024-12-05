package droids;

import HelperClasses.TextMessages;

public class Cow extends Droid{
    private final int maxHp = 30;
    private final int maxDamage = 12;
    private final int maxUsageOfSA = 3;
    private final String[] defaultSkin = {"^__^",
                            "(oo)\\________",
                            "(__)\\        )\\/\\",
                            "     ||----w |",
                            "     ||     ||"};

    private final String[] damageSkin = { "^__^",
                                    "(><)\\______",
                                    "(__)\\      )\\/\\__",
                                    "     //--w//",
                                    "    //   //"};

    private final String[] deathSkin = {  "^__^",
                                    "(xx)\\________",
                                    "(__)\\        )\\/\\",
                                    "     ||----w |",
                                    "     ||     ||"};
    private final String specialAbilitySkin = "   H           \n" +
                                              "  [ ]       '  \n" +
                                              "  |-|    *     . \n" +
                                              "  |_|      . .   \n" +
                                              "  | |    .      \n" +
                                              " /   \\     .    \n" +
                                              "|"+ TextMessages.GREEN + "_____" + TextMessages.RESET + "|  '  .   \n" +
                                              "| " + TextMessages.RED + "___" + TextMessages.RESET + " |  \\" + TextMessages.REDHighIntensity + "~~~" + TextMessages.RESET +"/  \n" +
                                              "| " + TextMessages.RED + "\\ /" + TextMessages.RESET + " |   \\_/   \n" +
                                              "| " + TextMessages.RED + "_Y_" + TextMessages.RESET + " |    |    \n" +
                                              "|" + TextMessages.GREEN + "_____" + TextMessages.RESET + "|  __|__  \n" +
                                              "`-----`          \n";

    public Cow(String name){
        super("Cow", name , 30, 12);
    }


    public String[] getDefaultSkin(){return this.defaultSkin;}
    public String[] getDamageSkin(){ return this.damageSkin; }
    public String[] getDeathSkin(){ return this.deathSkin; }
    public String getSpecialAbilitySkin() {return this.specialAbilitySkin;}

    public int getMaxHp(){return maxHp;}

    @Override
    public void resetDroid(){
        setHp(maxHp);
        setDamage(maxDamage);
        setUsingAmountOfSA(maxUsageOfSA);
    }

    @Override
    public void specialAbility() {
        int increasedDamage = getDamage() + 2;
        setDamage(increasedDamage);
        System.out.println("The Cow increased damage");
    }

//    public boolean megaBoosting(){
//        damage += 10;
//        System.out.println("The cow really got stronger");
//        return false;
//    }

}
