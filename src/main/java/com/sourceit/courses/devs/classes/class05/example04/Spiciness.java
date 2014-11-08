package com.sourceit.courses.devs.classes.class05.example04;


public enum Spiciness {
    MILD("Even children can eat it"),
    HOT("Be careful, it is very hot"); // должно заканчиваться ;

    private String description;
    // Constructor must be package or private access:
    private Spiciness(String description) {
        this.description = description;
    }
    public String getDescription() { return description; }
    public static void main(String[] args) {
        for(Spiciness witch : Spiciness.values())
            System.out.println(witch + ": " + witch.getDescription());
    }

}
