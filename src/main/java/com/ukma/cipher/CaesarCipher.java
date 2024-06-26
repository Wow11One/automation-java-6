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
        return encryptHelp(text, -shift);
    }

    private String encryptHelp(String text, int shift) {
        if (text == null || text.isEmpty()) {
            throw new RuntimeException("NULL TEXT ERROR!");
        }

        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (character != ' ') {
                char newAlphabetPosition = (char) (character + shift);
                result.append(newAlphabetPosition);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }
}
