import java.util.Random;

public class Obstacle {
    private String name;
    private int damage;
    private int award;
    private int mHealth;
    private int maxNumber;
    Obstacle(String name,int damage,int mHealth,int award,int maxNumber){
        this.name=name;
        this.damage=damage;
        this.award=award;
        this.mHealth=mHealth;
        this.maxNumber=maxNumber;
    }
    public int count(){
        Random r = new Random();
        return r.nextInt(this.maxNumber)+1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getmHealth() {
        return mHealth;
    }

    public void setmHealth(int mHealth) {
        this.mHealth = mHealth;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
}
