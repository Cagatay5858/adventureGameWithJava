import java.util.Scanner;

public class ToolStore extends NormalLoc {

    ToolStore(Player player) {
        super(player, "Mağaza");
    }

    public boolean getLocation(){
        System.out.println("Para : "+player.getMoney());
        System.out.println("1. Silahlar");
        System.out.println("2. Zırhlar");
        System.out.println("3. Çıkış");
        System.out.println("Seçiminiz : ");
        int setTool = scan.nextInt();
        int selItemId;
        switch (setTool){
            case 1:
                selItemId=weaponMenu();
                buyWeapon(selItemId);
                break;
            case 2:
                selItemId = armorMenu();
                buyArmor(selItemId);
                break;
            default:
                break;
        }
        return true;
    }
    public int weaponMenu(){
        System.out.println("1. Tabanca <Para : 25 - Hasar : 2>");
        System.out.println("2. Kılıç <Para : 35 - Hasar : 3>");
        System.out.println("3. Tüfek <Para : 45 - Hasar : 7>");
        System.out.println("4. Çıkış");
        System.out.println("Silah Seçiniz : ");
        int selweaponId = scan.nextInt();
        return selweaponId;
    }

    public void buyWeapon(int itemId){
        int damage=0,price=0;
        String weaponName=null;
        switch (itemId){
            case 1 :
                damage = 2;
                price = 25;
                weaponName = "Tabanca";
                break;
            case 2:
                damage = 3;
                price = 35;
                weaponName = "Kılıç";
                break;
            case 3:
                damage = 7;
                price = 45;
                weaponName= "Tüfek";
                break;
            case 4:
                System.out.println("Çıkış yapılıyor.");
                break;
            default:
                System.out.println("Geçersiz işlem");
                break;
        }
        if(price >0){
            if(player.getMoney() >= price) {
                player.getInv().setDamage(damage);
                player.getInv().setwName(weaponName);
                player.setMoney(player.getMoney() - price);
                System.out.println(weaponName+" satın aldınız, Önceki hasar : "+player.getDamage() + " Yeni hasar : "+player.getTotalDamage());
                System.out.println("Kalan para : "+player.getMoney());
            }else{
                System.out.println("Bakiye yetersiz");
            }
        }

    }

    public void buyArmor(int itemId){

        int avoid=0,price=0;
        String aName=null;
        switch (itemId){
            case 1 :
                avoid = 1;
                price = 15;
                aName = "Hafif Zırh";
                break;
            case 2:
                avoid = 3;
                price = 35;
                aName = "Orta Zırh";
                break;
            case 3:
                avoid = 5;
                price = 45;
                aName= "Ağır Zırh";
                break;
            case 4:
                System.out.println("Çıkış yapılıyor.");
                break;
            default:
                System.out.println("Geçersiz işlem");
                break;
        }
        if(price >0){
            if(player.getMoney() >= price) {
                player.getInv().setArmor(avoid);
                player.getInv().setaName(aName);
                player.setMoney(player.getMoney() - price);
                System.out.println(aName+" satın aldınız, Engellenen Hasar : "+player.getInv().getArmor());
                System.out.println("Kalan para : "+player.getMoney());
            }else{
                System.out.println("Bakiye yetersiz");
            }
        }

    }
    public int armorMenu(){
        System.out.println("1. Hafif Zırh \t  <Para : 15 - Hasar Engelleme : 1>");
        System.out.println("2. Orta Zırh \t <Para : 35 - Hasar Engelleme : 3>");
        System.out.println("3. Ağır Zırh \t <Para : 45 - Hasar Engelleme : 5>");
        System.out.println("4. Çıkış");
        System.out.println("Zırh Seçiniz : ");
        int selarmorId = scan.nextInt();
        return selarmorId;
    }
}
