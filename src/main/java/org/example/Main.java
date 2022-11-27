package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Напишите программу, принимающую список, содержащий текст и подсчитывающую в нем частоту появления слов,
 * и в конце выводящую 10 наиболее часто встречающихся слов.
 * Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр.
 * Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
 * Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово.
 * Выводите слова в нижнем регистре.
 * Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
 * Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте,
 * то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.
 * Pешение реализовать с помощью лямбда ф-ций.
 */
public class Main {
    public static void main(String[] args) {

        String text1 = "Мама мыла-мыла-мыла, раму. Мыла мама долго мыла-мыла-мыла раму мама. Жалко руки мамы, что" +
                " так долго МЫла раму!";

        String text2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at" +
                " faucibus.Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit" +
                " tincidunt efficitur.Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula " +
                "mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit.Integer vel odio" +
                " nec mi tempor dignissim. ";


        countWords(text1);
        System.out.println("----------------------------");
        countWords(text2);
    }

    public static void countWords(String text) {

        // Divide a string into an array by delimiter
        String[] textElements = text.split("[\\, -\\.\\!]+");

        // Making a list of the word and the quantity in the text
        Map<String, Integer> mapWords = Arrays.stream(textElements).collect(Collectors.toMap((String x) ->
                x.toLowerCase(), (String x) -> 1, (y1, y2) -> y1 + y2));

        // Create the list of entities that store the word and quantity
        List<OneWordInfo> mapQuantity = mapWords.keySet().stream().map(key -> new OneWordInfo(key, mapWords.get(key))).
                collect(Collectors.toList());

        // Sort entities by quantity and display the maximum 10 on the screen
        mapQuantity.stream().sorted().limit(10).forEach(p -> System.out.println(p.word + " " + p.quantity));
    }
}
