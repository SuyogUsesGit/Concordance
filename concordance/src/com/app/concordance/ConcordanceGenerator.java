package com.app.concordance;

import java.text.BreakIterator;
import java.util.*;

public class ConcordanceGenerator {

    public void printConcordance(String passage, ConcordanceGenerator concordanceGenerator) {
        Map<String, ConcordanceAttributes> map = concordanceGenerator.getConcordance(passage);
        for (Map.Entry<String, ConcordanceAttributes> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " {" + entry.getValue().getWordCount() + ":" + entry.getValue().getSentenceNumbers() + "}");
        }
    }

    private Map<String, ConcordanceAttributes> getConcordance(String passage) {
        List<String> sentences = getSentences(passage);
        Map<String, ConcordanceAttributes> map = new TreeMap<>();
        int counter = 0;
        for (String sentence : sentences) {
            counter++;
            List<String> words = getWordsFromSentence(sentence);
            for (String word : words) {
                generateConcordance(map, counter, word);
            }
        }
        return map;
    }

    private List<String> getSentences(String passage) {
        List<String> sentences = new ArrayList<>();
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        String source = passage;
        iterator.setText(source);
        int start = iterator.first();
        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()) {
            sentences.add(source.substring(start, end));
        }
        return sentences;
    }

    private List<String> getWordsFromSentence(String sentence) {
        List<String> words = new ArrayList<>();
        BreakIterator bi = BreakIterator.getWordInstance(Locale.US);
        bi.setText(sentence);
        int count = 0;
        int lastIndex = bi.first();
        while (lastIndex != BreakIterator.DONE) {
            int firstIndex = lastIndex;
            lastIndex = bi.next();

            if (lastIndex != BreakIterator.DONE
                    && Character.isLetterOrDigit(sentence.charAt(firstIndex))) {
                String word = sentence.substring(firstIndex, lastIndex);
                words.add(word);

            }
        }
        return words;
    }

    private void generateConcordance(Map<String, ConcordanceAttributes> map, int counter, String word) {
        if (!map.containsKey(word)) {
            map.put(word.toLowerCase(), new ConcordanceAttributes(1, counter + ""));
        } else {
            setConcordance(map, counter, word);
        }
    }

    private void setConcordance(Map<String, ConcordanceAttributes> map, int counter, String word) {
        ConcordanceAttributes concordanceAttributes = map.get(word);
        concordanceAttributes.setWordCount(concordanceAttributes.getWordCount() + 1);
        concordanceAttributes.setSentenceNumbers(concordanceAttributes.getSentenceNumbers() + "," + counter);
        map.put(word.toLowerCase(), concordanceAttributes);
    }



}
