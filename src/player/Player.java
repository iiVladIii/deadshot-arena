package player;

import weapon.Weapon;

public class Player {
    private int health;
    private int damage ;
    private double defence;
    private int stamina;
    private int accuracy;
    private Weapon weapon;

    public Player() {
        health = 100;
        damage = 10;
        defence = 5.0;
        stamina = 5;
        accuracy = 100;
    }

    public void makeShort() {

    }

    public void takeDamage() {

    }

    // getters
    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public double getDefence() {
        return defence;
    }

    public int getStamina() {
        return stamina;
    }

    public double getAccuracy() {
        return accuracy;
    }


    // setters
    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
}
