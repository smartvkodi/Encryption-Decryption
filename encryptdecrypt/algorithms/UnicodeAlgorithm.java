package encryptdecrypt.algorithms;

import encryptdecrypt.algorithms.abstractions.AbstractAlgorithm;

public class UnicodeAlgorithm  extends AbstractAlgorithm {

    int key;

    public UnicodeAlgorithm(String mode) {
        super(mode);
    }

    protected String encode(String plainText) {
        StringBuilder sb = new StringBuilder();
        for (char ch : plainText.toCharArray()) {
            sb.append((char) (ch + key));
        }
        return sb.toString();
    }

    protected String decode(String encryptedText) {
        StringBuilder sb = new StringBuilder();
        for (char ch : encryptedText.toCharArray()) {
            sb.append((char) (ch - key));
        }
        return sb.toString();
    }

    @Override
    public void setKey(String key) {
        this.key = Integer.parseInt(key);
    }

}
