package demo1;

public class XiaomiFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new Xiaomi();
    }
}
