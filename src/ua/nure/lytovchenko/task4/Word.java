package ua.nure.lytovchenko.task4;

import java.util.Objects;

public class Word implements Comparable<Word> {

    private String text;
    private int frequency;

    public Word(String word) {
        this.text = word;
        this.frequency = 1;
    }

    public Word(String word, int frequency) {
        this.text = word;
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Word word1 = (Word) o;
        return text.equals(word1.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    public int compareTo(Word w) {
        if (w.frequency != this.frequency) {
            return this.frequency - w.frequency;
        } else {
            return this.text.compareTo(w.text);
        }
    }

    @Override
    public String toString() {
        return text + " : " + frequency;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
