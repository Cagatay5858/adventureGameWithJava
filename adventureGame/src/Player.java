import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String cName;
    private int rHealth;
    private Inventory inv;
    Scanner scanner = new Scanner(System.in);
    public Player(String name){
        this.name = name;
        this.inv = new Inventory();
    }
    public void selectCha(){
        switch (chaMenu()){
            //samuray seçildi
            case 1 :
                initPlayer("Samuray",5,21,15);
                break;
            case 2:
                initPlayer("Okçu",7,18,20);
                break;
            case 3:
                initPlayer("Şövalye",8,24,5);
                break;
            default:
                initPlayer("Samuray",5,21,15);
                break;
        }
        System.out.println("Karakter : " + getcName() + "\t Hasar : "+getDamage()+"\t Sağlık : "+getHealth()+"\t Para : "+getMoney());
    }
    public int chaMenu(){
        System.out.println("Lütfen karakter seçiniz : ");
        System.out.println("1- Samuray \t Hasar : 5 \t Sağlık : 21 \t Para : 15");
        System.out.println("2- Okçu \t Hasar : 7 \t Sağlık : 18 \t Para : 20");
        System.out.println("3- Şövalye \t Hasar : 8 \t Sağlık : 24 \t Para : 5");
        System.out.println("Karakter Seçiminiz : ");
        int chaId = scanner.nextInt();

        while(chaId < 1 || chaId > 3){
            System.out.println("Lütfen geçerli bir karakter seçiniz : ");
            chaId = scanner.nextInt();
        }

        return chaId;
    }
    public int getTotalDamage(){
        return this.getDamage() + this.getInv().getDamage();
    }
    public void initPlayer(String cName , int dmg, int hlt, int mny){
        setcName(cName);
        setDamage(dmg);
        setHealth(hlt);
        setMoney(mny);
        setrHealth(hlt);

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getrHealth() {
        return rHealth;
    }

    public void setrHealth(int rHealth) {
        this.rHealth = rHealth;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }
}
