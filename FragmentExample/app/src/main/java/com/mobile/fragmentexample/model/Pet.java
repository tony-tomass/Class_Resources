package com.mobile.fragmentexample.model;


public class Pet {
    private String name;
    private String breed;
    private int age;

    public Pet(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String string = name + " (" + breed + "):"+ age;
        return string;
    }
}

