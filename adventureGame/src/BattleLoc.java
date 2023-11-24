public abstract class BattleLoc extends Location {
    protected Obstacle obstacle;
    protected String award;
    BattleLoc(Player player,String name,Obstacle obstacle,String award) {
        super(player);
        this.obstacle = obstacle;
        this.name = name;
        this.award=award;
    }

    public boolean getLocation(){
        int obsCount = obstacle.count();
        System.out.println("Şuan buradasınız : "+this.getName());
        System.out.println("Dikkatli ol!! Burada "+ obsCount + " tane "+ obstacle.getName()+" yaşıyor!!");
        System.out.println("<S>avaş veya <K>aç");
        String selCase = scan.next();
        selCase = selCase.toUpperCase();
        if(selCase.equals("S")){
            if(combat(obsCount)){
                System.out.println(this.getName()+" bölgesindeki Tüm düşmanları temizlediniz !");
                if(this.award.equals("Food")&&player.getInv().isFood()==false){
                    System.out.println(this.award+ " Kazandınız !");
                    player.getInv().setFood(true);
                }else if(this.award.equals("Firewood")&&player.getInv().isFirewood()==false){
                    System.out.println(this.award+ " Kazandınız !");
                    player.getInv().setFirewood(true);
                }else if(this.award.equals("Water")&&player.getInv().isWater()==false){
                    System.out.println(this.award+ " Kazandınız !");
                    player.getInv().setWater(true);
                }
                return true;
            }if(player.getHealth()<=0){
                System.out.println("Öldünüz !");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int obsCunt){
        for(int i = 0;i<obsCunt;i++){
            int defObsHealth = obstacle.getmHealth();
            playerStats();
            enemyStats();
            while(player.getHealth()>0&&obstacle.getmHealth()>0){
                System.out.print("<V>ur veya <K>aç : ");
                String selCase = scan.next();
                selCase = selCase.toUpperCase();
                if(selCase.equals("V")){
                    System.out.println("Siz vurdunuz !");
                    obstacle.setmHealth(obstacle.getmHealth()-player.getTotalDamage());
                    afterhit();
                    if(obstacle.getmHealth()>0){
                        System.out.println();
                        System.out.println(obstacle.getName()+" Size vurdu");
                        player.setHealth(player.getHealth()-(obstacle.getDamage()-player.getInv().getArmor()));
                        afterhit();
                    }

                }else{
                    return false;
                }

            }
            if(obstacle.getmHealth() <=0&&player.getHealth() >0){
                System.out.println("Düşmanı yendiniz !!");
                player.setMoney(player.getMoney()+obstacle.getAward());
                System.out.println("Güncel Paranız : "+player.getMoney());
                obstacle.setmHealth(defObsHealth);
            }else{
                return false;
            }
        }
        return true;
    }
    public void playerStats(){
        System.out.println("Oyuncu Değerleri \n-----------------------");
        System.out.println("Can : "+player.getHealth());
        System.out.println("Hasar : "+player.getDamage());
        System.out.println("Para : "+player.getMoney());
        if(player.getInv().getDamage()>0){
            System.out.println("Silah : "+player.getInv().getwName());
        }
        if(player.getInv().getArmor()>0){
            System.out.println("Zırh : "+player.getInv().getaName());
        }
    }
    public void enemyStats(){
        System.out.println("\n"+obstacle.getName() + " Değerleri\n---------------------");
        System.out.println("Can : "+obstacle.getmHealth());
        System.out.println("Hasar : "+obstacle.getDamage());
        System.out.println("Ödül : "+obstacle.getAward());
    }
    public void afterhit(){
        System.out.println("Oyuncu Canı : "+player.getHealth());
        System.out.println(obstacle.getName()+ " Canı : "+obstacle.getmHealth());
        System.out.println();
    }

}
