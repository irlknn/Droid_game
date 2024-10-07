package droids;

import HelperClasses.TextMessages;

public abstract class Droid {
    private final String name;
    private final String droidType;
    private int hp;
    private int damage;
    private int usingAmountOfSA = 3;

    public Droid(String droidType, String name,int hp, int damage){
        this.droidType = droidType;
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public String getDroidType() {return droidType;}

    public String[] getDefaultSkin(){ return new String[]{}; }
    public String[] getDamageSkin(){ return new String[]{}; }
    public String[] getDeathSkin(){ return new String[]{}; }
    public String getSpecialAbilitySkin() { return " "; }

    public void setUsingAmountOfSA(int amount){this.usingAmountOfSA = amount;}
    public int getUsingAmountOfSA(){return usingAmountOfSA;}

    public String getName() {return name;}
    public int getHp(){return hp;}
    public int getDamage(){return this.damage;}

    public void setHp(int hp){this.hp = hp;}
    public void setDamage(int damage){this.damage = damage;}

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void resetDroid(Droid d){}

    public boolean canSummon(){return false;}

    //public Droid summonSpecialDroid(){return null;}

    public int getMaxHp(){return 0;}
    public void specialAbility(Droid droid){}

    @Override
    public String toString() {
        return String.format("Type: " +  TextMessages.BLUE + "%s" + TextMessages.RESET +
                             ", Name:" +  TextMessages.YELLOW + "%s" + TextMessages.RESET +
                             ", Health:"+ TextMessages.RED + " %d" + TextMessages.RESET +
                             ", Damage:" + TextMessages.CYAN + " %d" + TextMessages.RESET +
                             ", Usage of SA:" +  TextMessages.PURPLE + "%d" + TextMessages.RESET,
                droidType, name, hp, damage, usingAmountOfSA);
    }
}
