package com.datastructures;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer> hashSet = new HashMap<>();

        hashSet.add("yas", 10);
        hashSet.add("babii", 30);
        hashSet.add("andrey", 30);
        hashSet.add("joao", 50);
        hashSet.add("Niltinho", 100);
        hashSet.add("abc", 30);
        hashSet.add("absc", 30);
        hashSet.add("adfdasdfsbc", 30);
        hashSet.add("aafsdfadsbc", 30);
        hashSet.add("aafsfsbc", 30);
        hashSet.add("wzcv", 30);
        hashSet.add("hhe", 30);
        hashSet.add("accccbc", 30);
        hashSet.add("ccaca", 30);

        for (var str : hashSet) {
            System.out.println(String.format("%s: %d", str.key, str.value));
        }

        System.out.println(hashSet.get("joao"));
    }
}
