package demo1;

public class Test {
    public static void main(String[] args) {

        PhoneFactory iPhoneFactory = new IPhoneFactory();
        iPhoneFactory.createPhone().play();

        PhoneFactory xiaomiFactory = new XiaomiFactory();
        xiaomiFactory.createPhone().play();


    }
}
