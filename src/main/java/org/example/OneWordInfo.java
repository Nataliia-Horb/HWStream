package org.example;

import lombok.Data;

@Data
public class OneWordInfo implements Comparable<OneWordInfo> {
    String word;
    Integer quantity;

    public OneWordInfo(String word, Integer quantity) {
        this.word = word;
        this.quantity = quantity;
    }

    @Override
    public int compareTo(OneWordInfo o) {
        if (this.quantity == o.quantity) {
            return this.word.compareTo(o.word);
        }
        return o.quantity - this.quantity;
    }
}
