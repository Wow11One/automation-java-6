package com.ukma.cipher;

public class CaesarCipher {

    public  String encrypt(String text, int shift) {
        if (shift < 0) {
            return text;
        }
        return encryptHelp(text, shift);

    }

    public  String decrypt(String text, int shift) {
        if (shift < 0) {
            return text;
        }
        return encryptHelp(text, 26 - (shift % 26));
    }

    private String encryptHelp(String text, int shift) {
        if (text == null || text.isEmpty()) {
            throw new RuntimeException("NULL TEXT ERROR!");
        }

        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + shift) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }
}
