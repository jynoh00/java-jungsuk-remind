package oop2.remind;

public class PolyParamEx {
    public static void main(String[] args) {
        Buyer b = new  Buyer();

        b.buy(new Tv());
        b.buy(new Computer());
        b.buy(new Audio());

        b.summary();

        System.out.println(b.items[0].toString());
//        (Tv)b.items[0].tvMethod(); // error
        ((Tv) b.items[0]).tvMethod();
    }
}

class Product {
    int price;
    int bonusPoint;

    Product(int price) {
        this.price = price;
        bonusPoint = (int) (price / 10.0);
    }

    Product() {
    }
}

class Tv extends Product {
    Tv() { super(100); }
    public String toString() { return "Tv"; }
    public void tvMethod() {
        System.out.println("test Method");
    }
}

class Computer extends Product {
    Computer() { super(200); }
    public String toString() { return "Computer"; }
}

class Audio extends Product {
    Audio() { super(100); }
    public String toString() { return "Audio"; }
}

class Buyer {
    int money = 300;
    int bonusPoint = 0;

    Product[] items = new Product[10];
    int count = 0;

    void buy(Product p) {
        if (money < p.price) {
            System.out.println("can't buy: " + p);
            return;
        }

        money -= p.price;
        bonusPoint += p.price;
        items[count++] = p;
        System.out.println(p + " has been successfully bought.");
    }

    void summary() {
        int sum = 0;
        String itemList = "";

        for (Product p : items) {
            if (p == null) break;
            sum += p.price;
            itemList += p + ", ";
        }

        System.out.println("total bought money: " + sum);
        System.out.println("total bought items: " + itemList);
    }
}