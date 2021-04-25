package com.app.concordance;

public class ConcordanceAttributes {

    private int wordCount;
    private String sentenceNumbers;

    public ConcordanceAttributes(int wordCount, String sentenceNumbers) {
        this.wordCount = wordCount;
        this.sentenceNumbers = sentenceNumbers;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public String getSentenceNumbers() {
        return sentenceNumbers;
    }

    public void setSentenceNumbers(String sentenceNumbers) {
        this.sentenceNumbers = sentenceNumbers;
    }

    @Override
    public String toString() {
        return "com.app.concordance.ConcordanceAttributes{" +
                "wordCount=" + wordCount +
                ", sentenceNumbers='" + sentenceNumbers + '\'' +
                '}';
    }
}
