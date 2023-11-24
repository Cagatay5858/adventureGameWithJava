public class SafeHouse extends NormalLoc {
    SafeHouse(Player player) {
        super(player, "Güvenli ev");
    }

    public boolean getLocation(){
        player.setHealth(player.getrHealth());
        System.out.println("Sağlığınız yenilendi!!");
        System.out.println("Şu an güvenli ev adlı yerdesiniz.");
        return true;
    }
}
