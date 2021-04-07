package encryptdecrypt.algorithms;

import encryptdecrypt.algorithms.abstractions.AbstractAlgorithm;

public class ShiftAlgorithm extends AbstractAlgorithm {

    int key;

    public ShiftAlgorithm(String mode) {
        super(mode);
    }

    protected String encode(String plainText) {
        StringBuilder sb = new StringBuilder();
        for (char ch : plainText.toCharArray()) {
            sb.append(ch >= 'a' && ch <= 'z' ? (char) ('a' + (ch - 'a' + key) % 26)
                    : ch >= 'A' && ch <= 'Z' ? (char) ('A' + (ch - 'A' + key) % 26)
                    : ch);
        }
        return sb.toString();
    }

    protected String decode(String encryptedText) {
        StringBuilder sb = new StringBuilder();
        for (char ch : encryptedText.toCharArray()) {
            sb.append(ch >= 'a' && ch <= 'z' ?
                    (ch - 'a' - key % 26) >= 0 ?
                            (char) ('a' + (ch - 'a' - key % 26)) : (char) ('z' + (ch - 'a' - key % 26) + 1)
                    : ch >= 'A' && ch <= 'Z' ?
                            (ch - 'A' - key % 26) >= 0 ?
                                    (char) ('A' + (ch - 'A' - key % 26)) : (char) ('Z' + (ch - 'A' - key % 26) + 1): ch);
        }
        return sb.toString();
    }

    @Override
    public void setKey(String key) {
        this.key = Integer.parseInt(key);
    }

}


