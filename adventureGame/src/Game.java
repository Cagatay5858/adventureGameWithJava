import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scanner = new Scanner(System.in);
    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Macera Oyununa hoş geldiniz !!");
        System.out.println("Başlamadan önce isminizi giriniz : ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);
        player.selectCha();
        start();
    }

    public void start(){
        while(true){
            System.out.println();
            System.out.println("================================");
            System.out.println();
            System.out.println("Eylem gerçekleştirmek için bir yer seçiniz : ");
            System.out.println("1.Güvenli ev --> Size ait güvenli bir mekan, düşman yok!");
            System.out.println("2.Mağara --> Karşınıza zombi çıkabilir !!");
            System.out.println("3.Orman --> Karşınıza vampir çıkabilir !!");
            System.out.println("4.Nehir --> Karşınıza ayı çıkabilir !!");
            System.out.println("5.Mağaza --> silah veya zırh alabilirsiniz ");
            System.out.print("Gitmek istediğiniz yer : ");
            int selloc = scanner.nextInt();
            while(selloc <0 || selloc >5){
                System.out.print("Geçerli bir yer seçiniz : ");
                selloc = scanner.nextInt();
            }

            switch (selloc){
                case 1:
                    location=new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                default:
                    location=new SafeHouse(player);
                    break;
            }
            if(location.getClass().getName().equals("SafeHouse")){
                if(player.getInv().isFood()&&player.getInv().isFirewood()&&player.getInv().isWater()){
                    System.out.println("Tebrikler Oyunu Kazandınız!!!");
                    break;
                }
            }
            if(!location.getLocation()){
                System.out.println("Oyun bitti");
                break;
            }
        }
    }
}
