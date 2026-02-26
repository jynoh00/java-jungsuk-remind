package study;

public class FighterEx {
    public static void main(String[] args) {
        Fighter f = new Fighter();
        if (f instanceof Unit) System.out.println("Child of Unit Class");
        if (f instanceof Movable) System.out.println("Implements : Movable interface");
        if (f instanceof Attackable) System.out.println("Implements : Attackable interface");
        if (f instanceof Fightable) System.out.println("Implements : Fightable interface");
        if (f instanceof Object) System.out.println("Child of Object Class interface");
    }
}

class Unit {
    int currentHP;
    int x, y;
}

class Fighter extends Unit implements Fightable {
//    void move(int x, int y) { // error
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

//    void attack(Unit u) { // error
    public void attack(Unit u) {
        u.currentHP--;
    }
}

interface Movable { void move(int x, int y); }
interface Attackable { void attack(Unit u); }
interface Fightable extends Movable, Attackable {}