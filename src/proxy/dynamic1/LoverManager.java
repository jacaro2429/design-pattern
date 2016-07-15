package proxy.dynamic1;

public class LoverManager {

    @Low(boyAge=16, girlAge=14)
    public void  beAbleToLove(Lover boy, Lover girl){
        System.out.println(boy.getName() + " is able to love " + girl.getName());
    }
}
