package com.example.lutemon;

import java.io.Serializable;

public class Lutemon implements Serializable {

    private String name, color;
    private int attack, defense, experience, health, maxHealth, id, choose, wins, losses, image, place;

    public Lutemon() {
        name = null;
        color = null;
        attack = 0;
        defense = 0;
        experience = 0;
        health = 0;
        maxHealth = 0;
        id = 0;
        choose = 0;
        wins = 0;
        losses = 0;
        image = 0;
        place = 0;
    }

    public Lutemon(String name, String color, int attack, int defense, int experience, int health, int maxHealth, int id, int choose, int wins, int losses, int image, int place) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.id = id;
        this.choose = choose;
        this.wins = wins;
        this.losses = losses;
        this.image = image;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getId() {
        return id;
    }

    public int getChoose() {
        return choose;
    }

    public void setChoose(int choose) {
        this.choose = choose;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

}
