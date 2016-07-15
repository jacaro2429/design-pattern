package proxy.dynamic1;

public class TestMain {

    public static void main(String[] args) {

        personTest();

        System.out.println();
        System.out.println("-----------------");
        System.out.println();

        loverTest();

    }

    static void personTest() {
        Person p = new Person();

        MethodProxy proxy = new MethodProxy(p, "sayHello");
        proxy.doPersonMethod();

        proxy.rebindMethod("love", "tom", "marry");
        proxy.doPersonMethod();
    }

    static void loverTest() {
        Lover boy = new Lover("jason", 16);
        Lover girl = new Lover("caroline", 14);

        LoverManager loverManager = new LoverManager();
        loverManager.beAbleToLove(boy, girl);

        MethodProxy proxy = new MethodProxy(loverManager, "beAbleToLove", boy, girl);

        proxy.doLoverMethod();

    }
}
