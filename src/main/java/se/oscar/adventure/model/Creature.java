package se.oscar.adventure.model;

public class Creature {
    private int health;
    private int damage;
    private final String name;

    public Creature(int health, int damage, String name) {
        this.health = health;
        this.damage = damage;
        this.name = name;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public void attack(Creature toAttack) {
        toAttack.takeDamage(this.damage);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}
