### **工厂方法模式**

目的：
- 是为了把产品的实例化操作延迟到子类工厂中完成，通过工厂子类来决定究竟应该实例化哪一个产品具体对象。

####工厂方法模式包含**四个部分**:
1、抽象产品
- 产品对象同一的基类，或者是同一接口。

2、具体的产品：
- 各个不同的实例对象类。

3、抽象工厂：
- 所有的子类工厂类的基类，或者同一接口。

4、具体的工厂子类：
- 负责每个不同的产品对象的实际创建。

定义一个接口：
~~~
public interface Phone {
    void play();
}
~~~
然后，将所有手机类都实现Phone接口
~~~
public class Xiaomi implements Phone {
    @Override
    public void play() {
        System.out.println("玩小米手机");
    }
}

public class IPhone implements Phone {
    @Override
    public void play() {
        System.out.println("玩苹果手机");
    }
}
~~~
创建一个手机工厂接口
~~~
public interface PhoneFactory {
    Phone createPhone();
}
~~~
现在我们有两款手机，分别为苹果手机、小米手机，so 我们要创建出两个具体手机工厂 并且实现 工厂接口。
~~~
public class IPhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}

public class XiaomiFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new Xiaomi();
    }
}
~~~
客户端的调用：
~~~
public class Test {
    public static void main(String[] args) {
        
        PhoneFactory iPhoneFactory = new IPhoneFactory();
        iPhoneFactory.createPhone().play();

        PhoneFactory xiaomiFactory = new XiaomiFactory();
        xiaomiFactory.createPhone().play();


    }
}

~~~
工厂方法模式，是最标准的一种工厂模式，也是应用广泛的一种模式。
But 工厂模式有一个很大的缺点：
- 就是，如果增加了一款产品，比如是Lenovo 那么你就需要为lenovo创建一个工厂类。
- 一个具体工厂只能创建一种具体产品。
-  系统类的个数将成对增加，在一定程度上增加了系统的复杂度；同时，有更多的类需要编译和运行，会给系统带来一些额外的开销。

